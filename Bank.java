/**
 * this class is used to test the classes Account and SavingsAccount
 * @author Karlee Fidek
 */
public class Bank 
{
    private static Account user = new Account();
	       	    
    public static void main(String[] args)
    {	 
    	//code to test best account choice algorithm
	    user.deposit(3000);
	     
	    //code to test savings account compound interest
	    //monthly interest - 1 year
	    SavingsAccount saver = new SavingsAccount();
	    
	    saver.modifyAnnualInterestRate(0.05);
	    
	    saver.setSavingsBalance(2000.00);
	    
	    for(int i = 0; i < 12; i++)
	    {
	    	saver.deposit(500.00);
	    	saver.calculateMonthlyInterest();
	    }
	    
	    System.out.println("The final balance of the savings account after 12 months of monthly "
	    		+ "compound interest and depositing $500/month is " + saver.getSavingsBalance());
	    
	    //biweekly interest - 1 year
	    saver.setSavingsBalance(2000.00);
	    
	    int monthTracker = 0;
	    for(int i = 0; i < 26; i++)
	    {
	    	if((monthTracker % 4) == 0)
	    	{
	    		saver.deposit(500.00);
	    	}
	    	saver.calculateBiweeklyInterest();
	    	monthTracker = monthTracker + 2;
	    }
	    
	    System.out.println("The final balance of the savings account after 12 months of biweekly "
	    		+ "compound interest and depositing $500/month is " + saver.getSavingsBalance());
    }
}
