package LinkedList;
public class ReorderList {
	public static void main(String args[]){
		ListNode list = new ListNode(2);
		list.next = new ListNode(3);
		list.next.next = new ListNode(3);
		list.next.next.next= new ListNode(2);
		reorderList_twoPointer(list);
		ListNode.printList(list);
		System.out.println();
	}
	
	
	
public static void reorderList(ListNode head) {
	if(head == null || head.next == null)
		return ;
	int length = 0;
	ListNode cur_1 = head;
	ListNode cur_2 = head;
	//�õ�������ܳ�
	while(cur_1 != null){
		cur_1 = cur_1.next;
		length++;
	}
	//�ҵ��������֮һ��λ�ã��������ƽ�����䣬����ǰ������Ц��
	for(int i = 1; i< length / 2 + length % 2; i++){
		cur_2 = cur_2.next;
	}
	//ListNode pre =cur_2;
	cur_2 = cur_2.next;
	//pre.next = null;
	cur_1 = head;
	cur_2 = ReverseLinkedList.reverseList_iter(cur_2);
	ListNode cur = new ListNode(0);
	head = cur;
	int i = 0;
	boolean flag = true;//true��ʾ���cur1�ϵ�Ԫ�أ��������cur2�ϵ�Ԫ��
	while(i < length){
		if(flag){
		  cur.next = cur_1;
		  cur_1 = cur_1.next;
		  cur = cur.next;
		  flag =false;
		}else{
			cur.next = cur_2;
			cur_2 = cur_2.next;
			cur = cur.next;
			flag =true;
		}
		i++;
	}
	head = head.next;
	
        
    }

public static void reorderList_twoPointer(ListNode head) {
	if(head == null || head.next == null)
		return;
	ListNode slow, fast;
	slow = head;
	fast = head.next;
	//�ҵ��м��㣬��ǰ��slow���������м��
	while(fast != null && fast.next != null){
		slow = slow.next;
		fast = fast.next.next;
	}
	ListNode rlist = slow.next;
	slow.next = null;
	ListNode pred = null;
	while(rlist != null){
		ListNode temp = rlist.next;
		rlist.next = pred;
		pred = rlist;
		rlist  = temp;
	}
	rlist = pred;
	ListNode llist = head;
	while(llist != null && rlist != null){
		ListNode lnext = llist.next;
		ListNode rnext = rlist.next;
		
		llist.next  = rlist;
		rlist.next = lnext;
		llist = lnext;
		rlist = rnext;
	}
		
	
}
}

