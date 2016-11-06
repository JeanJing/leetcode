package ArrayT;

public class SearchForARange {
	public static void main(String args[]){
		int [] result = searchRange(new int[]{8},8);
		for(int i  = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
	public static int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return new int[]{-1, -1};
		int low = 0;
		int high = nums.length - 1;
		int mid;
		while(low <= high){
			mid = low + (high - low) / 2;
			if(nums[mid] == target){
				int start, end;
				start = end = mid;
				while(start > 0 && nums[start] == nums[start - 1])
					start--;
				while(end < nums.length - 1 && nums[end] == nums[end + 1])
					end++;
				return new int[]{start, end};
			}else{
				if(nums[mid] < target)
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		return  new int[]{-1, -1};
        
    }
}
