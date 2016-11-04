package ArrayT;

import java.util.Arrays;

public class ThreeSumClosest {
	public static void main(String args[]) {
		int[] data = { 0, 2, 1, -3 };
		System.out.println(threeSumClosest(data, 1));
	}

	public static int threeSumClosest(int[] nums, int target) {

		if (nums == null || nums.length < 3)
			return 0;

		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2];
		int low, high;
		for (int i = 0; i < nums.length - 2; i++) {
			low = i + 1;
			high = nums.length - 1;
			
			while (low < high) {
				int close = nums[low] + nums[high] + nums[i];
				if (close == target) {
					return target;
				} else {
					if (Math.abs(close - target) < Math.abs(closest - target))
						closest = close;
					if (close < target) {
						low++;

					} else {
						high--;
					}
				}
			}
		}
		return closest;
	}
}
