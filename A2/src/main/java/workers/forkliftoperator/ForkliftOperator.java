package workers.forkliftoperator;

import workers.Employee;

public class ForkliftOperator extends Employee implements ForkLiftOperatorAPI {
    private final int minutesToCompleteStoringOneItem;

    public ForkliftOperator() {
        super();
        this.minutesToCompleteStoringOneItem = 20;
    }

    @Override
    public void storeItem(String item, int quantity) {
        if (isStringNullOrEmpty(item) || quantity <= 0) {
            throw new IllegalArgumentException("Invalid Arguments! Terminate.");
        }
        addMinutesWorked(this.minutesToCompleteStoringOneItem * quantity);
        System.out.println("Stored " + quantity + " " + item);
    }

    boolean isStringNullOrEmpty(String stringToBeValidated) {
        return stringToBeValidated == null || stringToBeValidated.equalsIgnoreCase("");
    }
}
