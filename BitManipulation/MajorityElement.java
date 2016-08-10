package BitManipulation;

public class MajorityElement {
	public static void main(String args[]){
		System.out.println(majorityElement(new int[]{2,3,2,1,2,1,2}));
	}
	public static int majorityElement(int[] nums) {
		int k = nums[0];
		int count = 0;
		for(int i = 0; i < nums.length; i++){
			if(k == nums[i]){
				count++;
			}else{
				if(count == 0){
					k = nums[i];
					count = 1;
				}else{
					count--;
				}
			}
		}
		return k;

	}
}
