package Tree;
import java.util.*;
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
    	
    	LinkedList<String> list = new LinkedList<String>();
    	if(root == null)
    		return list;
    	if(root.left == null && root.right == null){
    		list.add(String.valueOf(root.val));
    		return list;
    	}
    	List<String> lList, rList;
    	lList = rList = null;
    	if(root.left != null){
    		lList = binaryTreePaths(root.left);
    		for(String str:lList){
    			list.add(String.valueOf(root.val)+"->" + str);
    		}
    	}
    	if(root.right != null){
        	rList = binaryTreePaths(root.right);
        	for(String str:rList){
    			list.add(String.valueOf(root.val)+"->" + str);
    		}
    	}
    	return list;
        
    }
    ArrayList
    public static int binaryTreePath_2(TreeNode root) {
    	LinkedList<String>
		int max = 0;
		if(root == null)
			return 0;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode cur,pre;
		stack.push(root);
		pre = null;
		while(!stack.isEmpty()){
			cur = stack.peek();
			if(pre == null || pre.left == cur || pre.right == cur){
				if(cur.left != null)
					stack.push(cur.left);//这个很关键，因为stack中的所有元素对应一条路径，所以不可以同时将当前结点的左右结点都放进去
				else
					if(cur.right != null)
					   stack.push(cur.right);//只有在左结点为空的情况下，才可以将右结点放入
			}else{
				if(cur.left == pre){
					if(cur.right != null)//必须要保证放到stack里的必须是真正的结点，不可以放空节点
					stack.push(cur.right);
				}
				else
					stack.pop();
			}
			pre = cur;
			max = max > stack.size() ? max : stack.size();
		}
		return max;
		
		
	}

}
