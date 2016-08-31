package Tree2;

import java.util.List;

public class PathSum {
	
	public static void main(String args[]) {
		List<Integer> result;
		TreeNode root = new TreeNode(1);
		//TreeNode left = null;//new TreeNode(2);
		//root.left = left;
		TreeNode right = new TreeNode(2);
		root.right = right;
		//left.left = new TreeNode(6);
		//left.right = new TreeNode(4);
		right.left = new TreeNode(2);
		//right.right = new TreeNode(7);
		System.out.println(hasPathSum(root,6));
		

	}
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null)
			if(root.val == sum)
				return true;
			else
				return false;
		if(hasPathSum(root.left, sum -root.val ) || hasPathSum(root.right, sum - root.val ))
			return true;
		else 
			return false;
	}
}
