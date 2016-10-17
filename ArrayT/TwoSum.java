package ArrayT;

import java.util.*;

public class TwoSum {
	public static void main(String args[]){
		int [] result = twoSum(new int[]{4,6,8,1,35,5,9},11);
		for(int i  = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
	 public static int[] twoSum(int[] nums, int target) {
		 if(nums == null || nums.length == 0)
			 return new int[0];
		 int []result = null;
		 Node [] newNums = new Node[nums.length];
		 for(int i = 0; i < nums.length; i++){
			 newNums[i] = new Node(nums[i],i);
		 }
		 Arrays.sort(newNums);
		 int i,j;
		 i = 0;
		 j = nums.length - 1;
		 while(i < j){
			 if(newNums[i].value + newNums[j].value == target)
				 break;
			 else{
				 if(newNums[i].value + newNums[j].value > target)
					 j--;
				 else
					 i++;
			 }
		 }
		 if(i != j){
			 result = new int[2];
			 if(newNums[i].index <= newNums[j].index){
			    result[0] = newNums[i].index;
			    result[1] = newNums[j].index;
			 }else{
				 result[0] = newNums[j].index;
				 result[1] = newNums[i].index;
			 }
		 }
	 return result;
	 }
	 
	 
	 public static int[] twoSum_useMap(int[] nums, int target) {
		 if(nums == null || nums.length == 0)
			 return new int[0];
		 int []result = null;
		 HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		 for(int i = 0; i < nums.length; i++){
			 if(map.containsKey(target - nums[i])){
				 result = new int[2];
				 result[0] = map.get(target - nums[i]);
				 result[1] = i;
			 }
			 map.put(nums[i],i);
				 
		 }
		 
		 
		 
		 
		 
		 return result;
	 }
	 

}
class Node implements Comparable<Node>{
	int value;
	int index;
	public Node(int value, int index){
		this.value = value;
		this.index = index;
	}
	public int compareTo(Node o) {
		return value - o.value;
	}
	
}



