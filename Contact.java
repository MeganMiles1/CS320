package com.contactservice.mobileapp;

public class Contact {
	// Character limit
	private static final int MAX_CONTACT_ID_LENGTH = 10;
	private static final int MAX_NAME_LENGTH = 10;
	private static final int PHONE_LENGTH = 10;
	private static final int MAX_ADDRESS_LENGTH = 30;

	// Variables
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	// Constructors
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		validateContactId(contactId);
		validateName(firstName);
		validateName(lastName);
		validatePhone(phone);
		validateAddress(address);

		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	// Getters
	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	// Setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Validators
	private void validateContactId(String contactId) {
		if (contactId == null || contactId.length() > MAX_CONTACT_ID_LENGTH) {
			throw new IllegalArgumentException(
					"Contact ID must be a non-null string with length at most " + MAX_CONTACT_ID_LENGTH + " characters.");
		}
	}

	private void validateName(String name) {
		if (name == null || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(
					"Name must be a non-null string with length at most " + MAX_NAME_LENGTH + " characters.");
		}
	}

	private void validatePhone(String phone) {
		if (phone == null || phone.length() != PHONE_LENGTH) {
			throw new IllegalArgumentException(
					"Phone must be a non-null string with exactly " + PHONE_LENGTH + " digits.");
		}
	}

	private void validateAddress(String address) {
		if (address == null || address.length() > MAX_ADDRESS_LENGTH) {
			throw new IllegalArgumentException(
					"Address must be a non-null string with length at most " + MAX_ADDRESS_LENGTH + " characters.");
		}
	}

}
