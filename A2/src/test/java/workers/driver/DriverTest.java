package workers.driver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DriverTest {

    @Test
    void testIfDriverImplementsInterface() {
        Assertions.assertTrue(DriverAPI.class.isAssignableFrom(Driver.class));
    }

    @Test
    void checkIfDriverIsNull() {
        DriverAPI driverAPI = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            driverAPI.deliver("", "", 0);
        });
    }

    @Test
    void checkDeliverWhenItemIsNull() {
        DriverAPI driverAPI = new Driver();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            driverAPI.deliver(" ", null, 0);
        });
    }

    @Test
    void checkDeliverWhenAccountIsNull() {
        DriverAPI driverAPI = new Driver();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            driverAPI.deliver(null, "", 0);
        });
    }

    @Test
    void checkDeliverWhenItemIsEmpty() {
        DriverAPI driverAPI = new Driver();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            driverAPI.deliver("10012", "", 0);
        });
    }

    @Test
    void checkDeliverWhenAccountIsEmpty() {
        DriverAPI driverAPI = new Driver();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            driverAPI.deliver("", "", 0);
        });
    }

    @Test
    void checkDeliverWhenQuantityIsZero() {
        DriverAPI driverAPI = new Driver();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            driverAPI.deliver("10023", "pen", 0);
        });
    }

    @Test
    void checkDeliverWhenQuantityIsNegative() {
        DriverAPI driverAPI = new Driver();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            driverAPI.deliver("10023", "pen", -39);
        });
    }

    @Test
    void checkWorkingMinutesIsAddedOnceDelivered() {
        DriverAPI driverAPI = new Driver();
        driverAPI.deliver("10023", "pen", 20);
        Assertions.assertEquals(300, driverAPI.getMinutesWorkedSinceLastPay());
    }

    @Test
    void testIsStringNullOrEmptyReturnsTrue() {
        Driver driver = new Driver();
        Assertions.assertEquals(true, driver.isStringValueEmptyOrNull(""));
    }

    @Test
    void testIsStringNullOrEmptyReturnsFalse() {
        Driver driver = new Driver();
        Assertions.assertEquals(false, driver.isStringValueEmptyOrNull("Pen"));
    }


}
