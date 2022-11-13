package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import domain.Department;

import java.net.InetAddress;

public class DepartmentController
{
	private Socket connectionSocket;
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	private String action;
	
	//Default Constructor
	public DepartmentController()
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
	
	public void sendDepartment(Department depObj)
	{
		try {
			System.out.println("About to send Student data to server");
			objOs.writeObject(depObj);
			System.out.println("Student data sent to server");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void recieveResponse() 
	{
		try {
			if (action.equalsIgnoreCase("Create Department"))
			{
				Boolean flag = (Boolean) objIs.readObject();
						
				if(flag == true)
				{
					JOptionPane.showMessageDialog(null, "Record Added Successfully", "Add Record Status", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Record added to mysql\\janswholesale");
					// part that has null should be a GUI component
				}
			}
		} catch (ClassCastException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
}
