package BackTracking;
import java.util.*;
public class Permutations {
	public static void main(String []args){
		int []a = {1,2,3};
		List<List<Integer>> result = permute(a);
		
		for(int j = 0; j < result.size(); j++){
			System.out.println(result.get(j));
		}
	}
	public static List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0)
        	return null;
        return permute_helper(nums,nums.length);
    }
	public static List<List<Integer>> permute_helper(int[] nums, int n){
		List<List<Integer>> result = new  ArrayList<List<Integer>>();
		//n表示元素的个数
		if(n == 1){
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[0]);
			result.add(list);
			return result;
		}
		result = permute_helper(nums, n - 1);
		List<List<Integer>> tempResult = new  ArrayList<List<Integer>>();
		for(int i  = 0; i < result.size(); i++){
			List<Integer> list = result.get(i);
			for(int j = 0; j <= list.size(); j++){
				List<Integer> temp = new ArrayList<Integer>(list);
				temp.add(j,nums[n - 1]);
				tempResult.add(temp);
			}
		}
		return tempResult;
		
	}
}
