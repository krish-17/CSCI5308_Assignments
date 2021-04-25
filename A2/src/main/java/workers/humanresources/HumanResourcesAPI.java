package workers.humanresources;

import workers.driver.DriverAPI;
import workers.forkliftoperator.ForkLiftOperatorAPI;
import workers.picker.PickerAPI;

public interface HumanResourcesAPI {

    DriverAPI getDriverAPI();

    ForkLiftOperatorAPI getForkLiftOperatorAPI();

    int getTotalMinutesWorked();

    PickerAPI getPickerAPI();


}
