public class lCPrefix {
	public static void main(String args[]) {
		String[] strs = {"pretix","predsafdfadsfa","predfasfdsa","prefdsafd","predfasd","predasfhdjfhsaj"};
		System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		String lcPrefix = strs[0];
		int cunrrent_length_of_lc = strs[0].length();
		int length;
		for (int i = 1; i < strs.length; i++) {
			length = cunrrent_length_of_lc < strs[i].length() ? cunrrent_length_of_lc
					: strs[i].length();// 结果必须赋值
			for (int j = 0; j < length; j++) {
				if (strs[i].charAt(j) != lcPrefix.charAt(j)) {
					lcPrefix = lcPrefix.substring(0, j);// 子串为i-1
					cunrrent_length_of_lc = lcPrefix.length();
					break;
				}
			}
		}
		return lcPrefix;

	}

}
