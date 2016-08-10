package LinkedList;

public class RemoveNthNodeFromEndofList {
	public static void main(String args[]){
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next= new ListNode(4);
		list = removeNthFromEnd(list,1);
		ListNode.printList(list);
		System.out.println();
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;
		ListNode fast, slow;
		fast = slow = null;
		for (int i = 0; i < n; i++) {
			if(fast == null)
				fast = head;
			else
				fast = fast.next;
		} 
		while (fast.next != null) {
			if(slow == null)
				slow =head;
			else
				slow = slow.next;
			fast = fast.next;
		}
		// 找到要删除点的前一个节点
		if(slow == null)
			head = head.next;
		else
		slow.next = slow.next.next;
		return head;

	}
}
