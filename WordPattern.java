import java.util.*;

public class WordPattern {
	public static void main(String args[]) {
		String str = "jing zhen yan is a good girl";
		String nums[] = str.split(" ");// 也可以通过// 来区别
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		System.out.println(nums[nums.length - 1]);
		Map<Character, String> map = new TreeMap<Character, String>();
		map.put('a', "jingzhenayn");
		map.put('a', "zhendfda");// 它把之前那个替换掉了
		System.out.println(map);
		System.out.println(wordPattern("abab", "dog dog dog dog"));
	}

	public static boolean wordPattern(String pattern, String str) {
		String strPatternSet[] = str.split("\\ ");
		int numOfPattern = pattern.length();
		char partternToArray[] = pattern.toCharArray();
		Map<Character, String> bijection = new TreeMap<Character, String>();// map有几种类型
		if (numOfPattern != strPatternSet.length)
			return false;
		else {
			for (int i = 0; i < numOfPattern; i++) {
				if (bijection.containsKey(partternToArray[i])) {
					if ((bijection.get(partternToArray[i]))
							.compareTo(strPatternSet[i]) != 0)// 犯了一个严重的错误，就是用==来判断字符串是否相等，字符串是引用对象不是
						return false;
				} else {
					if (bijection.containsValue(strPatternSet[i]))
						return false;
					else {
						bijection.put(partternToArray[i], strPatternSet[i]);
					}
				}
			}

		}

		return true;

	}
}
