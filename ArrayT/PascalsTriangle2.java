package ArrayT;
import java.util.*;
public class PascalsTriangle2 {
	public static void main(String args[]){
		System.out.println(getRow(6));
	}
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> temp = new ArrayList<Integer>();
       
        if(rowIndex == 0){
        	temp.add(1);
        	return temp;
        }
        temp.add(1);
        temp.add(1);
        
        List<Integer> newTemp = null;
        int i = 1;
        while(i < rowIndex){
        	newTemp = new ArrayList<Integer>();
        	newTemp.add(1);
        	for(int j = 0; j< temp.size() - 1; j++){
        		newTemp.add(temp.get(j) + temp.get(j + 1));
        	}
        	newTemp.add(1);
        	temp = newTemp;
        	i++;
        }
        return newTemp;
        	
    }
}
