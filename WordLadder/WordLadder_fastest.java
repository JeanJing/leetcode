package WordLadder;
import java.util.*;
public class WordLadder_fastest {
	public static void main(String args[]){
		String words[] = {"hot","dog","lot","log"};
		Set<String> wordList = new HashSet<String>(Arrays.asList(words));//觉得自己越来越理解java了，好棒呀
		System.out.println(ladderLength( "hit","cog",wordList));
	}
	public static int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

	    int len = 1;
	    int strLen = beginWord.length();
	    HashSet<String> visited = new HashSet<String>();
        
	    //这个版本是双端的深度优先算法，会有两个集合，一个开始集合，一个结束集合
	    beginSet.add(beginWord);
	    endSet.add(endWord);
	    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
	        if (beginSet.size() > endSet.size()) {//如果开始集合的容量大于结束集合的容量，就交换，也就是说结束集合的容量比开始集合的大
	        	                                  //这样做的目的是什么呢？ 
	            Set<String> set = beginSet;
	            beginSet = endSet;
	            endSet = set;
	        }

	        Set<String> temp = new HashSet<String>();
	        for (String word : beginSet) {
	            char[] chs = word.toCharArray();
//遍历开始集合中的每一个字符串
	            for (int i = 0; i < chs.length; i++) {
	                for (char c = 'a'; c <= 'z'; c++) {
	                	//把字符串中每一个字符都用字母表中的每个字符替换掉得到一个字符串target
	                    char old = chs[i];
	                    chs[i] = c;
	                    String target = String.valueOf(chs);
  
	                    if (endSet.contains(target)) {//然后判断该字符串target是否包含在end集合里
	                        return len + 1;//这里很关键一旦end集合包含这个字符串，就可以直接return结果了，这里很关键
	                    }//包含直接返回
	                    
                        //不包含的话，如果该单词没有访问过，并且包含在单词列表中
	                    if (!visited.contains(target) && wordList.contains(target)) {
	                        temp.add(target);//保存到temp中
	                        visited.add(target);//visited中也要标记
	                    }
	                    chs[i] = old;//然后把chs变成原来的样子
	                }
	            }
	        }

	        beginSet = temp;//把temp设置为begin集合,之前begin里面的内容就被覆盖掉了
	        len++;//len++
	    }
		return 0;

	}
}
