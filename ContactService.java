package com.contactservice.mobileapp;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	// Initialize a map of contacts with string keys(ids)
	private Map<String, Contact> contacts;

	// Constructor
	public ContactService() {
		// Initializes a hash map with the map contact in it
		this.contacts = new HashMap<>();
	}

	// Add contact (validates by id)
	public void addContact(Contact contact) throws Exception {
		// Check if the contact ID is already present in the HashMap
	    if (!contacts.containsKey(contact.getContactId())) {
	        // If not present, add the contact to the HashMap
	        contacts.put(contact.getContactId(), contact);
	        System.out.println("Contact added successfully.");
	    } else {
	        // If the contact ID is already present, throw an exception
	        throw new IllegalArgumentException("Error: Contact with the same ID already exists. Contact not added.");
	    }
	}

	// Remove contact (searches by id)
	public void deleteContact(String contactId) {
		contacts.remove(contactId);
	}

	// Update contacts with any entries that are not null
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		
		// Check if the contact ID is present in the HashMap
	    if (contacts.containsKey(contactId)) {
	        // If present, retrieve the existing contact
	        Contact existingContact = contacts.get(contactId);

	        // Update fields only if the new value is not null
	        if (firstName != null) {
	            existingContact.setFirstName(firstName);
	        }
	        if (lastName != null) {
	            existingContact.setLastName(lastName);
	        }
	        if (phone != null) {
	            existingContact.setPhone(phone);
	        }
	        if (address != null) {
	            existingContact.setAddress(address);
	        }

	        // Print a message indicating success
	        System.out.println("Contact updated successfully.");
	    } else {
	        // If the contact ID is not present, display an error message or handle it accordingly
	        System.out.println("Error: Contact with the specified ID not found. Contact not updated.");
	    }
	}

	// Returns the contact map
	public Map<String, Contact> getContacts() {
		return contacts;
	}
}