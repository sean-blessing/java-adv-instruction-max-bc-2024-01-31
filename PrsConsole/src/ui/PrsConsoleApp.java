package ui;

import java.time.LocalDate;
import java.time.LocalDateTime;

import model.Request;
import model.User;

public class PrsConsoleApp {

	public static void main(String[] args) {
		System.out.println("Hello PRS");
		
		// create some users
		User u1 = new User(1, "dgrohl", "pwd1", "Dave", "Grohl", 
							"555-555-5555", "dgrohl@ff.com", false, false);
		User u2 = new User(2, "tuser", "pwd", "test", "user",
							"111-111-1111", "test@user.com", true, true);
		
		System.out.println("Users:");
		System.out.println("=================");
		System.out.println(u1);
		System.out.println(u2.toString());
		
		Request r1 = new Request(1, u1, "New request", "I need it", 
								LocalDate.now(),"Pickup", "New", 0.0, 
								LocalDateTime.now(),null);
		
		System.out.println("Request:");
		System.out.println("=================");
		System.out.println(r1);
		System.out.println("bye");

	}

}
