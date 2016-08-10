package LinkedList;

public class ReverseLinkedListII {
	public static void main(String args[]){
		ListNode list = new ListNode(2);
		list.next = new ListNode(3);
		list.next.next = new ListNode(3);
		list.next.next.next= new ListNode(2);
		list = reverseBetween(list,2,4);
		ListNode.printList(list);
		System.out.println();
	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;
		ListNode pred_m = null;
		ListNode m_pointer;
		ListNode pred, next;
		ListNode cur = head;
		for (int i = 0; i < m - 1; i++) {
			pred_m = cur;
			cur = cur.next;
		}
		// 当前cur指向第m个结点
		m_pointer = cur;
		pred = cur;
		cur = cur.next;
		for (int i = 0; i < n - m; i++) {
			next = cur.next;
			cur.next = pred;

			pred = cur;
			cur = next;
		}
		if (pred_m == null)
			head = pred;
		else
			pred_m.next = pred;

		m_pointer.next = cur;
		return head;
	}
}
