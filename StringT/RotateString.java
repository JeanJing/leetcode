package StringT;

public class RotateString {
public static void main(String args[]){
		String s = ".cocm";
		char []str = s.toCharArray();
		rotateString(str,6);
		System.out.println(String.valueOf(str));

	}
	public static void rotateString(char[] str, int offset) {
       if(str ==  null || str.length == 0)
    	   return;
		if(offset % str.length == 0)
    	   return;
       
       int n = offset % str.length;
       char []newstr  = new char[str.length];
       System.arraycopy(str, str.length - n, newstr, 0, n);
       System.arraycopy(str,0,newstr,n,str.length - n);
       System.arraycopy(newstr,0, str, 0 ,str.length);
    }

}
