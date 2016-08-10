package StringT;

public class CountAndSay {
	public static void main(String args[]){
		
		String s = "abcde";
		
		System.out.println(countAndSay_iter(6));

	}
	
	 public static String countAndSay(int n) {
		 if(n == 1)
			return String.valueOf(11);
		 String preString = countAndSay(n-1);
		 char []preCh = preString.toCharArray();
		 int pre_n = preString.length();
		 StringBuilder newString = new StringBuilder();
		 for(int i = 0; i < pre_n; i++){
			 int num = 0;
			 char dight = preCh[i];
			 while(i < pre_n && dight == preCh[i]){
				 num ++;
				 i++;
			 }
			 newString.append(num);
			 newString.append(dight);
			 i--;
		 }
		 return newString.toString();
		 
	 }
	 public static String countAndSay_iter(int n) {
		 String []ret = new String[n];
		 ret[0] = String.valueOf(1);
		 for(int i = 1; i < n; i++){
			 char []preCh = ret[i - 1].toCharArray();
			 int pre_n = ret[i - 1].length();
			 StringBuilder newString = new StringBuilder();
			 for(int j = 0; j < pre_n; j++){
				 int num = 0;
				 char dight = preCh[j];
				 while(j < pre_n && dight == preCh[j]){
					 num ++;
					 j++;
				 }
				 newString.append(num);
				 newString.append(dight);
				 j--;
			 }
			 ret[i] = newString.toString();
		 }
		 return ret[n - 1];
	 }

}
