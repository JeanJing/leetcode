package Tree2;
import java.util.*;
public class BalancedTree {
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
		System.out.println(isBalanced(root));
		

	}
	
	
    public static boolean isBalanced(TreeNode root) {
    	if(root == null)
    		return true;
    	if(isBalanced(root.left) && isBalanced(root.right)){
    		if(Math.abs(depthOfBinaryTree_queue(root.left) - depthOfBinaryTree_queue(root.right)) <= 1)
    				return true;
    		else
    			return false;
    	}else{
    		return false;
    	}
        
    }
    public static int depthOfBinaryTree_queue(TreeNode root){
    	if(root == null)
    		return 0;
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	
    	TreeNode curr;
    	int depth = 0;
    	int size = 0;
    	while(!queue.isEmpty()){
    		depth ++;
    		size = queue.size();
    		for(int i = 0; i < size; i++){
    			curr = queue.poll();
    			if(curr.left != null)
    				queue.offer(curr.left);
    			if(curr.right != null)
    				queue.offer(curr.right);
    		}
    	}
    	return depth;
    } 
    public static int depthOfBinaryTree_recurse(TreeNode root){//其实就是最大
    	
   		 if(root == null)
   			 return 0;
   		 if(root.left == null && root.right == null)
   			 return 1;
   		 return Math.max(depthOfBinaryTree_recurse(root.left), depthOfBinaryTree_recurse(root.right)) + 1;
   	        
    } 
}

