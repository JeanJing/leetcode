package String;

public class WildcardMatching {
	public static void  main(String args[]){
		System.out.println(countAndSay(6));
	}
	public static String countAndSay(int n) {
        if (n <= 0) return null;

        String s = "1";
        for (int i = 1; i < n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            int sLen = s.length();
            for (int j = 0; j < sLen; j++) {
                if (j < sLen - 1 && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                } else {
                    sb.append(count + "" + s.charAt(j));
                    // reset
                    count = 1;
                }
            }
            s = sb.toString();
        }

        return s;
    }
}
