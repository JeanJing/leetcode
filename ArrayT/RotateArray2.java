package ArrayT;

public class RotateArray2 {
	public static void main(String args[]) {
		int[] data = { 1, 2, 3, 4, 5, 6 };
		rotate(data, 2);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public static void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k % nums.length == 0)
			return;

		int n = k % nums.length;
		int count = 0;
		int tVal, currIndex, cVal;
		currIndex = 0;
		cVal = nums[0];
		boolean[] flag = new boolean[nums.length];

		while (count != nums.length) {
			if (!flag[currIndex]) {
				flag[currIndex] = true;
				tVal = nums[(currIndex + n) % nums.length];
				currIndex = (currIndex + n) % nums.length;
				nums[currIndex] = cVal;
				cVal = tVal;
			
				count++;
			} else {
				cVal = nums[++currIndex % nums.length];

			}
		}

	}

}
