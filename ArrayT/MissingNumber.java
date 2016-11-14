package ArrayT;

public class MissingNumber {
	public static void main(String args[]){
		int []matrix = {0};
		System.out.println(missingNumber2(matrix));
	}
	public static int missingNumber(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int n = nums.length + 1;
		int sum = n*(n - 1) / 2;
		for(int i = 0; i < nums.length; i++){
			sum -= nums[i];
		}
		return sum;
	}
	public static int missingNumber2(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int no1 = 0;
		for(int i = 1; i < nums.length + 1; i++)
			no1 ^= i;
		int no2 = 0;
		for(int i = 0; i < nums.length; i++)
			no2 ^= nums[i];
		return no1^no2;
	}

	public static int nSum(int n) {
		return n*(n + 1) / 2;
	}
}
