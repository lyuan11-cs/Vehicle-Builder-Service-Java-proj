package vehicle_builder.common.service;

import vehicle_builder.common.model.Vehicle;

import java.io.Serializable;

/**
 * Created by Lei on 10/19/2018.
 */
public class CreateVehicleResponse extends VehicleBuilderResponse {
    private Vehicle vehicle;

    public CreateVehicleResponse() {
        vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
