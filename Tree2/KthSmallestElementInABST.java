package Tree2;

import java.util.*;

import java.util.*;
public class KthSmallestElementInABST {
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
		System.out.println(kthSmallestInorder(root,4));
		

	}
	
    public static int kthSmallest(TreeNode root, int k) {
    	List<Integer> list = inorderTraversal(root);
    	return list.get(k - 1);
        
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		if(root == null)
			return result;
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode curr = root;
		
		while(curr != null || !stack.isEmpty()){
			if(curr != null){
				stack.push(curr);
				curr = curr.left;
			}else{
				curr = stack.pop();
				result.add(curr.val);
			    curr = curr.right;
			}
		}
		return result;
	}
    public static int kthSmallestInorder(TreeNode root,int k) {
		
		
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode curr = root;
		
		int count = 0;
		while(curr != null || !stack.isEmpty()){
			if(curr != null){
				stack.push(curr);
				curr = curr.left;
			}else{
				curr = stack.pop();
				if(++count == k)
					return curr.val;
			    curr = curr.right;
			}
		}
		return count;
	}


}
