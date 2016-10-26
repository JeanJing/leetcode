package ArrayT;

public class ThirdMaximumNumbe {
	public static void main(String args[]) {
		int[] data = { 1, 2, 2 };
		System.out.println(thirdMax(data));
	}

	public static int thirdMax(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2) {
			return nums[0] > nums[1] ? nums[0] : nums[1];
		}
		long first, second, third;
		first = Long.MIN_VALUE;
		second = Long.MIN_VALUE;
		third = Long.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > third) {
				// 大于第三个数，小于第二个数
				if (nums[i] < second) {
					third = nums[i];
				} else {
					// 大于第三个数，大于等于第二个数，小于第一个数
					if (nums[i] > second) {
						if (nums[i] < first) {
							third = second;
							second = nums[i];
						} else {
							if (nums[i] > first) {
								// 大于第三个数，大于等于第二个数，大于第一个数
								third = second;
								second = first;
								first = nums[i];
							}
						}
					}
				}
			}
		}
		if (third != Long.MIN_VALUE)
			return (int)third;
		else
			return (int)first;
	}

	public static int thirdMax_improved(int[] nums) {
		long first, second, third;
		first = Long.MIN_VALUE;
		second = Long.MIN_VALUE;
		third = Long.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > third) {
				// 大于第三个数，小于第二个数
				if (nums[i] < second) {
					third = nums[i];
				}
				// 大于第三个数，大于等于第二个数，小于第一个数
				if (nums[i] > second) {
					if (nums[i] < first) {
						third = second;
						second = nums[i];
					} 
					if (nums[i] > first) {
						// 大于第三个数，大于等于第二个数，大于第一个数
						third = second;
						second = first;
						first = nums[i];
					}
				}
			}

		}
		if (third != Long.MIN_VALUE)
			return (int)third;
		else
			return (int)first;
	}
}
