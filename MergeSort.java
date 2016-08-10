import java.util.*;

public class MergeSort {//学会面向对象编程的思想
	public   void sort(int a[], int start, int end) {
		int i = 2;// 控制外层循环
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
	public  void merge(int a[], int start, int middle, int end) {// 这里的middle都是属于前一小段的
		int temp[] = new int[end - start + 1];
		int n = 0;
		int i = start, j = middle + 1;
		while (i <= middle && j <= end) {// 写了几天c++有点混了
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
		// 这样返回的是一个副本，数组a指向的内容并没有发生改变，所以不可以，这是浅拷贝
		// 执行深度拷贝，要利用system.arrayscopy
		System.arraycopy(temp, 0, a, start, temp.length);
	}

}
