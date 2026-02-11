import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProductScreen extends JFrame {


    public  ProductScreen() {

        ArrayList<Product> product = new ArrayList<>();

        JFrame frame = new JFrame("Product Screen");
        Container container = frame.getContentPane();
        container.setLayout(new GridBagLayout());
        JTextField SKUfield = new JTextField(10);
        JLabel SKULabel = new JLabel("SKU:");
        JTextField Namefield = new JTextField(10);
        JLabel NameLabel = new JLabel("Name:");
        JTextField Pricefield = new JTextField(10);
        JLabel PriceLabel = new JLabel("Price:");
        JButton saveButton = new JButton("Save");



        addComponent(1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,4,frame,SKUfield);
        addComponent(0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,frame,SKULabel);
        addComponent(1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,4,frame,Namefield);
        addComponent(0,1,GridBagConstraints.CENTER,GridBagConstraints.NONE,frame,NameLabel);
        addComponent(1,2,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,4,frame,Pricefield);
        addComponent(0,2,GridBagConstraints.CENTER,GridBagConstraints.NONE,frame,PriceLabel);
        addComponent(4,3,GridBagConstraints.CENTER,frame,saveButton);


        JTable table = new JTable(new AbstractTableModel() {

            @Override
            public String getColumnName(int column){
                String[] columns = new String[] {"SKU", "Name", "Price"};
                return columns[column];
            }

            @Override
            public int getRowCount() {
                return product.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
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

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SKU = SKUfield.getText();
                String Name = Namefield.getText();
                Double Price = Double.parseDouble(Pricefield.getText());

                product.add(new Product(SKU, Name, Price));
                ((AbstractTableModel)table.getModel()).fireTableDataChanged();
                SKUfield.setText("");
                Namefield.setText("");
                Pricefield.setText("");
                SKUfield.requestFocus();
            }
        });

        addComponent(0,4,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,5,frame,new JScrollPane(table));

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

    public static void addComponent(int x, int y, int fill, JFrame frame, Component c){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.fill = fill;
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
