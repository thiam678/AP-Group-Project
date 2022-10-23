package model;


public class Employee {

    private String empID;
    private String name;
    //depcode
    private String empEmail;
    private String empTele;

    public Employee()
    {
        this.empID="";
        this.name="";
        this.empEmail="";
        this.empTele="";
    }


    public Employee(String empID, String name, String empEmail, String empTele) {
        this.empID = empID;
        this.name = name;
        this.empEmail = empEmail;
        this.empTele = empTele;
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


}
