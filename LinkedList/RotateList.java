package LinkedList;

public class RotateList {
	public static void main(String args[]){
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		//list.next.next.next= new ListNode(4);
		//list.next.next.next.next= new ListNode(5);
		list = rotateRight(list,300000001);
		ListNode.printList(list);
		System.out.println();
	}
	public static ListNode rotateRight_1(ListNode head, int k) {//这样的版本的话就是一直在遍历链表，时间上肯定是不行的
		//第一步对参数k进行处理
		if(head == null || head.next == null || k == 0)
			return head;
		ListNode slow,fast;
		slow = fast = head;
			ListNode end = null;
		for(int i = 0; i < k; i++){
	        if(fast.next == null){
	           end = fast;
	           fast.next = head;
	        	
	        }
		    fast = fast.next;
	    }
		//if(fast == end)
		//	return head;
	    while(fast.next != (end == null? null:end.next)){
	    	slow = slow.next;
	    	fast = fast.next;
	    }
	    ListNode newHead = slow.next;
	    fast.next = head;
	    slow.next = null;
	    return newHead;
	    



	}
	 public static ListNode rotateRight(ListNode head, int k) {
		 if(head == null || head.next == null || k == 0)
				return head;
				
			ListNode slow,fast;
			slow = fast = head;
			int ListLength = 0;
			for(int i = 0; i < k; i++){
		        if(fast.next == null){
		        	ListLength = i + 1;
		        	k  = k % ListLength;
		        	i = -1;
		        	fast = head;
		        	continue;
		        	
		        }
			    fast = fast.next;
		    }
			if(k == 0)
				return head;
		    if(fast == null)
				return head;
			
		    while(fast.next != null){
		    	slow = slow.next;
		    	fast = fast.next;
		    }
		    ListNode newHead = slow.next;
		    fast.next = head;
		    slow.next = null;
		    return newHead;
		}
	
}
