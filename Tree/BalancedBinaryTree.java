package Tree;

import java.util.List;

public class BalancedBinaryTree {
	public static void main(String args[]) {
		List<Integer> result;
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		//root.left = left;
		TreeNode right = new TreeNode(3);
		root.right = right;
		left.left = new TreeNode(6);
		left.right = new TreeNode(4);
		right.left = new TreeNode(5);
		right.right = new TreeNode(7);
		System.out.println(isBalanced(root));

	}

	public static boolean isBalanced(TreeNode root) {
		return  maxDepth(root) != -1;
	}

	public static int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		int leftDepth, rightDepth;
		leftDepth = maxDepth(root.left);
		rightDepth = maxDepth(root.right);
		if(leftDepth == -1|| rightDepth == -1 ||Math.abs(leftDepth - rightDepth) > 1)
			return -1;
		else
			return Math.max(leftDepth, rightDepth) + 1;
		
	}

}
