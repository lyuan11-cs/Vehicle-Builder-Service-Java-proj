package vehicle_builder.common.model;

import java.io.Serializable;

/**
 * Created by Lei on 10/19/2018.
 */
public abstract class Vehicle implements Serializable {
    private String owner;
    private int price;

    public Vehicle(String owner, int price) {
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

    public abstract void start();

    @Override
    public String toString() {
        return String.format("%s buys a %s at $%d", owner, this.getClass().getSimpleName(), price);
    }
}
