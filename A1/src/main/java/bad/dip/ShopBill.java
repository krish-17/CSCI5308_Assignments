package bad.dip;

public class ShopBill {

    private int total;
    private int orderQuantity;

    public ShopBill(int total, int orderQuantity) {

        this.total = total;
        this.orderQuantity = orderQuantity;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getTotal(Pencil p) {
        int total = p.getUnitPrice() * this.orderQuantity;
        return total;
    }
}
