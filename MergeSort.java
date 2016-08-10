import java.util.*;

public class MergeSort {//ѧ����������̵�˼��
	public   void sort(int a[], int start, int end) {
		int i = 2;// �������ѭ��
		while (i/2 <= end - start + 1) {
			for (int j = 0; j <= end; j += i) {
				if (j < end -i +1)
					merge(a, j, j + i / 2 - 1,  i + j - 1);
				else if(j >= end - i + 1 && j < end -i/2 + 1)
					merge(a, j, j + i / 2 - 1,end);
				else if(j >= end - i/2 +1)
					;
			}
			i *= 2;
		}
			
	}
	public  void merge(int a[], int start, int middle, int end) {// �����middle��������ǰһС�ε�
		int temp[] = new int[end - start + 1];
		int n = 0;
		int i = start, j = middle + 1;
		while (i <= middle && j <= end) {// д�˼���c++�е����
			if (a[i] <= a[j]) {
				temp[n++] = a[i++];
			} else {
				temp[n++] = a[j++];
			}
		}
		while (j > end && i <= middle)
			temp[n++] = a[i++];
		while (i > middle && j <= end)
			temp[n++] = a[j++];
		// �������ص���һ������������aָ������ݲ�û�з����ı䣬���Բ����ԣ�����ǳ����
		// ִ����ȿ�����Ҫ����system.arrayscopy
		System.arraycopy(temp, 0, a, start, temp.length);
	}

}
