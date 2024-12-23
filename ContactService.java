package contactService;

import java.util.Vector;

import contactService.Contact;

public class ContactService {
	
	//Vector construct to hold contacts	
	private Vector<Contact> ContactList;
	
	//Vector constructor
	public ContactService() {
		ContactList = new Vector<Contact>();
	}
	
	/*
	 * Method that compares searched string id with ContactList.
	 * If match found, returns false
	 * Else creates a new contact and adds to ContactList.
	 */
	public boolean addContact(String id, String firstName, String lastName, String phoneNumber, String address) {
		if (id == null) {
			return false; 
		}
		for (Contact contact : ContactList) {
			if (contact.getContactId() == id) {
				return false;
			}
		}
		Contact newContact = new Contact(id, firstName, lastName, phoneNumber, address);
		ContactList.add(newContact);
		return true;
	}
	
	/*
	 * Method that searches ContactList with input id.
	 * Removes contact if match is found.
	 * Else returns false
	 */
	public boolean deleteContact(String id) {
		Contact contactToDelete = null;
		for (Contact contact : ContactList) {
			if (contact.getContactId().equals(id)) {
				contactToDelete = contact;
				break;
			}
		}
		if (contactToDelete != null) {
			ContactList.remove(contactToDelete);
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * Method that searches contacts in ContactList using input contactId.
	 * If match is found, update values based on user input.
	 * Else return false
	 */
	public boolean updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		Contact contactToUpdate = null;
		for (Contact contact : ContactList) {
			if (contact.getContactId().equals(contactId)) {
				contactToUpdate = contact;
				break;
			}
		}
		//If contact found
			//If user input value for field is not null, update field value
			//If null, no field value change
		if (contactToUpdate != null) {
			if (firstName != null) {
				contactToUpdate.setFirstName(firstName);
			}
			if (lastName != null) {
				contactToUpdate.setLastName(lastName);
			}
			if (phoneNumber != null) {
				contactToUpdate.setPhoneNum(phoneNumber);
			}
			if (address != null) {
				contactToUpdate.setAddress(address);
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public Vector<Contact> getContacts() {
		return this.ContactList;
	}
}
