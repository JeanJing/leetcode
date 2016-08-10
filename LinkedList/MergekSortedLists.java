package LinkedList;

public class MergekSortedLists {
	public static void main(String args[]){
		ListNode list = new ListNode(2);
		//list.next = new ListNode(2);
		//list.next.next = new ListNode(3);
		//list.next.next.next= new ListNode(4);
		
		ListNode list2 =null;// new ListNode(1);
		//list2.next = new ListNode(2);
		//list2.next.next = new ListNode(3);
		//list2.next.next.next= new ListNode(4);
		ListNode list3 =  new ListNode(-1);
		ListNode [] lists = new ListNode[3];
		lists[0] = list;
	    lists[1] = list2;
	    lists[2] = list3;
		
		ListNode.printList(mergeKLists_2(lists));
		//Integer a[] = new Integer[1];
		//System.out.println(a);
		
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null)
			return null;
		int null_count = 0;
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while (true) {// 因为判断条件不明确，所以用while true，当停止条件出现的时候continue跳出
			int temp = Integer.MAX_VALUE;
			int index = -1;// 这里想的还不够完整
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] != null) {
					if (lists[i].val < temp) {
						temp = lists[i].val;
						index = i;

					}
				}
			}
			if(index == -1){
				return null;
			}
			cur.next = lists[index];
			cur = cur.next;

			lists[index] = lists[index].next;
			if (lists[index] == null)
				null_count++;
			if (null_count == lists.length)
				break;
		}
		return head.next;
	}
	public static ListNode mergeKLists_2(ListNode[] lists) {//采用两路归并
		if(lists == null || lists.length == 0)//在数组不为空的前提下，还要判断数组的长度是否为0
			return null;
		int length = lists.length;
		while(length > 1){
			int j = 0;
			for(int i = 0; i < length -1; i += 2){
				lists[j++] = MergeTwoSortedLists.mergeTwoLists(lists[i], lists[i + 1]);
			}
			if(length % 2 != 0){
				lists[j] = lists[length - 1]; 
				length = j + 1;
			}else{
			length = j;
			}
			
		}
		
		return lists[0];
	}
	//针对2个版本，可以转换为递归版本
	public static ListNode mergeKLists_3(ListNode[] lists) {//采用两路归并
		if(lists == null || lists.length == 0)//在数组不为空的前提下，还要判断数组的长度是否为0
			return null;
		return merge3_helper(lists,0,lists.length);
	}
	public static ListNode merge3_helper(ListNode[] lists,int start, int end){
		if(start == end)
			return lists[start];
		if(start == end - 1)
			return MergeTwoSortedLists.mergeTwoLists(lists[start],lists[end]);
		ListNode firstResult = merge3_helper(lists,start, start + (end -start)/2 -1 );
		ListNode secondResult = merge3_helper(lists, start + (end -start)/2, end);
		return MergeTwoSortedLists.mergeTwoLists(firstResult,secondResult);
	}

}
