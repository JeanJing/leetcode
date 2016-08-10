package StringT;

public class ValidPalindrome {
	public static void main(String args[]) {
		String s = "Pp";
		 
		System.out.println(isPalindrome_two_pointer(s));

	}
	public static boolean isPalindrome_two_pointer_NO(String s) {
		if(s == null || s.length() == 0 )
			return true;
		char []ch = s.toCharArray();
		int n = s.length();
		int lo = 0, ho = n -1;
		while(lo < ho){//�ַ���һ���ʱ��Ϳ���reverse�ַ���
			if(!Character.isLetterOrDigit(ch[lo])){
				lo++;
				continue;
			}
			if(!Character.isLetterOrDigit(ch[ho])){
				ho--;
				continue;
			}
			if(Character.toLowerCase(ch[lo]) != Character.toLowerCase(ch[ho]))
				return false;
			else{
				lo++;
				ho--;
			}
		}
		return true;
	}
	public static boolean isPalindrome_two_pointer(String s) {
		if(s == null || s.length() == 0 )
			return true;
		char []ch = s.toCharArray();
		StringBuilder str = new StringBuilder();
		int n = ch.length;
		for(int i = 0; i < n; i++){
			if(Character.isAlphabetic(ch[i])||Character.isDigit(ch[i]))
				str.append(Character.toLowerCase(ch[i]));
		}
		s = str.toString();
		ch = s.toCharArray();
		n = str.length();
		int lo = 0, ho = n -1;
		while(lo < ho){//�ַ���һ���ʱ��Ϳ���reverse�ַ���
			if(ch[lo] != ch[ho])
				break;
			else{
				lo++;
				ho--;
			}
		}
		return !(lo < ho);
	}
	
public static boolean isPalindrome(String s) {
	if(s == null || s.length() == 0 )
		return true;
	StringBuilder str = new StringBuilder();
	char []ch = s.toCharArray();
	int n = ch.length;
	for(int i = 0; i < n; i++){
		if(Character.isAlphabetic(ch[i])||Character.isDigit(ch[i]))
			str.append(Character.toLowerCase(ch[i]));
	}
	s = str.toString();
	ch = s.toCharArray();
	n = str.length();
	int lo = 0, ho = n -1;
	while(lo < ho){//�ַ���һ���ʱ��Ϳ���reverse�ַ���
		swap(ch,lo++,ho--);
	}
	return s.equals(String.valueOf(ch));
 }
private static void swap(char[]ch, int i, int j){//�ı��������
	char temp = ch[i];
	ch[i] = ch[j];
	ch[j] = temp;
}

}
