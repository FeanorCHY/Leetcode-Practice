package leedcode;

import java.util.Stack;

public class num439 {
    public String parseTernary(String exp) {
    	char[] arr=exp.toCharArray();
    	String res=null;
    	Stack<Boolean> st=new Stack<Boolean>();
    	for(int i=0;i<arr.length;i++){
    		if(arr[i]=='?'){
    			st.push(arr[i-1]=='T');
    			if(arr[i-1]=='T'){
    				res=arr[i+1]+"";
    			}
    		}
    		else if(arr[i]==':'){
    			boolean ret=true;
    			for(boolean each:st){
    				ret=ret&&each;
    			}
    			if(ret)
    				return res;
    			if(!st.pop())
    				res=arr[i+1]+"";
    		}
    	}
    	
    	return res;
    }
	public static void main(String[] args) {
		num439 sol=new num439();
		System.out.println(sol.parseTernary("F?T?2:6:T?T?5:F?7:7:T?6:T?2:F?T:T?2:T?T?F?F?F?4:T?F?5:T?F:T?F?4:9:9:6:3:9:5:T?F?F?F?F?5:2:9:6:F?4:T?6:7:T?8:F?0:F?F?5:T?F:5:T?T?9:4:F?F?T?F?F?6:8:F:4:F?F?T?F:F?F?0:F?7:2:T?8:T?F?9:8:7:1:6:T?T?F?9:T?F?3:8:3:F:4"));
	}

}
