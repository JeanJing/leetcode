package LinkedList;

public class DeleteNodeintheMiddleofSinglyLinkedList {
	public static void main(String args[]){
		ListNode list = new ListNode(2);
		ListNode node = new ListNode(3);
		list.next = node;
		deleteNode(node);
		ListNode.printList(list);
		System.out.println();
	}
	 public static  void deleteNode_answer(ListNode node) {
	        if (node == null) return;
	        if (node.next == null) node = null;

	        node.val = node.next.val;
	        node.next = node.next.next;
	    }
	 public static void deleteNode(ListNode node) {//在仅仅知道当前节点的情况下，删除中间节点
	        if(node == null)
	        	return;
	        if(node.next == null){
	        	node = null;//这样是根本无法删除的,因为值传递
	        }else{
	        	node.val = node.next.val;
		        ListNode next = node.next;
		        node.next = node.next.next;
		        next = null;
	        }
	        
	        
	 }
	        
	        

}
