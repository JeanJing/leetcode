




public class RemoveNthNodeFromEndofList {
	public static void main(String []args){
		linkedList list = new linkedList(1);
		list.addNode(2);
		list.addNode(3);
		//list.addNode(7);
		//list.addNode(2);
		//list.addNode(6);
		//list.addNode(34);
		//list.addNode(62);
		//list.addNode(7);
		//list.addNode(42);
		//list.addNode(5);
		
		ListNode node = removeNthFromEnd(list.head,1);
		//System.out.println(getNumberOfNodes(list.head));
	}
	public static int getNumberOfNodes(ListNode head){
		ListNode temp = head;
		int count = 0;
		while(temp !=null){//�����ﷸ�Ĵ�
			temp = temp.next;
			count++;
		}
		return count;
		
	}
public static ListNode removeNthFromEnd(ListNode head, int n) {
	ListNode temp  = head;
	int allNodes = getNumberOfNodes(head);
	if(allNodes < n || head == null)//�����������
		return head;
	int m = allNodes - n ;//�ҵ�ǰһ���ڵ�
	if(m == 0){
		head = head.next;
	}
	else{
	int i = 1;
	while(i < m){
		temp = temp.next;//�ҵĴ������ҵ�next��next��һ��ʼ�õ�forѭ��Ч���ܲ��ã��������ֱ����while����õ�
		i++;
	}
	if(temp.next != null)
	temp.next = temp.next.next;//�Լ�д�Ĵ�����ң�����������
	else
		temp.next = null;
	
	}
	return head;
        
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
	public ListNode() {
	}
}
class linkedList{
	ListNode head;
	linkedList(int val){
		head = new ListNode(val);
	}
	public void addNode(int val){
		ListNode temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = new ListNode(val);
	}
}
