package ArrayT;

public class TwoSumII {
	public static void main(String args[]){
		int [] result = twoSum_useBinarySearch(new int[]{2, 7, 11, 15},9);
		for(int i  = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
	public static int[] twoSum_useTwoPointer(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		
		while(low < high){
			if(nums[low] + nums[high] == target){
				return new int[]{low + 1, high + 1};
			}else{
				if(nums[low] + nums[high] < target)
					low++;
				else
					high--;
			}
				
		}
		return null;
	}
	public static int[] twoSum_useBinarySearch(int[] nums, int target) {
		 if(nums == null || nums.length < 2)
			 return null;
		 int []result = {-1,-1};
		 for(int i = 0; i < nums.length - 1; i++){
			 int index = binarySearch(nums,i+1,nums.length - 1,target - nums[i]);
			 if(index != -1){
				 result[0] = i + 1;
				 result[1] = index + 1;
				 return result;
			 }
		 }
		 return result;
	 }
	 public static int binarySearch(int []nums,int low, int high, int target){
		 int mid;
		 while(low <= high){
			 mid = low + (high - low) / 2;
			 if(nums[mid] == target)
				 return mid;
			 else{
				 if(nums[mid] < target){
					 low = mid + 1;
				 }else{
					 high = mid - 1;
				 }
			 }
		 }
		 return -1;
	 }

}
