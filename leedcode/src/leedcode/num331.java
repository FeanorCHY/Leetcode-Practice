package leedcode;

import java.util.Stack;

public class num331 {
    public boolean isValidSerialization(String preorder) {
    	if(preorder.equals("#"))//null input
    		return true;
    	String[] nodes=preorder.split(",");
    	Stack<Integer> st=new Stack<Integer>();
    	for(int i=0;i<nodes.length;i++){
    		if(nodes[i].equals("#")){
    			if(st.isEmpty())
    				return false;//take care of false input
    			int node=st.pop();
    			while(node!=0){
    				if(st.isEmpty()){
    					if(i==nodes.length-1)
    						return true;
    					else
    						return false;
    				}
    				node=st.pop();
    			}
    			st.push(1);
    		}
    		else{
    			st.push(0);
    		}
    	}
    	
        return false;
    }
	public static void main(String[] args) {
		String test="9,#,3,4,#,#,1,#,#,2,#,6,#,#";
		num331 sol=new num331();
		System.out.println(sol.isValidSerialization(test));

	}

}
