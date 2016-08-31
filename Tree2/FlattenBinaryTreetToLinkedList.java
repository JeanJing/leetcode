package Tree2;
import java.util.*;

public class FlattenBinaryTreetToLinkedList {
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
		flatten_extral_space(root);
		System.out.println("waiting is a torture");
	}

	public static void flatten_extral_space(TreeNode root) {
		if (root == null)
			return;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

		TreeNode curr, temp, root_flatten;
		stack.push(root);
		root_flatten = null;
		temp = null;
		while (!stack.isEmpty()) {
			curr = stack.pop();
			if (root_flatten == null) {
				root_flatten = temp = new TreeNode(curr.val);
			} else {
				temp.right = new TreeNode(curr.val);
				temp = temp.right;
			}
			if (curr.right != null)
				stack.push(curr.right);
			if (curr.left != null)
				stack.push(curr.left);

		}
		root.left = null;
		root.right = root_flatten.right;
	}

	public static void flatten_myself_preorder(TreeNode root) {
		if (root == null)
			return;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode curr, pre;
		pre = null;
		stack.push(root);
          
		while (!stack.isEmpty()) {
			curr = stack.pop();
			if (curr.right != null)
				stack.push(curr.right);
			if (curr.left != null)
				stack.push(curr.left);
		   if(pre != null){
			   pre.right = curr;
			   pre.left = null;
		   }
		   pre = curr;

		}
	}
	public void flatten(TreeNode root) {
        flatten(root, new TreeNode[1]);
    }

    private TreeNode flatten(TreeNode root, TreeNode[] pre) {
        if (root==null) {
            return root;
        }

        //root.right will be changed during recursion
        TreeNode rootRight = root.right;
        if (pre[0]!=null) {
            pre[0].left = null;
            pre[0].right = root;
        }
        pre[0] = root;

        flatten(root.left, pre);
        flatten(rootRight, pre);
        return root;
    }

}
