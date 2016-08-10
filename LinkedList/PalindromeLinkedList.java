package LinkedList;

import java.util.LinkedList;

public class PalindromeLinkedList {
	public static void main(String args[]){
		ListNode list = new ListNode(2);
		list.next = new ListNode(3);
		list.next.next = new ListNode(3);
		list.next.next.next= new ListNode(3);
		list.next.next.next.next= new ListNode(2);
	
		System.out.println(isPalindrome_withReverse(list));
	}
	
	public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
        	return true;
        ListNode slow, fast;
        LinkedList<ListNode> stack = new LinkedList<ListNode>();
        slow = head;
        stack.push(slow);
        fast = head.next;
        
        while(fast != null && fast.next != null){
        	
        	slow = slow.next;
        	stack.push(slow);
        	fast = fast.next.next;
        }
        ListNode middle = slow;//middle 为中间节点
        if(fast == null)//对应的是奇数
        	stack.pop();
        ListNode rlist = middle.next;
        while(!stack.isEmpty()){
        	if(stack.peek().val != rlist.val)
        		return false;
        	else{
        		stack.pop();
        		rlist = rlist.next;
        	}
        }
        return true;
        
    }
	public static boolean isPalindrome_withReverse(ListNode head) {
        if(head == null || head.next == null)
        	return true;
        ListNode slow, fast;
        slow = head;
        fast = head.next;
        ListNode pred = null;
        ListNode slow_next;
        while(fast != null && fast.next != null){
        	slow_next = slow.next;
        	slow.next = pred;
        	pred = slow;
        	slow = slow_next;
        	fast = fast.next.next;
        }
        ListNode middle = slow;//middle 为中间节点
        ListNode rlist = middle.next;
        if(fast == null)//对应的是奇数
        	slow = pred;
        else
        	slow.next = pred;
        while(slow != null){
        	if(slow.val != rlist.val)
        		return false;
        	else{
        		slow = slow.next;
        		rlist = rlist.next;
        	}
        }
        return true;
        
    }
}
