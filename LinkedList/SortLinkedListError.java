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
    //函数返回开始节点
    public static ListNode  sortListHelper(ListNode start, ListNode end){//忘了最开始的条件了，后面的为真正的end的next值
    	ListNode middle, slow, fast;
    	if(start.next == end)
    		return start;
    	slow = start;
    	fast = start;
    	while(fast != end && fast.next != end){//快慢指针找到中点的判定条件
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	middle = slow;//middle就是我们要找的中间节点前一个节点，我们把它分配给后半段
    	
    	start = sortListHelper(start, middle);//最后一个值为终止条件，并不包含
    	middle = sortListHelper(middle, end);
    	return merge(start, middle, end);
    	
    	
    }
	//做到这一步，真的很难过，还是没有想的很好
    
	public static ListNode merge(ListNode start, ListNode middle, ListNode end){//middle一定是合法的
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
