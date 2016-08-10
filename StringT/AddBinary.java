package StringT;

public class AddBinary {
public static void main(String args[]){
		
		//String []s = {"abcde","abcd"};
	    String str = " jing jing ";
		String []s = str.split(" ");
		System.out.println(addBinary("1110","1100"));
}
	 public static String addBinary(String a, String b) {
		 if(a == null || b == null)
			 return a == null ? b : a;
		 char []a_ch = a.toCharArray();
		 char []b_ch = b.toCharArray();
		 int a_length = a_ch.length;
		 int b_length = b_ch.length;
		 int sum = 0;
		 int carry = 0;
		 int i,j;
		 i = a_ch.length -1;
		 j = b_ch.length -1;
		 StringBuilder ret = new StringBuilder();
		 while(i >= 0 && j >= 0){
			 sum = a_ch[i--] - '0' + b_ch[j--] -'0' + carry;
			 carry = sum / 2;
			 sum = sum % 2;
			 ret.append(sum);
		
		 }
		 while(i >= 0){
			 sum = a_ch[i--] - '0' + carry;
			 carry = sum / 2;
			 sum = sum % 2;
			 ret.append(sum);
		 }
		 while(j >=0){
			 sum = b_ch[j--] - '0' + carry;
			 carry = sum / 2;
			 sum = sum % 2;
			 ret.append(sum);
		 }
		 if(carry == 1)
			 ret.append(carry);
		 return ret.reverse().toString();
	 }
	 public static String addBinary_simple(String a, String b) {
		 if(a == null || b == null)
			 return a == null ? b : a;
		 char []a_ch = a.toCharArray();
		 char []b_ch = b.toCharArray();
		 int a_length = a_ch.length;
		 int b_length = b_ch.length;
		 int sum = 0;
		 int carry = 0;
		 int i,j;
		 i = a_ch.length -1;
		 j = b_ch.length -1;
		 int a_temp,b_temp;
		 StringBuilder ret = new StringBuilder();
		 while(i >= 0 || j >= 0 || carry == 1){
			 a_temp =  i >= 0 ? a_ch[i--] - '0' : 0;
			 b_temp =  j >= 0 ? b_ch[j--] - '0' : 0;
			 sum = a_temp + b_temp + carry;
			 carry = sum / 2;
			 sum = sum % 2;
			 ret.append(sum);
		
		 }
		 return ret.reverse().toString();
	 }

}
