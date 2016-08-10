package Tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String args[]) {
		List<Integer> result;
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left = left;/*
		TreeNode right = new TreeNode(3);
		root.right = right;
		left.left = new TreeNode(6);
		left.right = new TreeNode(4);
		right.left = new TreeNode(5);
		right.right = new TreeNode(7);*/
		System.out.println(levelOrderBottom(root));
	}
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		TreeNode curr;
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> list = new  ArrayList<Integer>();
			for(int i = 0; i < size; i++){
				curr = queue.poll();
				list.add(curr.val);
				if(curr.left != null)
					queue.offer(curr.left);
				if(curr.right != null)
					queue.offer(curr.right);
			}
			result.add(list);
		}
		Collections.reverse(result);
		
		return result;
        
    }

}
