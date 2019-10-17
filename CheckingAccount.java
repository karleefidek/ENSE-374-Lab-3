/**
 * This class has the functionality of a checking account
 * It provides functions that allow the user to interact with the account
 * @author Karlee Fidek
 */
public class CheckingAccount 
{
	/**
	 * checkingBalance: holds the current balance of the checking account
	 */
    private double checkingBalance;
	    
    /**
     * initial constructor
     * initializes all values in the class
     */
    CheckingAccount()
    {
        checkingBalance = 0.0;
    }
	     
    /**
	 * deposits given amount into the checking account
	 * @param amount - double value representing amount to deposit into account
	 */
	public void deposit(double amount)
    {       
        checkingBalance = checkingBalance + amount;
    }
	      
	/**
	 * Withdraws amount specified by user. 
	 * Lets user know if withdrawal amount is too high.
	 * @param amount
	 */
    public void withdraw(double amount)
    {
        if(amount > checkingBalance)
	    {
            System.out.println("There are not enough funds in your savings account.");
            return;
        }
        else
        {
            checkingBalance = checkingBalance - amount;
        }     
    }
    
	/**
	 * allows user to make purchase using their debit card using funds from their checking account
	 * @param amount
    */
	public void useDebitCard(double amount)
    {
		if(amount > checkingBalance)
        {
            System.out.println("There are not enough funds in your checking account.");
            return;
        }
        else
        {
            checkingBalance = checkingBalance - amount;
        }       
    }
	
	/**
     * allows user to write checks using funds from their checking account
     * @param amount
     */
    public void useChecks(double amount)
    {
        checkingBalance = checkingBalance - amount;
    }
	
	/**
	 * allows user to pay bills electronically using funds from their checking account
	 * @param billPayment
    */
	public void payBills(double amount)
    {
		if(amount > checkingBalance)
        {
            System.out.println("There are not enough funds in your checking account.");
            return;
        }
        else
        {
            checkingBalance = checkingBalance - amount;
        }       
    }
	
	/**
	 * assigns provided value as users' checking balance
	 * @param balance
	 */
	public void setCheckingBalance(double balance)
	{
		checkingBalance = balance;
	}
	
    /**
	 * allows user to retrieve current checking balance
	 * @return
	 */
    public double getCheckingBalance()
    {
        return checkingBalance;
    }   
}