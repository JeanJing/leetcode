package LinkedList;

public class PartitionList {
	public static void main(String args[]){
		ListNode list = new ListNode(2);
		list.next = new ListNode(3);
		list.next.next = new ListNode(3);
		list.next.next.next= new ListNode(2);
		list = partition(list,3);
		ListNode.printList(list);
		System.out.println();
	}
	public static ListNode partition(ListNode head, int x) {
		
		if (head == null)
			return head;
		ListNode cur = head;
		ListNode less, more_and_equal;
		less = more_and_equal = null;
		while (cur != null) {
			if(cur.val >= x){
				more_and_equal = cur;
				cur = cur.next;
			}else{
				if(more_and_equal == null){
					less = cur;
					cur = cur.next;
				}else{
					if(less == null){
						more_and_equal.next = cur.next;//��һ��ɾ��ԭ���
						cur.next = head;//��ԭ������
						head = less = cur;//������ָ��ǰ���
						cur = more_and_equal.next;
					}else{
						more_and_equal.next = cur.next;//ɾ�����
						cur.next = less.next;
						less.next = cur;
						less = cur;
						cur = more_and_equal.next;			
					}
				}
			}
		}
		return head;
	}
}
