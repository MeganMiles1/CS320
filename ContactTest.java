package com.contactservice.mobileapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

	// test contact creation and initialization
	@Test
	public void testContactCreation() {
		// Initialize contact
		Contact contact = new Contact("1", "Mary", "Sue", "2145550000", "123 Avenue");
		
		// Check information initialized correctly
		assertNotNull(contact);
		assertEquals("1", contact.getContactId());
		assertEquals("Mary", contact.getFirstName());
		assertEquals("Sue", contact.getLastName());
		assertEquals("2145550000", contact.getPhone());
		assertEquals("123 Avenue", contact.getAddress());
	}

	// test constraints on contact fields
	@Test
	public void testContactValidation() {
		// ID
		// id must be unique
		assertThrows(IllegalArgumentException.class, () -> {
			// initialize contactService
			ContactService contactService = new ContactService();
			// new contact with unique id
			Contact contact1 = new Contact("1", "Mary", "Sue", "2145550000", "123 Avenue");
			// add to hashmap
			contactService.addContact(contact1);
			// new contact with the same id
			Contact contact2 = new Contact("1", "Mary", "Sue", "2145550000", "123 Avenue");
			// attempt to also add to hashmap
			contactService.addContact(contact2);
		});
		// id must be <= 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("12345123451", "Mary", "Sue", "2145550000", "123 Avenue");
		});
		// id must be !null
		assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(null, "Mary", "Sue", "2145550000", "123 Avenue");
		});

		// FIRST NAME
		// first name must be !null
		assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1", null, "Sue", "2145550000", "123 Avenue");
		});
		// first name must be <= 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1", "MaryXXXXXXX", "Sue", "2145550000", "123 Avenue");
		});

		// LAST NAME
		// last name must be !null
		assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1", "Mary", null, "2145550000", "123 Avenue");
		});
		// last name must be <= 10 characters
		assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1", "Mary", "SueXXXXXXXX", "2145550000", "123 Avenue");
		});

		// PHONE
		// phone must be !null
		assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1", "Mary", "Sue", null, "123 Avenue");
		});
		// phone must <= 10 characters
		// 11 characters
		assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1", "Mary", "Sue", "21455500000", "123 Avenue");
		});
		// 9 characters
		assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1", "Mary", "Sue", "214555000", "123 Avenue");
		});

		// ADDRESS
		// address must be !null
		assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1", "Mary", "Sue", "2145550000", null);
		});
		// address must be <= 30 characters
		assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("1", "Mary", "Sue", "2145550000", "1234567890123456789012345678901");
		});
	}

}
