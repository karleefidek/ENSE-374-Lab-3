/**
 * This class implements an algorithm that allows a user to enter their account 
 * preferences and chooses the type of account that best fits their preferences
 * @author Karlee Fidek
 */

import java.util.Scanner;

public class Account 
{
	private static Scanner scanner = new Scanner(System.in);
    private int savingsCount;
    private int checkingCount;
    private int marketCount;
    private SavingsAccount savingsAcct;
    private CheckingAccount checkingAcct;
    private MoneyMarketAccount marketAcct;
    
    /**
	 * initial constructor
	 * initializes all the values in the class
	 */
    Account()
    {
        savingsCount = 0;
        checkingCount = 0;
        marketCount = 0;
        savingsAcct = new SavingsAccount();
        checkingAcct = new CheckingAccount();
        marketAcct = new MoneyMarketAccount();
    }
    
    /**
     * Tool to decide which account the user should open.
     * Their answers to specific questions will be used to determine the appropriate account.
     * Keeps a count for the qualities of each type of account.
     * Once all the deciding qualities have been decided by the user, the counts will be compared.
     * to decide which account is the most appropriate.
     * @param amount - double value representing amount to deposit into account
     */
    public void deposit(double amount)
    {
        System.out.println("Do you plan on making more than 20 withdrawals from your account per month? (yes/no)");
        String choice = scanner.nextLine();
        
        //assumes user enters valid response - yes or no
        if(choice.equals("yes") || choice.equals("Yes"))
        {
        	checkingCount += 2;
        }
        else
        {
        	savingsCount++;
        	marketCount++;
        }
        
        System.out.println("Would you like a debit card to use for purchases? (yes/no)");
        choice = scanner.nextLine();
        	
        //assumes user enters valid response - yes or no
        if(choice.equals("yes") || choice.equals("Yes"))
        {
        	//more weight because it is necessary
        	checkingCount += 2;
        }
        else
        {
        	savingsCount++;
        	marketCount++;
        }
        
        System.out.println("Would you like checks? (yes/no)");
        choice = scanner.nextLine();
        	
        //assumes user enters valid response - yes or no
        if(choice.equals("yes") || choice.equals("Yes"))
        {
        	System.out.println("Do you plan on writing more than 15 checks per month? (yes/no)");
            choice = scanner.nextLine();
            	
            //assumes user enters valid response - yes or no
            if(choice.equals("yes") || choice.equals("Yes"))
            {
            	checkingCount++;
            }
            else
            {
            	marketCount++;
            }
        }
        else
        {
        	savingsCount++;
        }
        
        System.out.println("Do you plan on paying your bills electronically? (yes/no)");
        choice = scanner.nextLine();
        	
        //assumes user enters valid response - yes or no
        if(choice.equals("yes") || choice.equals("Yes"))
        {
        	checkingCount += 2;
        }
        else
        {
        	savingsCount++;
        	marketCount++;
        }
        
        System.out.println("Do you plan on having at least $5000 in your account at all times? (yes/no)");
        choice = scanner.nextLine();
        	
        //assumes user enters valid response - yes or no
        if(choice.equals("yes") || choice.equals("Yes"))
        {
        	marketCount++;
        }
        else
        {
        	System.out.println("Do you plan on having at least $1000 in your account at all times? (yes/no)");
        	choice = scanner.nextLine();
        	if(choice.equals("yes") || choice.equals("Yes"))
            {
            	savingsCount++;
            }
            else
            {
            	checkingCount++;
            }
        }
        	
        System.out.println("Would you like to earn interest on the money in your account? (yes/no)");
        choice = scanner.nextLine();
        	
        //assumes user enters valid response - yes or no
        if(choice.equals("yes") || choice.equals("Yes"))
        {
        	System.out.println("Do you want to...");
        	System.out.println("1. Earn less interest with a fixed interest rate");
        	System.out.println("2. Earn more interest with a varying interest rate");
        	System.out.println("1 or 2?");
        	choice = scanner.nextLine();
        	if(choice.equals("1"))
            {
            	savingsCount++;
            }
            else
            {
            	marketCount++;
            }
        }
        else
        {
            	checkingCount++;
        }
        
        if((savingsCount > checkingCount) && (savingsCount >= marketCount))
        {	
        	System.out.println("The appropriate account based on your preferences is a savings account");
        	savingsAcct.deposit(amount);
            
            //extra code could be added here to make use of the account functionality
            
            return;
        }   
        else if((checkingCount >= savingsCount) && (checkingCount >= marketCount))
        {
        	System.out.println("The appropriate account based on your preferences is a checking account");
        	checkingAcct.deposit(amount);
            
            //extra code could be added here to make use of the account functionality
            
            return;
        }
        else
        {
        	System.out.println("The appropriate account based on your preferences is a Money Market account");
        	marketAcct.deposit(amount);
            
            //extra code could be added here to make use of the account functionality
            
            return;
        }
    }
}
