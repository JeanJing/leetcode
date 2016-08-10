package BitManipulation;
import java.util.*;
//这道题没想出来也没关系，大神也么想出来，太精妙了
//Kao好难呀，老娘不想做了
public class SingleNumber3 {
	public static void main(String args[]){
		int nums[] = {1,2,3,1,2,3,4,5};
		//System.out.println(Integer.SIZE);//Integer.SIZE表明int类型的bit数
		System.out.println(singleNumber(nums));
		
	}
	 public static int[] singleNumber(int[] nums) {
	        int result[] = new int[2];
	        if (nums == null || nums.length == 0) return result;
	        int x1xorx2 = 0;
	        for(int n : nums)
	        	x1xorx2 ^= n;
	        int last_1_of_x1xorx2 = x1xorx2- (x1xorx2 & (x1xorx2 - 1));//位运算优先级很低很低
	        int x1 = 0,x2 = 0;
	        for(int i = 0; i < nums.length;i++){
	        	if((nums[i]&last_1_of_x1xorx2) == 0)
	        		x1 ^= nums[i];
	        	else
	        		x2 ^= nums[i];
	        }
	        result[0] = x1;
	        result[1] = x2;
	        return result;
	 }

	        
}
