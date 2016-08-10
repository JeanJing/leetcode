public class ContainerWithMostWater {
	public static void main(String args[]){
		int data[] = new int[15000];
		for(int i =0; i < data.length; i++){
			data[i] = i;
		}
		int height[] ={1,2,1};
		long startTime = System.currentTimeMillis();
		System.out.println(maxArea_n(height));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
	public static int maxArea_n(int[] height) {//线性时间实现
		int max_area = 0;
		int area = 0;
		int right = height.length - 1 ;
		int left = 0;
		
		while(left < right){
			area =(right - left)* (height[right] < height[left] ? height[right] : height[left]);//面积的大小取决于高度小的那个
		    //得到一个当前的area
			if(area > max_area)
				max_area = area;
			if(height[right] < height[left]){
				do{
					right--;
				}while(right > left && height[right + 1] >= height[right]);
				
			}else{
				do{
					left++;
				}while(right > left && height[left] <= height[left - 1]);
				
				
			}
			
			
		} 
		
		return max_area;
	}
	
	 public static int maxArea_nn(int[] height) {//时间超出了
		 int area = 0;
		 int width = 0;
		 int max_area = 0;
		 
		 for(int i = 0; i < height.length; i++){
			 for(int j = i + 1; j < height.length; j++){
				 if(height[i] < height[j]){
					 width = height[i];		 
				 }
				 else{
					 width = height[j];
				 }
				 
				 area = width * (j - i);
				 if(area > max_area){
					 max_area = area;
				 }
				 
			 }
			 
		 }
		return max_area;
	        
	    }

}
