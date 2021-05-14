/**
    This class will execute a loop that will call the withdraw method 
    in the Account class. This loop will loop 10 times.

    @author Jeremy Hill
    @version 1.8.0_271
 */
public class Withdrawal implements Runnable 
{
	private Account account;

	/**
    * Constructor
    * @param account Account object
    */
	public Withdrawal(Account account) 
	{
		this.account = account;
	}

	@Override
	public void run() 
	{
		for(int i = 1; i <= 10; i++) 
		{
			account.withdraw();
		}
	}
}