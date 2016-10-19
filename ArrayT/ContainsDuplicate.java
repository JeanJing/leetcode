package ArrayT;
import java.util.*;
public class ContainsDuplicate {
	public static void main(String args[]) {
		int[] data = {1,2,1,3,1};
		
		//for (int i = 0; i < data.length; i++) {
		//	System.out.print(data[i] + " ");
		//}
		System.out.println(containsDuplicate_2(data));
	}
    public static boolean containsDuplicate(int[] nums) {
    	if(nums == null)
    		return false;
    	HashSet<Integer> set = new HashSet<Integer>();
        
    	for(int i = 0; i < nums.length; i++){
    		if(set.contains(nums[i]))
    			return true;
    		else
    			set.add(nums[i]);
    	}
    	return false;
    }
    public static boolean containsDuplicate_2(int[] nums) {
    	if(nums == null)
    		return false;
    	for(int i = 0; i < nums.length; i++){
    		for(int j = i + 1; j < nums.length; j++){
    			if(nums[i] == nums[j])
    				return true;
    		}
    	}
    	return false;
    }
}
