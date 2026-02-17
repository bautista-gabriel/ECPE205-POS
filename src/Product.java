public class Product {

    private String SKU,Name;
    private Double Price;
    private int quantity;
        Double amount;

    public Product(String SKU, String name, Double price) {
        this.SKU = SKU;
        Price = price;
        Name = name;
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


    public Product(String SKU, String name, Double price,int quantity, Double amount) {
        this.SKU = SKU;
        Name = name;
        Price = price;
        this.quantity = quantity;
        this.amount = amount;
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
