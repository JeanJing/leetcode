package Tree2;
import java.util.*;
public class MaximumDepthofBinaryTree {
	
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
        System.out.println(maxDepth_iter(null));
    }
	
	 public static int maxDepth(TreeNode root) {
		 if(root == null)
			 return 0;
		 int depth =0;
		 
		 LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.offer(root);
		 TreeNode curr;
		 int size = 0;
		 
		 while(!queue.isEmpty()){
			 size = queue.size();
			 for(int i =0; i < size; i++){
				 curr = queue.poll();
				 if(curr.left != null)
					 queue.offer(curr.left);
				 if(curr.right != null)
					 queue.offer(curr.right);
			 }
			 depth++;
			 
		 }
		 return depth;
	        
	  }
	 public static int maxDepth_recurse(TreeNode root) {
		 if(root == null)
			 return 0;
		 if(root.left == null && root.right == null)
			 return 1;
		 return Math.max(maxDepth_recurse(root.left), maxDepth_recurse(root.right)) + 1;
	        
	  }
	 public static int maxDepth_iter(TreeNode root) {
		 if(root == null)
			 return 0;
		 LinkedList<TreeNode> route = new LinkedList<TreeNode>();
		 LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		 
		 TreeNode curr;
		 int maxdepth = 0;
		 stack.push(root);
		 while(!stack.isEmpty()){
			 curr = stack.pop();
			 
			 if(curr.left == null && curr.right == null){
				 while(!route.isEmpty() && route.peek().left != curr && route.peek().right != curr){
						 route.pop();
				 }
				 maxdepth = (route.size() + 1) > maxdepth ? (route.size() + 1) : maxdepth;
			 }else{
				 while(!route.isEmpty() && route.peek().left != curr && route.peek().right != curr){
					 route.pop();
				 }
				 route.push(curr);
			 }
				 
			 if(curr.left != null)
				 stack.push(curr.left);
			 if(curr.right != null)
				 stack.push(curr.right);
			 
			 
		 }
	      return maxdepth;  
	  }

}
