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
					stack.push(cur.left);//����ܹؼ�����Ϊstack�е�����Ԫ�ض�Ӧһ��·�������Բ�����ͬʱ����ǰ�������ҽ�㶼�Ž�ȥ
				else
					if(cur.right != null)
					   stack.push(cur.right);//ֻ��������Ϊ�յ�����£��ſ��Խ��ҽ�����
			}else{
				if(cur.left == pre){
					if(cur.right != null)//����Ҫ��֤�ŵ�stack��ı����������Ľ�㣬�����Էſսڵ�
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
