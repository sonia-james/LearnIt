package learnit.dsa.linkedlist;

public class DetectLoop {
	public static void main(String[] args) {
		Operations operations = new Operations();
		Node head = null;
		Node loop = new Node(4);
		head = operations.insert(head, loop);
		head = operations.insert(head, 2);
		head = operations.insert(head, 3);
		head = operations.insert(head, 4);
		head = operations.insertIterative(head, 6);
		head = operations.insertIterative(head, 7);
		head = operations.insertIterative(head, 8);
		head = operations.insertIterative(head, 9);
		head = operations.insertIterative(head, 10);
		head = operations.insert(head, loop);
		DetectLoop detectLoop = new DetectLoop();
		System.out.println(detectLoop.detectLoop(head));
	}
	
	private boolean detectLoop(Node head) {
		Node slow = head, fast = head;
		while(null!=slow && null!=fast && null!=fast.next){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		}
		return false;
	}
}
