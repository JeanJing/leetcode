package StringT;

import java.util.LinkedList;

public class ReverseWordsinaString {
	public static void main(String args[]) {
		String s = "   ";
		String []str = s.split(" ");
		
		//String jing = reverseWords_final_final(s);
		//for(String ch : str)
		System.out.println(reverseWords_with_stack(s));

	}
public static String reverseWords_with_stack(String s) {
	if (s == null || s.length() == 0)
		return s;
	LinkedList<String> stack = new LinkedList<String>();
	StringBuilder newString;
	char []str = s.toCharArray();
	int n = s.length();
	int i = 0;
	while (i < n) {
		while (i < n && str[i] == ' ')
			i++;
		newString = new StringBuilder("");
		while (i < n && str[i] != ' '){
			newString.append(str[i++]);
		}
		if(!newString.toString().equals(""))
		stack.push(newString.toString());	
	}
	newString = new StringBuilder("");
	while(!stack.isEmpty()){
		newString.append(stack.pop() + " ");
	}
	return newString.length() == 0 ? newString.toString() : newString.deleteCharAt(newString.length() - 1).toString();

}
	   public static String reverseWords_final_final(String s) {
			if (s == null)
				return s;
			StringBuilder newString = new StringBuilder("");
			char [] ch = s.toCharArray();//֮ǰ��Ϊ�˾��������µ��ڴ棬����ֱ�ӱ���s��
			int length = ch.length;//ÿ�η��ʶ�������ԣ���ֱ�ӷ��ʱ�����ֵ��ʱ���ǲ�һ���ģ�Ӱ�컹�Ǻܴ�
			int i = s.length() - 1;
			while (i >= 0) {
				while (i >= 0 && ch[i] == ' ')
					i--;
				while (i >= 0 && ch[i] != ' ')
					i--;
				int start = i + 1;
				if(ch[start] == ' ')
					break;
				while (start < s.length() && ch[start] != ' ')
					newString.append(ch[start ++]);
				newString.append(" ");
					
					

			}
			if(newString.length() > 0 )
				newString.deleteCharAt(newString.length() - 1);
			return newString.toString();

		}
	public static String reverseWords_final(String s) {
		if (s == null)
			return s;
		StringBuilder newString = new StringBuilder("");
		
		int i = s.length() - 1;
		while (i >= 0) {
			while (i >= 0 && s.charAt(i) == ' ')
				i--;
			while (i >= 0 && s.charAt(i) != ' ')
				i--;
			int start = i + 1;
			if(s.charAt(start) == ' ')
				break;
			while (start < s.length() && s.charAt(start) != ' ')
				newString.append(s.charAt(start ++));
			newString.append(" ");
				
				

		}
		if(newString.length() > 0 )
			newString.deleteCharAt(newString.length() - 1);
		return newString.toString();

	}
	public static String reverseWords_nocall_improved_improved(String s) {
		if (s == null)
			return s;
		StringBuilder newString = new StringBuilder("");
		LinkedList<String> stack = new LinkedList<String>();
		int i = s.length() - 1;
		while (i >= 0) {
			while (i >= 0 && s.charAt(i) == ' ')
				i--;
			StringBuilder temp = new StringBuilder(30);
			while (i >= 0 && s.charAt(i) != ' ')
				i--;
			int start = i +1;
			while (start < s.length() && s.charAt(start) != ' ')
				temp.append(s.charAt(start ++));
			if(temp.length() >0){
				if(newString.length() != 0)
					newString.append(" ");
				newString.append(temp.toString());
				
				
			}

		}
		return newString.toString();

	}
	public static String reverseWords_nocall_improved(String s) {// �Ӵ���ĩβ��ʼ
		if (s == null)
			return s;
		StringBuilder newString = new StringBuilder("");
		LinkedList<String> stack = new LinkedList<String>();
		int i = s.length() - 1;
		while (i >= 0) {
			while (i >= 0 && s.charAt(i) == ' ')
				i--;
			StringBuilder temp = new StringBuilder(30);
			while (i >= 0 && s.charAt(i) != ' ')
				temp.append(s.charAt(i--));
			if(temp.length() >0){
				if(newString.length() != 0)
					newString.append(" ");
				temp = temp.reverse();
				newString.append(temp.toString());
				
				
			}

		}
		return newString.toString();

	}

	public static String reverseWords_nocall(String s) {// ����Ϊ�����ܿ죬���û�У����п�����insert�ȽϺ�ʱ��
		if (s == null)
			return s;
		StringBuilder newString = new StringBuilder("");
		int i = 0;
		while (i < s.length()) {
			while (i < s.length() && s.charAt(i) == ' ')
				i++;
			StringBuilder temp = new StringBuilder(30);
			if (newString.length() != 0)
				if (i < s.length())
					newString.insert(0, ' ');
			while (i < s.length() && s.charAt(i) != ' ')
				temp.append(s.charAt(i++));
			newString.insert(0, temp);

		}
		return newString.toString();

	}

	// �����Ӿ�Ȼ�ٶȱ�ʹ��ջ����
	public static String reverseWords_simple(String s) {// ȥ��trim���ٶ�������40ms
		if (s == null || s.length() == 0)
			return s;
		String[] words = s.split(" +");
		if (words.length == 0)
			return new String();
		StringBuilder newString = new StringBuilder("");
		int end = words[0].length() == 0 ? 1 : 0;
		for (int i = words.length - 1; i >= end; i--) {
			newString.append(words[i]);
			if (words[i].length() > 0 && i != end)
				newString.append(" ");

		}
		return newString.toString();

	}

	public static String reverseWords(String s) {
		if (s == null)
			return s;
		int i = 0;
		LinkedList<String> stack = new LinkedList();
		char[] str_c = s.trim().toCharArray();
		String word = "";
		while (i < str_c.length) {
			if (str_c[i] != ' ') {
				word += str_c[i++];
			} else {
				if (word.length() != 0)
					stack.push(word);
				word = "";
				i++;
			}
		}
		stack.push(word);
		String newString = "";
		while (!stack.isEmpty()) {
			newString += (stack.pop() + " ");
		}
		return newString.trim();

	}
}
