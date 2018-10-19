package vehicle_builder.server;

import vehicle_builder.common.service.SocketConnector;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Lei on 10/19/2018.
 */
public class SocketConnectorImpl implements SocketConnector {
    ServerSocket socket;
    private String host;
    private int port;

    public SocketConnectorImpl(String host, int port) {
        this.host = host;
        this.port = port;
        socket = null;
    }

    @Override
    public void openSession() {
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println(String.format("Could not listen on port: %d", port));
            System.exit(1);
        }
        System.out.println(String.format("Server start listening on port %d", port));
    }

    @Override
    public void closeSession() {
    }

    @Override
    public void handleSession(String input) throws Exception {
        if (socket == null) {
            throw new Exception("Server socket is not established");
        }

        Socket clientSock = socket.accept();
        System.out.println(String.format("Accept Connection from client: %s", clientSock.getPort()));
        ServiceHandler handler = new ServiceHandler(clientSock);
        new Thread(handler).start();
    }
}
