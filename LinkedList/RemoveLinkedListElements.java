package LinkedList;

public class RemoveLinkedListElements {
	public static void main(String args[]) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(1);
		//list.next.next = new ListNode(3);
		// list.next.next.next= new ListNode(4);
		// list.next.next.next.next= new ListNode(5);
		list = removeElements(list, 1);
		ListNode.printList(list);
		System.out.println();
	}

	public static ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur != null && cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			}else{
			cur = cur.next;
			}
		}
		return dummy.next;
	}

}
