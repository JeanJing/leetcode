package StackT;

import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicateLetters {
	public static void main(String args[]){
		//boolean []block = new boolean[90];
		System.out.println(removeDuplicateLetters("bcabc"));
		//System.out.println(removeDuplicateLetters("/.."));
	}
	//删除的过程是真正的删除，这个版本不对
	 public static String removeDuplicateLetters_error(String s) {
		 if(s ==  null || s.length() == 0)
	        return s;
		 char []strs = s.toCharArray();
		 int n = s.length();
		 boolean []flag = new boolean[256];
		 Arrays.fill(flag, false);
		 for(int i = 0; i < n; i++){
			 flag[strs[i]] = true;
		 }
		 StringBuilder ret = new StringBuilder();
		 for(int i = 0; i < 256; i++){
			 if(flag[i]){
				 ret.append((char)i);
			 }
		 }
		 return ret.toString();
	 }
	 public static String removeDuplicateLetters(String s) {
		 if(s ==  null || s.length() == 0)
			 return s;
		 char []strs = s.toCharArray();
		 int n = s.length();
		 int []count = new int[26];
		 for(int i = 0; i <n; i++){
			 count[strs[i] - 'a']++;
		 }
		 boolean []isVisited = new boolean[26];
		 
		 Stack<Character> stack = new Stack<Character>();
		 stack.push('0');
		 for(int i = 0; i < n; i++){
			 //count[]
			 count[strs[i] - 'a']--;
			 if(!isVisited[strs[i] - 'a']){
				 if(strs[i] > stack.peek()){
					 stack.push(strs[i]);
					 isVisited[strs[i] - 'a'] = true;
				 }
				 else{
					 if(strs[i] < stack.peek()){
						 if(count[stack.peek() - 'a'] != 0){
							 while(strs[i] < stack.peek() && count[stack.peek() - 'a'] != 0){
							 isVisited[stack.pop() - 'a'] = false;						
							 }
							 stack.push(strs[i]);
							 isVisited[strs[i] - 'a'] = true;
						 }else{
							 stack.push(strs[i]);
							 isVisited[strs[i] - 'a'] = true;
						 }
					 }else{
						 //
					 }
				 }
			 }
			 
		 }
		 String rst = "";
		 while(!stack.isEmpty()){
			 rst = stack.pop() + rst;
		 }
		 return rst.substring(1);
	 }

}
