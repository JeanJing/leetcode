package LinkedList;

public class SwapNodeInPairs {
	public static void main(String args[]){
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		//list.next.next.next= new ListNode(4);
		//list.next.next.next.next= new ListNode(5);
		list = swapPairs(list);
		ListNode.printList(list);
		System.out.println();
	}
public static ListNode swapPairs(ListNode head) {
	if(head == null || head.next == null)
		return head;
	ListNode cur, pred, cur_next;
	cur = head;
	pred = null;
	while(cur != null && cur.next != null){
		if(pred == null){
			cur_next = cur.next;
			cur.next = cur.next.next;
			cur_next.next = cur;
			head = cur_next;
			
			pred = cur;
			cur = cur.next;
			
		}else{
			cur_next = cur.next;
			cur.next = cur.next.next;
			cur_next.next = cur;
			pred.next = cur_next;
			
			pred = cur;
			cur = cur.next;
			
			
		}
		
		
	}
	return head;
        
    }

}
