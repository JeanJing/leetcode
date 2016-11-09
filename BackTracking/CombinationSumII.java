package ArrayT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public static void main(String args[]){
		int []nums = {1,1};
		combinationSum(nums, 2);
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
	}
	
	static int currSum = 0;
	static List<Integer> list = null;
	static List<List<Integer>> result = null;

	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		currSum = 0;
		list = new ArrayList<Integer>();
		result = new ArrayList<List<Integer>>();
		combinationSum_helper(candidates, 0, target);
		return result;
	}

	public static void combinationSum_helper(int[] candidates, int pos,
			int target) {
		for (int i = pos; i < candidates.length; i++) {
			if (i < candidates.length && i > pos
					&& candidates[i] == candidates[i - 1])
				continue;
			if (i < candidates.length) {
				// ���currSum����target�����ҵ�һ����
				if (currSum + candidates[i] == target) {
					list.add(candidates[i]);
					List<Integer> temp = new ArrayList<Integer>(list);
					result.add(temp);
					list.remove(list.size() - 1);
					return;
				} else {
					// �����ǰ�����Ŀ��ֵ�����������������·���ǲ���ȷ��,�ص���һ��ʱ��Ҫ�Ѳ��ԵĽ�ȥ��
					if (currSum + candidates[i] > target) {
						return;
					} else {
						currSum += candidates[i];
						list.add(candidates[i]);
						combinationSum_helper(candidates, i + 1, target);
						currSum -= candidates[i];
						list.remove(list.size() - 1);

					}
				}
			}
		}
	}
}
