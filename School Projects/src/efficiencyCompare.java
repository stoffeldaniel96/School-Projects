import java.util.*;
/*=================================================================================

Name:          Daniel Stoffel	
User Name:     Dstoffel
Course:        CS 3100, Data Structures and Algorithms, Section 001
Instructor:    Dr. Reza Kamali
Date:  4/8/16        

INPUT: Randomized Arrays
OUTPUT: A table containing sorting array efficiencies.
=================================================================================*/
public class efficiencyCompare 
{
	public static void main (String args[])
	{
		int array1[] = new int[5];
		int array2[] = new int[10];
		int array3[] = new int[20];
		int array4[] = new int[40];
		int array5[] = new int[80];
		
		System.out.printf( "%-15s %15s %25s %10s %15s %n", "Array Size", "Insertion Sort Comparisons", "Merge Sort Comparisons", "n^2", "n Log(n)");
		array1 = arrayBuild(array1);
		System.out.printf( "%5d %25d %25d %20d %15d %n",array1.length, insertionSort(array1), mergeSort(array1), (array1.length * array1.length), (array1.length * Math.round(Math.log(array1.length))));
		array2 = arrayBuild(array2);
		System.out.printf( "%5d %25d %25d %20d %15d %n",array2.length, insertionSort(array2), mergeSort(array2), (array2.length * array2.length), (array2.length * Math.round(Math.log(array2.length))));
		array3 = arrayBuild(array3);
		System.out.printf( "%5d %25d %25d %20d %15d %n",array3.length, insertionSort(array3), mergeSort(array3), (array3.length * array3.length), (array3.length * Math.round(Math.log(array3.length))));
		array4 = arrayBuild(array4);
		System.out.printf( "%5d %25d %25d %20d %15d %n",array4.length, insertionSort(array4), mergeSort(array4), (array4.length * array4.length), (array4.length * Math.round(Math.log(array4.length))));
		array5 = arrayBuild(array5);
		System.out.printf( "%5d %25d %25d %20d %15d %n",array5.length, insertionSort(array5), mergeSort(array5), (array5.length * array5.length), (array5.length * Math.round(Math.log(array5.length))));
	}
	static int[] arrayBuild(int theArray[])
	{
		Random rand = new Random();
		for (int i = 0; i < theArray.length;i++)
		{
			theArray[i] = rand.nextInt(100);
		}
		return theArray;
	}
	
	static int insertionSort (int theArray[])
	{
		int count = 0;
		for (int unsorted = 1; unsorted < theArray.length; unsorted++)
		{
			int nextItem = theArray[unsorted];
			int loc;
			for(loc = unsorted - 1; loc >=0 && nextItem < theArray[loc]; loc--)
			{
				theArray[loc + 1] = theArray[loc];
				count++;
			}
			theArray[loc + 1] = nextItem;
			count++;
		} 
		return count;
	}
	
	public static int mergeSort(int[] list) 
    {
        int count = 0;
		//If list is empty; no need to do anything
        if (list.length <= 1) {
            count++;
        	return count;
        }
         
        //Split the array in half in two parts
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
         
        //Sort each half recursively
        mergeSort(first);
        mergeSort(second);
        count++;
         
        //Merge both halves together, overwriting to original array
        count += merge(first, second, list);
        return count;
    }
	
    private static int merge(int[] first, int[] second, int[] result) 
    {
    	int count = 0;
    	//Index Position in first array - starting with first element
        int iFirst = 0;
         
        //Index Position in second array - starting with first element
        int iSecond = 0;
         
        //Index Position in merged array - starting with first position
        int iMerged = 0;
         
        //Compare elements at iFirst and iSecond, 
        //and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) 
        {
            if (first[iFirst]< second[iSecond]) 
            {
                result[iMerged] = first[iFirst];
                iFirst++;
            } 
            else
            {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
            count++;
        }
        count++;
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        count++;
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
        count++;
        return count;
    }
}
