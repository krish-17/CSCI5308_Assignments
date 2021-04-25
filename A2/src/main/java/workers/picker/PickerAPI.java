package workers.picker;

public interface PickerAPI {
    void retrieve(String item, int count);

    int getMinutesWorkedSinceLastPay();
}
