import java.util.Scanner;
/*=================================================================================

Name:          Daniel Stoffel	
User Name:     Dstoffel
Course:        CS 2500, Computer Programming II, Section 001
Instructor:    Prerak Shah
Date:  12/9/15        

INPUT: User-inputed phrase
OUTPUT: User-inputed phrase is recursively printed in reverse order.
=================================================================================*/
public class recurPalindrome 
{
	private static String palindrome;
	private static Boolean userQuit;
	 /*
    FUNCTION NAME: Main ;
    INPUT: User-inputed phrase.
    OUTPUT: Recursively order-reversed phrase
    PRECONDITIONS:
    POSTCONDITIONS: 
    CALLERS: None.
    CALLES: recurPal

	 */
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		String userInput2 = null;
		userQuit = false;
		while (userQuit == false)
		{
			System.out.print("Please input a word: ");
			palindrome=userInput.next();
			System.out.println(palindrome + "-" + recurPal(palindrome));
			System.out.print("Would you like to continue? (Y/N): ");
			userInput2 = userInput.next();
			if(userInput2.equalsIgnoreCase("n") || userInput2.equalsIgnoreCase("no"))
			{
				userQuit = true;
			}
			System.out.println();
		}
		userInput.close();
	}
	
	/*
    FUNCTION NAME: recurPal;
    INPUT: User-inputed phrase.
    OUTPUT:  Recursively order-reversed phrase
    PRECONDITIONS:Phrase is valid for reversal.
    POSTCONDITIONS: 
    CALLERS: Main.
    CALLES: 

	 */
	public static String recurPal(String palindrome)
	{
		if (palindrome.length() ==0)
			return palindrome;
		else
			return recurPal(palindrome.substring(1)) + palindrome.charAt(0);
		
	}
}