package leedcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num385 {
    public NestedInteger deserialize(String s) {
    	Stack<NestedInteger> st=new Stack<NestedInteger>();
    	char[] arr=s.toCharArray();
		NestedInteger list=new NestedInteger();
		boolean sign=false;
    	if(arr[0]!='['){
        	NestedInteger ni=new NestedInteger(Integer.parseInt(s));
        	return ni;
    	}
    	else{
    		int num=0;
//    		NestedInteger ni=new NestedInteger(Integer.parseInt(s));
    		for(int i=1;i<arr.length;i++){
    			switch(arr[i]){
    				case'[':{
    					st.push(list);
    					NestedInteger tem=list;
    					list=new NestedInteger();
    					tem.add(list);
    					break;
    				}
    				case',':{
    					if(arr[i-1]>='0'&&arr[i-1]<='9'){
	    					if(sign)
	    						num=-num;
	    					sign=false;
	    					list.add(new NestedInteger(num));
	    					num=0;
    					}
    					break;
    				}
    				case']':{
    					if(arr[i-1]>='0'&&arr[i-1]<='9'){
        					if(sign)
        						num=-num;
        					sign=false;
        					list.add(new NestedInteger(num));
        					num=0;
    					}
    					if(st.isEmpty()){
    						return list;
    					}
    					list=st.pop();
    					
    					break;
    				}
    				case'-':sign=true;break;
    				default:{
    					num=num*10+arr[i]-'0';
    				}
    			}
    			
    			
    			
    		}
    	}
        return list;
    }
	public static void main(String[] args) {
		num385 sol=new num385();
		sol.deserialize("[1,2,[3,4,5],[[]],6,[]]");
	}

}
