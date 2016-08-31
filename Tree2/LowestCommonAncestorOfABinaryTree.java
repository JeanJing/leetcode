package Tree2;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {
	public static void main(String args[]) {

		TreeNode root = new TreeNode(-1);
        TreeNode left = new TreeNode(0);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;
        left.left = new TreeNode(-2);
        left.right = new TreeNode(4);
        left.left.left = new TreeNode(8);
        
        System.out.println(lowestCommonAncestor(root,left.left.left,left));
        System.out.println("jing");
    }
	//我设计的这个方法还是很费时间的
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	LinkedList<TreeNode> p_list = route(root,p);
    	p_list.push(p);
    	LinkedList<TreeNode> q_list = route(root,q);
    	q_list.push(q);
    	TreeNode curr_p, curr_q;
    	while(!p_list.isEmpty()){
    		curr_p = p_list.pop();
    		for(int i = 0; i < q_list.size(); i++){
    			if(curr_p == q_list.get(i))
    				return curr_p;
    		}
    	}
    	return root;
    }
    
    public static LinkedList<TreeNode> route(TreeNode root, TreeNode p){//从
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	TreeNode curr;
    	stack.push(root);
    	LinkedList<TreeNode> list = new LinkedList<TreeNode>(); 
    	while(!stack.isEmpty()){
    		curr = stack.pop();
    		if(curr == p){
    			while(!list.isEmpty() &&  list.peek().left != curr && list.peek().right != curr)
    				list.pop();
    			return list;
    		}
    			
    		else{
    			while(!list.isEmpty() &&  list.peek().left != curr && list.peek().right != curr)
    				list.pop();
    			list.push(curr);
    		}
    		
    		if(curr.right != null)
    			stack.push(curr.right);
    		if(curr.left != null)
    			stack.push(curr.left);
    		

    	}
    	return list;
    }
}
