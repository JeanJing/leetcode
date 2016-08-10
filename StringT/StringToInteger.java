package StringT;

public class StringToInteger {
	public static void main(String args[]) {

		// System.out.println(Integer.valueOf("-2147483649"));
		System.out.println(myAtoi_2("9223372036854775809"));
	}

	public static int myAtoi(String str) {// ��ʱ���쳣��������Ϊ���ֵ
		if (str == null || str.length() == 0)
			return 0;
		char[] ch = str.toCharArray();
		int n = ch.length;
		int i = 0;
		while (i < n && ch[i] == ' ')
			i++;
		int start = i;
		if (ch[i] == '-' || ch[i] == '+')
			i++;
		else {
			if (ch[i] - '0' < 0 || ch[i] - '0' > 9)
				return 0;
		}
		double result = 0.0;
		for (; i < n; i++) {

			if (ch[i] - '0' >= 0 && ch[i] - '0' <= 9)
				result = result * 10 + (ch[i] - '0');
			else {
				if(ch[start] == '-')
					result = -result;
				if (result > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				if (result < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
				return (int)result;
			}
		}
		if(ch[start] == '-')
			result = -result;
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int)result;
	}
	//�����İ汾
	public static int myAtoi_2(String str) {// ��ʱ���쳣��������Ϊ���ֵ
		if (str == null || str.length() == 0)
			return 0;
		char[] ch = str.toCharArray();
		int n = ch.length;
		int i = 0;
		while (i < n && ch[i] == ' ')
			i++;
		int start = i;
		if (ch[i] == '-' || ch[i] == '+')
			i++;
		else {
			if (ch[i] - '0' < 0 || ch[i] - '0' > 9)
				return 0;
		}
		double result = 0;
		while(i < n && ch[i] - '0' >= 0 && ch[i] - '0' <= 9){
				result = result * 10 + (ch[i++] - '0');
		}
		if(ch[start] == '-')
			result = -result;
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int)result;
	}
}
