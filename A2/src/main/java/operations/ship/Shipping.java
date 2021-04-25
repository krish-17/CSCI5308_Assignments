package operations.ship;

import workers.driver.DriverAPI;
import workers.humanresources.HumanResourcesAPI;
import workers.picker.PickerAPI;

public class Shipping implements ShippingAPI {
    private final HumanResourcesAPI humanResourcesAPI;

    public Shipping(HumanResourcesAPI humanResourcesAPI) {
        this.humanResourcesAPI = humanResourcesAPI;
    }

    public void ship(String item, String account, int quantity) {
        if (isStringValueNullOrEmpty(account) || isStringValueNullOrEmpty(item) || quantity <= 0) {
            throw new IllegalArgumentException("Invalid Values passed. Terminate instructions");
        }
        askPickerToRetrieve(item, quantity);
        askDriverToDeliver(account, item, quantity);
        System.out.println("Shipped " + quantity + " " + item + " to " + account);
    }

    void askPickerToRetrieve(String item, int quantity) {
        PickerAPI pickerAPI = humanResourcesAPI.getPickerAPI();
        pickerAPI.retrieve(item, quantity);
    }

    void askDriverToDeliver(String account, String item, int quantity) {
        DriverAPI driverAPI = humanResourcesAPI.getDriverAPI();
        driverAPI.deliver(account, item, quantity);
    }

    boolean isStringValueNullOrEmpty(String account) {
        return account == null || account.equalsIgnoreCase("");
    }
}
