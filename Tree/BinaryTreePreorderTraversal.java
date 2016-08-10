package Tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
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
		System.out.println(preorderTraversal(root));
	}
    public static List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList<Integer>();
    	if(root == null)
        	return result;
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode curr;
        while(!stack.isEmpty()){
        	curr = stack.pop();
        	result.add(curr.val);
        	if(curr.right != null)
        		stack.push(curr.right);
        	if(curr.left != null)
        		stack.push(curr.left);
        }
        return result;
    }

}
