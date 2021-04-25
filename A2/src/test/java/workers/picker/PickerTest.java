package workers.picker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PickerTest {

    @Test
    void testIfPickerImplementsInterface() {
        Assertions.assertTrue(PickerAPI.class.isAssignableFrom(Picker.class));
    }

    @Test
    void checkIfPickerIsNull() {
        PickerAPI PickerAPI = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            PickerAPI.retrieve("", 0);
        });
    }

    @Test
    void checkRetrieveWhenItemIsNull() {
        PickerAPI PickerAPI = new Picker();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PickerAPI.retrieve(null, 0);
        });
    }


    @Test
    void checkRetrieveWhenItemIsEmpty() {
        PickerAPI PickerAPI = new Picker();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PickerAPI.retrieve("", 0);
        });
    }


    @Test
    void checkRetrieveWhenQuantityIsZero() {
        PickerAPI PickerAPI = new Picker();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PickerAPI.retrieve("pen", 0);
        });
    }

    @Test
    void checkRetrieveWhenQuantityIsNegative() {
        PickerAPI PickerAPI = new Picker();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PickerAPI.retrieve("pen", -39);
        });
    }

    @Test
    void checkWorkingMinutesIsAddedOnceStored() {
        PickerAPI PickerAPI = new Picker();
        PickerAPI.retrieve("pen", 20);
        Assertions.assertEquals(100, PickerAPI.getMinutesWorkedSinceLastPay());
    }

    @Test
    void testIsStringNullOrEmptyReturnsTrue() {
        Picker picker = new Picker();
        Assertions.assertEquals(true, picker.isStringValueNullOrEmpty(""));
    }

    @Test
    void testIsStringNullOrEmptyReturnsFalse() {
        Picker picker = new Picker();
        Assertions.assertEquals(false, picker.isStringValueNullOrEmpty("Pen"));
    }

}
