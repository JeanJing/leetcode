package LinkedList;

public class InsertSortLinkedList {
	public static void main(String args[]) {
		ListNode list = new ListNode(3);
		list.next = new ListNode(4);
		list.next.next = new ListNode(1);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);
		list = insertionSortList_2(list);
		ListNode.printList(list);
		System.out.println();
	}

	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode cur, cur_sorted,pred;
		
		cur = head;
		cur_sorted = dummy.next;
		while (cur != null) {
			//更新里层循环
			cur_sorted = dummy.next;
			pred = dummy;
			while (cur_sorted != null && cur_sorted.val <= cur.val) {//找到cur第一个大于已排序的位置
				    pred = cur_sorted;
					cur_sorted = cur_sorted.next;
			}
			//将当前节点插入到合适的
			ListNode cur_next = cur.next;
			cur.next = pred.next;
			pred.next = cur;
			
			//更新外层循环的位置
			cur = cur_next;
			
			
		}
		return dummy.next;
	}
	public static ListNode insertionSortList_2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur, cur_sorted,next;
		ListNode newHead = null;
		
		cur = head;
		
		while (cur != null) {
			//更新里层循环
			cur_sorted = newHead;
	        if(cur_sorted == null || cur_sorted.val > cur.val){
	        	next = cur.next;
	        	cur.next = newHead;
	        	newHead = cur;
	        	cur = next;
	        }else{
	        		while(cur_sorted != null && cur_sorted.next != null ){
	        			if(cur_sorted.val <= cur.val && cur_sorted.next.val > cur.val ){
	        				break;
	        		     }else{
	        			    cur_sorted= cur_sorted.next;
	        		     }
	        		}
	        		next = cur.next;
	        		cur.next = cur_sorted.next;
	        		cur_sorted.next = cur;
	        		
	        		cur = next;
	        }
	        	
		}
		return newHead;
	}
}
