package controller;



import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.Employee;

import java.net.InetAddress;


public class StaffController {

	private Socket connectionSocket;
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	private String action;
	
	//Default Constructor
	public StaffController()
	{
		System.out.println("About to create client connection . . .");
		this.createConnection();
		this.configureStreams();
		//closeConnection();
	}

	private void createConnection() 
	{
		try {
			System.out.println("About to create client Socket . . .");
		connectionSocket = new Socket(InetAddress.getLocalHost(), 9000);
		System.out.println("client Socket created . . .");
		}catch (IOException e) {
			System.out.println("IO Exception shown");
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

	public void closeConnection()
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
	
	public void sendAction(String action)
	{
		this.action = action;
		try {
			objOs.writeObject(action);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void sendEmployee(Employee empObj)
	{
		try {
			System.out.println("About to send Student data to server");
			objOs.writeObject(empObj);
			System.out.println("Student data sent to server");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendEmployeeId(String empId)
	{
		try {
			objOs.writeObject(empId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendEmployeeEmail(String Email) 
	{
		try {
			objOs.writeObject(Email);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void sendEmployeeTelephone(String Telephone) 
	{
		try {
			objOs.writeObject(Telephone);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Employee retrieveEmployeeRecord() 
	{
		Employee employee = new Employee();
		
		try {
			employee = (Employee) objIs.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	public String retrieveEmployeeIDs() 
	{
		ArrayList<String> employeeIDs = new ArrayList<>();
		
		while(true) 
		{
			try {
				String employeeID = null;
				employeeID = (String) objIs.readObject();
				if (employeeID != null )
				{
					employeeIDs.add(employeeID);
					
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public ArrayList<Employee> recieveResponse()
	{
		ArrayList<Employee> employeeList = new ArrayList<>();
		
		try {
			if (action.equalsIgnoreCase("Create Employee"))
			{
				Boolean flag = (Boolean) objIs.readObject();
						
				if(flag == true)
				{
					JOptionPane.showMessageDialog(null, "Record Added Successfully", "Add Record Status", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Record added to mysql\\janswholesale");
					// part that has null should be a GUI component
				}
			}
			if(action.equalsIgnoreCase("Update Employee Record"))
			{
				Employee employee = (Employee) objIs.readObject();
				
				if(employee == null)
				{
					JOptionPane.showMessageDialog(null, "Record Updated Successfully", "Update Record Status", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Record updated in mysql\\janswholesale");
					// part that has null should be a GUI component
				}
			
			}
			if(action.equalsIgnoreCase("Update Employee Email"))
			{
				Boolean flag = (Boolean) objIs.readObject();
				
				if(flag == true)
				{
					JOptionPane.showMessageDialog(null, "Record Updated Successfully", "Update Record Status", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Record updated in mysql\\janswholesale");
					// part that has null should be a GUI component
				}
			
			}
			if(action.equalsIgnoreCase("Update Employee Telephone"))
			{
				Boolean flag = (Boolean) objIs.readObject();
				
				if(flag == true)
				{
					JOptionPane.showMessageDialog(null, "Record Updated Successfully", "Update Record Status", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Record updated in mysql\\janswholesale");
					// part that has null should be a GUI component
				}
			
			}
			if(action.equalsIgnoreCase("Delete Employee Record"))
			{
				Boolean flag = (Boolean) objIs.readObject();
				
				if(flag == true)
				{
					JOptionPane.showMessageDialog(null, "Record Deleted Successfully", "Delete Record Status", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Record deleted in mysql\\janswholesale");
					// part that has null should be a GUI component
				}
			}
			if (action.equalsIgnoreCase("Find Employee Record"))
			{
				Employee employee = new Employee();
				employee = (Employee) objIs.readObject();
				/*if (employee != null )
				{
					JOptionPane.showMessageDialog(null, "Record could not be found", "Find Record Status", JOptionPane.ERROR_MESSAGE);
					// part that has null should be a GUI component
					//return;
				}else*/ if (employee == null) 
				{
					JOptionPane.showMessageDialog(null, "Record was found", "Find Record Status", JOptionPane.INFORMATION_MESSAGE);
					//System.out.println("Record found in mysql\\janswholesale");
					
				}
			}
			if (action.equalsIgnoreCase("View All Employee Records"))
			{
				Employee employee = new Employee();
				
				while(true) 
				{
					try 
					{
						employee = (Employee) objIs.readObject();
						if (employee != null )
						{
							employeeList.add(employee);
							
							
						} else if (employee == null) 
						{
							JOptionPane.showMessageDialog(null, "All Records Viewed", "Employee Records", JOptionPane.INFORMATION_MESSAGE);
							// part that has null should be a GUI component
							break;
						}
					} catch(ClassNotFoundException e){
						System.out.println("Object could not be converted to an Employee");			
			       }//catch(EOFException e) {break;}
			   }
			}
		//closeConnection();   // do we close connection????	
		} catch (EOFException e) {
	            System.out.println("");
	            System.out.println("End of file reached");
		} catch (ClassCastException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return employeeList;
		
	}
}
