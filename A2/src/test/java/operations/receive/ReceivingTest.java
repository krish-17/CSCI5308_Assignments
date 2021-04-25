package operations.receive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import workers.humanresources.*;

class ReceivingTest {

    @Test
    void testReceiveWhenHumanResourceNull() {
        ReceivingAPI receivingAPI = new Receiving(null);
        Assertions.assertThrows(NullPointerException.class, () -> {
            receivingAPI.receive("Pen", 40);
        });
    }

    @Test
    void testReceiveWhenHumanResourceNotNull() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        Assertions.assertDoesNotThrow(() -> {
            new Receiving(humanResourcesAPI).receive("Pen", 10);
        });
    }

    @Test
    void testIfReceivingImplementsInterface() {
        Assertions.assertTrue(ReceivingAPI.class.isAssignableFrom(Receiving.class));
    }

    @Test
    void testReceivingWhenItemIsNull() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ReceivingAPI receivingAPI = new Receiving(humanResourcesAPI);
        Assertions.assertThrows(IllegalArgumentException.class, () -> { receivingAPI.receive(null, 10);});
    }

    @Test
    void testReceivingWhenItemIsEmpty() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ReceivingAPI receivingAPI = new Receiving(humanResourcesAPI);
        Assertions.assertThrows(IllegalArgumentException.class, () -> { receivingAPI.receive("", 10);});
    }

    @Test
    void testReceivingWhenQuantityIsZero() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ReceivingAPI receivingAPI = new Receiving(humanResourcesAPI);
        Assertions.assertThrows(IllegalArgumentException.class, () -> { receivingAPI.receive("car", 0);});
    }


    @Test
    void testReceivingWhenQuantityIsNegative() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ReceivingAPI receivingAPI = new Receiving(humanResourcesAPI);
        Assertions.assertThrows(IllegalArgumentException.class, () -> { receivingAPI.receive("pen", -4);});
    }

    @Test
    void testIfProcureIsCalledWhileReceiving() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ReceivingAPI receivingAPI = new Receiving(humanResourcesAPI);
        receivingAPI.receive("Pen", 10);
        Assertions.assertEquals(200, humanResourcesAPI.getTotalMinutesWorked());
    }

    @Test
    void testIsStringNullOrEmptyReturnsTrue() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        Receiving receiving = new Receiving(humanResourcesAPI);
        Assertions.assertEquals(true, receiving.isStringValueNullOrEmpty(""));
    }

    @Test
    void testIsStringNullOrEmptyReturnsFalse() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        Receiving receiving = new Receiving(humanResourcesAPI);
        Assertions.assertEquals(false, receiving.isStringValueNullOrEmpty("Pen"));
    }
}
