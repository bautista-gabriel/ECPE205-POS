import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
//submitted by Angelo Gabriel G. Bautista - 1010036
public class OrderScreen extends JFrame {
    ArrayList<Product> productList;

   public  OrderScreen(ArrayList<Product> productList) {
        this.productList = productList;
       JFrame frame = new JFrame("Order Screen");
       Container container = frame.getContentPane();
       container.setLayout(new GridBagLayout());
       JTextField field = new JTextField(10);
       JLabel SKULabel = new JLabel("SKU:");
       JCheckBox checkbox = new JCheckBox("Senior Citizen/ PWD Discount");
       final double[] total = {0};
       final double[] LESSVAT = {0};
       final double[] LESSPWDSCDSC = {0};
       JLabel lessVAT = new JLabel("Less VAT: " + LESSVAT[0]);
       JLabel lessPWDSCDSC = new JLabel("Less Senior Citizen/PWD Discount: " + LESSPWDSCDSC[0]);
       JLabel totalAmount = new JLabel("Total: " + total[0]);


       addComponent(1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,10,frame,field);
       addComponent(0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,frame,SKULabel);
       addComponent(1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,frame,checkbox);
       addComponent(0,5,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,frame,totalAmount);
       addComponent(0,3,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,frame,lessVAT);
       addComponent(0,4,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,frame,lessPWDSCDSC);

       JTable table = new JTable(new AbstractTableModel() {

           @Override
           public String getColumnName(int column){
               String[] columns = new String[] {"SKU", "Name", "Price", "Quantity", "Basic Commodity","Senior Citizen/PWD", "Amount"};
               return columns[column];
           }

           @Override
           public int getRowCount() {

               return productList.size();
           }

           @Override
           public int getColumnCount() {
               return 7;
           }

           @Override
           public Object getValueAt(int rowIndex, int columnIndex) {
               if (columnIndex == 0){
                   return productList.get(rowIndex).getSKU();
               }else if(columnIndex == 1){
                   return  productList.get(rowIndex).getName();
               }else if(columnIndex == 2){
                   return productList.get(rowIndex).getPrice();
               }else if(columnIndex == 3){
                   return productList.get(rowIndex).getQuantity();
               }else if(columnIndex ==4){
                   return productList.get(rowIndex).getProductType();
               }else if(columnIndex==5){
                   return productList.get(rowIndex).getCitizenType();
               }else{
                   return  productList.get(rowIndex).getAmount();
               }
           }
       });

       addComponent(0,2,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,10,frame,new JScrollPane(table));


       field.addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e) {

           }

           @Override
           public void keyPressed(KeyEvent e) {
               if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   for(int i=0; i< productList.size(); i++){
                       if(field.getText().equals(productList.get(i).getSKU())){
                           Product p = productList.get(i);

                           if(checkbox.isSelected()){

                               p.setCitizenType(true);
                           }else{

                               p.setCitizenType(false);
                           }

                           //determine the total if citizen is senior/pwd or just a regular citizen (apply the discounts if necessary)
                            if(p.getCitizenType() == false) {
                                int currentQuantity = p.getQuantity();
                                int newQuantity = p.setQuantity(currentQuantity + 1); //increment the quantity
                                p.setAmount(newQuantity * p.getPrice()); // set total amount of the product when its added

                                total[0] = 0;
                                for (int j = 0; j < productList.size(); j++) {
                                    total[0] += productList.get(j).getAmount(); //calculate total
                                }//update
                                totalAmount.setText("Total: " + total[0]);
                                ((AbstractTableModel) table.getModel()).fireTableDataChanged(); //update table
                            }else{
                                if(p.getProductType()==true){ //if basic commodity
                                    int currentQuantity = p.getQuantity();
                                    int newQuantity = p.setQuantity(currentQuantity + 1);

                                    double CommodityDiscount = 0;
                                   CommodityDiscount = p.getPrice() * 0.05;

                                   double discountedPrice = 0;

                                  discountedPrice =  p.setAmount(p.getPrice()-CommodityDiscount);

                                  p.setAmount(newQuantity * discountedPrice);

                                    total[0] = 0;
                                    LESSPWDSCDSC[0]=CommodityDiscount;
                                    for (int j = 0; j < productList.size(); j++) {
                                        total[0] += productList.get(j).getAmount(); //calculate total
                                    }//update
                                    totalAmount.setText("Total: " + total[0]);
                                    lessPWDSCDSC.setText("Less Senior Citizen/PWD Discount: " + LESSPWDSCDSC[0]);
                                    ((AbstractTableModel) table.getModel()).fireTableDataChanged(); //update table

                                }else{
                                    //non basic commodity
                                    int currentQuantity = p.getQuantity();
                                    int newQuantity = p.setQuantity(currentQuantity + 1);

                                    double tax = 0; //tax removal
                                    tax = (p.getPrice()/1.12) * 0.12;

                                    double NONCommodityDiscount = 0;
                                    NONCommodityDiscount = (p.getPrice()/1.12) * 0.20;

                                    double discountedPrice = 0;

                                    discountedPrice =  p.setAmount(p.getPrice() - tax - NONCommodityDiscount);

                                    p.setAmount(newQuantity * discountedPrice);

                                    total[0] = 0;
                                    LESSPWDSCDSC[0]= NONCommodityDiscount;
                                    LESSVAT[0] = tax;
                                    for (int j = 0; j < productList.size(); j++) {
                                        total[0] += productList.get(j).getAmount(); //calculate total
                                    }//update
                                    lessVAT.setText("Less VAT: " + LESSVAT[0]);
                                    totalAmount.setText("Total: " + total[0]);
                                    lessPWDSCDSC.setText("Less Senior Citizen/PWD Discount: " + LESSPWDSCDSC[0]);
                                    ((AbstractTableModel) table.getModel()).fireTableDataChanged(); //update table
                                }
                            }

                       }
                   }
               }
           }

           @Override
           public void keyReleased(KeyEvent e) {

           }
       });

       frame.setSize(1000, 1000);
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
