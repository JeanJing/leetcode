import java.util.ArrayList;


public class UglyNumber {
	public static void main(String args[]){
		System.out.println(isUgly(21));
		
	}
	//根据质因子分解的原理
	 public static boolean isUgly(int num) {
		 while(num >= 2){
			 if(num % 2 ==0)
				 num = num / 2;
			 else
				 if(num % 3 == 0)
					 num = num / 3;
				 else
					 if(num % 5 == 0)
						 num = num / 5;
					 else return false;
		 }
		 if(num == 1)
			 return true;
		 else
			 return false;//这里可以直接写成return num == 1
	 }
	/*
	 * 使用穷举法判断
	 * @param num
	 * @return
	 */
   public static boolean isUgly_exhaustion(int num) {
	   ArrayList<Integer> factorList = new ArrayList<Integer>();
	   if(num == 1)
		   return true;
	   factorList = allFactor(num);
	   for(int n:factorList){
		   if(isPrime(n))
			   if(n > 5)
				   return false;
	   }
	return true;
        
    }
   public static ArrayList<Integer> allFactor(int num){
	   ArrayList<Integer> array = new ArrayList<Integer>();
	   for(int i = 1; i < num / 2 + 1; i++){
		   if( num % i == 0)
			   array.add(i);
	   }
	   array.add(num);
	   return array;
   }
   public static boolean isPrime(int num){
	   ArrayList<Integer> array;
	   if(num == 1)
		   return false;
	   if(num == 2 || num == 3 || num == 5)
		   return true;
	   else{
		   array = allFactor(num);
		   if(array.size() == 2)
			   return true;
		   else 
			   return false;
	   }

   }
}
