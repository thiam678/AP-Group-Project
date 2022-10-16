package model;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Connector {
	private static Connection myConn = null;
	
	/*
	 * TRY THIS BELOW AND YOU'LL SEE WHERE IT WENT WRONG
	 */
	public static Connection getDatabaseConnection() {
		
		if(myConn != null) {
			return myConn;
		}
		if(myConn == null) {
			String url = "jdbc:mysql://localhost:3307/janswholesale";
			
			try {
				myConn = DriverManager.getConnection(url, "root", "usbw");
				if(myConn != null) {
					JOptionPane.showMessageDialog(null, "Connection established",
							"JDBC Connection Status", JOptionPane.INFORMATION_MESSAGE );
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return myConn;
	}
	
}
