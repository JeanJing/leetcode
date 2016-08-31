package Tree2;

import java.util.*;
public class BinaryTreeRightSideView {
	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        //right.left = new TreeNode(6);
       // right.right = new TreeNode(7);
        System.out.println(rightSideView(root));
    }
	
public static List<Integer> rightSideView(TreeNode root) {
	List<Integer> list = new LinkedList<Integer>();
	if(root == null)
		return list;
	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	queue.offer(root);
	TreeNode curr;
	int size;
	while(!queue.isEmpty()){
		size = queue.size();
		for(int i = 0; i < size -  1; i++){
			curr = queue.poll();
			if(curr.left != null)
				queue.offer(curr.left);
			if(curr.right != null)
				queue.offer(curr.right);
		}
		curr = queue.poll();
		list.add(curr.val);
		if(curr.left != null)
			queue.offer(curr.left);
		if(curr.right != null)
			queue.offer(curr.right);
		
	}
	return list;
	}

}
