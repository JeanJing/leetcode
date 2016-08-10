public class CountDigitOne {
	public static void main(String args[]) {
		// System.out.println(Math.pow(10,2));
		// System.out.println(countDigitOne_0(123));
		// System.out.println(countDigitOne_1(234));
		// System.out.println("xingbuxing ");
		int num = 1234;
		String numString = String.valueOf(num);
		StringBuffer str = new StringBuffer(numString);
		str = str.reverse();
		numString = str.toString();
		System.out.println(countDigitOne(1111));
		//System.out.println(countDigitOne_0(11));
	}

	public static int countDigitOne_0(int num) {
		int counter = 0;
		int tempCounter = 0;
		for (int i = 1; i <= num; i++) {
			tempCounter = countDigitOneInOneNumber(i);
			counter += tempCounter;
		}

		return counter;

	}

	public static int countDigitOne_1(int num) {// 这个很失败，我没有好好研究问题，不可一世的觉得自己可以很容易编出程序，shit
		if (num < 0)
			return 0;

		int counter = 0;
		if (num == 0)
			counter = 0;
		else
			counter = 1;
		int quotient = num / 10;// 商
		int remainder = num % 10;// 余数
		int bit = 0;
		while (quotient != 0) {
			bit++;// bit表示当前处理的位
			remainder = quotient % 10;
			quotient = quotient / 10;
			if (remainder == 0)
				counter = counter;
			else
				counter = counter + (remainder - 1) * counter + num
						% ((int) Math.pow(10, bit)) + 1 + counter;
		}

		return counter;

	}

	public static int countDigitOne(int num) {//想要得到一个整数的长度，可以首先把它变成字符串，然后利用字符串的长度得到整数的长度
		if(num < 0)                           //但是这里有一个问题，这样得到的字符串下标0对应的是整数的最高位但不是最低位
			return 0;
		String numString = String.valueOf(num);
		StringBuffer str = new StringBuffer(numString);
		str = str.reverse();
		numString = str.toString();
		int numberOfBit = numString.length();// 得到整数num的位数
		int counter = 0;// 用来记录1出现的次数
		int higherNum;
		int lowerNum;
		int allCounter = 0;
		for (int i = 0; i < numberOfBit; i++) {
			higherNum = num / ((int) Math.pow(10, i + 1));
			lowerNum = num % ((int) Math.pow(10, i));
			int current = Character.getNumericValue(numString.charAt(i));// 得到当前位的值
			switch (current) {
			case 0:
				counter = higherNum * ((int) Math.pow(10, i));
				break;
			case 1:
				if (i == 0)
					counter = higherNum * ((int) Math.pow(10, i)) + 1;
				else
					counter = higherNum * ((int) Math.pow(10, i)) + lowerNum + 1;
				break;
			default:
				counter = (higherNum + 1) * ((int) Math.pow(10, i));

			}
			allCounter += counter;

		}

		return allCounter;

	}

	public static int countDigitOneInOneNumber(int n) {
		int quotient = n;// 商
		int remainder = 0;// 余数
		int counter = 0;
		do {
			remainder = quotient % 10;
			quotient = quotient / 10;

			if (remainder == 1)
				counter++;

		} while (quotient != 0);

		return counter;

	}

}
