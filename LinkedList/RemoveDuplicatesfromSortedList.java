package LinkedList;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = head;
		ListNode index = head.next;
		while(index != null){
			if(index.val != pre.val){
				pre = index;
			}else{
				//要刪除這個節點同時pre的值是不變的
				pre.next = index.next;
				
			}
			index = index.next;
		}
		
		
		return head;
	}
}
