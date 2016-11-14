package ArrayT;

public class MaximumSubarray {
	public static void main(String args[]){
		int []nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray3(nums));
	}
	//当和变成了《=0的数前面的这个子数组已经基本上没有用了，
	//因为任何一个大于0的元素都可以替代它，所以这个时候更新为当前元素
	public static int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0)
        	return 0;
		int currMax = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++){
			if(currMax <= 0)
				currMax = nums[i];
			else
				currMax+=nums[i];
			if(currMax > max)
				max = currMax;
		}
		return max;
	}
	public static int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        int [][]mut = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++){
        	mut[i][i] = nums[i]; 
        }
        for(int i  = 0; i < nums.length; i++){
        	for(int j = i + 1; j < nums.length; j++){
        		if(i > 0 && j >0){
        			int max = Math.max(mut[i - 1][j] + nums[i],mut[i][j - 1] + nums[j]);
        		    if(max > mut[i-1][j-1])
        			    mut[i][j] = max;
        		    else
        		    	mut[i][j] = mut[i-1][j-1];
        		}else{
        			if(i == 0){
        			if( mut[i][j - 1] + nums[j] > mut[i][j-1])
        			 mut[i][j] = mut[i][j - 1] + nums[j];
        			else
        				mut[i][j] = mut[i][j - 1];
        			}
        		}
        	}
        	
        }
        return mut[0][nums.length - 1];
        	
    }
	public static int maxSubArray3(int []nums){
		if(nums == null || nums.length == 0)
        	return 0;
		int minSum = 0;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i < nums.length; i++){
			minSum = Math.min(sum, minSum);
			sum += nums[i];
			max = Math.max(max, sum - minSum);
		}
		return max;
	}
}
