package BitManipulation;
//利用位操作，最大的好处是没有用额外的内存
public class SingleNumber2 {
	public static void main(String args[]){
		int nums[] = {1,2,3,1,2,1,2,3,3,4};
		//System.out.println(Integer.SIZE);//Integer.SIZE表明int类型的bit数
		System.out.println(singleNumber(nums));
		
	}
	//对每一位进行处理
public static int singleNumber(int[] nums) {
      int result = 0, bit_i_sum = 0;

      for (int i = 0; i != Integer.SIZE; ++i) {
          bit_i_sum = 0;
          for (int j = 0; j != nums.length; ++j) {
              // get the *i*th bit of nums 得到数组nums中每个数的第i位并求其和
              bit_i_sum += ((nums[j] >> i) & 1);
          }
          // set the *i*th bit of result
          result |= ((bit_i_sum % 3) << i);
      }

      return result;
    }
}
