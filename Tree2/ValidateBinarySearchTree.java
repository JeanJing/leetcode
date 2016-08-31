package Tree2;

import java.util.LinkedList;

public class ValidateBinarySearchTree {
	public static void main(String args[]) {

		TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        root.left = left;
        TreeNode right = new TreeNode(15);
        root.right = right;
        //left.left = new TreeNode(1);
        //left.right = new TreeNode(3);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        System.out.println(isValidBST(root));
      
    }
	
	public static boolean isValidBST(TreeNode root) {
		if(root == null || (root.left == null && root.right == null))
			return true;
		if(root.left == null && root.right != null){
			 if(root.val < root.right.val )
			    return isValidBST(root.right);
			 else
				return false;
		}
		if(root.left != null && root.right == null){
			if(root.val >= root.left.val )
				return isValidBST(root.left);
			else
				return false;
		}
		if(root.val < root.right.val && root.val >= root.left.val)
			return isValidBST(root.left) && isValidBST(root.right);
		else
			return false;
		
	}

}
