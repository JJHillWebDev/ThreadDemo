/**
    This class will execute a loop that will write 10 values into the balance 
    in Account by calling the deposit method in the Account class.
    
    @author Jeremy Hill
    @version 1.8.0_271
 */
public class Deposit implements Runnable 
{
	private Account account;

	/**
    * Constructor
    * @param account Account object
    */
	public Deposit(Account account) 
	{
		this.account = account;
	}

	@Override
	public void run() 
	{
		for(int i = 1; i <= 10; i++) 
		{
			account.deposit(i);
		}
	}
}