import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoveZeros {
	public static void main(String args[]) {
		/*Integer a[] ={1,0,3,0,2};
		ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, a);//前后类型必须一样*/
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
		last = nums.length;// 到last的前一位截止
		int tempForExchange;
		while (first < last) {
			while (first < last && nums[first] != 0)
				// 对参数的要求
				first++;
			// 这里找到first为0的地方
			if (first < last) {
				for (int i = first; i < last - 1; ++i)  {
					nums[i] = nums[i + 1];
				}
				nums[last - 1] = 0;
				//first++;first不应该++因为first当前可能为0
				last--;
			}
		}

	}
}