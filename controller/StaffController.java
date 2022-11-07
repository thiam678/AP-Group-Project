package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Employee;
import model.Connector;

public class StaffController {

    private static Connection dbConn = Connector.getDatabaseConnection();
    private static Statement stmt =null;
    private static int affectedRows = 0;

    public void createEmployeeRecord(Employee obj) {
        String query = "INSERT INTO employee.employee (empID, name, empEmail, empTele)"
                + "VALUES ('"+ obj.getEmpID() + "' , '"+ obj.getName() +"', '" + obj.getEmpEmail()+"','"+obj.getEmpTele()+"',)'";
        try {
            stmt = dbConn.createStatement();
            affectedRows = stmt.executeUpdate(query);
            
            if(affectedRows ==1) {
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
    public void viewEmployeeRecord(Employee obj) throws SQLException {
    	
    	 Statement statement = StaffController.dbConn.createStatement();
    	    String view = "select * from employee";
    	    ResultSet resultSet = statement.executeQuery(view);
    	    
    	    try {
                statement = dbConn.createStatement();
                while (resultSet.next()) {
                
                	JOptionPane.showMessageDialog(null, view);
                }
                	
    	    }catch(Exception e) {
                System.err.println("Record " +e.getMessage());
            }
    	    

    }

}
