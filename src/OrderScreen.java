import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class OrderScreen extends JFrame {

   public  OrderScreen() {
       JFrame frame = new JFrame("Order Screen");
       Container container = frame.getContentPane();
       container.setLayout(new GridBagLayout());
       JTextField field = new JTextField(10);
       JLabel SKULabel = new JLabel("SKU:");

       addComponent(1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,4,frame,field);
       addComponent(0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,frame,SKULabel);

       ArrayList<Product> product = new ArrayList<>();

       JTable table = new JTable(new AbstractTableModel() {

           @Override
           public String getColumnName(int column){
               String[] columns = new String[] {"SKU", "Name", "Price", "Quantity", "Amount"};
               return columns[column];
           }

           @Override
           public int getRowCount() {
               return 0;
           }

           @Override
           public int getColumnCount() {
               return 5;
           }

           @Override
           public Object getValueAt(int rowIndex, int columnIndex) {
               if (columnIndex == 0){
                   return product.get(rowIndex).getSKU();
               }else if(columnIndex == 1){
                   return  product.get(rowIndex).getName();
               }else{
                   return product.get(rowIndex).getPrice();
               }
           }
       });

       addComponent(0,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,5,frame,new JScrollPane(table));


       field.addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e) {

           }

           @Override
           public void keyPressed(KeyEvent e) {
               if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   for(int i=0; i< product.size(); i++){
                       if(field.getText().equals(product.get(i).getSKU())){

                       }
                   }
               }
           }

           @Override
           public void keyReleased(KeyEvent e) {

           }
       });

       frame.setSize(500, 500);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

   }


    public static void addComponents(int gridx, int gridy, int width, int height, double weightx, double weighty, int fill, JFrame frame, Component c ){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx=gridx;
        constraints.gridy=gridy;
        constraints.gridwidth=width;
        constraints.gridheight=height;
        constraints.weightx=weightx;
        constraints.weighty=weighty;
        constraints.fill=fill;
        frame.add(c,constraints);
    }

    public static void addComponent(int x, int y, int anchor,int fill, JFrame frame, Component c){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.anchor=anchor;
        constraints.fill = fill;
        frame.add(c,constraints);
    }

    public static void addComponent(int x, int y, int anchor,int fill,int width, JFrame frame, Component c){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.anchor=anchor;
        constraints.fill = fill;
        constraints.gridwidth=width;
        frame.add(c,constraints);
    }

}
