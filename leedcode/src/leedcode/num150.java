package leedcode;

import java.util.Stack;

public class num150 {
    public int evalRPN(String[] tokens) {
    	Stack<String> st=new Stack<String>();
    	for(String str:tokens){
    		if(str.equals("+")){
    			int op1=Integer.parseInt(st.pop());
    			int op2=Integer.parseInt(st.pop());
    			st.push(Integer.toString(op1+op2));
    		}
    		else if(str.equals("-")){
    			int op1=Integer.parseInt(st.pop());
    			int op2=Integer.parseInt(st.pop());
    			st.push(Integer.toString(op2-op1));
    		}
    		else if(str.equals("*")){
    			int op1=Integer.parseInt(st.pop());
    			int op2=Integer.parseInt(st.pop());
    			st.push(Integer.toString(op1*op2));
    		}
    		else if(str.equals("/")){
    			int op1=Integer.parseInt(st.pop());
    			int op2=Integer.parseInt(st.pop());
    			st.push(Integer.toString(op2/op1));
    		}
    		else{
    			st.push(str);
    		}
    	}
    	
    	return Integer.parseInt(st.pop());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
