package workers;

public class Employee {
    private int minutesWorkedSinceLastPay;

    public Employee() {
        minutesWorkedSinceLastPay = 0;
    }

    protected void addMinutesWorked(int minutes) {
        minutesWorkedSinceLastPay += minutes;
    }

    public int getMinutesWorkedSinceLastPay() {
        return minutesWorkedSinceLastPay;
    }
}
