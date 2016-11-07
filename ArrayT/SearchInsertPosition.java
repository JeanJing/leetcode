package ArrayT;

public class SearchInsertPosition {
	public static void main(String args[]){
		int result = searchInsert(new int[]{1},0);
	
			System.out.println(result);
	}
	public static int searchInsert(int[] nums, int target) {
		 int low, high, mid;
		 low = 0;
		 high = nums.length - 1;
		 while(low <= high){
			 if(target >= nums[low] && target <= nums[high]){
				 mid = low + (high - low) / 2;
				 if(target == nums[mid])
					 return mid;
				 else{
					 if(target < nums[mid])
						 high = mid - 1;
					 else
						 low = mid + 1;
				 }
			 }else{
				 if(target > nums[high])
				     return high + 1;
				 else{
						return low;
				 }
			 }
		 }
		 return -1;
	  }
	 
}
