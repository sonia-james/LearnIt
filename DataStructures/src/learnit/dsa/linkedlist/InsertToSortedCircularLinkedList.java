package learnit.dsa.linkedlist;

/*
 * Insert to a sorted circular linked list
 * 1->2->3->4->1
 * Insert 5 
 * 1->2->3->4->5->1
 * 
 * 1->2->3->6->1
 * Insert 5
 * 1->2->3->5->6->1
 * 
 * Done using do-while loop and checking reference of head to detect loop
 */
public class InsertToSortedCircularLinkedList {
	public static void main(String[] args) {
		InsertToSortedCircularLinkedList insertToSortedCircularLinkedList = new InsertToSortedCircularLinkedList();
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node six = new Node(6);
		Node five = new Node(5);
		one.next = two;
		two.next = three;
		three.next = six;
		six.next = one; 
		
		//Display the linked list
		Operations operations = new Operations();
		operations.displayCircularList(one);
		
		//Insert to the sorted circular  linked list
		insertToSortedCircularLinkedList.insert(one, five);
		
		//Display the modified linked list
		System.out.println("\nList after Insert");
		operations.displayCircularList(one);
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
		do{
			if(current.val>newNode.val){
				previous.next = newNode;
				newNode.next = current;
				return head;
			}
			previous = current;
			current = current.next;
		} while(null!=current && current != head);
		previous.next = newNode;
		return head;	
	}

}
