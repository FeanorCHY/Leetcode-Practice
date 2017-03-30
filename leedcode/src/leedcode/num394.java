package leedcode;

import java.util.Stack;

public class num394 {
    public String decodeString(String s) {
    	Stack<String> strst=new Stack<String>();
    	Stack<Integer> st=new Stack<Integer>();
    	char[] arr=s.toCharArray();
    	int rep=0;
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<arr.length;i++){
    		if(arr[i]>='0'&&arr[i]<='9'){
    			rep=rep*10+arr[i]-'0';
    		}
    		else if(arr[i]=='['){
    			strst.push(sb.toString());
    			st.push(rep);
    			rep=0;
    			sb=new StringBuilder();
    		}
    		else if(arr[i]==']'){
    			int tem=st.pop();
    			StringBuilder temsb=new StringBuilder(strst.pop());
    			for(int j=0;j<tem;j++){
    				temsb.append(sb.toString());
    			}
    			sb=temsb;
    		}
    		else
    			sb.append(arr[i]);
    	}
    	
        return sb.toString();
    }
	public static void main(String[] args) {
		num394 sol=new num394();
		System.out.println(sol.decodeString("3[a2[c]]"));
	}

}
