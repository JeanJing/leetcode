package LinkedList;

public class LinkedListCycle {
	public static void main(String args[]){
		ListNode list = new ListNode(2);
		ListNode node = new ListNode(3);
		list.next = node;
		list.next.next = new ListNode(3);
		list.next.next.next= new ListNode(6);
		list.next.next.next.next = node;
		
		System.out.println(hasCycle_simplify(list));
		//ListNode.printList(list);
		System.out.println();
	}
	public static boolean hasCycle(ListNode head) {
		if(head == null)
			return false;
		ListNode fast, slow;
		fast = slow = head;
		boolean isFirst = true;
		while(fast != null && slow != null){
			if(isFirst){//以后遇到这样的代码，就想想可不可以将代码统一化
				slow = slow.next;
				if(fast.next == null)
					return false;
				else
				fast= fast.next.next;
				isFirst = false;	
			}else{
				if(fast == slow)
					return true;
				else
				{
					slow = slow.next;
					if(fast.next == null)
						return false;
					else
					fast= fast.next.next;
					
				}
				
			}
		}
		return false;
    }

	public static boolean hasCycle_simplify(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode fast, slow;
		slow = head;
		fast = head.next;
		boolean isFirst = true;
		while (fast != null && slow != null) {
			if (fast == slow)
				return true;
			else {
				slow = slow.next;
				if (fast.next == null)
					return false;
				else
					fast = fast.next.next;
			}
		}
		return false;
	}

}
