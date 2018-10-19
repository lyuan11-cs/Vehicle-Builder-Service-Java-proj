package vehicle_builder.common.model;

/**
 * Created by Lei on 10/19/2018.
 */
public class VehicleFactory {
    public static Vehicle createVehicle(String owner, int price) {
        if (price < 100) {
            return new Bike(owner, price);
        } else {
            return new Car(owner, price);
        }
    }
}
