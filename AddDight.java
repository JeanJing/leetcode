public class AddDight {
	
	
	public static void main(String args[]) {
		System.out.println(addDigits(2112345678));
	}

	public static int addDigits(int num) {

		while (num / 10 != 0) {
			int sum = 0;
			while (num != 0) {//错在这里，开始的时候是num/10 != 0，
				              //这样的话最后一位就没有办法获得，所以判断条件的终止状态是非常重要的
				sum += num % 10;
				num /= 10;
			}
			num = sum;
	}
		return num;

	}
}
