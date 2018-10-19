package vehicle_builder.common.model;

import java.io.Serializable;

/**
 * Created by Lei on 10/19/2018.
 */
public class Car extends Vehicle {
    public Car(String owner, int price) {
        super(owner, price);
    }

    @Override
    public void start() {
        System.out.println("Car start...");
    }
}
