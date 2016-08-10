package StringT;
import java.util.*;

public class TwoStringsAreAnagrams {
	public static void main(String args[]){
		long start,end;
		String s = "jingzhenyanjiayoumeiyouwenti";
		String t = "jinguweanjzhyontienyumeiyoia";
		start = System.currentTimeMillis();
		for(int i = 0;i < 100000; i++){
			anagram_hashmap(t,s);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		start = System.currentTimeMillis();
		for(int i = 0;i < 100000; i++){
			anagram_sort(t,s);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	public static boolean anagram_hashmap(String s, String t) {
		if(s == null || t == null)
			return false;
		if(s.length() != t.length())
			return false;
		int map[] = new int[256];
		Arrays.fill(map, 0);
		for(int i = 0; i < s.length(); i++){
			map[s.charAt(i)]++;
			map[t.charAt(i)]--;
		}
		for(int i = 0; i < map.length; i++){
			if(map[i] != 0)
				return false;
		}
		return true;
    }
	public static boolean anagram_sort(String s, String t) {
		if(s == null || t == null)
			return false;
		char []s_array = s.toCharArray();
		char []t_array = t.toCharArray();
	    Arrays.sort(s_array);
	    Arrays.sort(t_array);
	    s= String.valueOf(s_array);
	    t = String.valueOf(t_array);
	    if(s.equals(t))
	    	return true;
	    else
	    	return false;
	}
	
}
