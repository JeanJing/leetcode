package ArrayT;

import java.util.*;


public class SpiralMatrixII {
   public static void main(String args[]){
		int [][]matrix = generateMatrix(5);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
   }
   public static int[][] generateMatrix(int n) {
	    int[][] matrix = null;
		if (n == 0)
			return matrix;
		matrix = new int[n][n];
	
		int numberOfLoop = (n + 1) / 2;
		int count = 0;
		for (int i = 0; i < numberOfLoop; i++) {
			int respect = n - 1 - i;// 对应的行或者列

			// 判断当前行是否是最后一行
			if (i == respect) {
				for (int j = i; j <= respect; j++)
					matrix[i][j] = ++count;
			} else {
					for(int j = i; j < respect; j++){
						matrix[i][j] = ++count;
					}
					for(int j = i; j < respect; j++){
						matrix[j][respect] = ++count;
					}
					for(int j = respect; j > i; j--){
						matrix[respect][j] = ++count;
					}
					for(int j = respect; j > i; j--){
						matrix[j][i] = ++count;;
					}
				}
			}
		return matrix;

	}

}
