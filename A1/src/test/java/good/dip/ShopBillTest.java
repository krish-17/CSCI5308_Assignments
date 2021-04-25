package good.dip;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopBillTest {

    @Test
    public void testPlaceOrder() {
        Assertions.assertThrows( NullPointerException.class, () -> { new ShopBill().placeOrder(null); });
        ProductAPI mock = new PenAPIImpl();
        mock.setQuantity(15);
        ShopBill sb = new ShopBill();
        sb.setQuantity(25);
        Assertions.assertThrows( IllegalArgumentException.class, () -> { sb.setQuantity(-100);});
        Assertions.assertEquals(false, sb.placeOrder(mock));
        sb.setQuantity(10);
        Assertions.assertEquals(true, sb.placeOrder(mock));
    }

    @Test
    public void testCalculateOrderValue() {
        ProductAPI mock = new PenAPIImpl();
        mock.setQuantity(15);
        ShopBill sb = new ShopBill();
        sb.setQuantity(10);
        Assertions.assertEquals(sb.calculateOrderValue(mock), 0);
        mock.setIndProductPrice(100);
        Assertions.assertEquals(sb.calculateOrderValue(mock), 1000);

    }
}
