
public class SavingsAccount extends BankAccount {
	
	private double rate = 2.5 / 100;	// annual interest rate 
	private int savingsNumber = 0;				// number of savings account
	private String accountNumber;
	
	public SavingsAccount(String name, double balance) {
		super(name, balance);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		setAccountNumber(accountNumber);	
	}

	/**copy constructor creates another savings account for the same person*/
	public SavingsAccount(SavingsAccount s, double balance) {
		super(s, balance);
		this.savingsNumber = s.savingsNumber+1;
		accountNumber = super.getAccountNumber().split("-",2)[0]	// gets original account# from old savings account
										+ "-" + this.savingsNumber;	// then concatenates "-" and new savings number
	}
	
	/** Adds 1 month's worth of interest 
		and deposits it into the account */
	public void postInterest() {
		double newBalance = getBalance() * (1 + rate/12);
		setBalance(newBalance);
	}
	
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}
}
