package workers.humanresources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import workers.driver.DriverAPI;
import workers.forkliftoperator.ForkLiftOperatorAPI;
import workers.picker.PickerAPI;

class HumanResourcesTest {

    @Test
    void testIfHumanResourcesImplementsInterface() {
        Assertions.assertTrue(HumanResourcesAPI.class.isAssignableFrom(HumanResources.class));
    }

    @Test
    void testIfHumanResourceAPIIsNull() {
        HumanResourcesAPI humanResourcesAPI = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            humanResourcesAPI.getDriverAPI();
        });
    }

    @Test
    void testIfGetDriverAPINotReturnsNull() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        Assertions.assertNotEquals(null, humanResourcesAPI.getDriverAPI());
    }

    @Test
    void testIfGetDriverAPIIsInitializedProperly() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        DriverAPI driverAPI = humanResourcesAPI.getDriverAPI();
        Assertions.assertEquals(0, driverAPI.getMinutesWorkedSinceLastPay());
    }

    @Test
    void testIfGetForkLiftOperatorAPINotReturnsNull() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        Assertions.assertNotEquals(null, humanResourcesAPI.getForkLiftOperatorAPI());
    }

    @Test
    void testIfGetForkLiftOperatorAPIIsInitializedProperly() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ForkLiftOperatorAPI forkLiftOperatorAPI = humanResourcesAPI.getForkLiftOperatorAPI();
        Assertions.assertEquals(0, forkLiftOperatorAPI.getMinutesWorkedSinceLastPay());
    }

    @Test
    void testIfGetPickerAPINotReturnsNull() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        Assertions.assertNotEquals(null, humanResourcesAPI.getPickerAPI());
    }

    @Test
    void testIfGetPickerAPIIsInitializedProperly() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        PickerAPI pickerAPI = humanResourcesAPI.getPickerAPI();
        Assertions.assertEquals(0, pickerAPI.getMinutesWorkedSinceLastPay());
    }

    @Test
    void testGetTotalMinutesForValidCase() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        Assertions.assertEquals(0, humanResourcesAPI.getTotalMinutesWorked());
    }

    @Test
    void testGetTotalMinutesForInValidCase() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        Assertions.assertNotEquals(100, humanResourcesAPI.getTotalMinutesWorked());
    }

    @Test
    void testInitializeDriverAPIListMethod() {
        HumanResources humanResources = new HumanResources();
        humanResources.initializeDriverAPIList(10);
        Assertions.assertEquals(10, humanResources.getDriverListLength());
    }

    @Test
    void testInitializeForkLiftOperatorsListMethod() {
        HumanResources humanResources = new HumanResources();
        humanResources.initializeForkLiftOperatorAPIList(100);
        Assertions.assertEquals(100, humanResources.getForkLiftOperatorListLength());
    }

    @Test
    void testInitializePickersListMethod() {
        HumanResources humanResources = new HumanResources();
        humanResources.initializePickersAPIList(40);
        Assertions.assertEquals(40, humanResources.getPickerListLength());
    }

    @Test
    void testTotalDriverWorkingMinutes() {
        HumanResources humanResources = new HumanResources();
        Assertions.assertEquals(0, humanResources.getTotalDriverWorkingMinutes());
    }

    @Test
    void testTotalForkLiftOperatorsWorkingMinutes() {
        HumanResources humanResources = new HumanResources();
        Assertions.assertEquals(0, humanResources.getTotalForkLiftOperatorsWorkingMinutes());
    }

    @Test
    void testTotalPickerWorkingMinutes() {
        HumanResources humanResources = new HumanResources();
        Assertions.assertEquals(0, humanResources.getTotalPickersWorkingMinutes());
    }

    @Test
    void checkForGetDriverListLengthWhenNull() {
        HumanResources humanResources = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            humanResources.getDriverListLength();
        });
    }

    @Test
    void checkForGetForkLiftOperatorsListLengthWhenNull() {
        HumanResources humanResources = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            humanResources.getForkLiftOperatorListLength();
        });
    }

    @Test
    void checkForGetPickersListLengthWhenNull() {
        HumanResources humanResources = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            humanResources.getPickerListLength();
        });
    }

}
