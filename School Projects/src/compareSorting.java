import java.io.*;
import java.util.*;

/*=================================================================================

Name:          Daniel Stoffel	
User Name:     Dstoffel
Course:        CS 2500, Computer Programming II, Section 001
Instructor:    Prerak Shah
Date:  11/9/15        

INPUT: User-inputed file
OUTPUT: The efficiency of sorting algorithms is calculated
=================================================================================*/
public class compareSorting 
{
	static String fileName = null; 
	static int[] arrayCopy = null;
	static int[] tempArray = null;
	static int compA = 0;
	static int moveA = 0;
	static int compB = 0;
	static int moveB = 0;
	
	/*
    FUNCTION NAME: Main ;
    INPUT: User-inputed file.
    OUTPUT: sorting algorithm efficiency
    PRECONDITIONS:
    POSTCONDITIONS: 
    CALLERS: None.
    CALLES: readFile(), selectSort();

	 */
	public static void main (String args[])
	{
		Scanner scan = new Scanner(System.in);
		String user = null;
		Boolean userQuit = false;
		while(userQuit !=true )
		{
			readFile();
			System.out.println("");
			tempArray = arrayCopy;
			System.out.print("Selection sort starting...");
			compA = 0;
			moveA = 0;
			selectSort(tempArray);
			System.out.println("Done!");
			tempArray = arrayCopy;
			System.out.print("Merge Sort starting...");
			moveB = 0;
			compB = 0;
			mergeSort(tempArray);
			System.out.println("Done!");
			System.out.println("Selection sort Comparisons: " + compA + " Moves: " + moveA);
			System.out.println("Merge Sort Comparisons: " + compB + " Moves: " + moveB);
			System.out.println("");
			System.out.println("Would you like to continue? (y/n)");
			user = scan.next();
			if (user.equalsIgnoreCase("n"))
				userQuit = true;
		}
	}
	
	/*
    FUNCTION NAME: readFile;
    INPUT: User-inputed file.
    OUTPUT: Stores array values and prepares data for sorting.
    PRECONDITIONS:
    POSTCONDITIONS: arrays are initialized and prepared for sorting
    CALLERS: Main;
    CALLES: 

	 */
	public static void readFile()
	{
		System.out.print("Filename: ");
		Scanner input1 = new Scanner(System.in);
		fileName = input1.next();
		if (fileName.contains(".txt") != true) //adds .txt to end of user input, if it does not exist
			fileName = fileName.concat(".txt");
		System.out.println("Filename: " + fileName);
		System.out.println("");
		Scanner input2;
		try 
		{
			input2 = new Scanner(new File(fileName));
			if(input2.hasNext())
			{
				System.out.println("File Comment: " + input2.nextLine());
				arrayCopy = new int [Integer.parseInt(input2.next())];
				for (int i = 0; i < arrayCopy.length; i++)
				{
					if (input2.hasNext())
					{
						arrayCopy[i] = Integer.parseInt(input2.next());
					}
					else 
						arrayCopy[i] = 0;
				}
				
				
			}
			else 
				System.out.println("No Content Found");
		
		
		}
		catch (FileNotFoundException e) //catches exception and outputs error message
		{
			System.out.println("File not found.");
		}
	}
	/*
    FUNCTION NAME: selectSort;
    INPUT: array of integers
    OUTPUT: Efficiency of selection sorting Algorithm
    PRECONDITIONS: Valid array exists with sortable integers
    POSTCONDITIONS: Array is sorted via selection sort.
    CALLERS: Main;
    CALLES: 

	 */
	public static void selectSort(int[] forsort)
	{
		int index,smallerNum;
		for(int i = 0; i < forsort.length - 1; i++)
		{
			index = i;
			for(int j = i + 1; j < forsort.length; j++)
			{
				
				if (forsort[j] < forsort[index])
				{
					index = j;
				}
				compA++;
			}
			smallerNum = forsort[index];
			moveA++;
			forsort[index] = forsort[i];
			moveA++;
			forsort[i] = smallerNum;
			moveA++;
			
		}
		
	}
	/*
    FUNCTION NAME: mergeSort;
    INPUT: array of integers
    OUTPUT: Efficiency of merge sorting Algorithm
    PRECONDITIONS: Valid array exists with sortable integers
    POSTCONDITIONS: Array is sorted via merge sort
    CALLERS: Main;
    CALLES: Merge;
	Sidenote: This implementation of Merge Sort returns a different number of comparisons and moves then expected.
	 */
	public static int[] mergeSort(int [] list) 
	{
        if (list.length <= 1) 
        {
            return list;
        }
        compB++;
        
        // Split the array in half
        int[] first = new int[list.length / 2];
        moveB++;
        int[] second = new int[list.length - first.length];
        moveB++;
        System.arraycopy(list, 0, first, 0, first.length);
        moveB++;
        System.arraycopy(list, first.length, second, 0, second.length);
        moveB++;
        
        // Sort each half
        mergeSort(first);
        moveB++;
        mergeSort(second);
        moveB++;
        
        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        moveB++;
        return list;
    }
    
	/*
    FUNCTION NAME: merge;
    INPUT: three arrays;
    OUTPUT: One merged array
    PRECONDITIONS: Valid arrays exist 
    POSTCONDITIONS: A single merged array result;
    CALLERS: mergeSort;
    CALLES: 

	 */
    private static void merge(int[] first, int[] second, int [] result) 
    {
        int firstNum = 0;
        int secNum = 0;
        int j = 0;
        while (firstNum < first.length && secNum < second.length) 
        {
            if (first[firstNum] < second[secNum]) 
            {
                result[j] = first[firstNum];
                firstNum++;
            } 
            else 
            {
                result[j] = second[secNum];
                secNum++;
            }
            compB++;
            moveB++;
            j++;
        }
        System.arraycopy(first, firstNum, result, j, first.length - firstNum);
        moveB++;
        System.arraycopy(second, secNum, result, j, second.length - secNum);
        moveB++;
    }
}
