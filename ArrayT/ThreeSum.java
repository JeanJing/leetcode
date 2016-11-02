package ArrayT;

import java.util.*;

public class ThreeSum {
	public static void main(String args[]) {
		int[] data = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(data));
	}
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(nums == null || nums.length < 3)
        	return list;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
        	if(i > 0 && nums[i] == nums[i - 1])
        		break;
        	int low, high;
        	low = i + 1;
        	high = nums.length - 1;
        	while(low < high){
        		if(nums[low] + nums[high] == -nums[i]){
        			List<Integer> result = new LinkedList<Integer>();
        			result.add(nums[i]);
        			result.add(nums[low]);
        			result.add(nums[high]);
        			list.add(result);
        			low++;
        			while(low < nums.length && nums[low] == nums[low - 1])
        				low++;
        			high--;
        			while(high >= 0 && nums[high] == nums[high + 1])
        				high--;
        		}else{
        			if(nums[low] + nums[high] < -nums[i]){
        				low++;
        			}else{
        				high--;
        			}
        		}
        	}
        }
        return list;
    }

}
