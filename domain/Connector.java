package domain;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Connector {
private static Connection myConn = null;
	
	public static Connection getDatabaseConnection() {
		try {
			//1. Get Connection to localhost/xampp server
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jans_wholesale","root","");
			
			if (myConn != null) { //If connection was made to the xampp server
			  JOptionPane.showMessageDialog(null,"Connected to Local Server",
			 "JDBC Connection Status", JOptionPane.INFORMATION_MESSAGE);
			}
			
			myConn.close();
			
			}catch (Exception e) {
			e.printStackTrace ();


	        }
		return myConn;
	}
		
		
  }


