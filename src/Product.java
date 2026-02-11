public class Product {

    private String SKU,Name;
    private Double Price;
    private int quantity, amount;

    public Product(String SKU, String name, Double price) {
        this.SKU = SKU;
        Price = price;
        Name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public Product(String SKU, String name, Double price,int quantity, int amount) {
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
