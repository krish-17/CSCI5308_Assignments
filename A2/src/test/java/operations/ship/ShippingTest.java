package operations.ship;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import workers.humanresources.HumanResources;
import workers.humanresources.HumanResourcesAPI;

class ShippingTest {

    @Test
    void testShipWhenHumanResourceNull() {
        ShippingAPI shippingAPI = new Shipping(null);
        Assertions.assertThrows(NullPointerException.class, () -> {
            shippingAPI.ship("Pen", "10001", 40);
        });
    }

    @Test
    void testShipWhenHumanResourceNotNull() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        Assertions.assertDoesNotThrow(() -> {
            new Shipping(humanResourcesAPI).ship("Pen", "10001", 40);
        });
    }

    @Test
    void testIfShippingImplementsInterface() {
        Assertions.assertTrue(ShippingAPI.class.isAssignableFrom(Shipping.class));
    }

    @Test
    void testShippingWhenItemIsNull() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ShippingAPI shippingAPI = new Shipping(humanResourcesAPI);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shippingAPI.ship(null, "", 10);
        });
    }

    @Test
    void testShippingWhenItemIsEmpty() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ShippingAPI shippingAPI = new Shipping(humanResourcesAPI);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shippingAPI.ship("", "", 10);
        });
    }

    @Test
    void testShippingWhenQuantityIsZero() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ShippingAPI shippingAPI = new Shipping(humanResourcesAPI);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shippingAPI.ship("car", "", 0);
        });
    }


    @Test
    void testShippingWhenQuantityIsNegative() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ShippingAPI shippingAPI = new Shipping(humanResourcesAPI);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shippingAPI.ship("pen", "", -4);
        });
    }

    @Test
    void testShippingWhenAccountIsNull() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ShippingAPI shippingAPI = new Shipping(humanResourcesAPI);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shippingAPI.ship("car", null, 0);
        });
    }


    @Test
    void testShippingWhenAccountIsEmpty() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ShippingAPI shippingAPI = new Shipping(humanResourcesAPI);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shippingAPI.ship("", "", 10);
        });
    }

    @Test
    void testIfAskDriverToDeliverIsCalledDuringShipping() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ShippingAPI receivingAPI = new Shipping(humanResourcesAPI);
        receivingAPI.ship("100002", "Pen", 10);
        Assertions.assertEquals(150, humanResourcesAPI.getTotalMinutesWorked()-50);
    }

    @Test
    void testIfAskPickerToDeliverIsCalledDuringShipping() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        ShippingAPI receivingAPI = new Shipping(humanResourcesAPI);
        receivingAPI.ship("100002", "Pen", 10);
        Assertions.assertEquals(50, humanResourcesAPI.getTotalMinutesWorked()-150);
    }

    @Test
    void testIsStringNullOrEmptyReturnsTrue() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        Shipping shipping = new Shipping(humanResourcesAPI);
        Assertions.assertEquals(true, shipping.isStringValueNullOrEmpty(""));
    }

    @Test
    void testIsStringNullOrEmptyReturnsFalse() {
        HumanResourcesAPI humanResourcesAPI = new HumanResources();
        Shipping shipping = new Shipping(humanResourcesAPI);
        Assertions.assertEquals(false, shipping.isStringValueNullOrEmpty("Pen"));
    }


}
