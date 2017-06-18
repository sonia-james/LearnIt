package learnit.dsa.linkedlist;

/*
 * Insert to a sorted Linked List
 * Insert -> 1,4,2,3,5
 * 4
 * 1->4
 * 1->2->4
 * 1->2->3->4
 * 1->2->3->4->5
 */
public class InsertInSortedLinkedList {
	public static void main(String[] args) {
		InsertInSortedLinkedList insertInSortedLinkedList = new InsertInSortedLinkedList();
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		
		Node head = null;
		head = insertInSortedLinkedList.insert(head, four);
		head = insertInSortedLinkedList.insert(head, one);
		head = insertInSortedLinkedList.insert(head, two);
		head = insertInSortedLinkedList.insert(head, three);
		head = insertInSortedLinkedList.insert(head, five);
		
		Operations operations = new Operations();
		operations.display(head);
	}
	
	public Node insert(Node head, Node newNode){
		if(head == null){
			return newNode;
		}
		if(head.val>newNode.val){
			newNode.next = head;
			return newNode;
		}
		Node previous = null, current = head;
		while(null!=current){
			if(current.val>newNode.val){
				previous.next = newNode;
				newNode.next = current;
				return head;
			}
			previous = current;
			current = current.next;
		}
		previous.next = newNode;
		return head;
	}
}
