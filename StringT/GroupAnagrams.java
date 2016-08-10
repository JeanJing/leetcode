package StringT;

import java.util.*;

public class GroupAnagrams {
	public static void main(String args[]) {
		String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };

		System.out.println(anagrams(strs));
	}
	public static List<List<String>> groupAnagrams_37ms(String []strs){
		if(strs == null || strs.length == 0)
			return null;
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String,List<String>> map = new HashMap<String,List<String>>();
		Arrays.sort(strs);
		for(int i = 0; i < strs.length; i++){
			char []s = strs[i].toCharArray();
			Arrays.sort(s);
			String str = String.valueOf(s);
			if(map.containsKey(str)){
				map.get(str).add(strs[i]);
			}else{
				List<String> list = new LinkedList<String>();
				list.add(strs[i]);
				map.put(str,list);
			}
		}
		for(List<String> list : map.values()){
			result.add(list);
		}
		return result;
	}
	public List<List<String>> groupAnagrams_24ms(String[] strs) {
	    HashMap<String, List<String>> map = new HashMap();
	    for (String s : strs) {
	        char[] ar = s.toCharArray();
	        Arrays.sort(ar);
	        String sorted = String.valueOf(ar);
	        List<String> list = map.get(sorted);
	        if (list == null) list = new ArrayList<String>();
	        list.add(s);
	        map.put(sorted, list);
	    }
	    List<List<String>> res = new ArrayList();
	    for (List<String> l : map.values()) {
	        Collections.sort(l);
	        res.add(l);
	    }
	    return res;
	}

	public static List<List<String>> groupAnagrams_TLE(String[] strs) {
		if (strs == null || strs.length == 0)
			return null;
		List<List<String>> result = new ArrayList<List<String>>();// 要不设定初始容量
		for (int i = 0; i < strs.length; i++) {
			final String str = strs[i];
			int j = 0;
			boolean flagInserted = false;
			for (; j < result.size(); j++) {
				String head = result.get(j).get(0);
				if (anagram(strs[i], head)) {// 如果是就插入
					result.get(j).add(strs[i]);
					flagInserted = true;
					break;
				}

			}
			if (j == result.size() && !flagInserted)
				result.add(new LinkedList<String>() {
					{
						add(str);
					}
				});
		}
		for (int i = 0; i < result.size(); i++) {
			Collections.sort(result.get(i));
		}

		return result;
	}

	public static boolean anagram(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s.length() != t.length())
			return false;
		int map[] = new int[256];
		Arrays.fill(map, 0);
		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
			map[t.charAt(i)]--;
		}
		for (int i = 0; i < map.length; i++) {
			if (map[i] != 0)
				return false;
		}
		return true;
	}

	public boolean anagram_sort(String s, String t) {
		if (s == null || t == null)
			return false;
		char[] s_array = s.toCharArray();
		char[] t_array = t.toCharArray();
		Arrays.sort(s_array);
		Arrays.sort(t_array);
		s = String.valueOf(s_array);
		t = String.valueOf(t_array);
		if (s.equals(t))
			return true;
		else
			return false;
	}
	private static int getHash(int[] count) {
        int hash = 0;
        int a = 378551;
        int b = 63689;
        for (int num : count) {
            hash = hash * a + num;
            a = a * b;
        }
        return hash;
    }
    
    public static List<List<String>> anagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            int hash = getHash(count);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }

            map.get(hash).add(str);
        }

        for (List<String> tmp : map.values()) {
        	Collections.sort(tmp);
            result.add(tmp);
        }

        return result;
    }
}
