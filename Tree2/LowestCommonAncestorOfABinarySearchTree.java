package Tree2;

public class LowestCommonAncestorOfABinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        	return root;
       
        if(root.val >= p.val && root.val < q.val || root.val < p.val && root.val >= q.val)
        	return root;
        if(root.val  ==  p.val)
        	return p;
        if(root.val == q.val)
        	return q;
        if(p.val <root.val && q.val < root.val)
        	return lowestCommonAncestor(root.left, p, q);
        if(p.val> root.val && q.val > root.val)
        	return lowestCommonAncestor(root.left, p, q);
        return root;
       
        
    }
}
