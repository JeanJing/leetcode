public class MediumOfTwoSortedArray {
	public static void main(String args[]) {
		int nums1[] = { };
		int nums2[] = { 5, 6 };
		System.out.println(mediumOfTwoSortedArray(nums1, nums2));

	}

	public static double mediumOfTwoSortedArray(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int medium1 = (n + m) / 2;
		int medium2 = medium1 + (n + m) % 2;
		int point_1 = 0;
		int point_2 = 0;
		int i = 0;
		if (medium1 != medium2) {//总数为奇数，只有一个中位数
			//把for循环改成while循环
			int temp[] = new int[medium2];
			while(i < medium2 && point_1 < n & point_2 <m){
				if (nums1[point_1] < nums2[point_2]) {
					temp[i] = nums1[point_1++];
				} else {
					temp[i] = nums2[point_2++];
				}
				i++;
			}
			while(point_1 == n &&  i < medium2){
				temp[i] = nums2[point_2++];
				i++;
			}
			while(point_2 == m &&  i < medium2){
				temp[i] = nums1[point_1++];
				i++;
			}
			return temp[medium1];
		} else {// 这种情况有两个中位数,medium1和medium2相等
			int temp[] = new int[medium1 + 1];
			while(i < medium1 +1 && point_1 < n & point_2 <m){
				if (nums1[point_1] < nums2[point_2]) {
					temp[i] = nums1[point_1++];
				} else {
					temp[i] = nums2[point_2++];
				}
				i++;
			}
			while(point_1 == n &&  i < medium1 + 1){
				temp[i] = nums2[point_2++];
				i++;
			}
			while(point_2 == m &&  i < medium1 + 1){
				temp[i] = nums1[point_1++];
				i++;
			}
			return ((double) temp[medium1 - 1] + (double) temp[medium1]) / 2.0;

		}

	}

}
