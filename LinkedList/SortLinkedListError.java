package LinkedList;

public class SortLinkedListError {
	public static void main(String args[]){
		ListNode list = new ListNode(3);
		list.next = new ListNode(4);
		list.next.next = new ListNode(1);
		//list.next.next.next= new ListNode(4);
		//list.next.next.next.next= new ListNode(5);
		list = sortList(list);
		ListNode.printList(list);
		System.out.println();
	}
	
    public static ListNode sortList(ListNode head) {
    	if(head == null|| head.next == null)
    		return head;
    	head = sortListHelper(head,null);
    	return head;
    	
	
        
    }
    //�������ؿ�ʼ�ڵ�
    public static ListNode  sortListHelper(ListNode start, ListNode end){//�����ʼ�������ˣ������Ϊ������end��nextֵ
    	ListNode middle, slow, fast;
    	if(start.next == end)
    		return start;
    	slow = start;
    	fast = start;
    	while(fast != end && fast.next != end){//����ָ���ҵ��е���ж�����
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	middle = slow;//middle��������Ҫ�ҵ��м�ڵ�ǰһ���ڵ㣬���ǰ������������
    	
    	start = sortListHelper(start, middle);//���һ��ֵΪ��ֹ��������������
    	middle = sortListHelper(middle, end);
    	return merge(start, middle, end);
    	
    	
    }
	//������һ������ĺ��ѹ�������û����ĺܺ�
    
	public static ListNode merge(ListNode start, ListNode middle, ListNode end){//middleһ���ǺϷ���
		if(start ==  end)
			return start;
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode cur = head;
		ListNode l2 = middle;
		while(start!= middle && l2 != end){
			if(start.val <= l2.val){
				cur.next = start;
				cur = cur.next;
				start = start.next;
				
			}else{
				cur.next = l2;
				cur = cur.next;
				l2 = l2.next;
				
			}
		}
		
		if(start == middle)
			cur.next = l2;
		else{
			cur.next = start;
			while(start.next != middle){
				start = start.next;
			}
			start.next = end;
			
		}
		return head.next;
	}

}
