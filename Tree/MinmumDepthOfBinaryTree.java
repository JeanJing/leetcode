package Tree;

import java.util.List;

public class MinmumDepthOfBinaryTree {
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
		System.out.println(minDepth(root));
	}

	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		return minDepthHelper(root);

	}

	public static int minDepthHelper(TreeNode root) {
		if (root == null)
			return Integer.MAX_VALUE;
		if (root.left == null && root.right == null)
			return 1;
		else {
			return Math.min(minDepthHelper(root.left), minDepthHelper(root.right)) + 1;
		}
	}
}
