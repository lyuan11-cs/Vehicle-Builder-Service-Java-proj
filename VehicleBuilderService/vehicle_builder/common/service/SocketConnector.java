package vehicle_builder.common.service;

/**
 * Created by Lei on 10/19/2018.
 */
public interface SocketConnector {
    void openSession();

    void handleSession(String input) throws Exception;

    void closeSession();
}
