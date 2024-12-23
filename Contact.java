/**
 * Contact Class
 * @author Jerris English
 * Date: November 24, 2024
 */
package contactService;

public class Contact {
	
	//private and non-updatable contactId variable
	private final String contactId;
	//private contact variables
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	/*
	 * Constructor for contact that accepts id, first name, last name, phone, and address parameters.
	 * Throws exceptions if parameter lengths are violated.
	 */
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		if(contactId == null || contactId.length()>10) {
			throw new IllegalArgumentException("Invalid contact Id: must contain 10 or less digits.");
		}
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid first name: cannot be longer than 10 characters.");
		}
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid last name: cannot be longer than 10 characters.");
		}
		if(phoneNumber == null || phoneNumber.length()>10 || !onlyDigits(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number: must contain exactly 10 numeric digits.");
		}
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid address: cannot be longer than 30 characters.");
		}
		
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	//Setters
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid first name: cannot be longer than 10 characters.");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid last name: cannot be longer than 10 characters.");
		}
		this.lastName = lastName;
	}
	
	public void setPhoneNum(String phoneNumber) {
		if(phoneNumber == null || phoneNumber.length()!=10 || !onlyDigits(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number: must contain exactly 10 numeric digits.");
		}
		this.phoneNumber = phoneNumber;
	}
	
	public void setAddress(String address) {
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid address: cannot be longer than 30 characters.");
		}
		this.address = address;
	}
	
	//Getters
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	//Helper class to determine if phone number contains non-numeric characters
	public static boolean onlyDigits(String phoneNumber) {
		int n = phoneNumber.length();
		for (int i = 0; i < n; i++) {
			if (!Character.isDigit(phoneNumber.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}

