import java.util.Arrays;


public class lengthOfLongestSubstring_myself {
	public static void main(String args[]){
		System.out.println(lengthOfLongestSubstring("ejtdfngsdnnkgpkvtigsq"));
		
	}
	public static int lengthOfLongestSubstring(String s){
		int front = 0;
		int rear = 0;
		int length = s.length();
		int flagCharacter[] = new int[156];
		Arrays.fill(flagCharacter, -1);
		if(length == 0)
			return 0;
		int currentLongest = 1;
		int counter = 0;
		//��һ��whileѭ��������������
		while(front <= rear && front < length && rear < length){//���Ӧ���ǿ����Ż���
			if(flagCharacter[s.charAt(rear)] ==  -1){
				flagCharacter[s.charAt(rear)] = rear;
				rear ++;
				counter ++;	
			}
			else{
				if(counter > currentLongest)
					currentLongest = counter;//�������õ�ǰ����󳤶�
				counter = rear - flagCharacter[s.charAt(rear)];
				int tempFront = front;
				front = flagCharacter[s.charAt(rear)] + 1;
				for(int i = tempFront; i < front -1; i++ ){//���ǵ���������ĶԽ����Ӱ��
					flagCharacter[s.charAt(i)] = -1;//������Ե���
				}
				flagCharacter[s.charAt(rear)] = rear;//���ñ���µ�ֵ
				rear++;
			}
			
			
		}
		if(currentLongest < counter)
			currentLongest = counter;

		return currentLongest;
		
	}

}
