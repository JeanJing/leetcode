package ArrayT;

public class RemoveElement {
	public static void main(String args[]) {
		int[] data = {2,3,2,2,3,3};
		System.out.println(removeElement_2(data,3));
	}
	//这个借用的是快排中的一种解决框架
	public static int removeElement_1(int[] nums, int val) {
		if(nums == null || nums.length == 0)
			return 0;
		int i,j;
		i = 0;
		j = nums.length - 1;
		while(i < j){
			while(i < j && nums[i] != val)
				i++;
			while(i < j &&nums[j] == val)
				j--;
			if(i != j){
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
			}
		} 
		if(nums[i] == val)
			return i;
		return i + 1;
	}
	//借用快排中的之前的框架，也是双指针，不过两个指针都是从数组的头部开始的
	public static int removeElement_2(int[] nums, int val) {
		if(nums == null || nums.length == 0)
			return 0;
		int i,j;
		i = -1;
		j = -1;
		
		for(int k = 0; k < nums.length; k++){
			 if(nums[k] == val){
				 j++;
			 }else{
				 if(j == -1){
					 i = k;
				 }else{
					 int temp = nums[i + 1];
					 nums[k] = temp;
					 nums[i + 1] = k;
					 i++;
					 j++;
				 }
					 
			 }
		}
		return i + 1;
	}
}
