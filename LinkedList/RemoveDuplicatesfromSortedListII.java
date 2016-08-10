package LinkedList;

public class RemoveDuplicatesfromSortedListII {
	public static void main(String args[]){
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(2);
		list = deleteDuplicates(list);
		System.out.println();
	}
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode index, next, pred;
		index = head;
		next = index.next;
		pred = null;
		boolean isSame = false;
		while (index != null) {
			next = index.next;
			if (next == null) {
				if (isSame == true) {
					
					if (pred == null)
						head = next;
					else
						pred.next = next;
				} else {
					
					pred = index;
				}

			} else {
				if (index.val == next.val) {
					isSame = true;
					// �h����ǰ�Y�c
					if (pred == null)
						head = next;
					else
						pred.next = next;// �@�ӾͰ�index�o�h���ˣ�ͬ�rǰһ���Y�c��׃
				} else {
					if (isSame == true) {
						
						if (pred == null)
							head = next;
						else
							pred.next = next;
					} else {
					
						pred = index;
					}
					isSame = false;
				}
			}
			index = next;
			
		}

		return head;
	}
}
