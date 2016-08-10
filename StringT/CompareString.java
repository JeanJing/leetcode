
package StringT;

import java.util.Arrays;

public class CompareString {
	public static void main(String args[]){
	
		String s = "abcde";
		String t = "db";
		System.out.println(compareStrings(s,t));

	}
	 public static boolean compareStrings(String A, String B) {
		 if(B == null || B.length() == 0)
			 return true;
		 if(A == null||A.length() == 0 || A.length() < B.length())
			 return false;
		 char []a = A.toCharArray();
		 Arrays.sort(a);
		 char []b = B.toCharArray();
		 Arrays.sort(b);
		 int i;
		 i = 0;
		 while(i <= A.length() -B.length()){
			 if(a[i] != b[0])
				 i++;
			 else
				 break;
		}//找到第一个相等的点
		 if(i > A.length() -B.length())
			 return false;
		 int j =0;
		 while(j < b.length && i < a.length){
			 if(b[j] == a[i]){
				 j++;
				 i++;
			 }else{
				 i++;
			 }
		 }
		 if(j == b.length)
			 return true;
		 return false;
	       
	    }
	 public static boolean compareStrings_hashmap(String A, String B) {
		 if(B == null || B.length() == 0)
			 return true;
		 if(A == null || A.length() < B.length())
			 return false;
		 int []count = new int[256];
		 Arrays.fill(count,0);
		 char []a = A.toCharArray();
		 for(char c: a){
			 count[c]++;
		 }
		 char []b = B.toCharArray();
		 for(char c:b){
			 count[c]--;
			 if(count[c] < 0){
				 return false;
			 }
		 }
		 return true;
	 }
}
