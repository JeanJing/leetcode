
public class ValidAnagram_Answer {
	public static void main(String args[]){
		String a ="a";
		String b = "b";
		System.out.println(isAnagram(a,b));
	}
	public static boolean isAnagram(String s, String t) {
		if(s.length()!= t.length())
			return false;
		int j = 0;//���t
		int statistic[] = new int[26];//�������ԣ�ϵͳ�Զ�����ʼ��Ϊ0,��ʵ�ǲ����ֶ���ʼ����
		for(int i  = 0; i < s.length(); i++){
			statistic[s.charAt(i) - 'a'] ++;
		}
		for(int i  = 0; i < t.length(); i++){
			if((--statistic[t.charAt(i) - 'a']) < 0)//--��++��λ�ã��ܾö�û���ر��ע�ˣ�ֻҪ���õ��ĵط�һ��Ҫ����
				return false;
		}
		return true;

	}
}
