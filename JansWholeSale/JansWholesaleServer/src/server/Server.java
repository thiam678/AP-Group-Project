package server;

import model.Customer;
import model.Date;
import model.Product;

import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.time.LocalDate;

public class Server{
    private ServerSocket serverSocket;
    private Socket connectionSocket;
    private ObjectOutputStream objOs;
    private ObjectInputStream objIs;
    private static Connection dBConn = null;
    private Statement stmt;

    private PreparedStatement pst;
    private ResultSet result=null;

    int affectedRows=0;

    public Server() {
        this.createConnection();
        this.waitForRequests();
    }
    private void createConnection() {
        try {
            serverSocket= new ServerSocket(8888);
            JOptionPane.showMessageDialog(null, "Server is now ready...",
                    "SERVER STATUS",JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Server not ready...",
                    "SERVER STATUS",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void configureStreams() {
        try {
            objOs= new ObjectOutputStream(connectionSocket.getOutputStream());
            objIs = new ObjectInputStream(connectionSocket.getInputStream());
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    private static void getDatabaseConnection() {
        if(dBConn==null) {
            String url="jdbc:mysql://localhost:3307/lab7db";
            try {
                dBConn= DriverManager.getConnection(url, "root", "usbw");
                JOptionPane.showMessageDialog(null, "DB connection Established",
                        "CONNECTION STATUS",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Could not connect to database\n",
                        "Connection Failure",JOptionPane.ERROR_MESSAGE);
            }

        }

    }
    private void closeConnection() {
        try {
            objOs.close();
            objIs.close();
            connectionSocket.close();
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    private void addProduct(Product obj) {
        String query = "INSERT INTO janswholesale.product (productName, shortDescription, longDescription, itemInStock, unitPrice)"
                + "VALUES('" + obj.getproductName() + "','" + obj.getShortDescription() + "','" + obj.getLongDescription()
                + "','"+obj.getItemsInStock() + "','" +obj.getUnitPrice()+"');";
        try{
            stmt = dBConn.createStatement();
            if((stmt.executeUpdate(query)==1)){
                objOs.writeObject (true);
            }
            else {
                objOs.writeObject (false);
            }
        } catch(IOException | SQLException ioe) {
            ioe.printStackTrace();
        }
    }
    private Product findProductById (String productCode) {
        Product prod = new Product() ;
        String query = "SELECT * FROM janswholesale.product WHERE productCode = " + productCode;
        try {
            stmt = dBConn.createStatement () ;
            result = stmt.executeQuery (query);

            if (result.next ()) {
                prod.setproductName(result.getString(2));
                prod.setShortDescription(result.getString(3));
                prod.setLongDescription(result.getString(4));
                prod.setItemsInStock(Integer.parseInt(result.getString(5)));
                prod.setUnitPrice(Float.parseFloat(result.getString(6)));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prod;
    }
    public void updateProduct(Product prod) {
        try{
            String query= ("UPDATE janswholesale.product set productName = ?,shortDescription = ?," +
                    "longDescription = ?, itemsInStock = ?,unitPrice=? where productCode = ?");
            stmt = dBConn.createStatement();
            affectedRows = stmt.executeUpdate(query);
            if(affectedRows >=1) {
                System.out.println("Record of Product Code"+ prod.getProductCode()
                        + " has been changed to " );
            }

        } catch (Exception e) {
            System.err.println("Error Updating Record: "+ e.getMessage());
        }
    }
    public void deleteProduct(String pCode) {
        try {
            pst = dBConn.prepareStatement("delete from product  where productCode = ?");

            pst.setString(1, pCode);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Deleted!!");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        private void addCustomer(Customer obj) {
        String query = "INSERT INTO janswholesale.customer (idNumber, name, address, telephone, email, "
                + "dateOfBirth, dateOfMemberShip, dateOfMembershipExpiration )"
                + "VALUES ('"+ obj.getIdNumber() + "' , '"+ obj.getName() +"','"
                +obj.getAddress()+"' , '" +obj.getTelephone()+"' , '" +obj.getEmail()+"' , '" +obj.getDob().getYear()
                +"-" +obj.getDob().getMonth()+"-"+obj.getDob().getDay()+"','"
                + obj.getDateOfMembership().getYear()+"-" + obj.getDateOfMembership().getMonth()+"-"+obj.getDateOfMembership().getDay()
                +"' , '" +obj.getDateOfExpiry().getYear()+"-"+obj.getDateOfExpiry().getMonth()+"-"+obj.getDateOfExpiry().getDay()+"')";
        try{
            stmt = dBConn.createStatement();
            if((stmt.executeUpdate(query)==1)){
                objOs.writeObject (true);
            }
            else {
                objOs.writeObject (false);
            }
        } catch(IOException | SQLException ioe) {
            ioe.printStackTrace();
        }
    }
    private Customer findCustomerById (String idNumber) {
        Customer cus = new Customer() ;
        
        String query = "SELECT * FROM janswholesale.customer WHERE idNumber = " + idNumber;
        try {
            stmt = dBConn.createStatement () ;
            result = stmt.executeQuery (query);

            if (result.next ()) {
                cus.setIdNumber(result.getString(2));
                cus.setName(result.getString(3));
                cus.setAddress(result.getString(4));
                cus.setTelephone(result.getString(5));
                cus.setEmail(result.getString(6));
                LocalDate dob = LocalDate.parse(result.getString(7));
                LocalDate membership = LocalDate.parse(result.getString(8));
                LocalDate membershipExpiration =LocalDate.parse(result.getString(9));

                cus.setDob(new model.Date(dob.getDayOfMonth(),dob.getMonthValue(),dob.getYear()));
                cus.setDateOfMembership(new model.Date(membership.getDayOfMonth(),membership.getMonthValue(),membership.getYear()));
                cus.setDateOfExpiry(new Date(membershipExpiration.getDayOfMonth(),membershipExpiration.getMonthValue()
                        ,membershipExpiration.getYear()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cus;
    }
    public void updateCustomer(Customer cus) {
        try{
            String query= ("UPDATE janswholesale.customer set name = ?,address = ?," +
                    "telephone = ?, email= ?,dateOfBirth=?, dateOfMemberShip=?, " +
                    "dateofMembershipExpiration where idNumber = ?");
            stmt = dBConn.createStatement();
            affectedRows = stmt.executeUpdate(query);
            if(affectedRows >=1) {
                System.out.println("Record of Product Code"+ cus.getIdNumber()
                        + " has been changed to " );
            }

        } catch (Exception e) {
            System.err.println("Error Updating Record: "+ e.getMessage());
        }
    }
    public void deleteCustomer(String idNumber) {
        try {
            pst = dBConn.prepareStatement("delete from product  where productCode = ?");

            pst.setString(1, idNumber);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Deleted!!");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("InfiniteLoopStatement")
    private void waitForRequests() {
        String action;
        getDatabaseConnection();
        Product prod = null;
        Customer cus = null;
        try {
            while(true) {
                connectionSocket= serverSocket.accept();
                this.configureStreams();
                try {
                    action = (String) objIs.readObject();

                    if(action.equals("Add Product")) {
                        prod =(Product) objIs.readObject();
                        addProduct(prod);
                        objOs.writeObject(true);
                    }
                    else if (action.equals("Find Product")) {
                        String productCode = (String) objIs.readObject();
                        prod =findProductById(productCode);
                        objOs.writeObject(prod);
                    }
                    else if(action.equals("Update Product")){
                        prod =(Product) objIs.readObject();
                        updateProduct(prod);
                    }
                    else if(action.equals("Delete Product")){
                        prod =(Product) objIs.readObject();
                        deleteProduct(prod.getProductCode());
                    }
                    if(action.equals("Add Customer")) {
                        cus =(Customer) objIs.readObject();
                        addCustomer(cus);
                        objOs.writeObject(true);
                    }
                    else if (action.equals("Find Customer")) {
                        String idNumber = (String) objIs.readObject();
                        cus =findCustomerById(idNumber);
                        objOs.writeObject(cus);
                    }
                    else if(action.equals("Update Customer")){
                        cus =(Customer) objIs.readObject();
                        updateCustomer(cus);
                    }
                    else if(action.equals("Delete Customer")){
                        prod =(Product) objIs.readObject();
                        deleteProduct(prod.getProductCode());
                    }

                } catch (ClassNotFoundException | ClassCastException ex) {
                    ex.printStackTrace();
                }
                this.closeConnection();
            }
        } catch (EOFException ex) {
            System.out.println("Client has terminated connections with the server");
            ex.printStackTrace();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Server();
    }
}

