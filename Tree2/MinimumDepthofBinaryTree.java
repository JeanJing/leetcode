package Tree2;
import java.util.*;
public class MinimumDepthofBinaryTree {
	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;
        //left.left = new TreeNode(3);
        //left.right = new TreeNode(4);
        //right.left = new TreeNode(4);
        //right.right = new TreeNode(3);
        System.out.println(minDepth_queue(root));
        //LinkedList a;
    }
	
	 public static  int minDepth(TreeNode root) {
	        if(root == null)
	        	return 0;
	        return minDepthHelper(root);
	        
	 }
	 public static int minDepthHelper(TreeNode root){
		 if(root == null)
			 return Integer.MAX_VALUE;
		 if(root.left == null && root.right == null)
			 return 1;
		 return Math.min(minDepthHelper(root.left), minDepthHelper(root.right)) + 1;
	 }
	 public static int minDepth_queue(TreeNode root){
		 if(root == null)
			 return 0;
		 LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.add(root);
		 TreeNode curr;
		 int size;
		 int depth = 0;
		 while(!queue.isEmpty()){
			 depth ++;
			 size = queue.size();
			 for(int i = 0; i < size; i++){
				 curr = queue.poll();
				 if(curr.left == null && curr.right == null)
					 return depth;
				 if(curr.right != null)
					 queue.offer(curr.right);
				 if(curr.left != null)
					 queue.offer(curr.left);
				 
			 }
		 }
		 return depth;
	 }
}
