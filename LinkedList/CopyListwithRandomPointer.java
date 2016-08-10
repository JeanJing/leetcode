package LinkedList;

import java.util.*;

public class CopyListwithRandomPointer {
	public static void main(String args[]){
		RandomListNode r1 = new RandomListNode(1);
		RandomListNode r2 = new RandomListNode(2);
		RandomListNode r3 = new RandomListNode(3);
		RandomListNode r4 = new RandomListNode(4);
		RandomListNode r5 = new RandomListNode(5);
		
		r1.next = r2;
		r2.next = r3;
		r3.next = r4;
		r4.next = r5;
		
		r1.random = r2;
		r2.random = null;
		r3.random = r5;
		r4.random = r1;
		r5.random = r3;
		
		RandomListNode r6 = copyRandomList_2(r1);
		
		
		
		System.out.println();
		
		
		
	}
	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode cur = dummy;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		while (head != null) {
			if (map.containsKey(head)) {
				cur.next = map.get(head);
				if (head.random != null) {
					if (map.containsKey(head.random)) {
						cur.next.random = map.get(head.random);
					} else {
						cur.next.random = new RandomListNode(head.random.label);
						map.put(head.random, cur.next.random);
					}
				} else {
					cur.next.random = null;
				}
				
			} else {
				cur.next = new RandomListNode(head.label);
				map.put(head, cur.next);
				if (head.random != null) {
					if (map.containsKey(head.random)) {
						cur.next.random = map.get(head.random);
					} else {
						cur.next.random = new RandomListNode(head.random.label);
						map.put(head.random, cur.next.random);
					}
				} else {
					cur.next.random = null;
				}

			}
			head = head.next;
			cur =cur.next;
		}
		return dummy.next;
	}
	//���ڰ�����⣬�������ˣ��ò�����ѽ
	public static RandomListNode copyRandomList_2(RandomListNode head){
		if(head == null)//�쳣���������⣬��ʹֻ��һ���ڵ�Ҳ��Ҫ���临��
			return head;
		//��������Ľ�㸴�Ƶ�ԭ����ǰ���ĺ���
		RandomListNode cur = head;
		while(cur != null){
			RandomListNode temp = new RandomListNode(cur.label);
			temp.next = cur.next;
			cur.next = temp;
			cur = temp.next;
		}
		//���������random���ָ�ֵΪԭ�����random����һ�����
		cur = head;
		while(cur!= null){
			if(cur.random == null)
				cur.next.random = null;
			else
				cur.next.random = cur.random.next;
			//��ѭ�������ĸ���
			cur = cur.next.next;
			
		}
		//���������ԭ������ժȡ����
		cur = head;
		RandomListNode new_list = head.next;
		while(cur.next.next != null){//�������ж������һ��ڵ�û�д���������Ҫ������
			RandomListNode newcur_next = cur.next.next;
			cur.next.next = cur.next.next.next;
			cur.next = newcur_next;
			
			//ѭ���ĸ��²���
			cur = cur.next;
			
		}
		cur.next = null;
		return new_list;
		
	}

}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}