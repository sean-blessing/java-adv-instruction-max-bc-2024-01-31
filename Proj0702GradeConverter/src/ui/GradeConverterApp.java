package ui;

import model.Grade;
import util.Console;

public class GradeConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Grade Converter App!");
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			int numericGrade = Console.getInt("Enter numeric grade: ", -1, 101);
			Grade grade = new Grade(numericGrade);
			System.out.println("Letter grade: "+grade.getLetter());
			System.out.println();
			
			choice = Console.getString("Continue? (y/n): ", "y", "n");
		}
		
		System.out.println("Bye");
	}

}
