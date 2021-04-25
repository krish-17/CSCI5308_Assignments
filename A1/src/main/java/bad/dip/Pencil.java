package bad.dip;

public class Pencil {

    private String brand;
    private int unitPrice;
    private int availableStock;

    public Pencil(String brand, int unitPrice, int availableStock) {
        this.brand = brand;
        this.unitPrice = unitPrice;
        this.availableStock = availableStock;
    }

    public String getPencilBrandName() {
        return this.brand;
    }

    public void setPencilBrandName(String brandName) {
        this.brand = brandName;
    }

    public int getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }


    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

}
