import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;



public class Main {
    public static void main(String[]args) {
        ArrayList<Product> productList = new ArrayList<Product>();
        new OrderScreen(productList);
        new ProductScreen(productList);
    }
}
