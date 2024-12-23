package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import contactService.Contact;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testClassConstructor() {
		Contact contact = new Contact("1", "John", "Doe", "5555555555", "1 John Doe St");
		//testing that all contact parameters where correctly set
		assertTrue(contact.getContactId().equals("1"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Doe"));
		assertTrue(contact.getPhoneNumber().equals("5555555555"));
		assertTrue(contact.getAddress().equals("1 John Doe St"));
	}
	
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910111213", "John", "Doe", "5555555555", "1 John Doe St");
		});
	}
	
	@Test
	void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Doe", "5555555555", "1 John Doe St");
		});
	}
	
	@Test
	void testContactFirstNameIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "JohnJohnJohnJohn", "Doe", "5555555555", "1 John Doe St");
		});
	}
	
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", null, "Doe", "5555555555", "1 John Doe St");
		});
	}
	
	@Test
	void testContactLastNameIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "DoeDoeDoeDoeDoe", "5555555555", "1 John Doe St");
		});
	}
	
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", null, "5555555555", "1 John Doe St");
		});
	}
	
	@Test
	void testContactPhoneNumberLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "Doe", "555555555555", "1 John Doe St");
		});
	}
	
	@Test
	void testContactPhoneNumberHasNonDigits() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "Doe", "555aaa5555", "1 John Doe St");
		});
	}
	
	@Test
	void testContactPhoneNumberIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "Doe", null, "1 John Doe St");
		});
	}
	
	@Test
	void testContactAddressIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "Doe", "5555555555", "11111111111111111111111 John Doe St");
		});
	}
	
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "Doe", "5555555555", null);
		});
	}
	
	@Test
	void testSetFirstName() {
		Contact contact = new Contact("1", "John", "Doe", "5555555555", "1 John Doe St");
		contact.setFirstName("Jan");
		assertEquals("Jan", contact.getFirstName());
		
		assertAll("testing exceptions",
				//testing null first name exception
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
					contact.setFirstName(null)),
				//testing invalid first name length exception
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
					contact.setFirstName("JohnJohnJohnJohn"))
				);
	}
	
	@Test
	void testSetLastName() {
		Contact contact = new Contact("1", "John", "Doe", "5555555555", "1 John Doe St");
		contact.setLastName("Deer");
		assertEquals("Deer", contact.getLastName());
		
		assertAll("testing exceptions",
				//testing null last name exception
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
					contact.setLastName(null)),
				//testing invalid last name length exception
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
					contact.setLastName("DeerDeerDeerDeer"))
				);
	}
	
	@Test
	void testSetPhoneNum() {
		Contact contact = new Contact("1", "John", "Doe", "5555555555", "1 John Doe St");
		contact.setPhoneNum("1111111111");
		assertEquals("1111111111", contact.getPhoneNumber());
		
		assertAll("testing exceptions",
				//testing null phone number exception
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
					contact.setPhoneNum(null)),
				//testing invalid phone number length exception
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
					contact.setPhoneNum("111111")),
				///testing invalid phone number with non-numeric characters
				() -> Assertions.assertThrows(IllegalArgumentException.class, () ->
					contact.setPhoneNum("111aaa1111"))
				);
	}
	
	@Test
	void testSetAddress() {
		Contact contact = new Contact("1", "John", "Doe", "5555555555", "1 John Doe St");
		contact.setAddress("2 John Doe St");
		assertEquals("2 John Doe St", contact.getAddress());
		
		assertAll("testing exceptions",
				//testing null address exception
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
					contact.setAddress(null)),
				//testing invalid address length exception
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
					contact.setAddress("11111111111111111111111111 John Doe St"))
				);
	}
}
