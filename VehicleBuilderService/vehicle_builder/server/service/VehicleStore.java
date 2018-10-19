package vehicle_builder.server.service;

import vehicle_builder.common.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lei on 10/19/2018.
 */
public class VehicleStore {

    // Map<owner, vehicle>
    private static Map<String, Vehicle> vehicleMap = new HashMap<>();

    public synchronized void addVehicle(Vehicle vehicle) {
        if (!vehicleMap.containsKey(vehicle.getOwner())) {
            vehicleMap.put(vehicle.getOwner(), vehicle);
            System.out.println(String.format("Successfully add vehicle, owner: %s, price: %d",
                    vehicle.getOwner(), vehicle.getPrice()));
        } else {
            System.out.println(String.format("Duplicated owner: %s", vehicle.getOwner()));
        }
    }
}
