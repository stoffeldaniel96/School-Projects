/*=================================================================================

Name:          Daniel Stoffel	
User Name:     Dstoffel
Course:        CS 2500, Computer Programming II, Section 001
Instructor:    Prerak Shah
Date:          

INPUT: The user of this program inputs a 'y' for yes or a 'n' for no.

OUTPUT:

This program prints a little message and asks the user if he wants to see a printed image.
When the user answers 'y', it prints the pattern according to the users specifications.
and asks the question again.  When the user answers with 'n', the program stops.

PRECONDITIONS and POSTCONDITIONS: None.

=================================================================================*/
import java.util.*;
import java.io.*;

public class TileMap

{
	private static String fileName = null;
	private static int imageHeight =0;
	private static int imageWidth=0;
	private static char[][] buffer = null ;


	/*
    FUNCTION NAME: Main ;
    INPUT: none.
    OUTPUT: a message to the user of this program, all of the
    prompts and a final display according to user specifications.
    PRECONDITIONS:  None.
    POSTCONDITIONS: Variables and calls made according to users input
                    output set to start on a new line.
    CALLERS: None.
    CALLS: askPermission, getParameters(), getImage(), and printImage().

	 */

	public static void main(String args[]) throws FileNotFoundException
	{
		while (askPermission() == true)
		{
			imageHeight = 0;
			imageWidth = 0;
			getParameters();
			if (imageHeight != 0 && imageWidth != 0)
			{
				buffer = new char[imageHeight][imageWidth];
				getImage();			
				printImage();
			}
			else
				System.out.println ("Failed to find image and or image dimensions.");
		}

	}

	/*
    FUNCTION NAME: askPermission 
    INPUT: none.
    OUTPUT: a message to the user of this program.
    PRECONDITIONS:  output set to start on a new line.
    POSTCONDITIONS: variable response has user's answer stored in it.
    CALLERS: the main program
    CALLES: None.

	 */

	public static boolean askPermission()
	{
		System.out.print ("Would you like to print an image from a text file? (y/n) ----> ");
		Scanner input = new Scanner(System.in);
		String permission = input.next();
		if (permission.equalsIgnoreCase("y") || permission.equalsIgnoreCase("yes"))
			return true;
		else
			return false;

	}


	/*
   FUNCTION NAME getParameters ;
   INPUT: the file name, number of tiles across and down.
   OUTPUT: message "Getting Image..." if valid file and dimensions founds. "File not found" if not.
   PRECONDITIONS: the variable response has 'y' in it.
   POSTCONDITIONS: variables set with the values entered by user.
   CALLERS: the main program
   CALLEES: none
	 */

	static void getParameters()
	{
		System.out.print("Please insert file name ----> ");
		Scanner input1 = new Scanner(System.in);
		fileName = input1.next();
		if (fileName.contains(".txt") != true) //adds .txt to end of user input, if it does not exist
			fileName = fileName.concat(".txt");
		Scanner input2;
		try 
		{
			input2 = new Scanner(new File(fileName));
		
		System.out.println("Getting Image...");
		if(input2.hasNextInt()) //setting array size variables
			{
				imageHeight = input2.nextInt();
				imageWidth = input2.nextInt();
			}
		
		System.out.println("Image Height: " + imageHeight + " Image Width: " + imageWidth);
		System.out.println("");
		}
		catch (FileNotFoundException e) //catches exception and outputs error message
		{
			System.out.println("File not found.");
		}
	}

	/*
    FUNCTION NAME: getImage ;
    INPUT:the file name and the height and width of the pattern to be made.
    OUTPUT: none.
    PRECONDITIONS: array for image declared, the variables fileName, 
				   imageHeight and imageWidth set with proper values.  
    POSTCONDITIONS: the image is stored in the array.
    CALLERS: the main program
    CALLEES: none
	 */
	public	static void getImage() throws FileNotFoundException
	{
		String temp = null;
		Scanner input = new Scanner(new File(fileName));
		input.nextLine();
		for (int i = 0; i < buffer.length; i++)
		{
				temp = input.nextLine();
			for (int j = 0; j < buffer[i].length; j++)
			{
					buffer[i][j] = temp.charAt(j);
			}
		}
	}
		



	/*
    FUNCTION NAME: printImage
    INPUT:the buffer with the image and the height and width of the
          pattern to be made
    OUTPUT: the patterns structured according to users input.
    PRECONDITIONS: All of the variables are set and pattern is stored in 'buffer'.
    POSTCONDITIONS: Output displayed according to users input.
    CALLERS: the main program
    CALLEES: none
	 */
	//  This function uses for loops to display the images. The inner most for loop prints one line of the picture.


	public	static void printImage()
	{
		for (int i = 0; i < buffer.length; i++)
		{
			for (int j = 0; j < buffer[i].length; j++)
			{
				System.out.print(buffer[i][j]);
			}
			System.out.println("");
		}
	}
	
}
