package good.dip;

public class ShopBill {

    private int billVal;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        if ( quantity < 0 ) {
            throw new IllegalArgumentException(" Quantity can not be negative.!");
        }
        this.quantity = quantity;

    }

    public boolean placeOrder(ProductAPI pAPI) {
        return pAPI.getQuantity() >= this.quantity;
    }

    public int calculateOrderValue(ProductAPI pAPI) {
        if(placeOrder(pAPI)) {
            return pAPI.getIndProductPrice() * this.quantity;
        } else {
            return 0;
        }
    }
}
