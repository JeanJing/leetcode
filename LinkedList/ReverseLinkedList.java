package LinkedList;

public class ReverseLinkedList {
	
	 public static  ListNode reverseList_recurse(ListNode head) {
		 if(head == null ||head.next ==null)
			 return head;
		 ListNode subList = reverseList_recurse(head.next);
		 head.next.next = head;
		 head.next = null;
		 return subList;
	 
	 }
	 public static  ListNode reverseList_iter(ListNode head) {
		 if(head == null|| head.next == null)
			 return head;
		 ListNode pred, cur, next;
		 pred = head;
		 cur = head.next;
		 head.next = null;
		 while(cur!= null){
			 next = cur.next;
			 cur.next = pred;
			 
			 pred = cur;
			 cur = next;
		 }
		 return pred;
	 }
	 
	 public static void main(String args[]){
			ListNode list = new ListNode(2);
			ListNode node = new ListNode(3);
			list.next = node;
			list.next.next = new ListNode(3);
			list.next.next.next= new ListNode(6);
			//list.next.next.next.next = node;
			
			//System.out.println(reverseList(list));
			ListNode.printList(reverseList_iter(list));
			System.out.println();
		}

}
