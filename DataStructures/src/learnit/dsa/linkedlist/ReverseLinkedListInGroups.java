package learnit.dsa.linkedlist;

/*
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * Example:
 * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
 * Output:  3->2->1->6->5->4->8->7->NULL. 
 *
 * Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
 * Output:  5->4->3->2->1->8->7->6->NULL. 
 */

public class ReverseLinkedListInGroups {
	public static void main(String[] args) {
		Operations operations = new Operations();
		Node head = null;
		head = operations.insert(head, 1);
		head = operations.insert(head, 2);
		head = operations.insert(head, 3);
		head = operations.insert(head, 4);
		head = operations.insert(head, 5);
		head = operations.insertIterative(head, 6);
		head = operations.insertIterative(head, 7);
		head = operations.insertIterative(head, 8);
		head = operations.insertIterative(head, 9);
		head = operations.insertIterative(head, 10);
		System.out.println("\nLinkedList");
		operations.display(head);
		ReverseLinkedListInGroups reverseLinkedListInGroups = new ReverseLinkedListInGroups();
		head = reverseLinkedListInGroups.reverseInGroups(head, 3);
		System.out.println("\nReversed LinkedList");
		operations.display(head);
	}
	
	public Node reverseInGroups(Node head, int k){
		Node curr = head, prev = null, next = null;
		int count = 0;
		while(null!=curr && count<k){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr=next;
			count++;
		}
		if(next!=null){
			head.next = reverseInGroups(curr,k);
		}
		return prev;
	}
}
