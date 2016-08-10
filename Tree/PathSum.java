package Tree;
import java.util.*;
public class PathSum {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		
		/*root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(5);*/
		
		TreeNode left = new TreeNode(-2);
		root.left = left;
		TreeNode right = new TreeNode(-3);
		root.right = right;
		left.left = new TreeNode(1);
		left.right = new TreeNode(3);
		right.left = new TreeNode(-2);
		left.left.left = new TreeNode(-1);
		left.left.right = new TreeNode(-4);

		System.out.println(hasPathSum_recurse(null, -4));
	}
	
	public static boolean hasPathSum_recurse(TreeNode root, int sum){
		if(root == null)
			return false;
		return (hasPathSum_helper1(root.left, sum -root.val) || hasPathSum_helper1(root.right, sum -root.val)); 
	}
	public static boolean hasPathSum_helper1(TreeNode root, int sum) {
		if(root == null){
			if(sum ==0)
				return true;
			else
				return false;
		} 
			
		if(root.left == null && root.right == null)
			if(root.val == sum)
				return true;
			else 
				return false;
	
		if(hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val))
			return true;
		else
			return false;
		
	}
	public static boolean hasPathSum_helper(TreeNode root, int sum) {
		if(root == null){
			if(sum ==0)
				return true;
			else
				return false;
		} 
			
		if(root.left == null && root.right == null)
			if(root.val == sum)
				return true;
			else 
				return false;
	
		if(hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val))
			return true;
		else
			return false;
		
	}
	public static boolean hasPathSum_rec(TreeNode root, int sum) {
		if(root == null){
			return false;
		} 
			
		if(root.left == null && root.right == null)
			if(root.val == sum)
				return true;
			else 
				return false;
	
		if(hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val))
			return true;
		else
			return false;
		
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		if(root.left ==null && root.right == null)
			return root.val == sum;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		
		stack.push(root);
		int sumOfPath = 0;
		TreeNode curr;
		
		while(!stack.isEmpty()){
			curr = stack.pop();
			
			
			if(curr.left == null && curr.right == null){
				while(!list.isEmpty() &&(list.peek().left != curr && list.peek().right != curr)){
					TreeNode temp = list.pop();
					sumOfPath -= temp.val;
				}
				
				if((sumOfPath + curr.val) == sum)
					return true;
				
			
			}else{
				while(!list.isEmpty() &&(list.peek().left != curr && list.peek().right != curr)){
					TreeNode temp = list.pop();
					sumOfPath -= temp.val;
				}
				list.push(curr);
				sumOfPath += curr.val;
			if(curr.right != null)
				stack.push(curr.right);
			if(curr.left != null)
				stack.push(curr.left);
			}
			
		}

		return false;
	}
}

