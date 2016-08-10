package Tree;

/**
 * Created by celin on 2016/6/30.
 */
import java.util.*;

public class MaximumDepthOfBinaryTree {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left = left;
		TreeNode right = new TreeNode(3);
		root.right = right;
		left.left = new TreeNode(4);
		left.right = new TreeNode(5);
		//right.left = new TreeNode(6);
		//right.right = new TreeNode(7);

		System.out.println(maxDepth_2(root));
	}
	 public static int maxDepthReverse(TreeNode root) {
	        if (root == null)
	            return 0;
	        else{
	            return Math.max(maxDepthReverse(root.left), maxDepthReverse(root.right)) + 1;
	        }
	    }
	//���ù�����ȱ����Ĳ�����ӵصõ������ȣ������ջ��ǶԹ�����ȱ�����εĿ���
	 public static int maxDepthBreadthFirst(TreeNode root){
	        if(root == null)
	            return 0;
	        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.addLast(root);
	        int max = 0;
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            
	            for(int i = 0; i < size; i++){
	                TreeNode tempNode = queue.pollFirst(); 
	                if(tempNode.left != null)
	                    queue.addLast(tempNode.left);
	                if(tempNode.right != null)
	                    queue.addLast(tempNode.right);
	                
	            }
	            max++;
	        }
	        return max;
	    }
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		LinkedList<TreeNode> tempList = new LinkedList<TreeNode>();
		tempList.add(root);
		if (root.right == null && root.left == null)
			return 1;
		if (root.right != null)
			stack.push(root.right);
		if (root.left != null)
			stack.push(root.left);

		int max = 1;
		while (!stack.isEmpty()) {
			TreeNode tempNode = stack.pop();
			if (tempNode.right == null && tempNode.left == null) {
				while (!isParent(tempList.getLast(), tempNode)) {
					tempList.pollLast();// ����϶���ɾ��������Ԫ��
				}
				max = max > (tempList.size() + 1) ? max : (tempList.size() + 1);
			} else {
				while (!isParent(tempList.getLast(), tempNode))
					tempList.pollLast();
				tempList.add(tempNode);
				if (tempNode.right != null) {
					stack.push(tempNode.right);
				}
				if (tempNode.left != null) {
					stack.push(tempNode.left);
				}
			}

		}
		return max;

	}

	public static boolean isParent(TreeNode parent, TreeNode son) {
		if (parent.left == son || parent.right == son)
			return true;
		else
			return false;

	}
	public static int maxDepth_2(TreeNode root) {
		int max = 0;
		if(root == null)
			return 0;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode cur,pre;
		stack.push(root);
		pre = null;
		while(!stack.isEmpty()){
			cur = stack.peek();
			if(pre == null || pre.left == cur || pre.right == cur){
				if(cur.left != null)
					stack.push(cur.left);//����ܹؼ�����Ϊstack�е�����Ԫ�ض�Ӧһ��·�������Բ�����ͬʱ����ǰ�������ҽ�㶼�Ž�ȥ
				else
					if(cur.right != null)
					   stack.push(cur.right);//ֻ��������Ϊ�յ�����£��ſ��Խ��ҽ�����
			}else{
				if(cur.left == pre){
					if(cur.right != null)//����Ҫ��֤�ŵ�stack��ı����������Ľ�㣬�����Էſսڵ�
					stack.push(cur.right);
				}
				else
					stack.pop();
			}
			pre = cur;
			max = max > stack.size() ? max : stack.size();
		}
		return max;
		
		
	}
}
