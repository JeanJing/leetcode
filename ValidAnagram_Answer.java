
public class ValidAnagram_Answer {
	public static void main(String args[]){
		String a ="a";
		String b = "b";
		System.out.println(isAnagram(a,b));
	}
	public static boolean isAnagram(String s, String t) {
		if(s.length()!= t.length())
			return false;
		int j = 0;//标记t
		int statistic[] = new int[26];//但不调试，系统自动给初始化为0,其实是不用手动初始化的
		for(int i  = 0; i < s.length(); i++){
			statistic[s.charAt(i) - 'a'] ++;
		}
		for(int i  = 0; i < t.length(); i++){
			if((--statistic[t.charAt(i) - 'a']) < 0)//--和++的位置，很久都没有特别关注了，只要是用到的地方一定要想想
				return false;
		}
		return true;

	}
}
