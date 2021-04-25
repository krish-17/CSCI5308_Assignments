package workers.forkliftoperator;

public interface ForkLiftOperatorAPI {

    void storeItem(String item, int quantity);

    int getMinutesWorkedSinceLastPay();
}
