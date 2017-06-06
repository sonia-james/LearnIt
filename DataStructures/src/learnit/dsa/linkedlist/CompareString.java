package learnit.dsa.linkedlist;
/*
 * Reverse a linked list recursively
 * Input : 
 * str1 -> s->o->n->i->a
 * str2 ->  s->o->n->i->a
 * Output : 0
 * 
 * Input : 
 * str1 -> s->o->n->i->a->b
 * str2 ->  s->o->n->i->a->a
 * Output : 1
 * 
 * Input : 
 * str1 -> s->o->n->i->
 * str2 ->  s->o->n->i->a
 * Output : -1
 */
class CharNode {
	char val;
	CharNode next;
	CharNode(char val){
		this.val=val;
	}
}
public class CompareString {
	public static void main(String[] args) {
		CompareString compareString = new CompareString();
		CharNode head1 = null;
		CharNode head2 = null;
		head1 = compareString.insert(head1, 's');
		head1 = compareString.insert(head1, 'o');
		head1 = compareString.insert(head1, 'n');
		head1 = compareString.insert(head1, 'i');
		head1 = compareString.insert(head1, 'a');
		//head1 = compareString.insert(head1, 'a');
		
		head2 = compareString.insert(head2, 's');
		head2 = compareString.insert(head2, 'o');
		head2 = compareString.insert(head2, 'n');
		head2 = compareString.insert(head2, 'i');
		head2 = compareString.insert(head2, 'a');
		//head2 = compareString.insert(head2, 'b');
		
		System.out.println(compareString.compare(head1, head2));
	}
	
	public int compare(CharNode str1, CharNode str2){
		CharNode head1 = str1, head2 = str2;
		while(null!=head1 && null!=head2){
			if(head1.val < head2.val){
				return -1;
			}else if(head1.val > head2.val){
				return 1;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		if(null!=head1){
			return 1;
		}else if(null!=head2){
			return -1;
		}
		return 0;
	}
	
	public CharNode insert(CharNode head,char val){
		if(null==head){
			return new CharNode(val);
		}
		head.next = insert(head.next,val);
		return head;
	}
	
}
