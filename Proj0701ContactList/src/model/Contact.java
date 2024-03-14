package model;

public class Contact {
	// instance variables (Java) == properties in C#
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public Contact() {
		super();
	}

	public Contact(String firstName, String lastName, String email, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String displayContact() {
		String displayStr = "--------------------------------------------\n";
		displayStr += "------------ Current Contact ---------------\n";
		displayStr += "--------------------------------------------\n";
		displayStr += "Name: "+firstName+ " "+lastName+"\n";
		displayStr += "Email Address: "+email+"\n";
		displayStr += "Phone Number: "+phone+"\n";
		displayStr += "--------------------------------------------\n";
		return displayStr;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ "]";
	}

}
