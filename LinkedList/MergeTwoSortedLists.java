package LinkedList;

public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null || l2 == null)
			return l1 == null ? l2 : l1;
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode cur = head;
		while(l1!= null && l2 != null){
			if(l1.val <= l2.val){
				cur.next = l1;
				cur = cur.next;
				l1 = l1.next;
				
			}else{
				cur.next = l2;
				cur = cur.next;
				l2 = l2.next;
				
			}
		}
		cur.next = l1 == null ? l2: l1;
		return head.next;
	}
}
