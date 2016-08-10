package StringT;

import java.util.Arrays;

public class CompareVersion {
public static void main(String args[]){
		
		//String []s = {"abcde","abcd"};
	    //String temp = "";
		//System.out.println(Integer.valueOf(temp == "" ? "0" : temp));
		System.out.println(compareVersion_nosplit("1","12"));
	//StringBuilder str = new StringBuilder("");
	///if(str.equals(""))
	//	System.out.println("‘ı√¥ªÿ ¬");
}
public static int compareVersion_nosplit(String version1, String version2) {
	if (version1 == null || version2 == null)
		return 0;
    char []ver1 = version1.toCharArray();
    char []ver2 = version2.toCharArray();
	int n_ver1 = ver1.length;
	int n_ver2 = ver2.length;
	int i,j;
	i = j = 0;
	String ver1_temp, ver2_temp;
	while(i < n_ver1 || j < n_ver2){
		ver1_temp = "";
		while(i < n_ver1  && ver1[i] != '.'){
			ver1_temp += ver1[i++];
		}
		ver2_temp = "";
		while(j < n_ver2  && ver2[j] != '.'){
			ver2_temp += ver2[j++];
		}
		if(Integer.valueOf(ver1_temp.length() == 0 ? "0" : ver1_temp) 
				> Integer.valueOf(ver2_temp.length() == 0 ? "0" : ver2_temp))
			return 1;
		if(Integer.valueOf(ver1_temp.length() == 0 ? "0" : ver1_temp) 
				< Integer.valueOf(ver2_temp.length() == 0 ? "0" : ver2_temp))
			return -1;
		if(i < n_ver1) i++;
		if(j < n_ver2) j++;
	}
	
	return 0;

}
public static int compareVersion(String version1, String version2) {
	if (version1 == null || version2 == null)
		return 0;
	String[] ver1 = version1.split("\\.");
	String[] ver2 = version2.split("\\.");
	int n_ver1 = ver1.length;
	int n_ver2 = ver2.length;
	int n = Math.min(n_ver1, n_ver2);
	int i = 0;
	for(; i < n; i++){
		if(Integer.valueOf(ver1[i]) > Integer.valueOf(ver2[i]))
			return 1;
		if(Integer.valueOf(ver1[i]) < Integer.valueOf(ver2[i]))
			return -1;
	}
	if(n_ver1 < n_ver2){
		while(i < n_ver2 && Integer.valueOf(ver2[i]) == 0)
			i++;
		if(i < n_ver2 && Integer.valueOf(ver2[i]) > 0)
			return -1;
	}
	if(n_ver1 > n_ver2){
		while(i < n_ver1 && Integer.valueOf(ver1[i]) == 0)
			i++;
		if(i < n_ver1 && Integer.valueOf(ver1[i]) > 0)
			return 1;
	}
	return 0;

}
	public static int compareVersion_error(String version1, String version2) {
		if (version1 == null || version2 == null)
			return 0;
		// StringBuilder first1,first2;
		// StringBuilder second1,second2;

		// char[] v1_ch = version1.toCharArray();
		// /int v1_n = v1_ch.length;
		// char[] v2_ch = version2.toCharArray();
		// int v2_n = v2_ch.length;
		// int i1,i2;
		// i1 = i2 = 0;
		// while(i1 < v1__n){

		// }
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");
		int first1, first2;
		int second1, second2;
		if (ver1.length == 1) {
			first1 = Integer.valueOf(ver1[0]);
			second1 = 0;
		} else {
			first1 = ver1[0].length() == 0 ? 0 : Integer.valueOf(ver1[0]);
			second1 = ver1[1].length() == 0 ? 0 : Integer.valueOf(ver1[1]);
		}
		if (ver2.length == 1) {
			first2 = Integer.valueOf(ver2[0]);
			second2 = 0;
		} else {
			first2 = ver2[0].length() == 0 ? 0 : Integer.valueOf(ver2[0]);
			second2 = ver2[1].length() == 0 ? 0 : Integer.valueOf(ver2[1]);
		}
		if(first1 > first2)
			return 1;
		if(first1 < first2)
			return -1;
		if(second1 > second2)
			return 1;
		if(second1 < second2)
			return -1;
		return 0;

	}
	

}
