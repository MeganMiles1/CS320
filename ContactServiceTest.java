package com.contactservice.mobileapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class ContactServiceTest {

	@Test
    public void testAddContact() {
        // initialize contact service
        ContactService contactService = new ContactService();

        // create a contact
        Contact contact = new Contact("1", "Mary", "Sue", "2145550000", "123 Avenue");

        // assert that no exception is thrown
        assertDoesNotThrow(() -> contactService.addContact(contact));
    }

	@Test
    public void testDeleteContact() {
        // initialize contact service
        ContactService contactService = new ContactService();

        // create a contact
        Contact contact = new Contact("1", "Mary", "Sue", "2145550000", "123 Avenue");

        // add a contact
        assertDoesNotThrow(() -> contactService.addContact(contact));

        // assert that no exception is thrown
        assertDoesNotThrow(() -> contactService.deleteContact("1"));
    }

	@Test
	public void testUpdateContact() {
	    // initialize contact service
	    ContactService contactService = new ContactService();

	    // create a contact
	    Contact contact = new Contact("1", "Mary", "Sue", "2145550000", "123 Avenue");

	    // add a contact
	    assertDoesNotThrow(() -> contactService.addContact(contact));

	    // assert that no exception is thrown during the update
	    assertDoesNotThrow(() ->
	            contactService.updateContact("1", "Jane", "Doe", "1234567890", "456 Boulevard"));

	    // retrieve the updated contact
	    Map<String, Contact> contacts = contactService.getContacts();
	    Contact updatedContact = contacts.get("1");

	    // assert the updated values
	    assertEquals("Jane", updatedContact.getFirstName());
	    assertEquals("Doe", updatedContact.getLastName());
	    assertEquals("1234567890", updatedContact.getPhone());
	    assertEquals("456 Boulevard", updatedContact.getAddress());
	}

}
