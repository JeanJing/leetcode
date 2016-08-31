package Tree2;
import java.util.*;

public class PathSumII {
	public static void main(String args[]) {
		List<Integer> result;
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(4);
		root.left = left;
		TreeNode right = new TreeNode(8);
		root.right = right;
		left.left = new TreeNode(11);
		left.left.left = new TreeNode(7);
		left.left.right = new TreeNode(2);
		
		right.left = new TreeNode(13);
		right.right = new TreeNode(4);
		right.right.left = new TreeNode(5);
		
		System.out.println(pathSum_recurse(root,22));
		

	}

     public static List<List<Integer>> pathSum(TreeNode root, int sum) {
    	 List<List<Integer>> list = new LinkedList<List<Integer>>();
    	 if(root == null)
    		 return list;
    	 
    	 LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	 stack.push(root);
    	 
    	 LinkedList<TreeNode> route = new LinkedList<TreeNode>();
    	 TreeNode curr,temp;
    	 LinkedList<Integer> tempList;
    	 int sumOfPath = 0;
    	 while(!stack.isEmpty()){
    		 curr = stack.pop();
    		 if(curr.left == null && curr.right == null){
    			 while(!route.isEmpty() && (route.peek().left != curr && route.peek().right != curr)){
    				 temp = route.pop();
    				 sumOfPath -= temp.val;
    			 }
    			 if(sumOfPath + curr.val == sum ){
    				 tempList = new LinkedList<Integer>();
    				 for(TreeNode node : route){
    					 tempList.push(node.val);
    				 }
    				 tempList.add(curr.val);
    				 list.add(tempList);
    			 } 
    		 }else{
    			 while(!route.isEmpty() && (route.peek().left != curr && route.peek().right != curr)){
    				 temp = route.pop();
    				 sumOfPath -= temp.val;
    			 }
    			 route.push(curr);
    			 sumOfPath += curr.val;
    		 }
    		 if(curr.right != null)
    			 stack.push(curr.right);
    		 if(curr.left != null)
    			 stack.push(curr.left);
    	 }
    	 
    	 return list;
    }
     public static List<List<Integer>> pathSum_recurse_error(TreeNode root, int sum) {
    	 List<List<Integer>> list = new LinkedList<List<Integer>>();
    	 if(root == null)
    		 return list;
    	 pathSum_recurse_helper(root,sum,list);
    	 return list;
     }
     public static void  pathSum_recurse_helper(TreeNode root, int sum,
    		 List<List<Integer>> list) {
    	if(root == null)
    		return;
    	
    	if(root.left == null && root.right == null){
    		
    		if(root.val == sum){
    			LinkedList<Integer> templist = new LinkedList<Integer>();
    			templist.push(sum);
    			list.add(templist);
    			return;
    		}
    		return;
    	}
    	pathSum_recurse_helper(root.left, sum - root.val, list);//暂时想不出来
    	pathSum_recurse_helper(root.right, sum - root.val, list);
    	for(List<Integer> templist_2 : list){
    		templist_2.add(0,root.val);
    		
    	}
     }
     public static List<List<Integer>>   pathSum_recurse(TreeNode root, int sum) {
    	 List<List<Integer>> list = new LinkedList<List<Integer>>();
    	 if(root == null)
    		return list;
    	
    	if(root.left == null && root.right == null){
    		if(root.val == sum){
    			ArrayList<Integer> templist = new ArrayList<Integer>();
    			templist.add(sum);
    			list.add(templist);
    		}
    		return list;
    	}
    	List<List<Integer>> rList, lList;
    	
    	rList = pathSum_recurse(root.left, sum - root.val);//暂时想不出来
    	lList = pathSum_recurse(root.right, sum - root.val);
    	for(int i = 0; i < lList.size(); i++){
    		lList.get(i).add(0,root.val);
    	}
        for(int i = 0; i < rList.size(); i++){
        	rList.get(i).add(0,root.val);
    	}
        list.addAll(rList);
        list.addAll(lList);
        return list;
     }
	
	
}
