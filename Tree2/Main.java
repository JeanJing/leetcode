package Tree2;

import java.util.*;
//������Լ����Ǵ����˱߽��ϣ����Լ���Щ�����ʱ����һ��ѭ�����ҵ�ĳһ��ֵ����ѭ����������break���´β�Ҫ��
public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] data = new int[n];

		for (int i = 0; i < n; i++) {
			data[i] = in.nextInt();
		}

		int start = n;
		for (int i = 0; i < n - 1; i++) {
			if (data[i] > data[i + 1]){
				start = i;
				break;
			}
		}

		int end = -1;
		for (int i = start; i < n - 1; i++) {
			if (data[i] < data[i + 1]){
				end = i;
				break;
			}
		}
		boolean flag = true;
		if (end == -1)
			end = n - 1;
		if (start == n) {
			flag = true;
		} else {
			if (start > 0)
				if (data[end] < data[start - 1])
					flag = false;
			if (end < n - 1)
				if (data[start] > data[end + 1])
					flag = false;
		}
		if (flag)
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
