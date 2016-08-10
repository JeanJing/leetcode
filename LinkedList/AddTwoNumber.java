package LinkedList;

public class AddTwoNumber {
	public static void main(String args[]){
		ListNode list = new ListNode(2);
		list.next = new ListNode(3);
		list.next.next = new ListNode(3);
		list.next.next.next= new ListNode(2);
		
		
		ListNode list2 = new ListNode(8);
		list2.next = new ListNode(7);
		list2.next.next = new ListNode(7);
		list2.next.next.next= new ListNode(8);
		//list2.next.next.next.next= new ListNode(4);
		ListNode list3 = addTwoNumbers_with_extra_memory_new(list,list2);
		ListNode.printList(list3);
		System.out.println();
	}
	
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {//没有增加额外内存
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;// 感觉自己帮帮哒
		ListNode cur_1, cur_2;
		ListNode pre_1, pre_2;
		cur_1 = l1;
		cur_2 = l2;
		pre_1 = pre_2 = null;
		int isCarry = 0;// 表示是否有进位
		int sum = 0;
		// 将结果存储在l1中
		while (cur_1 != null && cur_2 != null) {
			sum = cur_1.val + cur_2.val + isCarry;
			cur_1.val = sum % 10;
			isCarry = sum / 10;
            
			pre_1 = cur_1;
			pre_2 = cur_2;
			cur_1 = cur_1.next;
			cur_2 = cur_2.next;
		}
		
		if (cur_2 == null) {
			while (cur_1 != null) {// cur_2提前结束了
				sum = cur_1.val + +isCarry;
				cur_1.val = sum % 10;
				isCarry = sum / 10;
				
				pre_1 = cur_1;
				cur_1 = cur_1.next;
			}
			if(isCarry == 1)
				pre_1.next = new ListNode(1);
			return l1;
		}
		if (cur_1 == null) {
			ListNode cur_2_temp = l2;
			while (l1 != null) {
				cur_2_temp.val = l1.val;
				cur_2_temp = cur_2_temp.next;
				l1 = l1.next;

			}
			while (cur_2 != null) {
				sum = cur_2.val + +isCarry;
				cur_2.val = sum % 10;
				isCarry = sum / 10;
				
				pre_2 = cur_2;
				cur_2 = cur_2.next;

			}
			if(isCarry == 1)
				pre_2.next = new ListNode(1);

			return l2;
		}
		if(isCarry == 1)
			pre_1.next = new ListNode(1);
		return l1;
	}

	public static ListNode addTwoNumbers_with_extra_memory(ListNode l1,
			ListNode l2) {
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;// 感觉自己帮帮哒
		ListNode cur_1, cur_2;
		ListNode newNode = new ListNode(0);// 这个作为头结点
		ListNode cur = newNode;
		cur_1 = l1;
		cur_2 = l2;

		int isCarry = 0;// 表示是否有进位
		int sum = 0;
		// 将结果存储在l1中
		while (cur_1 != null && cur_2 != null) {
			sum = cur_1.val + cur_2.val + isCarry;

			isCarry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;

			cur_1 = cur_1.next;
			cur_2 = cur_2.next;
		}

		while (cur_1 != null) {// cur_2提前结束了
			sum = cur_1.val + +isCarry;
		
			isCarry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			
			cur_1 = cur_1.next;
			
		
		}
		while (cur_2 != null) {
			sum = cur_2.val + +isCarry;
			
			isCarry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			
			cur_2 = cur_2.next;

		}
		if (isCarry == 1)
			cur.next = new ListNode(1);

		
		return newNode;
	}
	public static ListNode addTwoNumbers_with_extra_memory_new(ListNode l1,//这个是参看答案，把所有的操作都整合在一个while循环中
			ListNode l2) {
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;// 感觉自己帮帮哒
		ListNode cur_1, cur_2;
		ListNode newNode = new ListNode(0);// 这个作为头结点
		ListNode cur = newNode;
		cur_1 = l1;
		cur_2 = l2;

		int carry = 0;//表示是否有进位
		int sum = 0;
		int cur1_val = 0;
		int cur2_val = 0;
		// 将结果存储在l1中
		while (cur_1 != null || cur_2 != null || carry != 0) {
			cur1_val = cur_1 == null ? 0 : cur_1.val;
			cur2_val = cur_2 == null ? 0 : cur_2.val;
			sum = cur1_val + cur2_val + carry;

			carry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;

			cur_1 = cur_1 == null? null : cur_1.next;
			cur_2 = cur_2 == null? null : cur_2.next;
		}

		
		return newNode;
	}
	
}
