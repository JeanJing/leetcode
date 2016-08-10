package Tree;
import java.util.*;
public class BinaryTreeInorderTraversal {
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

}
