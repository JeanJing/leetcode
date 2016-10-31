package ArrayT;

public class SearchInRotatedSortedArray {
	public static void main(String args[]) {
		int[] nums = { 3,1 };
		System.out.println(search_binay(nums, 1));
		System.out.println(searchByPivot(nums, 1));
	}

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		if (nums[0] == target)
			return 0;
		int index = 1;
		while (index < nums.length && nums[index - 1] <= nums[index]) {
			if (nums[index] == target)
				return index;
			index++;
		}
		// ����������е�����˵�����ڴӵ�ǰ��index��ʼ���ж��ֲ���
		int low, high, mid = 0;
		low = index;
		high = nums.length - 1;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else {
				if (nums[mid] > target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	public static int search_binay(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int low, high, mid;
		low = 0;
		high = nums.length - 1;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return mid;
			} else {
				// ��һ�������ǰ��Ĳ����Ǿֲ�����
				if (nums[mid] >= nums[low]) {
					if (nums[low] <= target && target <= nums[mid]) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				} else {// �ڶ������������Ĳ����Ǿֲ�����
					if (nums[mid] <= target && target <= nums[high]) {
						low = mid + 1;
					} else {
						high = mid - 1;
					}
				}
			}
		}
		return -1;
	}

	// ��һ�ַ������ҵ���ת���˼·�����Խ�һ�������Ż�������˳����ҿ��Զ��ֲ���
	public static int findPivot(int[] nums, int low, int high) {
		if (nums == null)
			return -1;
		if (high < low)
			return -1;
		int mid = low + (high - low) / 2;
		if (mid > low && nums[mid] < nums[mid - 1])
			return mid - 1;
		if (mid < high && nums[mid + 1] < nums[mid])
			return mid;
		if (nums[mid] >= nums[low])
			return findPivot(nums, mid + 1, high);
		else
			return findPivot(nums, low, mid - 1);

	}

	public static int searchByPivot(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int pivot = findPivot(nums, 0, nums.length - 1);
		int low, high;
		if (pivot == -1) {
			low = 0;
			high = nums.length - 1;
		} else {
			if (target >= nums[0]) {
				low = 0;
				high = pivot;
			} else {
				low = pivot + 1;
				high = nums.length - 1;
			}
		}
		int mid = -1;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else {
				if (nums[mid] > target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}
