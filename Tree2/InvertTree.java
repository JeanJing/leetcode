package Tree2;

import java.util.List;

public class InvertTree {
	public static void main(String args[]) {
		List<Integer> result;
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(4);
		root.left = left;
		TreeNode right = new TreeNode(8);
		root.right = right;
		left.left = new TreeNode(11);
		left.left.left = new TreeNode(7);
		left.left.right = new TreeNode(2);
		
		right.left = new TreeNode(13);
		right.right = new TreeNode(4);
		right.right.left = new TreeNode(5);
		
		System.out.println(invertTree(root));
		

	}
    public static TreeNode invertTree(TreeNode root) {
        if(root == null)
           return root;
         TreeNode temp = root.left;
         root.left = root.right;
         root.right = temp;
         invertTree(root.left);
         invertTree(root.right);
       return root;
        
    }
}