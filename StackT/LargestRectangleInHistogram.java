package StackT;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

public class LargestRectangleInHistogram {
	public static void main(String args[]) {
		int[] nums = new int[3];
		Arrays.fill(nums, 1);
        long start = System.currentTimeMillis();
		System.out.println(largestRectangleArea(nums));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static int largestRectangleArea_exhaustion(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		int n = heights.length;
		int maxArea = 0;
		for (int i = 0; i < n; i++) {
				int minHeight = Integer.MAX_VALUE;
				for (int j = i; j < n; j++) {
					if (heights[j] < minHeight)
						minHeight = heights[j];
					if (minHeight * (j - i + 1) > maxArea)
						maxArea = minHeight * (j - i + 1);
				}
		}
		return maxArea;
	}
    //5月4日下午3点23分，终于通过了
	public static int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		int n = heights.length;
		int maxArea = 0;
		int area = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int i = 0;// 用来标记高度数组是否已经全部处理
		while (!stack.isEmpty() || i < n) {
			// 总共分为三种情况
			// 第一种：栈为空，i还在范围内，push这个i，并且i++
			if (stack.isEmpty() && i < n) {
				stack.push(i++);
			} else {
				// 第二种，栈不为空，并且i < n
				if (!stack.isEmpty() && i < n) {
					while (!stack.isEmpty()
							&& heights[stack.peek()] > heights[i]) {// 找到当前栈顶元素比i对应值小的
						int height = stack.pop();
						if (!stack.isEmpty())
							area = heights[height] * (i - stack.peek() - 1);// 这个地方可能有问题
						else//这部分也写错了
							area = heights[height] * ( i );

						if (area > maxArea)
							maxArea = area;
					}
                    //最开始对相等的处理有问题
					//这句话可以删掉，因为之前已经处理过了
					//if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
						stack.push(i++);

				}else{
				if (!stack.isEmpty() && i >= n) {
					int rightBounder = stack.pop();
					//15:08经过检验，这部分也因为没有分情况搞错了
					if(!stack.isEmpty())
						area = heights[rightBounder] *(rightBounder - stack.peek());
					else
						area = heights[rightBounder];
					if (area > maxArea)
						maxArea = area;
					//后来是栈空的时候处理没有想好，就把东西弄错了
					while (!stack.isEmpty()) {
						int height = stack.pop();
						if(!stack.isEmpty())//这里的peek有问题又改了一版
						area = heights[height]* (rightBounder - stack.peek());// 这个地方可能有问题
						else
							area = heights[height] * ( rightBounder + 1);//没有考虑特殊情况
						if (area > maxArea)
							maxArea = area;
					}
				}
			}
			}
		}

		return maxArea;

	}
	//思想和我的思想是一样的，但是代码要简化了很多
	public int largestRectangleArea_16row(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h;//= new int[height.length + 1];这一步就是完全是没有必要的
        h = Arrays.copyOf(height, height.length + 1);//这是要干什么，意义在哪里，将原先的数组长度加1，
        //并且这个新的元素赋值为0，这样就可以确保在数组遍历结束的同时将stack中大于0的元素全部计算完毕
        //真tmd牛
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
	public static int largestRectangleArea_for(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		int n = heights.length;
		int maxArea = 0;
		int area = 0;
		int leftBounder, rightBounder;
		for(int i = 0; i < n; i++){
			
			while(i > 0 && i < n && heights[i] == heights[i - 1])
				i++;
			if(i < n){
			int height = heights[i];
			leftBounder = rightBounder = i;
			//查找左边界
			
			for(; leftBounder >= 0; leftBounder--){
				if(heights[leftBounder] < height){
					break;
				}
			}

			for(; rightBounder < n; rightBounder++){
				if(heights[rightBounder] < height){
					
					break;
				}
			}
			
			area = rightBounder == leftBounder ? 1: height*(rightBounder - leftBounder -1);
			if(area > maxArea)
				maxArea = area;
			}
		}
		return maxArea;
	}

	public static int largestRectangleArea_5_3_晚上写的有问题(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		int n = heights.length;
		int maxArea = 0;
		int area = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		// 应该是与left有关系，今天头不是很舒服，做不出来了
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
				stack.push(i);
			else {
				while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
					int left = stack.peek();
					int height = heights[stack.pop()];// 弹出的高度

					while (!stack.isEmpty() && heights[stack.peek()] == height) {
						left = stack.pop();
					}

					if (stack.isEmpty())
						left--;
					area = height * (i - left);
					if (area > maxArea)
						maxArea = area;
				}

			}
		}
		while (!stack.isEmpty()) {
			int height = heights[stack.peek()];// 弹出的高度
			int length = 0;
			while (!stack.isEmpty() && heights[stack.peek()] == height) {
				stack.pop();
				length++;
			}

			area = height * length;
			if (area > maxArea)
				maxArea = area;
		}

		return maxArea;
	}

}
