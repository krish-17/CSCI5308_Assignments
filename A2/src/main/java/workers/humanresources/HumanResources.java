package workers.humanresources;

import workers.driver.Driver;
import workers.driver.DriverAPI;
import workers.forkliftoperator.ForkLiftOperatorAPI;
import workers.forkliftoperator.ForkliftOperator;
import workers.picker.Picker;
import workers.picker.PickerAPI;

import java.util.ArrayList;
import java.util.List;

public class HumanResources implements HumanResourcesAPI {

    private static final int MAX_EMPLOYEE_NUMBER = 5;

    private final int totalNumberOfDrivers;
    private final int totalNumberOfForkLiftOperators;
    private final int totalNumberOfPickers;
    private int nextDriver;
    private int nextForkLiftOperator;
    private int nextPicker;
    private List<DriverAPI> driverAPIList;
    private List<ForkLiftOperatorAPI> forkLiftOperatorAPIList;
    private List<PickerAPI> pickersApiList;

    public HumanResources() {
        nextDriver = 0;
        nextForkLiftOperator = 0;
        nextPicker = 0;
        totalNumberOfDrivers = MAX_EMPLOYEE_NUMBER;
        totalNumberOfForkLiftOperators = MAX_EMPLOYEE_NUMBER;
        totalNumberOfPickers = MAX_EMPLOYEE_NUMBER;
        initializeDriverAPIList(totalNumberOfDrivers);
        initializeForkLiftOperatorAPIList(totalNumberOfForkLiftOperators);
        initializePickersAPIList(totalNumberOfPickers);
    }

    int getPickerListLength() {
        return this.pickersApiList.size();
    }

    void initializePickersAPIList(int totalNumberOfPickers) {
        this.pickersApiList = new ArrayList<>();
        for (int i = 0; i < totalNumberOfPickers; i++) {
            this.pickersApiList.add(new Picker());
        }
    }

    int getForkLiftOperatorListLength() {
        return this.forkLiftOperatorAPIList.size();
    }

    void initializeForkLiftOperatorAPIList(int totalNumberOfForkLiftOperators) {
        this.forkLiftOperatorAPIList = new ArrayList<>();
        for (int i = 0; i < totalNumberOfForkLiftOperators; i++) {
            this.forkLiftOperatorAPIList.add(new ForkliftOperator());
        }
    }

    int getDriverListLength() {
        return this.driverAPIList.size();
    }


    void initializeDriverAPIList(int totalNumberOfDrivers) {
        driverAPIList = new ArrayList<>();
        for (int i = 0; i < totalNumberOfDrivers; i++) {
            driverAPIList.add(new Driver());
        }
    }


    @Override
    public DriverAPI getDriverAPI() {
        DriverAPI driverAPI = driverAPIList.get(nextDriver);
        nextDriver = (nextDriver + 1) % totalNumberOfDrivers;
        return driverAPI;
    }

    @Override
    public PickerAPI getPickerAPI() {
        PickerAPI pickerAPI = pickersApiList.get(nextPicker);
        nextPicker = (nextPicker + 1) % totalNumberOfPickers;
        return pickerAPI;
    }

    @Override
    public ForkLiftOperatorAPI getForkLiftOperatorAPI() {
        ForkLiftOperatorAPI forkLiftOperatorAPI = forkLiftOperatorAPIList.get(nextForkLiftOperator);
        nextForkLiftOperator = (nextForkLiftOperator + 1) % totalNumberOfForkLiftOperators;
        return forkLiftOperatorAPI;
    }

    @Override
    public int getTotalMinutesWorked() {
        return getTotalDriverWorkingMinutes() +
                getTotalPickersWorkingMinutes() +
                getTotalForkLiftOperatorsWorkingMinutes();
    }

    int getTotalDriverWorkingMinutes() {
        int totalWorkingMinutes = 0;
        for (DriverAPI driverAPI : driverAPIList) {
            totalWorkingMinutes += driverAPI.getMinutesWorkedSinceLastPay();
        }
        return totalWorkingMinutes;
    }

    int getTotalForkLiftOperatorsWorkingMinutes() {
        int totalWorkingMinutes = 0;
        for (ForkLiftOperatorAPI forkLiftOperatorAPI : forkLiftOperatorAPIList) {
            totalWorkingMinutes += forkLiftOperatorAPI.getMinutesWorkedSinceLastPay();
        }
        return totalWorkingMinutes;
    }

    int getTotalPickersWorkingMinutes() {
        int totalWorkingMinutes = 0;
        for (PickerAPI pickerAPI : pickersApiList) {
            totalWorkingMinutes += pickerAPI.getMinutesWorkedSinceLastPay();
        }
        return totalWorkingMinutes;
    }
}
