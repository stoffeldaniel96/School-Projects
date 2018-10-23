/*=================================================================================

Name:          Daniel Stoffel	
User Name:     Dstoffel
Course:        CS 2500, Computer Programming II, Section 001
Instructor:    Prerak Shah
Date:  11/4/15        

INPUT: User-inputed phrase
OUTPUT: The results of checking for palidromes
PRECONDITIONS and POSTCONDITIONS: User inputed a valid phrase; Results of palindrome testing.

=================================================================================*/
import java.util.*;

public class palidriver 
{
	/*
    FUNCTION NAME: Main ;
    INPUT: User-inputed phrase.
    OUTPUT: The result of checking whether or not the user-inputed phrase was a palindrome.
    PRECONDITIONS:
    POSTCONDITIONS: The results of palindrome checking.
    CALLERS: None.
    CALLES: palidromeChecker.java;

	 */
	
	private static Scanner scanner;

	public static void main(String args[])
	{
		System.out.println("Insert Phrase for Palindrome Checking: ");
		scanner = new Scanner (System.in);
		String input = scanner.nextLine();
		palidromeChecker checkd = new palidromeChecker(input);
		if(checkd.checkPal())
			System.out.println(input + " is a Palindrome!");
		else
			System.out.println(input + " is not a Palindrome!");
	}
}
