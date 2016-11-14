package ArrayT;

import java.util.*;

public class SpiralMatrix {
	public static void main(String args[]){
		int [][]matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println(spiralOrder(matrix));
	}
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return result;
		int m = matrix.length;
		int n = matrix[0].length;

		int numberOfLoop = (Math.min(m, n) + 1) / 2;
		for (int i = 0; i < numberOfLoop; i++) {
			int belowRow = m - 1 - i;// �����ж�Ӧ���������
			int rightCol = n - 1 - i;// �����ж�Ӧ���������

			// �жϵ�ǰ���Ƿ������һ��
			if (i == belowRow) {
				for (int j = i; j <= rightCol; j++)
					result.add(matrix[i][j]);
			} else {
				if (i == rightCol) {
					for (int j = i; j <= belowRow; j++)
						result.add(matrix[j][i]);
				} else {
					for(int j = i; j < rightCol; j++){
						result.add(matrix[i][j]);
					}
					for(int j = i; j < belowRow; j++){
						result.add(matrix[j][rightCol]);
					}
					for(int j = rightCol; j > i; j--){
						result.add(matrix[belowRow][j]);
					}
					for(int j = belowRow; j > i; j--){
						result.add(matrix[j][i]);
					}
				}
			}

		}
		return result;

	}
}
