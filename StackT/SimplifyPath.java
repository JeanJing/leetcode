package StackT;

import java.util.Stack;

public class SimplifyPath {
	public static void main(String args[]){
		System.out.println(simplifyPath("/.."));
	}
	
	public static String simplifyPath(String path) {
		if (path == null || path.length() == 0)
			return path;
		char []strs = path.toCharArray();
		int n = path.length();
		int i = 0;
		Stack<String> stack = new Stack<String>();
		while(i < n){
			StringBuilder part = new StringBuilder();
			while(i < n && strs[i] != '/')
				part.append(strs[i++]);
			String partToStr = part.toString();
			if(!partToStr.isEmpty()){//string尽然有isempty这样的函数
				if(partToStr.equals("..")){
					if(!stack.isEmpty())
					stack.pop();
				}else{
					if(partToStr.equals("."))
						;
					else
						stack.push(partToStr);
				}
			}
			i++;
		}
		StringBuilder result = new StringBuilder();
		while(!stack.isEmpty()){
			result.insert(0, "/" + stack.pop());
		}
		
		return result.length() == 0 ? "/": result.toString();
	}
}
