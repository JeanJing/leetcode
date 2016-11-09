package ArrayT;

import java.util.*;

public class CombinationSum {
	public static void main(String args[]){
		int []nums = {2, 3, 6, 7};
		combinationSum(nums, 7);
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
	}
	
	static int currSum = 0;
	static List<Integer> list = null;
	static List<List<Integer>> result = null;

	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		currSum = 0;
		list = new ArrayList<Integer>();
		result = new ArrayList<List<Integer>>();
		combinationSum_helper(candidates, 0, target);
		return result;
	}

	public static void combinationSum_helper(int[] candidates,int pos, int target) {
        for(int i = pos; i < candidates.length; i++){
        	//如果currSum等于target表明找到一个解
        	if(currSum + candidates[i] == target){
        		list.add(candidates[i]);
        		List<Integer> temp = new ArrayList<Integer>(list);
        		result.add(temp);
        		list.remove(list.size() - 1);
        		return;
        	}else{
        		//如果当前解大于目标值，则这条深度搜索的路径是不正确的,回到上一步时，要把不对的解去掉
        		if(currSum + candidates[i] > target){
        			continue;
        		}else{
        			currSum += candidates[i];
        			list.add(candidates[i]);
        			combinationSum_helper(candidates,i,target);
        			currSum -= candidates[i];
        			list.remove(list.size() - 1);
        			
        		}
        	}
        }
    }
	 public List<List<Integer>> combinationSum_2(int[] candidates, int target) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        List<Integer> list = new ArrayList<Integer>();
	        if (candidates == null) return result;

	        Arrays.sort(candidates);
	        helper(candidates, 0, target, list, result);

	        return result;
	    }

	    private void helper(int[] candidates, int pos, int gap,
	                        List<Integer> list, List<List<Integer>> result) {

	        if (gap == 0) {
	            // add new object for result
	            result.add(new ArrayList<Integer>(list));
	            return;
	        }

	        for (int i = pos; i < candidates.length; i++) {
	            // cut invalid candidate
	            if (gap < candidates[i]) {
	                return;
	            }
	            list.add(candidates[i]);
	            helper(candidates, i, gap - candidates[i], list, result);
	            list.remove(list.size() - 1);
	        }
	    }
}
