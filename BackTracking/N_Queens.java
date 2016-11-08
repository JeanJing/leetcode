package BackTracking;
import java.util.*;
public class N_Queens {
	public static void main(String args[]){
		List<List<String>> result = solveNQueens(9);
		for(int i = 0; i < result.size(); i++){
			System.out.println("��" + i + "�����÷���Ϊ��");
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
		//��һ����row��col��ʼ����col������Ƕ�Ϊ0
		//Arrays.fill(row, -1);
		result = new ArrayList<List<String>>();
		placeQueen(0,n);
		return result;
        
    }
	//r��ʾΪ��r�з��õ�r��queen
	public static void  placeQueen(int r, int n){
		//�Ѿ�����������n���㣬���ʱ�����
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
			//���ڵ�r�У������е��У��жϵ�i���Ƿ���Ա�����queen
			for(int i = 0; i < n; i++){
				//���col[i] == 0������i����û�зŹ�Ԫ�� 
				if(col[i] == 0){
					//һ������£����ڽ��е���r�У�ֻ��ǰ���r�з��ù�Ԫ�أ�
					//���Ե�r����û�зŹ�Ԫ��
					//�����ֻ��Ҫ�ж�ǰ��ŵ�r��Ԫ���Ƿ��(r,i)��ͬһ��б����
					int j = 0;
					for(; j < r; j++){
						if(Math.abs(r - j) == Math.abs(row[j] - i))
							break;
					}
					//������queen����λ��(r,i)������б�߹�������һ����λ�ÿ��Է��õ�r��Ԫ��
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
