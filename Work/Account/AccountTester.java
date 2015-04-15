
public class AccountTester {


	public static void main(String[] args)
	{
		System.out.println("Test case 1:  standard testing.");
		
		Account acct = new Account(1000);
		
		System.out.println("Initial balance:  $" + acct.getBalance());
		
		acct.deposit(2000);
		acct.withdraw(500);
		acct.deposit(250);
		acct.withdraw(750);
		
		System.out.println("Account should now have $2000.  Actually has:  $" + acct.getBalance());
		if(Math.abs(2000 - acct.getBalance()) < 0.001)
		{
			System.out.println("Test passed.");
		}
		else
		{
			System.out.println("Test failed.");
		}
		System.out.println();
		
		System.out.println("Test case 2:  constructor abuse.");
		try
		{
			acct = new Account(-1000);
			System.out.println("Test failed - no exception was generated.");
		}
		catch(RuntimeException e)
		{
			System.out.println("Test passed.");
		}
		
		System.out.println("Test case 3:  deposit abuse.");
		acct = new Account(500);
		try
		{
			acct.deposit(-1000);
			System.out.println("Test failed - no exception was generated.");
		}
		catch(RuntimeException e)
		{
			System.out.println("Test passed.");
		}
		System.out.println();
		
		System.out.println("Test case 3:  withdrawal abuse.");
		acct = new Account(500);
		try
		{
			acct.withdraw(-1000);
			System.out.println("Test failed - no exception was generated.");
		}
		catch(RuntimeException e)
		{
			System.out.println("Test passed.");
		}
		System.out.println();
		
		System.out.println("Test case 4:  balance abuse.");
		acct = new Account(500);
		acct.deposit(1000);
		acct.withdraw(750);
		try
		{
			acct.withdraw(1000);
			System.out.println("Test failed - no exception was generated.");
		}
		catch(RuntimeException e)
		{
			System.out.println("Test passed.");
		}
		System.out.println();
	}

}