/* 
 * Leah Clemens
 * CS-320
 * 03.31.2023
 */
package contact_service;

public class Contact {
	//private fields
	private String contactID;
	private String firstName;
	private String lastName; 
	private String phoneNum;
	private String contactAddress;
	
	//constructor using private fields
	public Contact(String contactID, String firstName, String lastName, String phoneNum, String userAddress) {
		super();
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.contactAddress = userAddress;
	}
	
	//default constructor 
	public Contact () {}

	//getters and setters
	public String getContactID() {
		return contactID;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String userAddress) {
		this.contactAddress = userAddress;
	}
	
	//output format for each contact
	public String toString() {
		return contactID + " | " + lastName + ", " + firstName + 
				" | " + phoneNum + " | " + contactAddress;
	}

	public static void main(String[] args) {
		System.out.println("4. Task Description");
		
	}
}
