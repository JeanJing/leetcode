package WordLadder;
import java.util.*;
public class WordLadder_writeMyself {
	public static void main(String args[]){
		String words[] = {"hot","dog","lot","log"};
		Set<String> wordList = new HashSet<String>(Arrays.asList(words));//�����Լ�Խ��Խ���java�ˣ��ð�ѽ
		System.out.println(ladderLength( "hit","cog",wordList));
	}
	public static int ladderLength(String begin, String end, Set<String> wordList){
		Set<String> beginSet = new HashSet<String>(),
				endSet = new HashSet<String>();//����д���룬�����գ�������ͬʱ��ʼ��
		
		Set<String> visited = new HashSet<String>();//��¼�����Ƿ�������������
		int len = 1;//��¼�任���еĳ���
		
		beginSet.add(begin);
		endSet.add(end);
		while(!beginSet.isEmpty() && !endSet.isEmpty()){
			//��Ϊ��begin��end����������мбƣ�����ÿ��ֻ��beginSet���д�������Ϊ��Ч��Ӧ��ÿ�ζ��Զ̵ļ��ϴ������԰ѵ�ǰ�����ٵļ�����Ϊ��ǰ����
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
						word_to[i] = ch;//�����ı�һ���ַ�����ĳ���ַ�ֻ�����������
						String target = String.valueOf(word_to);
						if(endSet.contains(target))
							return len + 1;//������ѭ������ʲô�����ҵ�ǰ���ʵ��ڽ����ʣ�
						                   //��ô������Ҫ�ľ����ж�һ�����ʵ��ڽ������Ƿ���wordlist��
						                   //д������򣬸������Ҷ��������ļ��䣬�����ٺ���
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
