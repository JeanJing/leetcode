package Tree;
import java.util.*;
public class BinaryTreePostorderTraversal {
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
		System.out.println(postorderTraversal(root));
	}
	public static List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
        	return new LinkedList<Integer>();
        List<Integer> result = new LinkedList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode temp = null;
        while(!stack.isEmpty()){
        	TreeNode top = stack.peek();
        	while((top.left != null || top.right != null) &&isPush(top,temp) ){
        		
        		if(top.right != null)
        		  stack.push(top.right);
        		if(top.left != null)
          		  stack.push(top.left);
        		  
        	}
        	temp = stack.pop();
        	result.add(temp.val);
        }
        return result;
    }
	//true表示可以push孩子结点
	public static boolean isPush(TreeNode parrent, TreeNode children){
		if(parrent.right != null){
			if(children != parrent.right)
				return true;
			else
				return false;
		}else{
			if(children != parrent.left)
				return true;
			else 
				return false;
		}
	}

}
