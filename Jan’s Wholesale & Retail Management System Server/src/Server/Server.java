package Server;
import domain.Department;
import domain.Employee;


import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Server
{

	private static Connection myConn = null;
	private ServerSocket serverSocket;
	private Socket connectionSocket;
	private ObjectOutputStream objOs; 
	private ObjectInputStream objIs;

	
	//Default Constructor
	public Server()
	{
		this.createConnection();
		this.waitForRequest();
	}
		
	public static Connection getDatabaseConnection()
	{
		
		if(myConn != null) {
			return myConn;
		}
		if(myConn == null) {
			String url = "jdbc:mysql://localhost:3306/janswholesale";
			
			try {
				myConn = DriverManager.getConnection(url, "root", "");
				if(myConn != null) {
					JOptionPane.showMessageDialog(null, "Connection established",
							"JDBC Connection Status", JOptionPane.INFORMATION_MESSAGE );
				}
				
			}catch(Exception e) {
				System.out.println("not able to connect to mysql/janswholesale");
				JOptionPane.showMessageDialog(null, "Could not connect to database\n" + e,
						"CONNECTION FAILURE", JOptionPane.ERROR_MESSAGE);// part that has null should be a GUI component 
				e.printStackTrace();
			}
		}
		
		return myConn;
	}
	
	
	
	private void createConnection() 
	{
		try {
			System.out.println("Creating Server Connection . . .");
		serverSocket = new ServerSocket(9000);
		}catch (IOException e) {
			e.printStackTrace();			
		}
	}
	
	private void configureStreams()
	{
		try {
			System.out.println("About to configure streams . . .");
			objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
			objIs = new ObjectInputStream(connectionSocket.getInputStream());
			System.out.println("Streams configured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void closeConnection()
	{		
		try {
			objOs.close();
			objIs.close();
			connectionSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void waitForRequest() 
	{
		String action = "";//probably based on what the cashier client presses on the GUI
		getDatabaseConnection();
		Employee employeeObject = null;
		Department depObj = null;
		
		System.out.println("Waiting for client's requests . . . ");
		try {
			while(true) 
			{
				connectionSocket = serverSocket.accept();
				this.configureStreams();
				try {
					action = (String) objIs.readObject();
					
					if(action.equals("Create Employee"))
					{
						employeeObject = (Employee) objIs.readObject();
						StaffController.createEmployeeRecord(employeeObject);//Passes data through parameters from stream to create new employee
						objOs.writeObject(true);
					}/* else if (action.equals("Update Employee Email")) {
						String empID = (String) objIs.readObject();
						String Email = (String) objIs.readObject();
						//Call method to find the Employee based on the id number
						
						StaffController.updateEmployeeEmail(empID, Email);//Passes data through parameters from stream to update employee's email
						objOs.writeObject(true);
					} else if (action.equals("Update Employee Telephone")) {
						String empID = (String) objIs.readObject();
						String Telephone = (String) objIs.readObject();
						//Call method to find the Employee based on the id number
						
						StaffController.updateEmployeeTelephone(empID, Telephone);//Passes data through parameters from stream to update employee's telephone
						objOs.writeObject(true);
					}*/ else if (action.equals("Delete Employee Record")) {
						String empID = (String) objIs.readObject();
						
						StaffController.deleteEmployeeRecord(empID);//Passes data through parameters from stream to delete employee's record
					} else if (action.equals("Find Employee Record")) {
						String empID = (String) objIs.readObject();
						
					
				      
				      objOs.writeObject(StaffController.viewEmployeeRecord(empID));
					} else if (action.equals("View All Employee Records")) {
						StaffController.viewEmployeeRecords();
						objOs.writeObject(employeeObject);
					} else if (action.equals("Create Department")) {
						depObj = (Department) objIs.readObject();
											
						DepartmentController.createDepartmentRecord(depObj);
						objOs.writeObject(true);
						
					}else if (action.equals("Update Employee Record")) {
						//String empID = (String) objIs.readObject();
						employeeObject = (Employee) objIs.readObject();
						//Call method to find the Employee based on the id number
						//StaffController.viewEmployeeRecord(empID);
						StaffController.updateEmployeeRecord(employeeObject);//Passes data through parameters from stream to update employee's email
						//objOs.writeObject(true);
					}else if (action.equals("Retrieve IDs")) {
					
						objOs.writeObject(StaffController.viewEmployeeIDs());
					}
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				} catch (ClassCastException ex) {
					ex.printStackTrace();
				}
				this.closeConnection();
			}
		} catch (EOFException ex) {
			System.out.println("Client has terminated its connection with server");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
}
