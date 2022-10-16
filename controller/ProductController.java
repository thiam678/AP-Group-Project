package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Connector;
import model.Product;

public class ProductController {
	private static Connection dbConn = Connector.getDatabaseConnection();
	private static Statement stmt =null;
	private static int affectedRows = 0;
	
	public static void insertRecord(Product obj) {
		String query = "INSERT INTO janswholesale.product (productCode, productName, "
				+ "shortDescription, longDescription, itemInStock, unitPrice)" 
				+ "VALUES ('"+ obj.getProductCode() + "' , '"+ obj.getproductName() + "' , '"
				+ obj.getShortDescription()+ "' , '"+ obj.getLongDescription() 
				+ "' ,'"+obj.getItemsInStock()+"','" + obj.getUnitPrice()+"')";
		try {
		    stmt = dbConn.createStatement();
			affectedRows = stmt.executeUpdate(query);
			if(affectedRows == 1) {
				JOptionPane.showMessageDialog(null,
						"Record Created", "Record creation status",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (SQLException e) {
				System.err.println("ERROR IS IN YOUR SQL STATEMENT");
		}catch(Exception e) {
			System.err.println("ERROR Creating Record: " +e.getMessage());
		}
	}
	
	
	public static void update(String productCode, float unitPrice) {
		
		String update = "UPDATE jan's_wholesale.product SET Unit Price = '" + unitPrice
							+ "' WHERE Product Code = '"+ productCode + "'";
		try {
			stmt = dbConn.createStatement();
			affectedRows = stmt.executeUpdate(update);
			if(affectedRows >=1) {
				System.out.println("Unit Price of Product Code"+ productCode
						+ " has been changed to " + unitPrice);
			}
			
		} catch (Exception e) {
			System.err.println("Error Updating Record: "+ e.getMessage());
		}
	}
	
	public static void delete(String productCode) {
		
		String deleteRecord = "DELETE FROM jan's_wholesale.product "
				+ "WHERE Product Code = '"+productCode+"'";
		
		try {
			stmt = dbConn.createStatement();
			affectedRows = stmt.executeUpdate(deleteRecord);
			
			if (affectedRows == 1) {
				System.out.println("Record Deleted Successfully");
			}
			
		} catch (Exception e) {
			System.err.println("Error Deleting Record: "+ e.getMessage());
		}
		
	}
	

}
