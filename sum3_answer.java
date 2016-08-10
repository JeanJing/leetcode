import java.util.*;

public class sum3_answer {
	public static void main(String args[]) {
		int[] nums = { 0, 0, 0 };
		LinkedList<LinkedList<Integer>> rst = new LinkedList<LinkedList<Integer>>();
		rst = threeSum(nums);
		System.out.println(rst);
	}

	public static LinkedList<LinkedList<Integer>> threeSum(int[] num) {

		LinkedList<LinkedList<Integer>> rst = new LinkedList<LinkedList<Integer>>();
		if (num == null || num.length < 3) {
			return rst;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}

			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right] + num[i];
				if (sum == 0) {
					LinkedList<Integer> tmp = new LinkedList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[left]);
					tmp.add(num[right]);
					rst.add(tmp);
					left++;
					right--;
					while (left < right && num[left] == num[left - 1]) { // to
						left++;
					}
					while (left < right && num[right] == num[right + 1]) { // to
																			// skip
																			// duplicates
						right--;
					}
				} else if (sum < 0) {
					left++;
					while (left < right && num[left] == num[left - 1]) { // to
						// skip
						// duplicates
						left++;
					}
					while (left < right && num[right] == num[right + 1]) { // to
						// skip
						// duplicates
						right--;
					}
				} else {
					right--;
					while (left < right && num[left] == num[left - 1]) { // to
						// skip
						// duplicates
						left++;
					}
					while (left < right && num[right] == num[right + 1]) { // to
						// skip
						// duplicates
						right--;
					}
				}
			}
		}
		return rst;
	}
}
