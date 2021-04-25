package workers.picker;

import workers.Employee;

public class Picker extends Employee implements PickerAPI {
    private final int minuteToRetrieveOneItem;

    public Picker() {
        super();
        this.minuteToRetrieveOneItem = 5;
    }

    @Override
    public void retrieve(String item, int quantity) {
        if (isStringValueNullOrEmpty(item) || quantity <= 0) {
            throw new IllegalArgumentException("Invalid parameters to Pick!");

        }
        addMinutesWorked(this.minuteToRetrieveOneItem * quantity);
        System.out.println("Picked " + quantity + " " + item);
    }

    boolean isStringValueNullOrEmpty(String stringToBeValidated) {
        return stringToBeValidated == null || stringToBeValidated.equalsIgnoreCase("");
    }
}
