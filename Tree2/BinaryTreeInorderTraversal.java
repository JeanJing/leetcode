package Tree2;

import java.util.*;


public class BinaryTreeInorderTraversal {
	public static void main(String args[]) {
		List<Integer> result;
		TreeNode root = new TreeNode(1);
		//TreeNode left = null;//new TreeNode(2);
		//root.left = left;
		TreeNode right = new TreeNode(2);
		root.right = right;
		//left.left = new TreeNode(6);
		//left.right = new TreeNode(4);
		right.left = new TreeNode(3);
		//right.right = new TreeNode(7);
		System.out.println(inorderTraversal(root));
		

	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		if (root == null)
			return list;

		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);

		TreeNode curr, pre;
		pre = null;
		
		while(!stack.isEmpty()){
			curr = stack.peek();
			if(curr.left == null && curr.right == null){
				pre = stack.pop();
				list.add(pre.val);
			}else{
				if(curr.left != pre && curr.right != pre){
					if(curr.left != null)
						stack.push(curr.left);
				}else{
					if(curr.left == null || curr.left == pre ){
					    list.add(curr.val);
					    if(curr.right != null)
					    	stack.push(curr.right);
					}else{
						if(curr.right == null || curr.right == pre ){
							pre = stack.pop();
						}
					}
				}
			}
				
		}

		
		return list;
	}
	

}
