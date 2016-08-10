package StringT;

import java.util.Arrays;

public class LongestCommonPrefix {
public static void main(String args[]){
		
		String []s = {"abcde","abcd"};
		
		System.out.println(longestCommonPrefix(s));
}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int length = strs.length;
		char []Lpre;
		if(strs[0] == null || strs[0].length() == 0)
			return "";
		else
			Lpre= strs[0].toCharArray();
		for (int i = 1; i < length; i++) {
			if(strs[0] == null || strs[0].length() == 0)
				return "";
			int j = 0;
			char [] ch_str = strs[i].toCharArray();
			
			int minLength = Integer.min(Lpre.length, ch_str.length);
			
			while(j < minLength && Lpre[j] == ch_str[j])
				j++;
			Lpre = Arrays.copyOf(Lpre, j);

		}
		return String.valueOf(Lpre);

	}

}
