package StringT;

import java.util.Arrays;

public class ReverseWordInAString2 {
	public static void main(String args[]) {
		String s = "      JinNg  ZhEn  Yan     ";
		System.out.println(reverseWords(s));
		//String []str = s.split(" ");
		
		//String jing = reverseWords_final_final(s);
		//for(String ch : str)
		//System.out.println(ch);
		int []data = {12,34,46,4,141,4,313,543,543};
		System.out.println(Arrays.toString(data));

	}
	public static String reverseWords(String s) {
		if (s == null)
			return s;

		StringBuilder newString = new StringBuilder();
		char[] ch = s.toCharArray();
		int length = ch.length;
		int i = length - 1;
		while (i >= 0) {
			while (i >= 0 && ch[i] == ' ')
				i--;
			while (i >= 0 && ch[i] != ' ')
				i--;
			int start = i + 1;
			if (ch[start] == ' ')
				break;
			while (start < length && ch[start] != ' '){
				if(ch[start] >= 97 && ch[start] <= 122){
				newString.append((char)(ch[start++] -'a' + 'A'));
				}else{
					if(ch[start] >= 65 && ch[start] <= 90)
						newString.append((char)(ch[start++]  + 'a' - 'A'));
					else
						newString.append(ch[start++]);
				}
				
			}
			newString.append(" ");
		}
		if (newString.length() > 0)
			newString.deleteCharAt(newString.length() - 1);
		return newString.toString();

	}

}
