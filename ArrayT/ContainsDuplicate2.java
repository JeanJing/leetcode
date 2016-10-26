package ArrayT;

import java.util.*;

public class ContainsDuplicate2 {
	public static void main(String args[]) {
		int[] data = {1,0,1,1};
		System.out.println(containsDuplicate_k_window(data,1));
	}
	public static boolean containsDuplicate(int[] nums, int k) {
    	if(nums == null)
    		return false;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < nums.length; i++){
    		if(map.containsKey(nums[i])){
    			if(i - map.get(nums[i]) <= k)
    				return true;
    		}
    		map.put(nums[i], i);		
    	}
    	return false;
    	
    }
    public static boolean containsDuplicate_k_window(int[] nums, int k) {
    	if(nums == null)
    		return false;
    	HashSet<Integer> set = new HashSet<Integer>();
        
    	for(int i = 0; i < nums.length; i++){
    		if(!set.add(nums[i]))
    			return true;
    		if(set.size() > k)
    			set.remove(nums[i - k]);
    	}
    	return false;
    	
    }
    
}
