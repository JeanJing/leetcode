public class ValidAnagram {
	public static void main(String args[]) {

	}

	public static boolean isAnagram(String s, String t) {
		if(s.length()!= t.length())
			return false;
		int j = 0;//±ê¼Çt
		int s_statistic[] = new int[26];
		for(int i = 0;i < s_statistic.length;i++){
			s_statistic[i] = 0;
		}
		int t_statistic[] = new int[26];
		for(int i = 0;i < t_statistic.length;i++){
			t_statistic[i] = 0;
		}
		
		for(int i  = 0; i < s.length(); i++){
			s_statistic[s.charAt(i) - 'a'] ++;
		}
		for(int i  = 0; i < t.length(); i++){
			t_statistic[t.charAt(i) - 'a'] ++;
		}
		for(int i = 0;i < s_statistic.length;i++){
			if(s_statistic[i]!=t_statistic[i])
				return false;
		}
		return true;

	}
}
