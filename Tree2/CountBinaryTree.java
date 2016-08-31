package Tree2;

import java.util.List;

public class CountBinaryTree {
	public static void main(String args[]) {
		List<Integer> result;
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left = left;
		TreeNode right = new TreeNode(3);
		root.right = right;
		left.left = new TreeNode(6);
		left.right = new TreeNode(4);
		right.left = new TreeNode(5);
		right.right = new TreeNode(7);
		System.out.println(countNodes_2(root));
		

	}
	public static int countNodes_2(TreeNode root) {
		if (root==null) return 0;
		if (root.left==null) return 1;
		int height = 0;
	    int nodesSum = 0;
		TreeNode curr = root;
	    while(curr.left!=null) {
	    	nodesSum += (1<<height);
	    	height++;
	    	curr = curr.left;
	    }
	    return nodesSum;
	}

	public static int countNodes(TreeNode root){
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}

}
