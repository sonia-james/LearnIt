package learnit.dsa.linkedlist;

/*
 * Linkedlist Operations
 * 1. Insert Iterative
 * 2. Insert Recursive
 * 3. Display
 * 4. Display circular linked list
 */
public class Operations {
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
		operations.display(head);
	}
	
	public Node insertIterative(Node head,int val){
		Node node = new Node(val);
		if(null==head){
			return node;
		}
		if(null==head.next){
			head.next = node;
			return head;
		}
		Node list = head;
		while(null!=list){
			if(null==list.next){
				list.next = node;
				break;
			}
			list = list.next;
		}
		return head;
	}
	
	public Node insert(Node head,int val){
		if(null==head){
			return new Node(val);
		}
		head.next = insert(head.next,val);
		return head;
	}
	
	public Node insert(Node head,Node newNode){
		if(null==head){
			return newNode;
		}
		head.next = insert(head.next,newNode);
		return head;
	}
	
	public void display(Node head){
		if(null==head){
			return;
		}
		System.out.print(" "+head.val);
		display(head.next);
	}
	
	public void displayCircularList(Node head){
		if(null==head){
			return;
		}
		Node list = head;
		do{
			System.out.print(" "+list.val);
			list = list.next;
		}while(null!=list && list != head);
		
	}
}
