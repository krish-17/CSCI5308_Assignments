package good.dip;

public class PenAPIImpl implements  ProductAPI {

    private int availableQuantity;
    private int indPrice;

    @Override
    public void setQuantity(int quantity) {
        if ( quantity < 0 ) {
            throw new IllegalArgumentException("Quantity can't be negative");
        }
        this.availableQuantity = quantity;
    }

    @Override
    public int getQuantity() {
        return this.availableQuantity;
    }

    @Override
    public int getIndProductPrice() {
        return this.indPrice;
    }

    @Override
    public void setIndProductPrice(int indProdPrice) {
        if ( indProdPrice < 0 ) {
            throw new IllegalArgumentException("Individual product price can't be negative");
        }
        this.indPrice = indProdPrice;
    }

}
