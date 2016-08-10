package StringT;

public class LengthOfLastWord {
	public static void main(String args[]) {
		String s = " jingzhen  adfa dafdafd Pp            ";
		 
		System.out.println(lengthOfLastWord(s));

	}
	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0)
			return 0;
		char [] ch = s.toCharArray();
		int n = ch.length;
		int i = n - 1;
		while( i >= 0 && ch[i] == ' ')
			i--;
		int lenOfLast = 0;
		while( i >= 0 && ch[i] != ' '){
			lenOfLast++;
			i--;
		}
		return lenOfLast;

	}

}
