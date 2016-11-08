package BackTracking;
import java.util.*;
public class N_Queens {
	public static void main(String args[]){
		List<List<String>> result = solveNQueens(9);
		for(int i = 0; i < result.size(); i++){
			System.out.println("第" + i + "个放置方法为：");
			for(int j = 0; j < result.get(i).size(); j++){
				System.out.println(result.get(i).get(j));
			}
			System.out.println();
		}
	}
	static int []row = new int[1000];
	static int []col = new int[1000];
	static List<List<String>> result = null;
	public static List<List<String>> solveNQueens(int n) {
		//第一步对row和col初始化，col本身就是都为0
		//Arrays.fill(row, -1);
		result = new ArrayList<List<String>>();
		placeQueen(0,n);
		return result;
        
    }
	//r表示为第r行放置第r个queen
	public static void  placeQueen(int r, int n){
		//已经放置完所有n个点，这个时候构造解
		if(r == n){
			List<String> list = new ArrayList<String>();
			for(int i = 0; i < n; i++){
				StringBuilder str = new StringBuilder("");
				for(int j = 0; j < n; j++){
					if(row[i] == j)
						str.append("Q");
					else
						str.append(".");
				}
				list.add(str.toString());
			}
			result.add(list);
		}else{
			//对于第r行，对所有的列，判断第i列是否可以被放置queen
			for(int i = 0; i < n; i++){
				//如果col[i] == 0表明第i列是没有放过元素 
				if(col[i] == 0){
					//一般情况下，现在进行到第r行，只有前面的r行放置过元素，
					//所以第r行是没有放过元素
					//这里就只需要判断前面放的r个元素是否和(r,i)在同一个斜线上
					int j = 0;
					for(; j < r; j++){
						if(Math.abs(r - j) == Math.abs(row[j] - i))
							break;
					}
					//表明将queen放在位置(r,i)不存在斜线攻击，进一步该位置可以放置第r个元素
					if(j == r){
						col[i] = 1;
						row[r] = i;
						placeQueen(r + 1, n);
						col[i] = 0;
						row[r] = -1;
					}
				}
			}
		}
	}
}
