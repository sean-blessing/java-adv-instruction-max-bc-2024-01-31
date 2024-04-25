package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Contact;

public class LambdaContactManagerApp {

	public static void main(String[] args) {
		System.out.println("Hello");
		List<Contact> contacts = new ArrayList<>();
		
		contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
		contacts.add(new Contact("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));
		
		System.out.println("===== Contacts w/ no phone #s =====");
		// p. 551
		contacts.stream().filter( c -> c.getPhone() == null )
							.forEach(c -> System.out.println(c.getName()));
		
		System.out.println("== How many contacts have no phone #?");
		// filter the list
		List<Contact> contactsNoPhone = contacts.stream()
				.filter(c -> c.getPhone()==null)
				.collect(Collectors.toList());		
		
		
		// print the total
		System.out.println("There are "+contactsNoPhone.size()+" contacts with no phone number");
		
		System.out.println("=========== p. 553 transform a list of Contact objects");
		List<String> contactNames = contacts.stream()
				.map(c -> c.getName())
				.collect(Collectors.toList());
		// print names
		contactNames.stream().forEach(str -> System.out.println(str));
		
		// double colon operator - same example
		List<String> contactNames2 = contacts.stream()
				.map(Contact::getName)
				.collect(Collectors.toList());
		// print names
		contactNames2.stream().forEach(System.out::println);
		
		// map/reduce p. 555
		System.out.println("----- reduce contact objects to single string of names");
		String csv = contacts.stream()
				.map(c -> c.getName())
				.reduce("", (a, b) -> a + b + ", ");
		csv = csv.substring(0,csv.length() - 2);
		System.out.println("All contacts: "+csv);
		
		System.out.println("bye");

	}

}
