package vehicle_builder.server;

import vehicle_builder.common.model.Vehicle;
import vehicle_builder.common.service.*;
import vehicle_builder.server.adapter.VehicleBuilder;
import vehicle_builder.server.adapter.VehicleBuilderImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Lei on 10/19/2018.
 */
public class ServiceHandler implements VehicleBuilderService, Runnable {
    private Socket clientSock;
    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    public ServiceHandler(Socket clientSock) {
        this.clientSock = clientSock;
    }

    @Override
    public void createVehicle(CreateVehicleRequest request) throws Exception {
        // Create new vehicle.
        VehicleBuilder builder = new VehicleBuilderImpl();
        Vehicle newVehicle = builder.createVehicle(request.getOwner(), request.getPrice());

        // Write response.
        CreateVehicleResponse response = new CreateVehicleResponse();
        response.setVehicle(newVehicle);
        if (writer == null) {
            writer = new ObjectOutputStream(clientSock.getOutputStream());
        }
        writer.writeObject(response);
    }

    private void closeSession()  {
        // Write response.
        try {
            if (writer == null) {
                writer = new ObjectOutputStream(clientSock.getOutputStream());
            }
            writer.writeObject(new CloseSessionResponse());
        } catch (IOException e) {
            System.err.println(e);
        }
        // Close session.
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public void run() {
        System.out.println(String.format("Handler started for client %s", clientSock.getInetAddress().getHostName()));

        while (true) {
            try {
                if (clientSock == null) {
                    throw new Exception("Client socket is not established.");
                }

                Object input = null;
                if (reader == null) {
                    reader = new ObjectInputStream(clientSock.getInputStream());
                }
                input = reader.readObject();

                VehicleBuilderResponse response = null;
                if (input instanceof CreateVehicleRequest) {
                    createVehicle((CreateVehicleRequest) input);
                } else if (input instanceof CloseSessionRequest) {
                    closeSession();
                    Thread.interrupted();
                    break;
                } else {
                    System.out.println("Request not supported");
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
