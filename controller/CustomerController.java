package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Customer;
import model.Connector;

public class CustomerController {
	private static Connection dbConn = Connector.getDatabaseConnection();
	private static Statement stmt =null;
	private static int affectedRows = 0;
	
	public void insertRecord(Customer obj) {
		String query = "INSERT INTO janswholesale.customer (idNumber, name, address, telephone, email, "
				+ "dateOfBirth, dateOfMemberShip, dateOfMembershipExpiration )" 
				+ "VALUES ('"+ obj.getIdNumber() + "' , '"+ obj.getName() +"','" 
				+obj.getAddress()+"' , '" +obj.getTelephone()+"' , '" +obj.getEmail()+"' , '" +obj.getDob().getYear()
				+"-" +obj.getDob().getMonth()+"-"+obj.getDob().getDay()+"','"
				+ obj.getDateOfMembership().getYear()+"-" + obj.getDateOfMembership().getMonth()+"-"+obj.getDateOfMembership().getDay()
				+"' , '" +obj.getDateOfExipiry().getYear()+"-"+obj.getDateOfExipiry().getMonth()+"-"+obj.getDateOfExipiry().getDay()+"')";
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
	public double memberShipDiscount() {
		double discount = 0;
		return discount;
		
	}
  

}
