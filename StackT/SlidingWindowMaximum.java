package StackT;
import java.util.*;
public class SlidingWindowMaximum {
	public  static void main(String args[]){
		int nums[] = {-7,-8,7,5,7,1,6,0};
		int []result;
		result = maxSlidingWindow(nums, 4);
		System.out.println("jingzhenyan");
		
    }
	
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0 || nums.length < k)
			return new int[0];
		int n = nums.length;
		int []result = new int[n - k + 1];
		int j = 0;
		Deque<Integer> que = new LinkedList<Integer>();
		for(int i = 0; i < n; i++){
			while(!que.isEmpty() && que.peekLast() < nums[i])
				que.pollLast();
			que.addLast(nums[i]);
			if(i > k - 1 && !que.isEmpty() && que.peekFirst() == nums[i - k])
				que.pollFirst();
			if(i >= k- 1)
				result[j++] = que.peekFirst();
				
		}
		
		
		
		
		return result;
        
    }
	
	
	
	
	
	
}
