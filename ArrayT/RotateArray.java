package ArrayT;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return;
		if (k % nums.length == 0)
			return;

		int n = k % nums.length;
		int[] newnums = new int[nums.length];
		System.arraycopy(nums, nums.length - n, newnums, 0, n);
		System.arraycopy(nums, 0, newnums, n, nums.length - n);
		System.arraycopy(newnums, 0, nums, 0, nums.length);

	}

}
