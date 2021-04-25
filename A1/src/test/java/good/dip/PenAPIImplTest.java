package good.dip;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PenAPIImplTest {

    @Test
    public void testQuantity() {
        ProductAPI pAPI = new PenAPIImpl();
        Assertions.assertThrows(IllegalArgumentException.class, () -> { pAPI.setQuantity(-15); });
        pAPI.setQuantity(25);
        Assertions.assertEquals(pAPI.getQuantity(), 25);
    }
    @Test
    public void testIndProductPrice() {
        ProductAPI pAPI = new PenAPIImpl();
        Assertions.assertThrows(IllegalArgumentException.class, () -> { pAPI.setIndProductPrice(-15); });
        pAPI.setIndProductPrice(25);
        Assertions.assertEquals(pAPI.getIndProductPrice(), 25);
    }

}
