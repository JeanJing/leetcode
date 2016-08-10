package StackT;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
	LinkedList<NestedInteger> stack = new LinkedList<NestedInteger>();;

	public NestedIterator(List<NestedInteger> nestedList) {
		int n = nestedList.size();
		for (int i = n - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	public Integer next() {
		NestedInteger top = stack.pop();
		if (top.isInteger())
			return top.getInteger();
		else {
			while (!stack.peek().isInteger()) {
				List<NestedInteger> nestedList = top.getList();
				int n = nestedList.size();
				for (int i = n - 1; i >= 0; i--) {
					stack.push(nestedList.get(i));
				}
			}
		}

		return Integer.valueOf(32);
	}

	public boolean hasNext() {
		return stack.isEmpty();
	}
}

interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
