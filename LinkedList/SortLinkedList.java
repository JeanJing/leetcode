package LinkedList;
//�ù鲢����ݹ�汾ʵ�֡��ʼ�İ汾û�п����������������𣬻�е����������Ĺ鲢���򷽷���������˰�����룬���շ��ֻ��������⣬�������
public class SortLinkedList {
	public static void main(String args[]){
		ListNode list = new ListNode(3);
		list.next = new ListNode(4);
		//list.next.next = new ListNode(1);
		//list.next.next.next= new ListNode(4);
		//list.next.next.next.next= new ListNode(5);
		list = sortList(list);
		ListNode.printList(list);
		System.out.println();
	}
	public static ListNode sortList(ListNode head) {
    	if(head == null|| head.next == null)
    		return head;
    	//����ͨ�����֣�����ʹʱ�临�Ӷȱ�Ϊlog(n)
    	ListNode middle  = findMiddleBefore(head);//�������Ŀ���ǲ�����middleΪ0�������
    	ListNode rlist = middle.next;
    	middle.next = null;
    	head = sortList(head);
    	rlist = sortList(rlist);
    	return mergeTwoLists(head, rlist);
    }
	public static ListNode findMiddleBefore(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode slow, fast;
		slow = head;
		fast = head.next;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;	
	}
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
