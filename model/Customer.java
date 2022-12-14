package model;

public class Customer {
	private String idNumber;
	private String name;
	private String address;
	private String telephone;
	private String email;
	Date dob;
	Date dateOfMembership;
	Date dateOfExipiry;

	public Customer() {
		this.idNumber="";
		this.name="";
		this.address="";
		this.telephone="";
		this.email="";
		this.setDob(new Date(1,1,2000));
		this.setDateOfMembership(new Date(1,1,2000));
		this.setDateOfExipiry(new Date(1,1,2000));
		
	}

	public Customer(String idNumber, String name, String address, String telephone, String email, Date dob,
			Date dateOfMembership, Date dateOfExipiry) {
		super();
		this.idNumber = idNumber;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.dob = dob;
		this.dateOfMembership = dateOfMembership;
		this.dateOfExipiry = dateOfExipiry;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDateOfMembership() {
		return dateOfMembership;
	}

	public void setDateOfMembership(Date dateOfMembership) {
		this.dateOfMembership = dateOfMembership;
	}

	public Date getDateOfExipiry() {
		return dateOfExipiry;
	}

	public void setDateOfExipiry(Date dateOfExipiry) {
		this.dateOfExipiry = dateOfExipiry;
	}

	@Override
	public String toString() {
		return "ID Number = " + idNumber + "\n"+ "Name = " + name + "\n" +"Address=" + address + 
				", "+ "Telephone Number = " + telephone + "\n" +" Email= " + email + "\n"+
				"Date of Birth=" + dob + "\n" +" Date of Membership = " + dateOfMembership + "\n" +
				"Date of Exipiry = "+ dateOfExipiry + "\n";
	}
	

}
