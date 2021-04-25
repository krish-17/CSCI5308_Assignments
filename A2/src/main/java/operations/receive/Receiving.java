package operations.receive;

import workers.forkliftoperator.ForkLiftOperatorAPI;
import workers.humanresources.HumanResourcesAPI;

public class Receiving implements ReceivingAPI {
    private final HumanResourcesAPI humanResourcesAPI;

    public Receiving(HumanResourcesAPI humanResourcesAPI) {
        this.humanResourcesAPI = humanResourcesAPI;
    }

    @Override
    public void receive(String item, int quantity) {
        if (quantity <= 0 || isStringValueNullOrEmpty(item)) {
            throw new IllegalArgumentException("Invalid Arguments! Terminate it");
        }
        procureItem(item, quantity);
        System.out.println("Received " + quantity + " " + item);
    }

    void procureItem(String item, int quantity) {
        ForkLiftOperatorAPI forkliftOperatorAPI = humanResourcesAPI.getForkLiftOperatorAPI();
        forkliftOperatorAPI.storeItem(item, quantity);
    }

    boolean isStringValueNullOrEmpty(String account) {
        return account == null || account.equalsIgnoreCase("");
    }
}
