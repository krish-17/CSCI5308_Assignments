package workers.driver;

import workers.Employee;

public class Driver extends Employee implements DriverAPI {
    private final int minutesToCompleteOneDelivery;

    public Driver() {
        super();
        this.minutesToCompleteOneDelivery = 15;
    }

    @Override
    public void deliver(String account, String item, int quantity) {
        if (isStringValueEmptyOrNull(account) || isStringValueEmptyOrNull(item) || quantity <= 0) {
            throw new IllegalArgumentException("Invalid parameters to deliver! Abort");
        }
        addMinutesWorked(minutesToCompleteOneDelivery * quantity);
        System.out.println("Delivered " + item + " to " + account);
    }

    boolean isStringValueEmptyOrNull(String stringToBeValidated) {
        return stringToBeValidated == null || stringToBeValidated.equalsIgnoreCase("");
    }
}
