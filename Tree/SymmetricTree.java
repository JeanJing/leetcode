package Tree;

import java.util.LinkedList;
import java.util.Stack;

public class SymmetricTree {
    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(2);
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        right.left = new TreeNode(3);
        right.right = null;//new TreeNode(4);
        System.out.println(isSymmetric(root));
        // System.out.println(levelOrderTraverse(root));
    }
    public static boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> RList, tempList;
        Stack<Integer> compareList = new Stack<Integer>();
        RList = new LinkedList<TreeNode>();
        tempList = new LinkedList<TreeNode>();
        int length = RList.size();
        while (length % 2 != 0) {
            for (int i = 0; i < length / 2; i++) {
                TreeNode tempnode = RList.pollFirst();
                if(tempnode != null) {
                    compareList.push(tempnode.val);
                    tempList.add(tempnode.left);
                    tempList.add(tempnode.right);
                }
                else
                    compareList.push(null);


            }
            while(RList.size() > 0){
                TreeNode tempnode = RList.pollFirst();
                if(tempnode != null){
                    if(tempnode.val != compareList.pop())
                        return false;
                    tempList.add(tempnode.left);
                    tempList.add(tempnode.right);
                }else{
                    if(compareList.pop() != null)
                        return false;
                }

            }
            RList.addAll(tempList);
            tempList.clear();

        }
        return true;
    }
}

