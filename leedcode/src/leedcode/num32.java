package leedcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class num32 {
    public int longestValidParentheses(String s) {
    	Stack<Integer> st=new Stack<Integer>();
    	int max=0;
    	char[] arr=s.toCharArray();
    	st.push(-1);
    	for(int i=0;i<arr.length;i++){
    		if(arr[i]=='('||st.size()==1||arr[st.peek()]==')'){
    			st.push(i);
    		}
    		else{
    			st.pop();
    			max=Math.max(max, i-st.peek());
    		}
    	}
        return max;
    }

	public static void main(String[] args) {
		num32 sol=new num32();
		System.out.println(sol.longestValidParentheses(")()(()))((((()"));
	}

}
