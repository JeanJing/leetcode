package StringT;

import java.util.LinkedList;

public class ValidParentheses {
	public static void main(String args[]) {

		// System.out.println(Integer.valueOf("-2147483649"));
		System.out.println(isValid("([{}])"));
	}

	public static boolean isValid(String s) {
		if (s == null && s.length() == 0)
			return true;
		if (s.length() % 2 == 1)
			return false;
		char[] ch = s.toCharArray();
		int n = s.length();
		Character top;
		LinkedList<Character> stack = new LinkedList<Character>();
		for (int i = 0; i < n; i++) {
			if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[')
				stack.push(ch[i]);
			else {
				//if (ch[i] == ')' || ch[i] == '}' || ch[i] == ']') {
					if (stack.isEmpty())
						return false;
					else {
						top = stack.pop();
						switch(ch[i]){
						   case ')': if(top != '(') return false; break;
						   case '}': if(top != '{') return false; break;
						   case ']': if(top != '[') return false; break;
						}

					}
				//} else {
				//	return false;// ԭ��˵�˷�Χ�����Ӧ�ÿ���ʡ��
				//}

			}
		}
		
		return stack.isEmpty();
	}

}
