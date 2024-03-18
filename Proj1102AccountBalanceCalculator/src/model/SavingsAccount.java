package model;

public class SavingsAccount extends Account {
	private double monthlyInterestRate;
	private double monthlyInterestPayment;
	
	public SavingsAccount(double monthlyInterestRate, double balance) {
		super();
		setBalance(balance);
		this.monthlyInterestRate = monthlyInterestRate;
	}
	
	public void calculateMonthlyInterestPayment() {
		monthlyInterestPayment = getBalance() * monthlyInterestRate;
	}
	
	public void applyPaymentToBalance() {
		setBalance(getBalance() + monthlyInterestPayment);
	}
	
	public double getMonthlyInterestPayment() {
		return monthlyInterestPayment;
	}
	
	
}
