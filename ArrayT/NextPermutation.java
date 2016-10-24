package ArrayT;

import java.util.Arrays;

public class NextPermutation {
	public static void main(String args[]) {
		int[] a = { 1,3,2 };
		nextPermutation(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1)
			return;
		int p, q;
		p = q = -1;
		for (int i = nums.length - 1; i >= 1; i--) {
			if (nums[i] > nums[i - 1]) {
				p = i - 1;// ֮���ҵ�������������С��
				break;
			}
		}
		if (p == -1) {
			for (int i = 0; i < nums.length / 2; i++) {
				int temp = nums[i];
				nums[i] = nums[nums.length - 1 - i];
				nums[nums.length - 1 - i] = temp;
			}
			return;
		}
		for (int i = p + 1; i < nums.length; i++) {
			if (nums[i] <= nums[p]) {
				q = i - 1;
				break;
			}
		}
		if (q == -1) {
			q = nums.length - 1;
		}
		// ����p��q
		int temp = nums[p];
		nums[p] = nums[q];
		nums[q] = temp;

		// ֮���p+1 ��ĩβ��������
		//Arrays.sort(nums, p + 1, nums.length);//��Ϊ���ÿ⺯������ʱ�仨�Ѵ�һЩ
		//���������ʵ��һ���������в��Ǻܸ���
		for(int i = p + 1; i <= (p  + nums.length) / 2; i++){
			int tem = nums[i];
			nums[i] = nums[p + nums.length - i];
			nums[p + nums.length - i] = tem;
		}
		
	}

	

	public void nextPermutation_2(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int k = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				k = i;
				break;
			}
			// if current rank is the largest, reverse it to smallest, return
			if (k == -1) {
				reverse(nums, 0, nums.length - 1);
				return;
			} // step2: search the first nums[k] < nums[l] backward
			int l = nums.length - 1;
			while (l > k && nums[l] <= nums[k])
				l--;
			// step3: swap nums[k] with nums[l]
			int temp = nums[k];
			nums[k] = nums[l];
			nums[l] = temp;
			reverse(nums, k + 1, nums.length - 1);
		}
	}
	public static void reverse(int[] nums, int lb, int ub) {
		for (int i = lb, j = ub; i < j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
}
