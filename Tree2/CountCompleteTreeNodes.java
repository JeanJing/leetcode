package Tree2;

public class CountCompleteTreeNodes {
	 public int countNodes(TreeNode root) {
			if (root==null) return 0;
			if (root.left==null) return 1;
			int height = 0;
		    int nodesSum = 0;
			TreeNode curr = root;
		    while(curr.left!=null) {
		    	nodesSum += (1<<height);
		    	height++;
		    	curr = curr.left;
		    }
		    return nodesSum + countLastLevel(root, height);
		}

		private int countLastLevel(TreeNode root, int height) {
			if(height==1) 
				if (root.right!=null) return 2;
				else if (root.left!=null) return 1;
				else return 0;
			TreeNode midNode = root.left;//midNode指的的左子树最右边的那个结点
			int currHeight = 1;
			while(currHeight<height) {
				currHeight++;
				midNode = midNode.right;
			}
			if (midNode==null) return countLastLevel(root.left, height-1);
			else return (1<<(height-1)) + countLastLevel(root.right, height-1);
		}
		
		
		
		public int countNodes_2(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        int h = getHeight(root);
	        if (h == 1) {
	            return 1;
	        }
	        int hRight = getHeight(root.right);
	        if (hRight == h - 1) {
	            return (1 << h - 1) + countNodes(root.right);
	        } else {
	            return (1 << h - 2) + countNodes(root.left);
	        }
	    }

	    private int getHeight(TreeNode root) {
	        int h = 0;
	        while (root != null) {
	            h++;
	            root = root.left;
	        }
	        return h;
	    }
	
}

