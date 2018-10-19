package vehicle_builder.common.service;

import java.io.Serializable;

/**
 * Created by Lei on 10/19/2018.
 */
public class VehicleBuilderRequest implements Serializable {
    String message;

    public VehicleBuilderRequest() {
        message = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
