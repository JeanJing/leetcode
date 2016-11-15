package ArrayT;

public class SetMatrixZeroes {
	public static void main(String args[]){
		int [][]matrix = {{0,1,0},{1,1,1},{1,1,0}};
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		setZeroesInPlace(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void setZeroes(int[][] matrix) {
       if(matrix == null || matrix.length == 0)
    	   return;
       int m = matrix.length;
       int n = matrix[0].length;
       int [][]newMatrix = new int[m][n];
       for(int i = 0; i < m; i++){
    	   for(int j = 0; j < n; j++){
    		   newMatrix[i][j] = matrix[i][j];
    	   }
       }
       for(int i = 0; i < m; i++){
    	   for(int j = 0; j < n; j++){
    		   if(matrix[i][j] == 0){
    			   for(int k = 0; k < n; k++)
    				   newMatrix[i][k] = 0;
    			   for(int k = 0; k < m; k++)
    				   newMatrix[k][j] = 0;
    		   }
    	   }
       }
       for(int i = 0; i < m; i++){
    	   for(int j = 0; j < n; j++){
    		   matrix[i][j] = newMatrix[i][j];
    	   }
       }
    }
	public static void setZeroes_inPlace(int[][] matrix) {//如果这个矩阵是0/1矩阵
	       if(matrix == null || matrix.length == 0)
	    	   return;
	       int m = matrix.length;
	       int n = matrix[0].length;
	       for(int i = 0; i < m; i++){
	    	   for(int j = 0; j < n; j++){
	    		   if(matrix[i][j] == 0){
	    			   for(int k = 0; k < n; k++){
	    				  if(matrix[i][k] != 0){
	    					  matrix[i][k] = 2;
	    				  }
	    			   }
	    				   
	    			   for(int k = 0; k < m; k++){
	    				   if(matrix[k][j] != 0){
		    					  matrix[k][j] = 2;
		    				  }
	    			   }
	    		   }
	    	   }
	       }
	       
	       for(int i = 0; i < m; i++){
	    	   for(int j = 0; j < n; j++){
	    		   matrix[i][j] %=2;
	    	   }
	       }
	       
	}
	public static void setZeroes_2(int[][] matrix) {//如果这个矩阵是0/1矩阵
	       if(matrix == null || matrix.length == 0)
	    	   return;
	       int m = matrix.length;
	       int n = matrix[0].length;
	       boolean []flag = new boolean[m + n];
	       //遍历矩阵记录哪一行，那一列需要被置为0
	       for(int i = 0; i < m; i++){
	    	   for(int j = 0; j < n; j++){
	    		   if(matrix[i][j] == 0){
	    			   flag[i] = true;
	    			   flag[m + j] = true;
	    		   }
	    			   
	    	   }
	       }
	       for(int i = 0; i < m; i++){
	    	   if(flag[i]){
	    		   for(int j = 0; j < n; j++)
	    			   matrix[i][j] = 0;
	    	   }
	    		   
	       }
	       for(int i = m; i < m+n; i++){
	    	   if(flag[i]){
	    		   for(int j = 0; j < m; j++)
	    			   matrix[j][i- m] = 0;
	    	   }
	       } 
	}
	public static void setZeroesInPlace(int[][] matrix) {//如果这个矩阵是0/1矩阵
	       if(matrix == null || matrix.length == 0)
	    	   return;
	       int m = matrix.length;
	       int n = matrix[0].length;
	       boolean flagRow = false;
	       boolean flagCol = false;
	       
	       //遍历矩阵记录哪一行，那一列需要被置为0
	       for(int i = 0; i < m; i++){
	    	   for(int j = 0; j < n; j++){
	    		   if(i == 0 && matrix[i][j] == 0)
	    			   flagRow = true;
	    		   if(j == 0 && matrix[i][j] == 0)
	    			   flagCol = true;   
	    		   if(matrix[i][j] == 0){
	    			   matrix[i][0] = 0;
	    			   matrix[0][j] = 0;
	    		   }
	    			   
	    	   }
	       }
	       //通过判断第一行来确定每一列是否被置为0
	       for(int i = 1; i < n; i++){
	    	   if(matrix[0][i] == 0)
	    		   for(int j = 1; j < m; j++ )
	    			   matrix[j][i] = 0;
	       }
	       for(int i = 1; i < m; i++){
	    	   if(matrix[i][0] == 0)
	    		   for(int j = 1; j < n; j++ )
	    			   matrix[i][j] = 0;
	       }
	       if(flagRow){
	    	   for(int i = 0; i < n; i++ )
    			   matrix[0][i] = 0;
	       }
	       if(flagCol){
	    	   for(int i = 0; i < m; i++ )
    			   matrix[i][0] = 0;
	       }
	    	   
	}
}
