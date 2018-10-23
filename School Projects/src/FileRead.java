
import java.io.*;    // for File
import java.util.*;  // for Scanner

public class FileRead
{
	public static void main(String[] args)throws FileNotFoundException
	{
		System.out.print("Please insert file name ----> ");
		Scanner user = new Scanner (System.in);
		Scanner input = new Scanner(new File(user.next()));

		String strLine; 
		
		input.nextLine();
		while (input.hasNextLine())
		{
			// Print the content on the console
			strLine = input.nextLine();
			System.out.println (strLine);
		}

	}
}
