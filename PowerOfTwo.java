public class PowerOfTwo {
	public static void main(String args[]) {
		int m =0;
		System.out.println(isPowerOfTwo(m));
	}

	public static boolean isPowerOfTwo(int n) {
		while(n > 0  && (n & 1) == 0){
			n >>= 1;
		}
		return n == 1;

	}
}
