package LinkedList;
import java.util.*;

public class RemoveDuplicatesfromUnsortedList {
	public static void main(String args[]){
		ListNode list = new ListNode(2);
		list.next = new ListNode(3);
		list.next.next = new ListNode(3);
		list.next.next.next= new ListNode(2);
		list = deleteDuplicates(list);
		ListNode.printList(list);
		System.out.println();
	}
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return head;
		Set<Integer> hashtable = new HashSet<Integer>();
		ListNode cur = head;
		ListNode pred = null;
		while(cur != null){
			if(hashtable.contains(cur.val)){
				//�����̈́h��
				
					pred.next = cur.next;//�@�ӾͰ�cur�������ǂ��Y�c�o�h������
				
			}else{
				//�������Ͳ�̎��
				hashtable.add(cur.val);
				pred = cur;
			}
			
			cur = cur.next;
		}
		return head;
	}

}
