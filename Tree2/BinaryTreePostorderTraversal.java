package Tree2;
import java.util.*;

public class BinaryTreePostorderTraversal {
	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(2);
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        right.left = new TreeNode(4);
        right.right = new TreeNode(3);
        System.out.println(postorderTraversal(root));
    }
	
	
	public static List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> resultList = new LinkedList<Integer>();
		if(root == null)
			return resultList;
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode curr, pre;
		curr = root;
		pre = null;
		
		stack.push(root);
		while(!stack.isEmpty()){
			curr = stack.peek();
			if(curr.left == null && curr.right == null){
				pre = stack.pop();
				resultList.add(pre.val);
			}else{
				if(pre == null){
					if(curr.right != null)
						stack.push(curr.right);
					if(curr.left != null)
						stack.push(curr.left);
					continue;
				}
				if(curr.left == pre || curr.right == pre){
					pre = stack.pop();
					resultList.add(pre.val);
				}else{
					if(curr.right != null)
						stack.push(curr.right);
					if(curr.left != null)
						stack.push(curr.left);
				}
			}
		}
		return resultList;
	}

}
