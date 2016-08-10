
public class ReverseInteger {
	public static void main(String args[]){
		System.out.println(reverseInteger(1563847412));
		System.out.println(Math.pow(2,31));
	}
	public static int reverseInteger(int x){
		String numberic = String.valueOf(x);
		int flag =0;
		int length = 0;
		int j = 0;
		if(numberic.charAt(0) >= '0' && numberic.charAt(0) <= '9'){
			flag = 1;
			length = numberic.length();
			j = 0;
		}
		else{
			flag = -1;
			length = numberic.length() - 1;
			j = 1;
		}
		char str[] = new char[length];
		int i = str.length -1;
		while(i >= 0){
			str[i--] = numberic.charAt(j++);
		}
		long result = str[0] - '0';
		for(int m = 1; m < length; m++){
			result = result * 10 + str[m] - '0';
		}
		if(result > Math.pow(2,31))
			return 0;
		return (int) (flag * result);
		
	}

}
