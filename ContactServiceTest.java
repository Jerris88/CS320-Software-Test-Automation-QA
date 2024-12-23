package Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import contactService.ContactService;


class ContactServiceTest {

	@Test
	public void testContactServiceAddContact() {
		ContactService contactList = new ContactService();
		//testing adding a new contact to contact list
		assertTrue(contactList.addContact("1", "John", "Doe", "5555555555", "1 John Doe St"));
		//testing that the size of the contact list increased to 1 after adding John
		assertEquals(1, contactList.getContacts().size());
		//testing that the contact was successfully added
		assertEquals("John", contactList.getContacts().get(0).getFirstName());
		//testing adding a second contact to contact list
		assertTrue(contactList.addContact("2", "Jane", "Doe", "1111111111", "1 Jane Doe St"));
		//testing that the size of the contact list increased to 2 after adding Jane
		assertEquals(2, contactList.getContacts().size());
		//testing that the Jane was successfully added to contact list
		assertEquals("Jane", contactList.getContacts().get(1).getFirstName());
		
		//testing duplicate addContact where the id is already in use
		assertFalse(contactList.addContact("1", "John", "Doe", "5555555555", "1 John Doe St"));
		//testing addContact exception using a null id parameter
		assertFalse(contactList.addContact(null, "Jess", "Doe", "2222222222", "1 Jess Doe St"));
	}
	
	@Test
	public void testContactServiceDeleteContact() {
		ContactService contactList = new ContactService();
		contactList.addContact("1", "John", "Doe", "5555555555", "1 John Doe St");
		//testing that the size of contactList increased to one after adding new contact
		assertEquals(1, contactList.getContacts().size());
		//testing the delete contact method using id as parameter
		assertTrue(contactList.deleteContact("1"));
		//testing that that the size of contactList was changed to zero after contact deletion
		assertEquals(0, contactList.getContacts().size());
		
		//testing delete contact exception where the search id is not found in contact list
		assertFalse(contactList.deleteContact("1"));
		//testing delete contact exception where the search id parameter is null
		assertFalse(contactList.deleteContact(null));
	}
	
	@Test
	public void testContactServiceUpdateContact() {
		ContactService contactList = new ContactService();
		contactList.addContact("1", "John", "Doe", "5555555555", "1 John Doe St");
		//testing updating contact with valid parameters
		assertTrue(contactList.updateContact("1", "Jan", "Deer", "1111111111", "1 Jan Doe St"));
		//testing that the contact parameters were successfully updated
		assertEquals("Jan", contactList.getContacts().get(0).getFirstName());
		assertEquals("Deer", contactList.getContacts().get(0).getLastName());
		assertEquals("1111111111", contactList.getContacts().get(0).getPhoneNumber());
		assertEquals("1 Jan Doe St", contactList.getContacts().get(0).getAddress());
		//testing updating the contact with no change in parameters using null values
		assertTrue(contactList.updateContact("1", null, null, null, null));
		//testing that all contact parameters remain unchanged after passing null values
		assertEquals("Jan", contactList.getContacts().get(0).getFirstName());
		assertEquals("Deer", contactList.getContacts().get(0).getLastName());
		assertEquals("1111111111", contactList.getContacts().get(0).getPhoneNumber());
		assertEquals("1 Jan Doe St", contactList.getContacts().get(0).getAddress());
		
		//testing exception for attempting to updated a contact with an id that doesn't exist
		assertFalse(contactList.updateContact("4", "Josh", "Doe", "2222222222", "1 Josh Doe St"));
		//testing exception for attempting to update a contact using a null search id
		assertFalse(contactList.updateContact(null, "Jan", "Doe", "5555555555", "1 Jan Doe St"));
	}
}
