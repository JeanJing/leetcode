package BitManipulation;

public class SingleNumber {
	public static void main(String args[]){
		int nums[] = {1,2,3,1,2};
		System.out.println(singleNumber(nums));
		
	}
	//����ٶ���������Ϊ3
    public static int singleNumber(int[] nums) {
        int data = nums[0];
        for(int i = 1; i < nums.length; i++){
        	data  = data ^ nums[i];
        }
        return data;
    }
}
