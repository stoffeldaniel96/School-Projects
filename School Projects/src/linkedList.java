/*=================================================================================

Name:  Daniel Stoffel	
Date:  10/29/2018        
Desc: An example of an implementation of a simple linked list in java.
Source(s): Pulled mostly from https://www.geeksforgeeks.org/linked-list-set-1-introduction/

=================================================================================*/
public class linkedList {
	Node head;
	
	public static class Node {
		int data;
		Node next;
		Node (int d) {data = d; next=null;}
	}
	public static void main (String[] args)
	{
		linkedList test = new linkedList ();
		test.head = new Node (6);
		Node second = new Node (23);
		Node third = new Node (43);
		Node fourth = new Node (24);
		
		test.head.next = second;
		second.next = third;
		third.next = fourth;
		
		System.out.println("The Fourth Element in the linked list is: " + fourth.data);
	}
}
