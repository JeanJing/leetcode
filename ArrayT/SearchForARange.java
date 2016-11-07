package ArrayT;

public class SearchForARange {
	public static void main(String args[]){
		int [] result = searchRange_binary(new int[]{ 8, 8},8);
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
	public static int[] searchRange_binary(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return new int[]{-1, -1};
		int low = 0;
		int high = nums.length - 1;
		int mid;
		while(low <= high){
			mid = low + (high - low) / 2;
			if(target < nums[mid])
				high = mid - 1;
			else{
				if(target > nums[mid])
					low = mid + 1;
				else{
					if(mid > 0){
						if(nums[mid - 1] < nums[mid]){
							low = mid;
							break;
						}else{
							high = mid - 1;
						}
						
					}
					else{
						low = 0;
						break;
					}
				}
			}
		}
		int low2 = low;
		high = nums.length -1;
		while(low <= high){
			mid = low2 + (high - low2) / 2;
			if(target < nums[mid])
				high = mid - 1;
			else{
				if(target > nums[mid])
					low2 = mid + 1;
				else{
					if(mid < nums.length - 1){
						if(nums[mid] < nums[mid+1]){
							high = mid;
							return new int[]{low, high};
						}else{
							low2 = mid + 1;
						}
						
					}
					else{
						high = nums.length - 1;
						return new int[]{low, high};
						
					}
				}
			}
		}
		return new int[]{-1,-1};
	}
}
