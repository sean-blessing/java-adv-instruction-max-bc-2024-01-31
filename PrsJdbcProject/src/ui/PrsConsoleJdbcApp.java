package ui;

import java.util.ArrayList;

import db.UserDb;
import model.User;

public class PrsConsoleJdbcApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the PRS JDBC Console App!");

		// 1 - Get All Users
		ArrayList<User> users = UserDb.getAll();
		if (users!=null) {
			System.out.println("List of Users:");
			System.out.println("==============================");
			for (User u: users) {
				System.out.println(u);
			}
		}
		else {
			System.out.println("Error - check logs");
		}
		
		System.out.println("Get User by Id (3):");
		User user = UserDb.getById(3);
		if (user != null) {
			System.out.println(user);
		}
		else {
			System.out.println("Error - check logs");
		}
		
		System.out.println("bye");
	}

}
