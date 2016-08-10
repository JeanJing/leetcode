package StringT;

public class MultiplyStrings {
	public static void main(String args[]) {

		//System.out.println(helper("123456789".toCharArray(), '5'));
		System.out.println(multiply("998888888888", "0"));

	}

	public static String multiply(String num1, String num2) {
		if (num1 == null || num2 == null || num1.length() == 0
				|| num2.length() == 0)
			return String.valueOf(0);
		StringBuilder nums1 = new StringBuilder(num1);
		StringBuilder nums2 = new StringBuilder(num2);
		char[] ch1 = nums1.reverse().toString().toCharArray();
		char[] ch2 = nums2.reverse().toString().toCharArray();
		int n1 = ch1.length;
		int n2 = ch2.length;
		int []innerResult  = new int[n1 + n2];//这个检验正确
		for(int i = 0; i < ch1.length; i++){
			for(int j = 0; j < ch2.length; j++){
				innerResult[i+j] += (ch1[i] - '0') *(ch2[j] - '0');
			}

		}
		String result = "";
		int carry = 0;
		for(int i =0; i < innerResult.length -1; i++){
			result = String.valueOf((innerResult[i] + carry) % 10) + result;
			carry = (innerResult[i] + carry) / 10;
		}
		if(carry > 0 )
			result = String.valueOf(carry) + result;
		int i  = 0;
		while(i < result.length() - 1 && result.charAt(i) == '0')
			i++;
		return result.substring(i);
	}

	public static String multiply_error(String num1, String num2) {// 因为中间涉及到计算，所以会有溢出的情况，而利用double会有精度的问题出现
		if (num1 == null || num2 == null || num1.length() == 0
				|| num2.length() == 0)
			return String.valueOf(0);
		char[] ch1 = num1.toCharArray();
		char[] ch2 = num2.toCharArray();
		int n1 = ch1.length;
		int n2 = ch2.length;
		double result, innerResult;
		result = innerResult = 0.0;
		int carry = 0;
		result = innerResult = carry = 0;
		for (int i = n2 - 1; i >= 0; i--) {
			innerResult = 0.0;
			carry = 0;
			for (int j = n1 - 1; j >= 0; j--) {
				innerResult += (((ch1[j] - '0') * (ch2[i] - '0') + carry) % 10)
						* Math.pow(10, n1 - 1 - j);
				carry = ((ch1[j] - '0') * (ch2[i] - '0') + carry) / 10;
			}
			if (carry > 0)
				innerResult += carry * Math.pow(10, n1);
			result = result + innerResult * Math.pow(10, n2 - 1 - i);
		}
		/*
		 * if (result > Integer.MAX_VALUE) return
		 * String.valueOf(Integer.MAX_VALUE); if (result < Integer.MIN_VALUE)
		 * return String.valueOf(Integer.MIN_VALUE);
		 */
		return String.valueOf((long) result);
	}

	private static double helper(char[] ch1, char ch2_s) {
		double innerResult = 0.0;
		int carry = 0;
		for (int j = ch1.length - 1; j >= 0; j--) {
			innerResult += (((ch1[j] - '0') * (ch2_s - '0') + carry) % 10)
					* Math.pow(10, ch1.length - 1 - j);
			carry = ((ch1[j] - '0') * (ch2_s - '0') + carry) / 10;
		}
		if (carry > 0)
			innerResult += carry * Math.pow(10, ch1.length);
		return innerResult;
	}
}
