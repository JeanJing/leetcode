package StackT;

import java.util.LinkedList;
import java.util.Stack;
public class QueueWithStack{
	public  static void main(String args[]){
		MyQueue stack = new MyQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.peek());
		stack.push(4);
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.empty());
		
    }
    
}
class MyQueue {
	
	
	Stack<Integer> stack1 = new Stack<Integer>();//用于push
	Stack<Integer> stack2 = new Stack<Integer>();//用于pop
	
    // Push element x to the back of queue.
    public void push(int x) {
    	stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	if(stack2.empty()){
    		while(!stack1.empty()){
    			stack2.push(stack1.peek());
    			stack1.pop();
    		}
    	}
    	stack2.pop();
        
    }

    // Get the front element. 
    public int peek() {
    	if(stack2.empty()){
    		while(!stack1.empty()){
    			stack2.push(stack1.peek());
    			stack1.pop();
    		}
    
    	}
    		 return stack2.peek();

    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}