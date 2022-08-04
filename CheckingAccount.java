
public class CheckingAccount extends BankAccount {
	
	private static double FEE = 0.15;	// cost of clearing one check
	
	public CheckingAccount(String name, double amount) {
		super(name, amount);
		String newAccountNumber = getAccountNumber() + "-10";		
		setAccountNumber(newAccountNumber);	
	}
	
	@Override
	public boolean withdraw(double amount)
	{
		boolean completed = true;

		if (amount <= getBalance())
		{
			double newBalance = getBalance() - (amount + FEE);
			setBalance(newBalance);
		}
		else
		{
			completed = false;
		}
		return completed;
	}
	
}
