package domain;

import java.io.Serializable;

public class Employee implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String empID;
    private String name;
    private String empEmail;
    private String empTele;
    private String depCode;
    private String empCode;

    public Employee()
    {
        this.empID="";
        this.name="";
        this.empEmail="";
        this.empTele="";
        this.depCode="";
        this.empCode= "";
    }


    public Employee(String empID, String name, String empEmail, String empTele, String depCode, String empCode) {
        this.empID = empID;
        this.name = name;
        this.empEmail = empEmail;
        this.empTele = empTele;
        this.depCode = depCode;
        this.empCode = empCode;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpTele() {
        return empTele;
    }

    public void setEmpTele(String empTele) {
        this.empTele = empTele;
    }
    

	public String getDepCode() {
		return depCode;
	}


	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}


	public String getEmpCode() {
		return empCode;
	}


	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}


	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", name=" + name + ", empEmail=" + empEmail + ", departmentCode=" + depCode + "employeeCode="+ empCode+"]";
	}


}
