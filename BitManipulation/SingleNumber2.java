package BitManipulation;
//����λ���������ĺô���û���ö�����ڴ�
public class SingleNumber2 {
	public static void main(String args[]){
		int nums[] = {1,2,3,1,2,1,2,3,3,4};
		//System.out.println(Integer.SIZE);//Integer.SIZE����int���͵�bit��
		System.out.println(singleNumber(nums));
		
	}
	//��ÿһλ���д���
public static int singleNumber(int[] nums) {
      int result = 0, bit_i_sum = 0;

      for (int i = 0; i != Integer.SIZE; ++i) {
          bit_i_sum = 0;
          for (int j = 0; j != nums.length; ++j) {
              // get the *i*th bit of nums �õ�����nums��ÿ�����ĵ�iλ�������
              bit_i_sum += ((nums[j] >> i) & 1);
          }
          // set the *i*th bit of result
          result |= ((bit_i_sum % 3) << i);
      }

      return result;
    }
}
