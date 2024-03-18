package ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Request;
import model.User;
import util.Console;

public class PrsConsoleApp {

	public static void main(String[] args) {
		System.out.println("Hello PRS");
		List<User> users = new ArrayList<>();
		
		// create some users
		User u1 = new User(1, "dgrohl", "pwd1", "Dave", "Grohl", 
							"555-555-5555", "dgrohl@ff.com", false, false);
		User u2 = new User(2, "tuser", "pwd", "test", "user",
							"111-111-1111", "test@user.com", true, true);
		User u3 = new User(3, "asandler", "pwd11", "Adam", "Sandler",
				"255-876-9900", "asandler@test.com", true, true);
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
		String command = "";
		while (!command.equalsIgnoreCase("Exit")) {
			command = promptCommandMenu();
			switch(command) {
				case "Show":
				case "show":
					showUsers(users);
					break;
				case "Add":
				case "add":
					addUser(users);
					break;
				case "Get":
				case "get":
					User u = getUser(users);
					if (u != null)
						System.out.println(u);
					else
						System.out.println("Invalid id entered.");
					break;
				case "Exit":
					// do show logic
					break;
				default:
					System.out.println("Invalid command");
					break;
			}
			
			
		}
		
//		System.out.println("Users:");
//		System.out.println("=================");
//		System.out.println(u1);
//		System.out.println(u2.toString());
		
//		Request r1 = new Request(1, u1, "New request", "I need it", 
//								LocalDate.now(),"Pickup", "New", 0.0, 
//								LocalDateTime.now(),null);
//		
//		System.out.println("Request:");
//		System.out.println("=================");
//		System.out.println(r1);
		System.out.println("bye");

	}
	
	private static void showUsers(List<User> users) {
		System.out.println("\nList of Users:");
		System.out.println("==================================");
		for (User u: users) {
			System.out.println(u);
		}
	}
	
	private static User getUser(List<User> users) {
		System.out.println("\nGet User by ID:");
		System.out.println("==================================");
		int userId = Console.getInt("User ID: ", 0, Integer.MAX_VALUE);
		User user = null;
		for (User u: users) {
			// find the user who's id matches userId
			if (u.getId() == userId) {
				user = u;
			}
		}
		return user;
	}
	
	private static void addUser(List<User> users) {
		System.out.println("\nAdd a new user:");
		System.out.println("==================================");
		int id = Console.getInt("User ID: ");
		String uname = Console.getString("Username: ");
		String pwd = Console.getString("Password: ");
		String fname = Console.getString("Firstname: ");
		String lname = Console.getString("Lastname: ");
		String phone = Console.getString("Phone: ");
		String email = Console.getString("Email: ");
		boolean rvw = false;
		boolean adm = false;
		User u = new User(id, uname, pwd, fname, lname, phone, email, rvw, adm);
		users.add(u);
	}
	
	private static String promptCommandMenu() {
		System.out.println("\nCOMMAND MENU:");
		System.out.println("==================================");
		System.out.println("Show - Show all users");
		System.out.println("Add - Add user");
		System.out.println("Get - Get a user by id");
		System.out.println("Exit - Exit program");
		return Console.getString("Command: ");
	}

}
