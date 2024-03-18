package ui;

import java.text.NumberFormat;

import model.Account;
import model.CheckingAccount;
import model.SavingsAccount;
import util.Console;

public class AccountBalanceCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Account Balance Caluculator App!");

		String choice = "y";
		
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		
		CheckingAccount ca = new CheckingAccount(1, 1000);
		SavingsAccount sa = new SavingsAccount(.01, 1000);
		
		System.out.println("Starting Balances: ");
		System.out.println("Checking: "+cf.format(ca.getBalance()));
		System.out.println("Savings:  "+cf.format(sa.getBalance()));
		System.out.println();
		
		System.out.println("Enter transactions for the month: \n");
		
		while (choice.equalsIgnoreCase("y")) {
			String action = Console.getString("Withdrawal or Deposit? (w/d) ", "w", "d");
			String account = Console.getString("Checking or savings? (c/s) ", "c", "s");
			double amount = Console.getDouble("Amount? ", 0, Double.MAX_VALUE);
			
			// do math! - deposit or withdraw from correct account
			Account acct = null;
			if (account.equalsIgnoreCase("c")) {
				acct = ca;
			}
			else {
				acct = sa;
			}
			
			if (action.equalsIgnoreCase("w")) {
				acct.withdraw(amount);
			}
			else {
				acct.deposit(amount);
			}
			choice = Console.getString("Continue? (y/n) ", "y", "n");
		}
		
		// Monthly Calculations
		System.out.println("Monthly Payments and Fees:");
		System.out.println("Checking Fee: \t\t\t"+cf.format(ca.getMonthlyFee()));
		sa.calculateMonthlyInterestPayment();
		sa.applyPaymentToBalance();
		System.out.println("Savings Interest Payment: "+cf.format(sa.getMonthlyInterestPayment()));
		System.out.println();
		
		// Print Final Balances
		ca.subtractMonthlyFeeFromBalance();
		System.out.println("Final Balances:");
		System.out.println("Checking: "+cf.format(ca.getBalance()));
		System.out.println("Savings:  "+cf.format(sa.getBalance()));
		
		
		
		
		System.out.println("Bye");
	}

}
