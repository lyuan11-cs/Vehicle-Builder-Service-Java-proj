package vehicle_builder.common.service;

import vehicle_builder.common.model.Vehicle;

/**
 * Created by Lei on 10/19/2018.
 */
public interface VehicleBuilderService {
    void createVehicle(CreateVehicleRequest request) throws Exception;
}
