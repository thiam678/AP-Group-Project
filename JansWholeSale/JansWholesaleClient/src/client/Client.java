package client;

import model.Customer;
import model.Product;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private Socket connectionSocket;
    private ObjectOutputStream objOs;
    private ObjectInputStream objIs;
    private String action="";

    public Client() {
        this.createConnection();
        this.configureStreams();

    }
    private void createConnection() {
        try {
            connectionSocket= new Socket("127.0.0.1",8888);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void configureStreams() {
        try {
            objIs = new ObjectInputStream(connectionSocket.getInputStream());
            objOs= new ObjectOutputStream(connectionSocket.getOutputStream());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
   public void closeConnection(){
        try {
            objOs.close();
            objIs.close();
            connectionSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
   }
    public void sendAction(String action) {
        this.action=action;
        try {
            objOs.writeObject(action);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendProduct(Product prod) {
        try {
            objOs.writeObject(prod);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendProductCode(String pCode) {
        try {
            objOs.writeObject(pCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateProduct(Product prod) {
        try {
            objOs.writeObject(prod.getProductCode());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteProduct(String pCode) {
        try {
            objOs.writeObject(pCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendCustomer (Customer cus){
            try {
                objOs.writeObject(cus);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public void sendCustomerID (String idNumber){
            try {
                objOs.writeObject(idNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public void updateCustomer(Customer cus) {
        try {
            objOs.writeObject(cus.getIdNumber());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteCustomer(String idNumber) {
        try {
            objOs.writeObject(idNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void receiveResponse() {
        try {
            if(action.equalsIgnoreCase("Add Product")) {
                Boolean flag = (Boolean) objIs.readObject();
                if(flag== true) {
                    JOptionPane.showMessageDialog(null, "Record added successfully", "Add Record Status",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error adding record", "Add Record Status",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(action.equalsIgnoreCase("Find Product")) {
                Product prod;
                prod = (Product) objIs.readObject();
                if(prod==null) {
                    JOptionPane.showMessageDialog(null, "Record could not be found", "Find Record Status",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if(action.equalsIgnoreCase("Update Product")) {
                Boolean flag = (Boolean) objIs.readObject();
                if(flag== true) {
                    JOptionPane.showMessageDialog(null, "Record updated successfully", "Update Record Status",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error updating record", "Update Record Status",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
            if(action.equalsIgnoreCase("Delete Product")) {
                Boolean flag = (Boolean) objIs.readObject();
                if(flag== true) {
                    JOptionPane.showMessageDialog(null, "Record deleted successfully", "Delete Record Status",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error deleting record", "Delete Record Status",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(action.equalsIgnoreCase("Add Customer")) {
                Boolean flag = (Boolean) objIs.readObject();
                if(flag== true) {
                    JOptionPane.showMessageDialog(null, "Record added successfully", "Add Record Status",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(action.equalsIgnoreCase("Find Customer")) {
                Customer cus;
                cus = (Customer) objIs.readObject();
                if(cus==null) {
                    JOptionPane.showMessageDialog(null, "Record could not be found", "Find Record Status",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            if(action.equalsIgnoreCase("Update Customer")) {
                Boolean flag = (Boolean) objIs.readObject();
                if(flag== true) {
                    JOptionPane.showMessageDialog(null, "Record updated successfully", "Update Record Status",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error updating record", "Update Record Status",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(action.equalsIgnoreCase("Delete Customer")) {
                Boolean flag = (Boolean) objIs.readObject();
                if(flag== true) {
                    JOptionPane.showMessageDialog(null, "Record deleted successfully", "Delete Record Status",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error deleting record", "Delete Record Status",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (ClassCastException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Client();
    }

}
