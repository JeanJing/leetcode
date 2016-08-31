package Tree2;

import java.util.*;

public class BinaryTreePaths {
	
	public static void main(String args[]) {
		List<Integer> result;
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left = left;
		TreeNode right = new TreeNode(3);
		root.right = right;
		left.left = new TreeNode(6);
		left.right = new TreeNode(4);
		right.left = new TreeNode(5);
		right.right = new TreeNode(7);
		System.out.println(binaryTreePaths(root));
		

	}
	
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new LinkedList<String>();
		if(root == null)
			return list;
		if(root.left == null && root.right == null){
			String str = String.valueOf(root.val);
			list.add(str);
			return list;
		}
		List<String> rList, lList;
		
		lList = binaryTreePaths(root.left);
		rList = binaryTreePaths(root.right);
		
		for(int i = 0; i < lList.size();i++){
			list.add(String.valueOf(root.val) + "->" +lList.get(i));
		}
		for(int i = 0; i < rList.size();i++){
			list.add(String.valueOf(root.val) + "->" +rList.get(i));
		}
		return list;
        
    }

}
