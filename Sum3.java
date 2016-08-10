import java.util.*;

public class Sum3 {
	public static void main(String args[]) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		int nums[] = { 0, 0, 0, 0, 0, 1, -1 };
		list = threeSum(nums);
		System.out.println(list);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
	//MergeSort ms = new MergeSort();
    //ms.sort(nums, 0, nums.length -1);//对数组排序
	Arrays.sort(nums);//排序对最后的结果是非常重要的
	//处理特殊情况
	int left, right, sum;
	if(nums == null || nums.length < 3)
		return list;
	for(int i = 0; i < nums.length - 2; i ++ ){
		if(i != 0  && nums[i] == nums[i - 1])//i如果是0的话是不可以是不可以skip的
			continue;//推出当前循环
		left = i + 1;
		right = nums.length - 1;
		
		//计算当前值对应的3sum值
		while(left < right){
			sum = nums[left] + nums[right] + nums[i];
			if(sum == 0){
				List<Integer> l = new LinkedList<Integer>();
				l.add(nums[i]);
				l.add(nums[left]);
				l.add(nums[right]);
				list.add(l);
				right--;
				left++;
                while(left < right && nums[right] == nums[right + 1]){//skip重复出现的元素
					right--;
				}
                while(left < right && nums[left] == nums[left - 1]){//skip重复出现的元素
                	left++;
                }
			}else if(sum > 0){
				right--;
			}else{
				left++;
			}
			
		}	
	}
	return list;
        
    }
}
