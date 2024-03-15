package ui;

import java.util.ArrayList;
import java.util.List;

import util.Console;

public class PrimeNumberCheckerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the prime number checker!");
		
		// while loop - while choice is Y or y
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
		
			// prompt for theNumber
			int theNumber = Console.getInt("Enter a whole number between 1 and 5000: ", 0, 5001);
			
			// business logic:
			// - what is the business logic?
			// - a prime number is only evenly divisible (no remainder) by itself and 1
			// - 10:  10/1 = 10, 10/2 = 5, 10/3 = 3.333, 10/4 = 2.5, 10/5 = 2
			//        10/6 = 1....., 10/7 = 1....., 10/8 = 1...., 10/9 = 1.11111, 10/10 = 1
			// - 7:   7/1 = 7, 7/2 = 3...., 7/3 = 2...., 7/4 = 1...., 7/5 = 1...., 
			//        7/6 = 1....   7/7 = 1
			// - what's a 'factor'? theNumber divided by i has 0 remainder
			// - define factorsList
			List<Integer> factorsList = new ArrayList<>();
			// - loop from 1 to theNumber
			for (int i = 1; i <= theNumber; i++) {
				//   - modulus theNumber % i
				//   - if remainder is 0 add i to our factorsList
				if (theNumber % i == 0) {
					factorsList.add(i);
				}
			}
			
			// print:
			// - prime number (factorsList size is 2)
			// - OR print the # of factors and the factors
			if (factorsList.size()==2) {
				System.out.println(theNumber+" is prime.");
			}
			else {
				StringBuilder factorsStr = new StringBuilder();
				for (int factor: factorsList) {
					factorsStr.append(factor + " ");
				}
				System.out.println(factorsList.size() + " factors: "+factorsStr);
			}
			choice = Console.getString("Continue? (y/n) ");
		}
		
		
		
		
		
		
		
		
		System.out.println("bye");
	}

}
