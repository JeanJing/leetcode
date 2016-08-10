package WordLadder;
import java.util.*;
public class WordLadder_writeMyself {
	public static void main(String args[]){
		String words[] = {"hot","dog","lot","log"};
		Set<String> wordList = new HashSet<String>(Arrays.asList(words));//觉得自己越来越理解java了，好棒呀
		System.out.println(ladderLength( "hit","cog",wordList));
	}
	public static int ladderLength(String begin, String end, Set<String> wordList){
		Set<String> beginSet = new HashSet<String>(),
				endSet = new HashSet<String>();//这样写代码，更紧凑，声明的同时初始化
		
		Set<String> visited = new HashSet<String>();//记录单词是否已在序列里面
		int len = 1;//记录变换序列的长度
		
		beginSet.add(begin);
		endSet.add(end);
		while(!beginSet.isEmpty() && !endSet.isEmpty()){
			//因为从begin和end两个方向进行夹逼，但是每次只对beginSet进行处理，所以为了效率应该每次都对短的集合处理，所以把当前容量少的集合作为当前集合
			if(beginSet.size() < endSet.size()){
				Set<String> set = beginSet;
				beginSet = endSet;	
			}
			Set<String> temp = new HashSet<String>();
			for(String word : beginSet){
				char word_to[] = word.toCharArray();
				for(int i = 0; i < word_to.length; i++){
					for(char ch = 'a'; ch <= 'z'; ch++){
						char old = word_to[i];
						word_to[i] = ch;//看来改变一个字符串的某个字符只有这个方法了
						String target = String.valueOf(word_to);
						if(endSet.contains(target))
							return len + 1;//这三层循环在做什么，在找当前单词的邻近单词，
						                   //那么最最重要的就是判断一个单词的邻近单词是否在wordlist，
						                   //写这个程序，更多是我对这个程序的记忆，理解很少很少
						if(!visited.contains(target) && wordList.contains(target)){//!temp.contains(target)){
							visited.add(target);
							temp.add(target);
						}
						word_to[i] = old;
					}
				}
			}
			beginSet = temp;
			len++;
		}
		
		
		return 0;
		
	}
}
