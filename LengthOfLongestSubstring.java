import java.util.*;
public class LengthOfLongestSubstring {//看了这个我把之前的问题简化的太多了
	public static void main(String args[]){
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	 public static int lengthOfLongestSubstring(String s) {
	        int[] map = new int[256]; // map from character's ASCII to its last occured index
	        Arrays.fill(map, -1);
	        
	        int slow = 0;
	        int fast = 0;
	        int ans = 0;
	        for (fast = 0; fast < s.length(); fast++) {
	            int ch = s.charAt(fast);
	            while (map[ch]!=-1 && slow < fast) {
	                int temp = s.charAt(slow);
	                map[temp] = -1;
	                slow ++;
	            }
	            map[ch] = 0;
	            ans = Math.max(ans, fast-slow + 1);
	        }
	        
	        return ans;
	    }

}
