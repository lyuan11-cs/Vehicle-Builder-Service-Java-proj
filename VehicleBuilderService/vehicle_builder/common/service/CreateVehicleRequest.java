package vehicle_builder.common.service;

import java.io.Serializable;

/**
 * Created by Lei on 10/19/2018.
 */
public class CreateVehicleRequest extends VehicleBuilderRequest {
    private String owner;
    private int price;

    public CreateVehicleRequest(String owner, int price) {
        this.owner = owner;
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
