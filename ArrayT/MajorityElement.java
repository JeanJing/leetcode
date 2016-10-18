package ArrayT;

public class MajorityElement {
	public static void main(String args[]) {
		int[] data = {1,2,1,2,1};
		majorityElement(data);
		//for (int i = 0; i < data.length; i++) {
		//	System.out.print(data[i] + " ");
		//}
		System.out.println(majorityElement(data));
	}
	public static int majorityElement(int[] nums){
		int data, count;
		count = 0;
		data = nums[0];
		for(int i = 0; i < nums.length; i++){
			if(data == nums[i])
				count++;
			else
				count--;
			if(count == 0){
				if(i < nums.length)
				data = nums[i+1];
			}
		}
		return data;
	}
	/*public static int majorityElement_erro(int[] nums) {
		int data, count;
		data = nums[0];
		count = 1;
		int maxCount = 0;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] == nums[i - 1])
				count++;
			else{
				if(count > maxCount){
					data = nums[i - 1];
					maxCount = count;
				}
				count = 1;
			}	
		}
		if(count > maxCount){
			data = nums[nums.length - 1];
			maxCount = count;
		}
        return data;
    }*/
}
