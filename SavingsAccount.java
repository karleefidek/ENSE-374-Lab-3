/**
 * This class has the functionality of a savings account
 * It provides functions that allow the user to interact with the account
 * @author Karlee Fidek
 */
public class SavingsAccount 
{
    /**
     * annualInterestRate: holds annual interest rate value for account holder
     * savingsBalance: holds current balance of the savings account
     * monthlyLimit: holds the limit of how many withdrawals the account holder can make per month
     * monthlyCount: holds the number of withdrawals the account holder has made in the current month
     */
    private double annualInterestRate;
	private double savingsBalance;
	private int monthlyLimit;
	private int monthlyCount;
		
	/**
	 * initial constructor
	 * initializes all the values in the class
	 */
	public SavingsAccount()
	{
        annualInterestRate = 0.0;
	    savingsBalance = 0.0;
	    monthlyLimit = 20;
	    monthlyCount = 0;
	}
	
	/**
	 * deposits given amount into the savings account
	 * @param amount - double value representing amount to deposit into account
	 */
	public void deposit(double amount)
	{	 
	    savingsBalance = savingsBalance + amount; 
	}

	/**
	 * Withdraws amount specified by user. 
	 * Lets user know if withdrawal amount is too high.
	 * Lets user know if they have exceeded the monthly withdrawal limit.
	 * @param amount
	 */
	public void withdraw(double amount)
	{   
	    if(amount > savingsBalance )
	    {
	        System.out.println("There are not enough funds in your savings account.");
	        return;
	    }
	    else if(monthlyCount >= monthlyLimit)
	    {
	        System.out.println("Monthly withdrawal limit exceeded.");
	        return;
	    }
	    else
	    {           
	        //updates savings account
	        savingsBalance = savingsBalance - amount;
	        monthlyCount++;
	    }
	}
	
	/**
	 * calculates monthly compound interest and updates savings balance
	 */
	public void calculateMonthlyInterest()
	{
    	double monthlyInterestRate = annualInterestRate / 12.0;
    	savingsBalance = savingsBalance + (savingsBalance * monthlyInterestRate);
	} 
	
	/**
	 * calculates biweekly compound interest and updates savings balance
	 */
	public void calculateBiweeklyInterest()
	{
        double biweeklyInterestRate = annualInterestRate / 26.0;
		savingsBalance = savingsBalance + (savingsBalance * biweeklyInterestRate);
	}

	/**
	 * assigns provided value as users' savings balance
	 * @param savings
	 */
	public void setSavingsBalance(double savings)
	{
		savingsBalance = savings;
	}

	/**
	 * allows user to retrieve current savings balance
	 * @return
	 */
	public double getSavingsBalance()
	{
		return savingsBalance;
	}

	/**
	 * sets the annual interest rate to provided value
	 * @param rate
	 */
	public void modifyAnnualInterestRate(double rate)
	{
		annualInterestRate = rate;
	}
	
	/**
	 * returns monthly counter of how many times user withdrew money from the account
	 * @return
	 */
	public int getMonthlyCount()
	{
	    return monthlyCount;
	}
}