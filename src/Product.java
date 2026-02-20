public class Product {
    //submitted by Angelo Gabriel G. Bautista - 1010036
    private String SKU,Name;
    private Double Price;
    private int quantity;
     private   Double amount;
      private  Boolean ProductType;
      private Boolean CitizenType;

    public Boolean getCitizenType() {
        return CitizenType;
    }

    public void setCitizenType(Boolean citizenType) {
        CitizenType = citizenType;
    }

    public Boolean getProductType() {
        return ProductType;
    }

    public void setProductType(Boolean productType) {
        ProductType = productType;
    }

    public Product(String SKU, String name, Double price,Boolean productType) {
        this.SKU = SKU;
        Price = price;
        Name = name;
        ProductType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
        return quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public Double setAmount(Double amount) {
        this.amount = amount;
        return amount;
    }


    public Product(String SKU, String name, Double price,int quantity, Double amount, Boolean productType, Boolean citizenType) {
        this.SKU = SKU;
        Name = name;
        Price = price;
        this.quantity = quantity;
        this.amount = amount;
        ProductType = productType;
        CitizenType = citizenType;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}
