package ArrayT;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
	public static void main(String args[]){	
		int[] data = {-1, 0, 1, 2, -1, -4};
		System.out.println(fourSum(data,0));
	}
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(nums == null || nums.length < 3)
        	return list;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
        	if(i > 0 && nums[i] == nums[i - 1])
        		continue;
        	for(int j = i + 1; j < nums.length - 2; j++){
        		if(j > i + 1 && nums[j] == nums[j - 1])
            		continue;
        		int low, high;
            	low = j + 1;
            	high = nums.length - 1;
            	while(low < high){
            		if(nums[low] + nums[high] + nums[i] + nums[j] == target){
            			List<Integer> result = new LinkedList<Integer>();
            			result.add(nums[i]);
            			result.add(nums[j]);
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
            			if(nums[low] + nums[high] < target - (nums[i] + nums[j])){
            				low++;
            			}else{
            				high--;
            			}
            		}
            	}
        	}
        	
        	
        }
        return list;
    }
	

}
