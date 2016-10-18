package ArrayT;

public class MoveZeroes {
	public static void main(String args[]) {
		int[] data = { 1, 0, 3, 4, 0, 6 ,0,0,0};
		moveZeroes(data);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	public static void moveZeroes(int[] nums) {
		if (nums == null && nums.length == 0)
			return;
		int flag1, flag2;
		flag1 = -1; // 用来标记0的末尾
		flag2 = -1;// 用来标记非0的末尾
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				flag1 = i;
			else {
				if (flag1 == -1) {
					flag2++;
				} else {
					int temp = nums[flag2 + 1];
					nums[flag2 + 1] = nums[i];
					nums[i] = temp;
					flag1++;
					flag2++;
				}
			}

		}
	}

}
