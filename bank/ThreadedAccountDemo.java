/**
    This is a proof of concept application to demonstrate threads.
    This program will address the deposits and withdrawal functionality 
    of a bank customer's son's account with the following behavior:

    For each deposit that is made into the sons account, he can make a 
    onetime withdrawal of the entire amount that was deposited. He cannot make
    a partial withdrawal. He has to withdraw the entire amount of the deposit.

	He has to make his withdrawal after each deposit.

	No additional deposits can be made to his account until he has made the 
	withdrawal.

    @author Jeremy Hill
    @version 1.8.0_271
 */
public class ThreadedAccountDemo 
{
	/**
    * The main method will create an Account object, and call the Deposit and 
    * Withdrawal constructors passing it the reference to the Account object. 
    * It will create a thread for the deposit and a thread for the withdraw
    * @param args the command line arguments
    */
	public static void main(String[] args) throws InterruptedException 
	{
		// create an Account object, the deposit thread and the withdraw thread
		Account account = new Account();
		Thread deposit = new Thread(new Deposit(account), "Deposit Thread");
		Thread withdraw = new Thread(new Withdrawal(account), "Withdraw Thread");

		deposit.start();
		withdraw.start();

		// use the join() method to prevent the main thread from terminating
		// prior to the Deposit and Withdrawal threads
		try 
		{
			deposit.join();
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Main thread Interrupted");
		}

		try 
		{
			withdraw.join();
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Main thread Interrupted");
		}
	}
}