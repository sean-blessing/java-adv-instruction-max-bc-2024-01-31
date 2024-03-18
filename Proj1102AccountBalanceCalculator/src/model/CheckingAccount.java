package model;

public class CheckingAccount extends Account {
	
	private double monthlyFee;

	public CheckingAccount(double monthlyFee, double balance) {
		super();
		this.setBalance(balance);
		this.monthlyFee = monthlyFee;
	}
	
	public void subtractMonthlyFeeFromBalance() {
		setBalance(getBalance() - monthlyFee);
	}
	
	public double getMonthlyFee() {
		return monthlyFee;
	}
	
	
	
	

}
