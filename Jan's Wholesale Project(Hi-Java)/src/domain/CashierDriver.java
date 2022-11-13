package domain;

import java.util.ArrayList;
import java.util.List;

import controller.DepartmentController;
import controller.StaffController;

public class CashierDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StaffController cashier = new StaffController();
		Employee employee = new Employee("1001", "John Public", "publicj@anemail.com", "8765556666", "Account&Sales3333","Sup1000");
		Employee employee1 = new Employee("1002", "Devon House", "devonhousej@anemail.com", "8765556666", "Inventory","LW2000");
		Employee employee2 = new Employee("1003", "Den Hill", "denhill@anemail.com", "8765556666", "Account&Sales3333", "Cash3000");
		
		Employee Kobe = new Employee("1005"
,"Kobe Lawrence"
,"k_lawrence@gmail.com"
,"8763546668"
,"Invent2222"
,"LW2000");
		
		
		
		/*cashier.sendAction("Find Employee Record");
		cashier.sendEmployeeId("1005");
		System.out.println("Message sent to server");
		
		cashier.recieveResponse();
		System.out.println("Response received");*/
		
		cashier.sendAction("Update Employee Record");
		//cashier.sendEmployeeId("1005");
		cashier.sendEmployee(Kobe);
		System.out.println("Message sent to server");
		
		cashier.recieveResponse();
		System.out.println("Response received");
		
		
		
		//Management
		// Inventory
		// Accounting and Sales
	/*	DepartmentController depart = new DepartmentController();
		Department depo = new Department("Man1001", "Management");
		Department depo2 = new Department("Invent2222", "Inventory");
		Department depo3 = new Department("Account&Sales3333", "Accounting and Sales");
		
		depart.sendAction("Create Department");
		System.out.println("Message sent to server");
		depart.sendDepartment(depo3);
		System.out.println("Record sent to Server");
		depart.recieveResponse();
		System.out.println("Response recieved");
*/
		
		/*cashier.sendAction("Create Employee");
		System.out.println("Message sent to server");
		
		cashier.sendEmployee(employee);
		System.out.println("Record sent to server");
		
		cashier.recieveResponse();
		System.out.println("Response received");*/
		
		/*cashier.sendAction("Update Employee Email");
		cashier.sendEmployeeId("1003");
		cashier.sendEmployeeEmail("dud@gaming.com");
		System.out.println("Message sent to server");
		
		cashier.recieveResponse();
		System.out.println("Response received");*/
		
		/*cashier.sendAction("Update Employee Telephone");
		cashier.sendEmployeeId("1003");
		cashier.sendEmployeeEmail("8762874869");
		System.out.println("Message sent to server");
		cashier.recieveResponse();
		System.out.println("Response received");*/
		
		/*cashier.sendAction("View All Employee Records");
		List<Employee> employeeList = new ArrayList<Employee>();
		//studentList.addAll(studentList);
		employeeList = cashier.recieveResponse();
		for (Employee employee3 : employeeList) 
		{
			System.out.println(employee3);
			
		}
		System.out.println("Response received");*/
		
		
		/*cashier.sendAction("Find Employee Record");
		cashier.sendEmployeeId("1004");
		System.out.println("Message sent to server");
		
		cashier.recieveResponse();
		System.out.println("Response received");*/
	
		
		/*
		cashier.sendAction("Delete Employee Record");
		cashier.sendEmployeeId("1002");
		System.out.println("Message sent to server");
		
		cashier.recieveResponse();
		System.out.println("Response received");*/
		
	}

}
