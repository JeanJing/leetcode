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
    //5��4������3��23�֣�����ͨ����
	public static int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		int n = heights.length;
		int maxArea = 0;
		int area = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int i = 0;// ������Ǹ߶������Ƿ��Ѿ�ȫ������
		while (!stack.isEmpty() || i < n) {
			// �ܹ���Ϊ�������
			// ��һ�֣�ջΪ�գ�i���ڷ�Χ�ڣ�push���i������i++
			if (stack.isEmpty() && i < n) {
				stack.push(i++);
			} else {
				// �ڶ��֣�ջ��Ϊ�գ�����i < n
				if (!stack.isEmpty() && i < n) {
					while (!stack.isEmpty()
							&& heights[stack.peek()] > heights[i]) {// �ҵ���ǰջ��Ԫ�ر�i��ӦֵС��
						int height = stack.pop();
						if (!stack.isEmpty())
							area = heights[height] * (i - stack.peek() - 1);// ����ط�����������
						else//�ⲿ��Ҳд����
							area = heights[height] * ( i );

						if (area > maxArea)
							maxArea = area;
					}
                    //�ʼ����ȵĴ���������
					//��仰����ɾ������Ϊ֮ǰ�Ѿ��������
					//if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
						stack.push(i++);

				}else{
				if (!stack.isEmpty() && i >= n) {
					int rightBounder = stack.pop();
					//15:08�������飬�ⲿ��Ҳ��Ϊû�з���������
					if(!stack.isEmpty())
						area = heights[rightBounder] *(rightBounder - stack.peek());
					else
						area = heights[rightBounder];
					if (area > maxArea)
						maxArea = area;
					//������ջ�յ�ʱ����û����ã��ͰѶ���Ū����
					while (!stack.isEmpty()) {
						int height = stack.pop();
						if(!stack.isEmpty())//�����peek�������ָ���һ��
						area = heights[height]* (rightBounder - stack.peek());// ����ط�����������
						else
							area = heights[height] * ( rightBounder + 1);//û�п����������
						if (area > maxArea)
							maxArea = area;
					}
				}
			}
			}
		}

		return maxArea;

	}
	//˼����ҵ�˼����һ���ģ����Ǵ���Ҫ���˺ܶ�
	public int largestRectangleArea_16row(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h;//= new int[height.length + 1];��һ��������ȫ��û�б�Ҫ��
        h = Arrays.copyOf(height, height.length + 1);//����Ҫ��ʲô�������������ԭ�ȵ����鳤�ȼ�1��
        //��������µ�Ԫ�ظ�ֵΪ0�������Ϳ���ȷ�����������������ͬʱ��stack�д���0��Ԫ��ȫ���������
        //��tmdţ
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
			//������߽�
			
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

	public static int largestRectangleArea_5_3_����д��������(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		int n = heights.length;
		int maxArea = 0;
		int area = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		// Ӧ������left�й�ϵ������ͷ���Ǻ����������������
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
				stack.push(i);
			else {
				while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
					int left = stack.peek();
					int height = heights[stack.pop()];// �����ĸ߶�

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
			int height = heights[stack.peek()];// �����ĸ߶�
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
