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
				// ���ڵ���������С�ڵڶ�����
				if (nums[i] < second) {
					third = nums[i];
				} else {
					// ���ڵ������������ڵ��ڵڶ�������С�ڵ�һ����
					if (nums[i] > second) {
						if (nums[i] < first) {
							third = second;
							second = nums[i];
						} else {
							if (nums[i] > first) {
								// ���ڵ������������ڵ��ڵڶ����������ڵ�һ����
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
				// ���ڵ���������С�ڵڶ�����
				if (nums[i] < second) {
					third = nums[i];
				}
				// ���ڵ������������ڵ��ڵڶ�������С�ڵ�һ����
				if (nums[i] > second) {
					if (nums[i] < first) {
						third = second;
						second = nums[i];
					} 
					if (nums[i] > first) {
						// ���ڵ������������ڵ��ڵڶ����������ڵ�һ����
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
