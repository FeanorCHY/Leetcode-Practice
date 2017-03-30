package leedcode;

import java.util.Stack;

public class MinStack {
	Stack<Integer> min=new Stack<Integer>();
	Stack<Integer> st=new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        st.push(x);
        if(min.isEmpty())
        	min.push(x);
        else{
        	min.push(Math.min(min.peek(), x));
        }
    }
    
    public void pop() {
        min.pop();
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
