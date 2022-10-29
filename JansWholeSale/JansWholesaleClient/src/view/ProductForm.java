package view;

import client.Client;
import model.Product;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductForm  implements ActionListener {

    private JPanel Main;
    private JTextField productNameTextField;
    private JTextField sDescriptionTextField;
    private JTextField lDescriptionTextField;
    private JButton delete;
    private JButton searchButton;
    private JTextField itemInStockTextField;
    private JTextField unitPriceTextField;
    private JButton saveButton;
    private JButton updateButton;
    private JTextField searchIDTextField;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductForm");
        frame.setContentPane(new ProductForm().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ProductForm() {
        saveButton.addActionListener(this);
        delete.addActionListener(this);
        searchButton.addActionListener(this);
        updateButton.addActionListener(this);
        delete.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Product product = new Product();
        Client client = new Client();

        if (e.getSource() == saveButton) {
            product.setproductName(productNameTextField.getText());
            product.setShortDescription(sDescriptionTextField.getText());
            product.setLongDescription(lDescriptionTextField.getText());
            product.setItemsInStock(Integer.parseInt(itemInStockTextField.getText()));
            product.setUnitPrice(Float.parseFloat(unitPriceTextField.getText()));

            productNameTextField.setText("");
            sDescriptionTextField.setText("");
            lDescriptionTextField.setText("");
            itemInStockTextField.setText("");
            unitPriceTextField.setText("");

            productNameTextField.requestFocus();


        }
        client.sendAction("Add Product");
        System.out.println("Message sent to server");
        client.sendProduct(product);
        System.out.println("Record sent to server");
        client.receiveResponse();
        System.out.println("Response receive from server");
        client.closeConnection();
        System.out.println("Connection Closed");

        String pCode = null;
        if (e.getSource() == delete) {

            pCode = searchIDTextField.getText();

            searchIDTextField.setText("");
            productNameTextField.setText("");
            sDescriptionTextField.setText("");
            lDescriptionTextField.setText("");
            itemInStockTextField.setText("");
            unitPriceTextField.setText("");

            searchIDTextField.requestFocus();

        }
        client.sendAction("Delete Product");
        System.out.println("Message sent to server");
        client.deleteProduct(pCode);
        System.out.println("Record sent to server");
        client.receiveResponse();
        System.out.println("Response receive from server");
        client.closeConnection();
        System.out.println("Connection Closed");

        if (e.getSource()== searchButton){

            pCode= searchIDTextField.getText();

            productNameTextField.setText(product.getproductName());
            sDescriptionTextField.setText(product.getShortDescription());
            lDescriptionTextField.setText(product.getLongDescription());
            itemInStockTextField.setText(String.valueOf(product.getItemsInStock()));
            unitPriceTextField.setText(String.valueOf(product.getUnitPrice()));
        }
        client.sendAction("Find Product");
        System.out.println("Message sent to server");
        client.sendProductCode(pCode);
        System.out.println("Record sent to server");
        client.receiveResponse();
        System.out.println("Response receive from server");
        client.closeConnection();
        System.out.println("Connection Closed");

        if(e.getSource()== updateButton){

        }
        if (e.getSource()==delete){
            String productCode= searchIDTextField.getText();

            client.sendAction("Delete Product");
            System.out.println("Message sent to server");
            client.deleteProduct(pCode);
            System.out.println("Record deleted server");
            client.receiveResponse();
            System.out.println("Response receive from server");
            client.closeConnection();
            System.out.println("Connection Closed");
        }


    }


}
