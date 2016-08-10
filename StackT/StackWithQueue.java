package StackT;

import java.util.LinkedList;

public class StackWithQueue {
	public  static void main(String args[]){
		MyStackWithTwoQueue stack = new MyStackWithTwoQueue();
		stack.push(1);
		stack.pop();
		System.out.println(stack.empty());
		/*stack.push(2);
		stack.push(3);
		System.out.println(stack.top());
		stack.push(4);
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.empty());*/
		
    }
}
class MyStack{
	private LinkedList<Integer> queue;
	
	public MyStack(){
		queue = new LinkedList<Integer>();

	}
	 // Push element x onto stack.
    public void push(int x) {
        queue.add(x);

    }

    // Removes the element on top of the stack.
    public void pop() {
    	int n = queue.size();
    	if(n == 1)
    		queue.remove();
    	else{
    		for(int i = 0; i < n - 1; i++){
    			queue.add(queue.peek());
    			queue.remove();
    		}
    		queue.remove();
    	}
        
    }

    // Get the top element.
    public int top() {
    	int n = queue.size();
    	if(n == 1)
    		 return queue.peek();
    	else{
    		int peek;
    		for(int i = 0; i < n - 1; i++){
    			queue.add(queue.peek());
    			queue.remove();
    		}
    		peek = queue.peek();
    		queue.add(queue.peek());
			queue.remove();
			return peek;
    	}
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
class MyStackWithTwoQueue{
	LinkedList<Integer> queue1; 
	LinkedList<Integer> queue2; 
	public MyStackWithTwoQueue(){
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}
	// Push element x onto stack.
    public void push(int x) {
        if(queue1.isEmpty()){
        	queue1.add(x);
        	while(!queue2.isEmpty()){
        		queue1.add(queue2.remove());
        	}
        }else{
        if(queue2.isEmpty()){
        	queue2.add(x);
        	while(!queue1.isEmpty()){
        		queue2.add(queue1.remove());
        	}
        }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!queue1.isEmpty())
        	queue1.remove();
        if(!queue2.isEmpty())
        	queue2.remove();
    }

    // Get the top element.
    public int top() {
    	 if(!queue1.isEmpty())
         	return queue1.peek();
         if(!queue2.isEmpty())
         	return queue2.peek();
         return 0;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}