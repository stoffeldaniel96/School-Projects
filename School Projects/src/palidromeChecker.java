/*=================================================================================

Name:          Daniel Stoffel	
User Name:     Dstoffel
Course:        CS 2500, Computer Programming II, Section 001
Instructor:    Prerak Shah
Date:  11/4/15        

INPUT: User-inputed phrase
OUTPUT: The results of checking for palindromes
PRECONDITIONS and POSTCONDITIONS: User inputed a valid phrase; Results of palindrome checking.

=================================================================================*/
import java.util.*;

public class palidromeChecker 
{
	private static Stack<Character> sCheck = new Stack<Character>();
	private static Queue<Character> qCheck= new LinkedList<Character>();
	/*
    FUNCTION NAME: palidromeChecker;
    INPUT: User inputed phrase
    OUTPUT: Creates a stack and queue containing characters from user-inputed phrase.
    PRECONDITIONS: User inputed a valid phrase:
    POSTCONDITIONS: A stack and queue are initialized with characters from the valid phrase.
    CALLES: validPhrase();
	 */
	public palidromeChecker(String input)
	{
		if(validPhrase(input))
		{
			for(int i = 0; i < input.length(); i++)
			{
				if (Character.isLetter(input.charAt(i)))
				{
					sCheck.push(input.charAt(i));
					qCheck.offer(input.charAt(i));
				}
			}
		}
	}
	
	/*
    FUNCTION NAME: validPhrase;
    INPUT: User-inputed phrase
    OUTPUT: Checks if user-inputed phrase is valid, returns true;
    CALLERS: palidromeChecker();

	 */
	public static boolean validPhrase(String chPhrase)
	{
		Boolean result = false;
		Character test;
		for (int i = 0; i < chPhrase.length();i++)
		{
			test = chPhrase.charAt(i);
			if (Character.isLetter(test))
			{
				result = true;
			}
		}
		return result;
	}
	/*
    FUNCTION NAME: checkPal;
    INPUT: Characters from queue and stack;
    OUTPUT: Checks if stack and queue have the same characters, returns true if so.
    PRECONDITIONS: A stack and queue have been initialized with the same phrase characters.
    POSTCONDITIONS: Whether or not the phrase was a palindrome was tested.
    CALLERS: ;
    CALLES: ;

	 */
	public boolean checkPal()
	{
		Boolean result = false;
		int count = 0;
		int size = sCheck.size();
		String inp1, inp2;
		String print1 = "Backward: ";
		String print2 = "Forward: ";
		
		while(!sCheck.isEmpty())
		{
			inp1 = "" + sCheck.pop();
			print1 = print1.concat(inp1);
			inp2 = "" + qCheck.remove();
			print2 = print2.concat(inp2);
			if(inp1.equalsIgnoreCase(inp2))
			{
				count++;
			}
		}
		System.out.println(print2);
		System.out.println(print1);
		if (count == size && size != 0)
			result = true;
		return result;
	}
}

