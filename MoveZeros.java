import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoveZeros {
	public static void main(String args[]) {
		/*Integer a[] ={1,0,3,0,2};
		ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, a);//ǰ�����ͱ���һ��*/
		int a[] ={0,1,0,3,12};
		moveZeroes(a);
		for(int n : a){
		System.out.print(n + " ");
		}
		System.out.println();
	}

	public static void moveZeroes(int[] nums) {
		int first, last;
		first = 0;
		last = nums.length;// ��last��ǰһλ��ֹ
		int tempForExchange;
		while (first < last) {
			while (first < last && nums[first] != 0)
				// �Բ�����Ҫ��
				first++;
			// �����ҵ�firstΪ0�ĵط�
			if (first < last) {
				for (int i = first; i < last - 1; ++i)  {
					nums[i] = nums[i + 1];
				}
				nums[last - 1] = 0;
				//first++;first��Ӧ��++��Ϊfirst��ǰ����Ϊ0
				last--;
			}
		}

	}
}