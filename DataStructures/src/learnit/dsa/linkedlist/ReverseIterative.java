package learnit.dsa.linkedlist;
/*
 * Reverse a linked list iteratively
 * 1->2->3->4
 * 4->3->2->1
 */
public class ReverseIterative {
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
		ReverseIterative reverseIterative = new ReverseIterative();
		head = reverseIterative.reverse(head);
		System.out.println("\nReverse");
		operations.display(head);
	}
	
	private Node reverse(Node head){
		if(null == head){
			return null;
		}
		if(null==head.next){
			return head;
		}
		Node current = head,previous=null, list=null;
		Node temp = null;
		while(null!=current){
			list = current.next;
			current.next = previous;
			previous = current;
			current = list;
		}
		return previous;
	}
}
