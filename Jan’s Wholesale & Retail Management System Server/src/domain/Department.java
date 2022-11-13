package domain;

import java.io.Serializable;

public class Department implements Serializable
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String depCode;
	    private String depName;

	    public Department()
	    {
	        this.depCode= "";
	        this.depName="";
	    }

	    public Department(String depCode, String depName)
	    {
	        this.depCode=depCode;
	        this.depName=depName;
	    }

	    public String getDepCode() {
	        return depCode;
	    }

	    public void setDepCode(String depCode) {
	        this.depCode = depCode;
	    }

	    public String getDepName() {
	        return depName;
	    }

	    public void setDepName(String depName) {
	        this.depName = depName;
	    }

	    @Override
	    public String toString() {
	        return "Department{" +
	                "depCode=" + depCode +
	                ", depName='" + depName + '\'' +
	                '}';
	    }
}


