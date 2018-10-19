package vehicle_builder.server.adapter;

import vehicle_builder.common.model.Vehicle;
import vehicle_builder.common.model.VehicleFactory;
import vehicle_builder.common.service.CreateVehicleRequest;
import vehicle_builder.common.service.VehicleBuilderService;
import vehicle_builder.server.service.VehicleStore;

/**
 * Created by Lei on 10/19/2018.
 */
public class VehicleBuilderImpl implements VehicleBuilder {
    private VehicleStore store;

    public VehicleBuilderImpl() {
        store = new VehicleStore();
    }

    @Override
    public Vehicle createVehicle(String owner, int price) {
        Vehicle vehicle = VehicleFactory.createVehicle(owner, price);
        store.addVehicle(vehicle);
        return vehicle;
    }
}
