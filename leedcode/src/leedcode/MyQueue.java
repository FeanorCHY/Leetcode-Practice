package leedcode;

import java.util.Stack;

public class MyQueue {

	Stack<Integer> st=new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
    	Stack<Integer> tem=new Stack<Integer>();
    	while(!st.isEmpty())
    		tem.push(st.pop());
    	st.push(x);
    	while(!tem.isEmpty())
    		st.push(tem.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        st.pop();
    }

    // Get the front element.
    public int peek() {
      return st.peek();  
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return st.isEmpty();
    }
}
