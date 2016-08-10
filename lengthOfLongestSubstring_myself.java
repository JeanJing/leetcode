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
		//用一个while循环控制整个过程
		while(front <= rear && front < length && rear < length){//这个应该是可以优化的
			if(flagCharacter[s.charAt(rear)] ==  -1){
				flagCharacter[s.charAt(rear)] = rear;
				rear ++;
				counter ++;	
			}
			else{
				if(counter > currentLongest)
					currentLongest = counter;//重新设置当前的最大长度
				counter = rear - flagCharacter[s.charAt(rear)];
				int tempFront = front;
				front = flagCharacter[s.charAt(rear)] + 1;
				for(int i = tempFront; i < front -1; i++ ){//不是调整，是真的对结果有影响
					flagCharacter[s.charAt(i)] = -1;//这里可以调整
				}
				flagCharacter[s.charAt(rear)] = rear;//设置标记新的值
				rear++;
			}
			
			
		}
		if(currentLongest < counter)
			currentLongest = counter;

		return currentLongest;
		
	}

}
