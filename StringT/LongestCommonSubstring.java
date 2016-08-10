package StringT;

public class LongestCommonSubstring {
	public static void main(String args[]){
		
		String s = ".cocm";
		String t = ".cox.coc";
		System.out.println(longestCommonSubstring(s,t));

	}
	
	public static int longestCommonSubstring(String A, String B) {
        if(A == null || B== null)
        	return 0;
        char []a = A.toCharArray();
        char []b = B.toCharArray();
        int longestCommonLength = 0;
        for(int start = 0; start  < a.length; start++){
        	int j = 0;
        	while( j < b.length && a[start] != b[j])
        		j++;
        	int i = start;
        	int length = 0;
        	while(j < b.length && i < a.length){
        		if(a[i++] == b[j++])
        			length ++;
        		else{
        			if(length > longestCommonLength)
                		longestCommonLength = length;
        			length = 0;
        			i = start;
        			
        		}
        	}
        	if(length > longestCommonLength)
        		longestCommonLength = length;
        		
        }
        return longestCommonLength;
    }

}
