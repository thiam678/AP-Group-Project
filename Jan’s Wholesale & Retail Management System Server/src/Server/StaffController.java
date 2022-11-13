package Server;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import domain.Employee;

public class StaffController 
{
	    private static Connection myConn = Server.getDatabaseConnection();
	    private static Statement stmt =null;
	    private static ResultSet result = null;
	   
	    private static int affectedRows = 0;

	    public static void createEmployeeRecord(Employee obj) {
	        String query = "INSERT INTO janswholesale.`employee` (EmployeeID, Name, Email, Telephone, DepartmentCode, EmployeeCode)"
	                + "VALUES ('"+ obj.getEmpID() + "', '"+ obj.getName() +"', '" + obj.getEmpEmail()+"', '"+obj.getEmpTele()+"', '"+obj.getDepCode()+"', '"+obj.getEmpCode()+"')";
	        
	        try {	        		
	            stmt = myConn.createStatement();
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
	    
	    //Searches for and View's one employee record by entering Id
	    public static Employee viewEmployeeRecord(String empID) {
	    	
	    	 Employee employee = new Employee();
	    	    String view = "SELECT * FROM janswholesale.employee WHERE EmployeeID= " + empID;
	    	    try {
	    	        stmt = myConn.createStatement();
	                result =  stmt.executeQuery(view);
	                while (result.next()) {
	                   employee.setEmpID(result.getString("EmployeeID"));
	 	               employee.setName(result.getString("Name"));
	 	               employee.setEmpEmail(result.getString("Email"));
	 	               employee.setEmpTele(result.getString("Telephone"));
	 	               employee.setDepCode(result.getString("DepartmentCode"));
	 	               employee.setEmpCode(result.getString("EmployeeCode"));
	 	          
	 	              // Employee emp = new Employee(id,name,email,telephone,depoCode,empCode);
	 	               
	 	               employee.toString();
	 	              //System.out.println("Employee [EmployeeID=" + id +", Name=" + name + ", Email Address=" + email + ", Telephone Number=" + telephone+ "]");
	            //   JOptionPane.showMessageDialog(null, "Employee [EmployeeID=" + id +", Name=" + name + ", Email Address=" + email + ", Telephone Number=" + telephone +"departmentCode=" + depoCode + "employeeCode="+ empCode+"]");
	                }
	                	
	    	    }catch(SQLException e) {
	                System.err.println("Record " +e.getMessage());
	            }
				return employee;
	    	    
	    }
	    
	     
	    
	    //Views all employee records 
	    public static Employee viewEmployeeRecords() {
	    	
	    	 Employee employee = new Employee();
	    	    String view = "SELECT * FROM `employee`";
	    	    try {
	    	        stmt = myConn.createStatement();
	                result =  stmt.executeQuery(view);
	                while (result.next()) {
	                	   employee.setEmpID(result.getString("EmployeeID"));
		 	               employee.setName(result.getString("Name"));
		 	               employee.setEmpEmail(result.getString("Email"));
		 	               employee.setEmpTele(result.getString("Telephone"));
		 	               employee.setDepCode(result.getString("DepartmentCode"));
		 	               employee.setEmpCode(result.getString("EmployeeCode"));
	 	              
	 	              // System.out.println(id + name + email + telephone);
	 	              //System.out.println("Employee [EmployeeID=" + id +", Name=" + name + ", Email Address=" + email + ", Telephone Number=" + telephone+ ", Department Code="+depoCode+", Employee Code="+ empCode+"]");
	                	//JOptionPane.showMessageDialog(null, view);
	                }
	                	
	    	    }catch(SQLException e) {
	                System.err.println("Record " +e.getMessage());
	            }
				return employee;
	    	    
	    }
	    
	  //Views all employee records 
	    public static String viewEmployeeIDs() {
	    	
	    	String id = null;
	    	    String view = "SELECT * FROM `employee`";
	    	    try {
	    	        stmt = myConn.createStatement();
	                result =  stmt.executeQuery(view);
	                while (result.next()) {
	                	  id = result.getString("EmployeeID");
		 	             //  employee.setName(result.getString("Name"));
		 	               //employee.setEmpEmail(result.getString("Email"));
		 	               //employee.setEmpTele(result.getString("Telephone"));
		 	               //employee.setDepCode(result.getString("DepartmentCode"));
		 	               //employee.setEmpCode(result.getString("EmployeeCode"));
	 	              
	 	              // System.out.println(id + name + email + telephone);
	 	              //System.out.println("Employee [EmployeeID=" + id +", Name=" + name + ", Email Address=" + email + ", Telephone Number=" + telephone+ ", Department Code="+depoCode+", Employee Code="+ empCode+"]");
	                	//JOptionPane.showMessageDialog(null, view);
	                }
	                	
	    	    }catch(SQLException e) {
	                System.err.println("Record " +e.getMessage());
	            }
				return id;
	    	    
	    }
	    
	    /*
	    //Updates Employee's email address
	    public static void updateEmployeeEmail(String empID, String empEmail) {
			
			String update = "UPDATE janswholesale.employee SET Email = '" + empEmail
								+ "' WHERE EmployeeID = '"+ empID + "'";
			try {
				stmt = myConn.createStatement();
				affectedRows = stmt.executeUpdate(update);
				if(affectedRows == 1) {
					System.out.println("Email of EmployeeID "+ empID
							+ " has been changed to " + empEmail);
				}
				
			} catch (Exception e) {
				System.err.println("Error Updating Record: "+ e.getMessage());
			}
			
		}
		
	    //Update Employee's Telephone number
		public static void updateEmployeeTelephone(String empID, String empTele) {
			
			String update = "UPDATE janswholesale.employee SET Telephone = '" + empTele
								+ "' WHERE EmployeeID = '"+ empID + "'";
			try {
				stmt = myConn.createStatement();
				affectedRows = stmt.executeUpdate(update);
				if(affectedRows ==1) {
					System.out.println("Telephone of EmployeeID"+ empID
							+ " has been changed to " + empTele);
				}
				
			} catch (Exception e) {
				System.err.println("Error Updating Record: "+ e.getMessage());
			}
			
		}*/
		
		//Update Employee's Telephone number
		public static void updateEmployeeRecord(Employee obj) {
			/*EmployeeID = '" + obj.getEmpID() + "',*/
			String update = "UPDATE janswholesale.employee SET Name = '"+ obj.getName() +"', Email = '" + obj.getEmpEmail()+"', Telephone = '"+obj.getEmpTele()+"', DepartmentCode = '"+obj.getDepCode()+"', EmployeeCode ='"+obj.getEmpCode()+"' WHERE EmployeeID = "+ obj.getEmpID();
			try {
				stmt = myConn.createStatement();
				affectedRows = stmt.executeUpdate(update);
				if(affectedRows ==1) {
					System.out.println("Record of "+ obj.getName() + " has been updated.");
				}
				
			} catch (Exception e) {
				System.err.println("Error Updating Record: "+ e.getMessage());
			}
			
		}
		
		//Delete an employee's record
		public static void deleteEmployeeRecord(String empID) {
			
			String deleteRecord = "DELETE FROM janswholesale.employee "
					+ "WHERE EmployeeID = '"+empID+"'";
			
			try {
				stmt = myConn.createStatement();
				affectedRows = stmt.executeUpdate(deleteRecord);
				
				if (affectedRows == 1) {
					System.out.println("Record Deleted Successfully");
				}
				
			} catch (Exception e) {
				System.err.println("Error Deleting Record: "+ e.getMessage());
			}
			
		}
}
