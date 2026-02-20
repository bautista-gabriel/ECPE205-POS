import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

//submitted by Angelo Gabriel G. Bautista - 1010036


public class Main {
    public static void main(String[]args) {
        ArrayList<Product> productList = new ArrayList<Product>();
        new OrderScreen(productList);
        new ProductScreen(productList);
    }
}
