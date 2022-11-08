package model;

public class Supervisor extends Employee{
	
	Department Dep;
	
	public Supervisor() {
		super();
		Dep = new Department();
	}
	
	public Supervisor(String EmpId, String name, String EmpTele, String EmpEmail, Department Depart )
	{
		super(EmpEmail,EmpTele,name,EmpEmail);
		this.Dep = Depart ;
	
	}

	public Department getDep() {
		return Dep;
	}

	public void setDep(Department dep) {
		Dep = dep;
	}
	
	public String Tostring() {
		return "employee ID ="  +getEmpID() + "\n"+ "Name = "
	+ getName() + "\n"+ "Employee Email = " + getEmpEmail() +"\n"+
				"Employee Telephone = " + getEmpTele() +"/n" +"Department ="  +Dep+ "" +   "/n" ;
	}

}
