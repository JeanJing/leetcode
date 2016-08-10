public class ProductExceptSelf {
	public static void main(String args[]) {
		int nums[] = { 0, 2, 0, 4 };
		int subProduct[] = productExceptSelf(nums);
		for (int n : subProduct) {
			System.out.println(n);
		}

	}

	public static int[] productExceptSelf(int[] nums) {// 我没有考虑0的情况
		int length = nums.length;
		int[] subProduct = new int[length];// 这样初始化本来就是0;
		// 第一步判断0的个数
		int counter = 0;
		for (int i = 0; i < length; i++) {
			if (nums[i] == 0)
				counter++;
		}
		if (counter > 1) {
			// 不做任何处理
		}
		if (counter == 0) {
			int product = 1;
			for (int i = 0; i < length; i++) {
				product *= nums[i];
			}
			for (int i = 0; i < length; i++) {
				subProduct[i] = product / nums[i];
			}
		}
		if(counter == 1){
			int product = 1;
			int flag = 0;
			for (int i = 0; i < length; i++) {
				if(nums[i] != 0){
					product *=nums[i];
				}
				else{
					flag = i;
				}
			}
			subProduct[flag] = product;
			
		}
		return subProduct;

	}

}
