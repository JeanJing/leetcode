package WordLadder;
import java.util.*;
public class WordLadder_fastest {
	public static void main(String args[]){
		String words[] = {"hot","dog","lot","log"};
		Set<String> wordList = new HashSet<String>(Arrays.asList(words));//�����Լ�Խ��Խ���java�ˣ��ð�ѽ
		System.out.println(ladderLength( "hit","cog",wordList));
	}
	public static int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

	    int len = 1;
	    int strLen = beginWord.length();
	    HashSet<String> visited = new HashSet<String>();
        
	    //����汾��˫�˵���������㷨�������������ϣ�һ����ʼ���ϣ�һ����������
	    beginSet.add(beginWord);
	    endSet.add(endWord);
	    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
	        if (beginSet.size() > endSet.size()) {//�����ʼ���ϵ��������ڽ������ϵ��������ͽ�����Ҳ����˵�������ϵ������ȿ�ʼ���ϵĴ�
	        	                                  //��������Ŀ����ʲô�أ� 
	            Set<String> set = beginSet;
	            beginSet = endSet;
	            endSet = set;
	        }

	        Set<String> temp = new HashSet<String>();
	        for (String word : beginSet) {
	            char[] chs = word.toCharArray();
//������ʼ�����е�ÿһ���ַ���
	            for (int i = 0; i < chs.length; i++) {
	                for (char c = 'a'; c <= 'z'; c++) {
	                	//���ַ�����ÿһ���ַ�������ĸ���е�ÿ���ַ��滻���õ�һ���ַ���target
	                    char old = chs[i];
	                    chs[i] = c;
	                    String target = String.valueOf(chs);
  
	                    if (endSet.contains(target)) {//Ȼ���жϸ��ַ���target�Ƿ������end������
	                        return len + 1;//����ܹؼ�һ��end���ϰ�������ַ������Ϳ���ֱ��return����ˣ�����ܹؼ�
	                    }//����ֱ�ӷ���
	                    
                        //�������Ļ�������õ���û�з��ʹ������Ұ����ڵ����б���
	                    if (!visited.contains(target) && wordList.contains(target)) {
	                        temp.add(target);//���浽temp��
	                        visited.add(target);//visited��ҲҪ���
	                    }
	                    chs[i] = old;//Ȼ���chs���ԭ��������
	                }
	            }
	        }

	        beginSet = temp;//��temp����Ϊbegin����,֮ǰbegin��������ݾͱ����ǵ���
	        len++;//len++
	    }
		return 0;

	}
}
