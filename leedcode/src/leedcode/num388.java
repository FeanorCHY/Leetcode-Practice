package leedcode;

import java.util.Stack;

public class num388 {
    public int lengthLongestPath(String input) {
    	int max=-1;
    	Stack<Integer> st=new Stack<Integer>();
    	int count=0;
    	int len=0;
    	boolean file=false;
    	int leval=0;
    	char[] arr=input.toCharArray();
    	boolean begin=false;
    	int space=0;
    	for(int i=0;i<arr.length;i++){
    		if(arr[i]=='\n'||i==arr.length-1){
    			begin=false;
    			if(i==arr.length-1)
    				len++;
    			if(!file){
	    			while(leval!=st.size()){
	    				count-=st.pop();
	    			}
	    			st.push(len+1);
	    			count+=len+1;
	    			len=0;
    			}
    			else{
	    			while(leval!=st.size()){
	    				count-=st.pop();
	    			}
    				if(leval!=st.size()){
    					len-=(st.size()-leval)*4;
    				}
    				max=Math.max(max, count+len);
    				file=false;
    				len=0;
    			}
    			int index=i+1;
    			while(index<arr.length&&arr[index]=='\t'){
    				index=index+1;
    			}
    			leval=index-i-1;
    			i=index-1;
    		}
    		else if(arr[i]=='.'){
    			file=true;
    			len++;
    		}
    		else{ 
    			if(arr[i]==' '){
    				if(begin==false)
    					space++;
    			}
    			else
    				begin=true;
    			
    			len++;
    		}
    	}
        return Math.max(max, 0);
    }
	public static void main(String[] args) {
		num388 sol=new num388();
		System.out.println(sol.lengthLongestPath("a\n\tb\n\t\tc.txt\n\taaaa.txt"));
	}

}
