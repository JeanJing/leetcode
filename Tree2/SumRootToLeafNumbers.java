package Tree2;

import java.util.*;

public class SumRootToLeafNumbers {
	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);
        System.out.println(sumNumbers_queue(root));
    }
   public static int sumNumbers(TreeNode root) {
	   if(root == null)
		   return 0;
	   LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	   stack.push(root);
	   LinkedList<TreeNode> route = new LinkedList<TreeNode>();
	
	   TreeNode curr;
	   
	   int sum = 0;
	   int currInt = 0;
	   while(!stack.isEmpty()){
		   curr = stack.pop();
		   if(curr.left == null && curr.right == null){
			   while(!route.isEmpty() && route.peek().left != curr && route.peek().right != curr){
				   TreeNode temp = route.pop();
				   currInt = (currInt - temp.val) / 10;
			   }
			   sum += (currInt * 10 + curr.val);
			   //sumList.add(currInt * 10 + curr.val);
		   }
		   while(!route.isEmpty() && route.peek().left != curr && route.peek().right != curr){
			   TreeNode temp = route.pop();
			   currInt = (currInt - temp.val) / 10;
		   } 
		   route.push(curr);
		   currInt = currInt * 10 + curr.val;
		   if(curr.right != null)
			   stack.push(curr.right);
		   if(curr.left != null)
			   stack.push(curr.left);
	   }

       return sum;
    }
   public static int sumNumbers_recurse(TreeNode root) {
	   if(root == null)
		   return 0;
	   return sumNumbers_recurse_helper(root, 0);
	   
   }
   public static int sumNumbers_recurse_helper(TreeNode root, int number) {
	   if(root == null)
		   return 0;
	   if(root.left == null && root.right == null)
		   return number * 10 + root.val;
	   int leftVal, rightVal;
	   leftVal = 0;
	   rightVal = 0;
	  //if(root.left != null)
		   leftVal = sumNumbers_recurse_helper(root.left, number * 10 + root.val);
	   //if(root.right != null)
		   rightVal = sumNumbers_recurse_helper(root.right, number * 10 +root.val);
	   return  leftVal + rightVal;
	   
   }
   public static int sumNumbers_queue(TreeNode root){
	   if(root == null)
		   return 0;
	  
	   LinkedList<TreeNode> queue_node = new LinkedList<TreeNode>();
	   LinkedList<Integer> queue_sum = new LinkedList<Integer>();
	   int sum = 0;
	   
	   queue_node.offer(root);
	   queue_sum.offer(root.val);
	   
	   TreeNode curr;
	   int currSum;
	   while(!queue_node.isEmpty()){
		   curr = queue_node.poll();
		   currSum = queue_sum.poll();
		   
		   if(curr.left == null && curr.right == null){
			   sum += currSum;
		   }
		   if(curr.left != null){
			   queue_node.offer(curr.left);
			   queue_sum.offer(currSum * 10 + curr.left.val);
		   }
		   if(curr.right != null){
			   queue_node.offer(curr.right);
			   queue_sum.offer(currSum * 10 + curr.right.val);
		   }
		   
	   }
	   return sum;
	   
   }

}
