package workers.forkliftoperator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ForkLiftOperatorTest {


    @Test
    void testIfForkLiftOperatorImplementsInterface() {
        Assertions.assertTrue(ForkLiftOperatorAPI.class.isAssignableFrom(ForkliftOperator.class));
    }

    @Test
    void checkIfForkLiftOperatorIsNull() {
        ForkLiftOperatorAPI forkLiftOperatorAPI = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            forkLiftOperatorAPI.storeItem("", 0);
        });
    }

    @Test
    void checkStoreItemWhenItemIsNull() {
        ForkLiftOperatorAPI forkLiftOperatorAPI = new ForkliftOperator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            forkLiftOperatorAPI.storeItem(null, 0);
        });
    }


    @Test
    void checkStoreItemWhenItemIsEmpty() {
        ForkLiftOperatorAPI forkLiftOperatorAPI = new ForkliftOperator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            forkLiftOperatorAPI.storeItem("", 0);
        });
    }


    @Test
    void checkStoreItemWhenQuantityIsZero() {
        ForkLiftOperatorAPI forkLiftOperatorAPI = new ForkliftOperator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            forkLiftOperatorAPI.storeItem("pen", 0);
        });
    }

    @Test
    void checkStoreItemWhenQuantityIsNegative() {
        ForkLiftOperatorAPI forkLiftOperatorAPI = new ForkliftOperator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            forkLiftOperatorAPI.storeItem("pen", -39);
        });
    }

    @Test
    void checkWorkingMinutesIsAddedOnceStored() {
        ForkLiftOperatorAPI forkLiftOperatorAPI = new ForkliftOperator();
        forkLiftOperatorAPI.storeItem("pen", 20);
        Assertions.assertEquals(400, forkLiftOperatorAPI.getMinutesWorkedSinceLastPay());
    }

    @Test
    void testIsStringNullOrEmptyReturnsTrue() {
        ForkliftOperator forkliftOperator = new ForkliftOperator();
        Assertions.assertEquals(true, forkliftOperator.isStringNullOrEmpty(""));
    }

    @Test
    void testIsStringNullOrEmptyReturnsFalse() {
        ForkliftOperator forkliftOperator = new ForkliftOperator();
        Assertions.assertEquals(false, forkliftOperator.isStringNullOrEmpty("Pen"));
    }

}
