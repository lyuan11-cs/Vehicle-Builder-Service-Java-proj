package vehicle_builder.server.adapter;

import vehicle_builder.common.model.Vehicle;

/**
 * Created by Lei on 10/19/2018.
 */
public interface VehicleBuilder {
    Vehicle createVehicle(String owner, int price);
}
