/**
    This class contains a field that represents the balance in the son's 
    account. It also has two methods that print the deposit the withdrawls
    to the console.

    @author Jeremy Hill
    @version 1.8.0_271
 */
public class Account 
{
	private int balance;
	private boolean depositMade;

	/**
    * Prints the withdrawal to the console
    */
	public synchronized void withdraw() 
	{
		while (!depositMade)
		{
			try 
			{
				wait();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		depositMade = false;
		System.out.println("Withdraw: " + balance);
		notify();
	}


	/**
    * Adds the deposit to the account's balance and print it to the console
    * @param num Represents the deposit number
    */
	public synchronized void deposit(int num) 
	{
		while (depositMade)
		{
			try 
			{
				wait();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		balance = num;
		depositMade = true;
		System.out.println("Deposit: " + balance);
		notify();
	}
}