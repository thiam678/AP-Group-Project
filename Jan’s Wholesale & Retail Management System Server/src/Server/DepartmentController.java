package Server;
import domain.Department;
import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DepartmentController 
{
	    private static Connection myConn = Server.getDatabaseConnection();
	    private static Statement stmt =null;
	  
	   
	    private static int affectedRows = 0;
	    
	    public static void createDepartmentRecord(Department obj)
	    {
	    	String query = "INSERT  INTO janswholesale.`department` (DepartmentCode, DepartmentName)" + 
	    "VALUES ('"+ obj.getDepCode() + "', '"+ obj.getDepName() +"')";
	    	
	    	try {
	    		stmt = myConn.createStatement();
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
}
