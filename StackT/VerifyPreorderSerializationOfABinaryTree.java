package StackT;

import java.util.LinkedList;
import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree {
	public static void main(String args[]){
		System.out.println(isValidSerialization("9###"));
	}

	public static boolean isValidSerialization(String preorder) {
		if (preorder == null || preorder.length() == 0)
			return true;

		String[] nodes = preorder.split(",");
		int n = nodes.length;
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < n; i++) {
			if (!nodes[i].equals("#"))
				stack.push(nodes[i]);
			else {
				if (nodes[i].equals("#"))
					if (stack.isEmpty())
						stack.push("#");// 这块我开始认为false
					else {
						if (!stack.peek().equals("#"))
							stack.push("#");
						else {
							while (!stack.isEmpty() && stack.peek().equals("#")) {
								stack.pop();
								if (stack.isEmpty())
									return false;
								stack.pop();
							}
							stack.push("#");
						}
					}
			}
		}
		return (stack.size() == 1 && stack.peek().equals("#")) ? true : false;
	}

}
