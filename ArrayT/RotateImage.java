package ArrayT;

public class RotateImage {
	public static void main(String []args){
		int [][]matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotate3(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
        	return;
        int n = matrix.length;
        int [][]newMatrix = new int[n][n];
        for(int i  = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		newMatrix[j][n - 1 - i] = matrix[i][j];
        	}
        }
        for(int i  = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		matrix[i][j] = newMatrix[i][j];
        	}
        }
    }
	public static void rotate2(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
        	return;
        int n = matrix.length;
        int mid = 0 + (n - 1) / 2;
        for(int i = 0; i <= mid; i++){
        	int curr = matrix[0][n - 1 - i];
        	matrix[0][n - 1 - i] = matrix[i][0];
        	int row = n - 1 - i;
        	int col = n - 1;
        	while(row != 0 || col != n - 1 - i){
        		int temp = matrix[row][col];
        		matrix[row][col] = curr;
        		curr = temp;
        		int tempRow = row;
        		row = col;
        	    col = n - 1 - tempRow;
        	}
        }
    }
	public static void rotate3(int[][] matrix) {
		transposition(matrix);
		symmetry(matrix);
	}
	public static void transposition(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void symmetry(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}
	}
}
