package Tree2;
import java.util.*;


public class SymmetricTree {
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
        System.out.println(isSymmetirc_breadth_first(root));
    }
	public static boolean  isSymmetirc(TreeNode root){
		if(root == null)
			return false;
		return isSymmetircHelper(root.left, root.right);
		
	}
    public static boolean  isSymmetircHelper(TreeNode root1, TreeNode root2){
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.val == root2.val){
			if(isSymmetircHelper(root1.left, root2.right) && isSymmetircHelper(root1.right, root2.left))
				return true;
			else
				return false;
		}else{
			return false;
		}
	}
    public static void reverseTree(TreeNode root){
    	if(root == null)
    		return ;
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	TreeNode curr, temp;
    	stack.push(root);
    	while(!stack.isEmpty()){
    		curr = stack.pop();
    		temp = curr.left;
    		curr.left = curr.right;
    		curr.right = temp;
    		
    		if(curr.left != null)
    			stack.push(curr.left);
    		if(curr.right != null)
    			stack.push(curr.right);
    		
    	}
    }
    
    
    public static boolean  isSymmetirc_breadth_first(TreeNode root){
    	if(root == null)
			return false;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<TreeNode> templist;
		LinkedList<TreeNode> stack;
		TreeNode curr;
		TreeNode front, end;
		queue.offer(root);
		while(!queue.isEmpty()){
			templist = new LinkedList<TreeNode>(queue);
			int size = templist.size();
			for(int i = 0; i< size/2; i++){
				
				front = templist.pollFirst();
				end = templist.pollLast();
				if(front == null && end == null)
					continue;
				if(front == null || end == null )
					return false;
				if(front.val != end.val)
					return false;
			}
			for(int i = 0; i < size; i++){
				curr = queue.poll();
				if(curr != null){
					queue.offer(curr.left);
					queue.offer(curr.right);
				}
			}
		}
		
		
		
		return true;
		
	}

}
