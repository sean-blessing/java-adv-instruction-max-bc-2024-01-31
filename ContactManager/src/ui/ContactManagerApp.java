package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import model.Contact;
import model.TestContact;

public class ContactManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Contact Manager App!");
		
		List<Contact> contacts = new ArrayList<>();
		
		contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
		contacts.add(new Contact("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));
		
		List<Contact> contactsNoPhone = filterContactsNoPhone(contacts);
		displayContactsSummary(contactsNoPhone, "Contacts w/ No Phone");
		
		List<Contact> contactsNoEmail = filterContactsNoEmail(contacts);
		displayContactsSummary(contactsNoEmail, "Contacts w/ No Email");

		List<Contact> contactsNoEmailOrPhone = filterContactsNoEmailOrPhone(contacts);
		displayContactsSummary(contactsNoEmailOrPhone, "Contacts w/ No Email and No Phone");
		
		System.out.println("============ Lambdas =============");
		List<Contact> contactsNoPhone2 = filterContacts(contacts,
			(Contact c) -> { return c.getPhone()==null;});
		displayContactsSummary(contactsNoPhone2, "Contacts no phone (lambda)");

		List<Contact> contactsNoEmail2 = filterContacts(contacts,
				c -> c.getEmail()==null);
		displayContactsSummary(contactsNoEmail2, "Contacts no email (lambda)");
		
		List<Contact> contactsNoEmailOrPhone2 = filterContacts(contacts,
				c -> (c.getEmail() == null && c.getPhone() == null));
		displayContactsSummary(contactsNoEmailOrPhone2, "Contacts no email or phone(lambda)");
		
		System.out.println("-----------  Consumer Interface -----------");
		// change names to uppercase
		processContacts(contacts, c-> c.setName(c.getName().toUpperCase()));
		// print names
		processContacts(contacts, c-> System.out.println(c.getName()));
		
		System.out.println("Bye");
	}
	
	private static void processContacts(List<Contact> contacts, Consumer<Contact> consumer) {
		//Consumer - performs an operation on Contact and doesn't return a value
		for (Contact c: contacts) {
			consumer.accept(c);
		}
	}
	
//	private static List<Contact> filterContacts(List<Contact> contacts, TestContact condition) {
//		List<Contact> filteredContacts = new ArrayList<>();
//		for (Contact c: contacts) {
//			if (condition.test(c)) {
//				filteredContacts.add(c);
//			}
//		}
//		
//		return filteredContacts;
//	}
	
	private static List<Contact> filterContacts(List<Contact> contacts, Predicate<Contact> condition) {
		List<Contact> filteredContacts = new ArrayList<>();
		for (Contact c: contacts) {
			if (condition.test(c)) {
				filteredContacts.add(c);
			}
		}
		
		return filteredContacts;
	}
	private static void displayContactsSummary(List<Contact> contacts, String header) {
		System.out.println(header);
		System.out.println("=====================");
		for (Contact c: contacts) {
			System.out.println(c);
		}
	}
	
	private static List<Contact> filterContactsNoPhone(List<Contact> contacts) {
		List<Contact> contactsNoPhone = new ArrayList<>();
		for (Contact c: contacts) {
			if (c.getPhone() == null) {
				contactsNoPhone.add(c);
			}
		}
		return contactsNoPhone;
	}
	
	private static List<Contact> filterContactsNoEmail(List<Contact> contacts) {
		List<Contact> contactsNoEmail = new ArrayList<>();
		for (Contact c: contacts) {
			if (c.getEmail() == null) {
				contactsNoEmail.add(c);
			}
		}
		return contactsNoEmail;
	}

	private static List<Contact> filterContactsNoEmailOrPhone(List<Contact> contacts) {
		List<Contact> contactsNoEmailOrPhone = new ArrayList<>();
		for (Contact c: contacts) {
			if (c.getEmail() == null && c.getPhone() == null) {
				contactsNoEmailOrPhone.add(c);
			}
		}
		return contactsNoEmailOrPhone;
	}
}
