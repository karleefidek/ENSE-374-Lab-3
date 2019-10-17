/**
 * This class has the functionality of a Money Market account.
 * It provides functions that allow the user to interact with the account
 * @author Karlee Fidek
 */
public class MoneyMarketAccount 
{
	/**
	 * marketBalance: holds the current balance of the Money Market account
	 * interestRate: holds the current interest rate of the account
	 * monthlyCheckLimit: holds the limit of how many checks the account holder can write per month
	 * monthlyWithdrawalLimit: holds the limit of how many withdrawals the account holder can make per month
	 * monthlyWithdrawlCount: holds the number of withdrawals the account holder has made in the current month
	 * monthlyCheckCount: holds the number of check the account holder has wrote in the current month
	 */
    private double marketBalance;
    private double interestRate;
    private int monthlyCheckLimit;
    private int monthlyWithdrawalLimit;
    private int monthlyWithdrawalCount;
    private int monthlyCheckCount;
    
    /**
	 * initial constructor -
	 * initializes all the values in the class
	 */
    MoneyMarketAccount()
    {
        marketBalance = 0.0;
        interestRate = 0.0;
        monthlyCheckLimit = 15;
        monthlyWithdrawalLimit = 20;
        monthlyCheckCount = 0;
        monthlyWithdrawalCount = 0;
    }
    
    /**
	 * deposits given amount into the money market account
	 * @param amount - double value representing amount to deposit into account
	 */
    public void deposit(double amount)
    {
	    marketBalance = marketBalance + amount;
    }
    
    /**
	 * Withdraws amount specified by user. 
	 * Lets user know if withdrawal amount is too high.
	 * Lets user know if they have exceeded the monthly withdrawal limit.
	 * @param amount - double value representing amount to withdraw from account
	 */
	public void withdraw(double amount)
	{   
	    if(amount > marketBalance )
	    {
	        System.out.println("There are not enough funds in your savings account.");
	        return;
	    }
	    else if(monthlyWithdrawalCount >= monthlyWithdrawalLimit)
	    {
	        System.out.println("Monthly withdrawal limit exceeded.");
	        return;
	    }
	    else
	    {
	        marketBalance = marketBalance - amount;
	        monthlyWithdrawalCount++;
	    }
	}
	
	/**
     * allows user to write checks using funds from their money market account
     * @param amount
     */
    public void useChecks(double amount)
    {
    	if(monthlyCheckCount >= monthlyCheckLimit)
	    {
	        System.out.println("Monthly check limit exceeded.");
	        return;
	    }
    	else
    	{
    		marketBalance = marketBalance - amount;
	        monthlyCheckCount++;
    	}
    }
    
    /**
	 * calculates monthly compound interest and updates market balance
	 */
	public void calculateMonthlyInterest()
	{
    	double monthlyInterestRate = interestRate / 12.0;
    	marketBalance = marketBalance + (marketBalance * monthlyInterestRate);
	} 
	
	/**
	 * calculates biweekly compound interest and updates market balance
	 */
	public void calculateBiweeklyInterest()
	{
        double biweeklyInterestRate = interestRate / 26.0;
		marketBalance = marketBalance + (marketBalance * biweeklyInterestRate);
	}
	
	/**
	 * assigns provided value as users' market balance
	 * @param balance
	 */
	public void setMarketBalance(double balance)
	{
		marketBalance = balance;
	}

	/**
	 * allows user to retrieve current market balance
	 * @return marketBalance
	 */
	public double getMarketBalance()
	{
		return marketBalance;
	}
    
	/**
	 * sets the interest rate to provided value
	 * @param rate
	 */
	public void modifyInterestRate(double rate)
	{
		interestRate = rate;
	}
}
