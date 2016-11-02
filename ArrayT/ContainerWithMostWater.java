package ArrayT;

public class ContainerWithMostWater {
	public static void main(String args[]) {
		int[] data = { 2, 2,3 };
		System.out.println(maxArea(data));
	}

	public static int maxArea(int[] height) {
		if (height == null || height.length <= 1)
			return 0;
		int max, area;
		max = Integer.MIN_VALUE;
		int low, high;
		low = 0;
		high = height.length - 1;
		while (low < high) {
			if (height[low] <= height[high]) {
				area = (high - low) * height[low];
				max = area > max ? area : max;
				low++;
			} else {
				area = (high - low) * height[high];
				max = area > max ? area : max;
				high--;
			}
		}
		return max;
	}
}
