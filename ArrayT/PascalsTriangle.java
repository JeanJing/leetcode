package ArrayT;
import java.util.*;
public class PascalsTriangle {
	public static void main(String args[]){
		System.out.println(generate_iter(6));
	}
	//��ʹ�õݹ飬ջ���
	public static List<List<Integer>> generate_recur(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(numRows == 0)
			return result;
		if(numRows == 1){
			temp.add(1);
			result.add(temp);
			return result;
		}
		if(numRows == 2){
			temp.add(1);
			result.add(temp);
			temp = new ArrayList<Integer>();
			temp.add(1);
			temp.add(1);
			result.add(temp);
			return result;
		}
		result = generate_recur(numRows - 1);
		int length = result.size();
		temp = new ArrayList<Integer>();
		temp.add(1);
		for(int i = 0; i < result.get(length - 1).size() - 1;i++){
			temp.add(result.get(length - 1).get(i) + result.get(length - 1).get(i + 1));
		}
		temp.add(1);
		result.add(temp);
		return result;
	}
	public static List<List<Integer>> generate_iter(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(numRows == 0)
			return result;
		if(numRows == 1){
			temp.add(1);
			result.add(temp);
			return result;
		}
		
			temp.add(1);
			result.add(temp);
			temp = new ArrayList<Integer>();
			temp.add(1);
			temp.add(1);
			result.add(temp);
		//������result�Ѿ�������������
		for(int i = 2; i < numRows; i++){
			temp = new ArrayList<Integer>();
			temp.add(1);
			for(int j = 0; j < result.get(result.size() - 1).size() - 1; j++){
				temp.add(result.get(result.size() - 1).get(j) + result.get(result.size()  - 1).get(j + 1));
			}
			temp.add(1);
		    result.add(temp);
		}
		
		
		return result;
	}
}
