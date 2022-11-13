package domain;

public class LineWorker extends Employee {
private Department Dep;
	
	public LineWorker() {
		super();
		Dep = new Department();
	}
	
	public LineWorker(String EmpId, String name, String EmpTele, String EmpEmail, String DepartmentCode, String EmployeeCode, Department Depart)
	{
		super(EmpId,EmpTele,name,EmpEmail,DepartmentCode,EmployeeCode);
		this.Dep = Depart ;
	
	}

	public Department getDep() {
		return Dep;
	}

	public void setDep(Department dep) {
		Dep = dep;
	}
	
	public String Tostring() {
		return "Department ="  +Dep+ "" +  "employee ID ="  +getEmpID() + "\n"+ "Name = "
	+ getName() + "\n"+ "Employee Email = " + getEmpEmail() +"\n"+
				"Employee Telephone = " + getEmpTele() +"/n" + "/n" ;
		}
}

