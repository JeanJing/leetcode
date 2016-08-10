public class Easy_FirstBadVersion {
	public static void main(String args[]){
		long start = System.currentTimeMillis();
		int i  = 1000000;
		while(i > 0){
			i--;
		firstBadVersion(2126753390);
		}
		long end = System.currentTimeMillis();
		System.out.println(end -start);
	}

	public static int firstBadVersion(int n) {
		if (isBadVersion(1))
			return 1;
		int good, bad, middle;
		good = 1;
		bad = n;
		while (good + 1 < bad) {
			middle = good  + (bad - good) / 2;//因为数字特别的大，在这里居然就溢出了这是我没有想到的
			if (isBadVersion(middle)) {
				bad = middle;
				//if(!isBadVersion(bad - 1))//但是这种情况是比较少的
				//	return bad;
			} else {
				good = middle;
				//if(isBadVersion(good + 1))
				//	return good +1;
			}
		}
		if (isBadVersion(good))
			return good;
		else
			return bad;

	}

	public static boolean isBadVersion(int version) {
		if(version >= 1702766719)
			return true;
		else 
			return false;
	}

}
