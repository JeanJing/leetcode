public class AddDight {
	
	
	public static void main(String args[]) {
		System.out.println(addDigits(2112345678));
	}

	public static int addDigits(int num) {

		while (num / 10 != 0) {
			int sum = 0;
			while (num != 0) {//���������ʼ��ʱ����num/10 != 0��
				              //�����Ļ����һλ��û�а취��ã������ж���������ֹ״̬�Ƿǳ���Ҫ��
				sum += num % 10;
				num /= 10;
			}
			num = sum;
	}
		return num;

	}
}
