package ArrayT;

import java.util.Arrays;

public class PlusOne {
	public static void main(String args[]){
		int []digits = {9,9};
		digits = plusOne(digits);
		for(int i = 0; i < digits.length; i++){
			System.out.print(digits[i]+ " ");
		}
		System.out.println();
	}
	public static int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0)
			return new int[0];
		int length = digits.length;
		int[] newDigits = new int[length + 1];
		int curr, pre = 0;
		for (int i = length-1; i >= 0; i--) {
			if (i == length-1) {
				curr = (digits[i] + pre + 1) % 10;
				if ((digits[i] + pre + 1) / 10 != 0)
					pre = 1;
				else
					pre = 0;
				newDigits[i + 1] = curr;

			} else {
				curr = (digits[i] + pre) % 10;
				if ((digits[i] + pre) / 10 != 0)
					pre = 1;
				else
					pre = 0;
				newDigits[i + 1] = curr;
			}
		}
		if (pre != 0)
			newDigits[0] = 1;
		else
			newDigits = Arrays.copyOfRange(newDigits, 1, newDigits.length);
		return newDigits;
	}
}
