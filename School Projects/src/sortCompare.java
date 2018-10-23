import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*=================================================================================

Name:          Daniel Stoffel	
User Name:     Dstoffel
Course:        CS 3100, Data Structures and Algorithms, Section 001
Instructor:    Dr. Reza Kamali
Date:  3/18/16        

INPUT: User-inputed pasted unsorted array or array file
OUTPUT: The efficiency of various sorting algorithms
=================================================================================*/
public class sortCompare
{
	static int compMerge, compIns;
	static Scanner scan,scanFile;
	static int[] array = null;
	static int[] arrayCopy = null;
	static String userInput1;
	static int arraySize;
	
	/*
    FUNCTION NAME: Main ;
    INPUT: User-inputed file or array.
    OUTPUT: sorting algorithm efficiency
    PRECONDITIONS:
    POSTCONDITIONS: 
    CALLERS: None.
    CALLES: readFile(), mergeSort(), insertSort();

	 */
	public static void main (String args[])
	{
		Boolean validOption = false;
		Boolean finishRun = false;
		System.out.println("Comparison of Insertion Sort vs. Merge Sort:\n");
		scan = new Scanner(System.in);
		while (finishRun != true)
		{
			System.out.println("Would you like to: \n\n1.Input Array Manually \n2.Load Array from File (.txt files)");
			System.out.print("Input (1 or 2): ");
			while (validOption != true)
			{
				userInput1 = scan.nextLine();
				if (userInput1.equals("1"))
				{
					System.out.print("\nPlease insert array size: ");
					array = new int[scan.nextInt()];
					for(int i = 0; i < array.length;i++)
					{
						System.out.print("Please insert value for array element " + (i+1) + ": ");
						array[i] = scan.nextInt();
					}
					validOption = true;
				}
				else if (userInput1.equals("2"))
				{
					readFile();
					validOption = true;
				}
				else
				{
					System.out.print("Please choose valid option: ");
				}
			}
			arrayCopy = array;
			compIns = 0;
			insertSort(arrayCopy);
			arrayCopy = array;
			compMerge = 0;
			mergeSort(arrayCopy);
			System.out.println("Insertion Sort Comparisons: " + compIns + " Merge Sort Comparisons: " + compMerge + "\n");
			System.out.print("Would you like to finish? (y/n)");
			userInput1 = scan.nextLine();
			if (userInput1.equalsIgnoreCase("n"))
			{
				validOption = false;
				compIns = 0;
				compMerge = 0;
			}
			else 
			{
				finishRun = true;
			}
		}
		System.out.println("The difference between the number of comparisons becomes signficant when the array size is roughly larger than 10 elements.");	
		System.out.println("Insertion Sort has an efficiency of n^2 while Merge Sort is n*Log(n), with the operation predictions roughly producing the\nsame results as the comparison checks.\nA Difference of 5 exists.");
	}
	
	/*
    FUNCTION NAME: readFile;
    INPUT: none.
    OUTPUT: file-loaded array
    PRECONDITIONS: Valid array exist 
    POSTCONDITIONS: 
    CALLERS: 
    CALLES: main();

	 */
	public static void readFile()
	{
		Boolean validFile = false;
		while (validFile != true)
		{
			System.out.print("\nPlease insert name of file containing array: ");
			userInput1 = scan.nextLine();
			if (!userInput1.contains(".txt"))
			{
				userInput1 = userInput1.concat(".txt");
				System.out.println("File: " + userInput1);
			}
			try 
			{
				scanFile = new Scanner(new File(userInput1));
				while (scanFile.hasNextInt())
				{
					arraySize++;
					scanFile.next();
				}
				scanFile = new Scanner(new File(userInput1));
				if(scanFile.hasNext())
				{
					
					array = new int [arraySize];
					for (int i = 0; i < array.length; i++) //scans through file for array values
					{
						if (scanFile.hasNext())
						{
							array[i] = Integer.parseInt(scanFile.next());
						}
						else 
							array[i] = 0;
					}
					
					
				}
				else 
					System.out.println("No Content Found");
				validFile = true;
			}
			catch (FileNotFoundException e) //catches exception and outputs error message
			{
				System.out.println("File not found.");
			}
		}
	}
	
	/*
    FUNCTION NAME: insertSort;
    INPUT: one array;
    OUTPUT: One insertion sorted array
    PRECONDITIONS: Valid arrays exist 
    POSTCONDITIONS: A single sorted array result;
    CALLERS: main();
    CALLES: 

	 */
	public static void insertSort(int [] input) 
	{
		int temp;
        for (int i = 1; i < input.length; i++) //sorts array using insertion sort
        {
            for(int j = i ; j > 0 ; j--)
            {
                if(input[j] < input[j-1])
                {
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
                compIns++;
            }
            compIns++;
        }

	}
	
	/*
    FUNCTION NAME: mergeSort;
    INPUT: an array
    OUTPUT: One merged sorted array
    PRECONDITIONS: Valid arrays exist 
    POSTCONDITIONS: A single merged array result;
    CALLERS: main();
    CALLES: merge();

	 */
	public static int[] mergeSort(int [] input) 
	{
        if (input.length <= 1) 
        {
            return input;
        }
        compMerge++;
        // Split the array in half
        int[] first = new int[input.length / 2];
        int[] second = new int[input.length - first.length];
        System.arraycopy(input, 0, first, 0, first.length);
        System.arraycopy(input, first.length, second, 0, second.length);
        
        // Sort each half
        mergeSort(first);
        mergeSort(second);
        // Merge the halves together, overwriting the original array
        merge(first, second, input);
        return input;
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
        while (firstNum < first.length && secNum < second.length) //recombines arrays using comparison
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
            j++;
            compMerge++;
            compMerge++;
        }
        System.arraycopy(first, firstNum, result, j, first.length - firstNum); //recombines array fragments back into one array
        System.arraycopy(second, secNum, result, j, second.length - secNum);
        compMerge++;
        compMerge++;
    }
    
}
