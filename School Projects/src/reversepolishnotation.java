/*=================================================================================

Name:          Daniel Stoffel	
User Name:     Dstoffel
Course:        CS 2500, Computer Programming II, Section 001
Instructor:    Prerak Shah
Date:  9/29/15        

INPUT: The user of this program inputs values and or a character operator to carry out a calculation, "q" or "quit" exits the program.

OUTPUT:

This program takes user-inputed values and character operators in Post-fix expression to carry out and print the results of a calculation.

PRECONDITIONS and POSTCONDITIONS: None.

=================================================================================*/
import java.util.*;

public class reversepolishnotation
{
	public static boolean userQuit = false;
	public static String userInput = null;
	static Stack<Integer> mem = new Stack<Integer>();
	
	/*
    FUNCTION NAME: Main ;
    INPUT: none.
    OUTPUT: a message to the user of this program, all of the
    prompts and a final display according to user specifications.
    PRECONDITIONS:  None.
    POSTCONDITIONS: 
    CALLERS: None.
    CALLES: readInput();

	 */
	public static void main(String args[])
	{

		Scanner scan = new Scanner(System.in);
		System.out.println("Reverse Polish Notation Calculator:");
		readInput("h");
		while (userQuit != true)
		{
			userInput = scan.nextLine();
			readInput(userInput);
				
		}

	}

	/*
    FUNCTION NAME: readInput;
    INPUT: User input.
    OUTPUT: Pushes integers to stack and saves operators.
    PRECONDITIONS:  User's available options are printed to screen.
    POSTCONDITIONS: Reads user-input and prints response based on specifications.
    CALLERS: the main program;
    CALLES: runCalc(), isOperator();

	 */
	public static void readInput(String userinp)
	{

        String token;
        char operator;
        Scanner scan = new Scanner(userinp);
        while (scan.hasNext())
        {
        	token = scan.next();
        	if (isOperator(token))
        	{
        		runCalc(token.charAt(0));
        	}
        	else
        	{
        		try
        		{
        			mem.push(new Integer(Integer.parseInt(token)));
        		}
        		catch (NumberFormatException e)
        		{
        			System.out.println("Please input a valid operator or number");
        		}
        	}
        }

		
	}
	/*
    FUNCTION NAME: isOperator;
    INPUT: User input passed through scanner.
    OUTPUT: True if user input contains an operator, false if not.
    PRECONDITIONS: User has inputed a readable character.
    POSTCONDITIONS: Returns whether or not user inputed character was an operator.
    CALLERS: readInput();
    CALLES: 

	 */
	public static boolean isOperator(String input)
	{
		String operators = new String();
		String temp = new String();
		Boolean opresult = false;
		operators = "+ - * / p q m % n f c r d h";

		Scanner scan = new Scanner(operators);
		while (scan.hasNext())
		{
			temp = scan.next();
			if(temp.equals(input))
			opresult = true;
		}
		return opresult;
		
	}
	
	/*
    FUNCTION NAME: runCalc;
    INPUT: User-inputed integers and operators.
    OUTPUT: Performs user-specified calculations and options.
    PRECONDITIONS: User has inputed a valid operator character.
    POSTCONDITIONS: Reads user input and performs response based on specifications.
    CALLERS: readInput();
    CALLES: 

	 */
	public static void runCalc(char operator)
	{
		int result = 0;
		int input1 = 0;
		int input2 = 0;
        switch (operator)
        {
            case '+': //performs simple addition provided the stack isn't empty
                if (mem.isEmpty() != true)
                	input1 = mem.pop();
                if (mem.isEmpty() != true)
                	input2 = mem.pop();
            	mem.push(input1 + input2);
                break;
            case '-': //performs simple subtraction provided the stack isn't empty
            	if (mem.isEmpty() != true)
                	input1 = mem.pop();
                if (mem.isEmpty() != true)
                	input2 = mem.pop();
                mem.push(input1 - input2);
                break;
            case '*': //performs simple multiplication provided the stack isn't empty
            	if (mem.isEmpty() != true)
                	input1 = mem.pop();
                if (mem.isEmpty() != true)
                	input2 = mem.pop();
                mem.push(input1 * input2);
                break;
            case '/': //performs simple division provided the stack isn't empty
            	if (mem.isEmpty() != true)
                	input1 = mem.pop();
                if (mem.isEmpty() != true)
                	input2 = mem.pop();
                if (input1 != 0 && input2 != 0)
                	mem.push(input2 / input1);
                else
                	System.out.println("Cannot divide by zero");
                break;
            case 'q': //terminates program loop
            	userQuit = true;
            	break;
            case 'p': //prints top of stack provided the stack isn't empty
            	if (mem.isEmpty() != true)
            		System.out.println(mem.peek());
            	else 
            		System.out.println("Stack is Empty");
            	break;
            case 'n': //prints the top value of the stack, then sets top to null
            	if (mem.isEmpty() != true)
            		System.out.println(mem.peek());
            	else 
            		System.out.println("Stack is Empty");
            	if (mem.isEmpty() != true)
            		mem.pop();
            	break;
            case '%': //performs remainder of division operation provided the stack isn't empty
            	if (mem.isEmpty() != true)
                	input1 = mem.pop();
                if (mem.isEmpty() != true)
                	input2 = mem.pop();
            	mem.push(input2 % input1);
            	break;
            case 'm': //negates the top value in the stack provided the stack isn't empty
            	if (mem.isEmpty() != true)
                	input1 = mem.pop();
            	mem.push(input1 * -1);
            	break;
            case 'f': //prints contents of the stack
            	if (mem.isEmpty() != true)
            		System.out.println(mem.toString());
            	else 
            		System.out.println("Stack is Empty");
            	break;
            case 'r': //swaps top value with second to top value in stack provided the stack isn't empty
            	if (mem.isEmpty() != true)
                	input1 = mem.pop();
                if (mem.isEmpty() != true)
                	input2 = mem.pop();
            	mem.push(input1);
            	mem.push(input2);
            	break;
            case 'd': //duplicates top value of stack 
            	if (mem.isEmpty() != true)
                	input1 = mem.pop();
            	mem.push(input1);
            	mem.push(input1);
            	break;
            case 'c': //clears the stack
            	while (mem.size() != 0)
            	{
            		mem.pop();
            	}
            	break;
            case 'h': //prints available user options
            	System.out.println("");
            	System.out.println("p  print top");
            	System.out.println("n  print top and remove");
            	System.out.println("d  duplicate top");
            	System.out.println("r  exchange top two items");
            	System.out.println("f  print contents of stack");
            	System.out.println("c  clear stack");
            	System.out.println("+  add");
            	System.out.println("-  subtract");
            	System.out.println("*  multiply");
            	System.out.println("/  integer divide");
            	System.out.println("%  integer remainder");
            	System.out.println("m  unary minus");
            	System.out.println("q  quit");
            	System.out.println("h  print options");
            	System.out.println("");
            	break;
            	
        }
	}
}