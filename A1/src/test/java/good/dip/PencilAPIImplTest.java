package good.dip;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PencilAPIImplTest {

    @Test
    public void testQuantity() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new PencilAPIImpl().setQuantity(-15); });
        ProductAPI pAPI = new PencilAPIImpl();
        pAPI.setQuantity(25);
        Assertions.assertEquals(pAPI.getQuantity(), 25);
    }
    @Test
    public void testIndProductPrice() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new PencilAPIImpl().setIndProductPrice(-15); });
        ProductAPI pAPI = new PencilAPIImpl();
        pAPI.setIndProductPrice(25);
        Assertions.assertEquals(pAPI.getIndProductPrice(), 25);
    }


}
