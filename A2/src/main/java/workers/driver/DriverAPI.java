package workers.driver;

public interface DriverAPI {
    void deliver(String account, String item, int quantity);

    int getMinutesWorkedSinceLastPay();
}
