package leedcode;

import java.util.Stack;

public class num255 {
    public boolean verifyPreorder(int[] preorder) {
    	if(preorder.length<=2)
    		return true;
    	Stack<Integer> st=new Stack<Integer>();
    	int need=Integer.MIN_VALUE;
    	int root=preorder[0];
    	st.push(root);
    	for(int i=1;i<preorder.length;i++){
    		if(preorder[i]<need)
    			return false;
    		if(preorder[i]>root){
    			int last=root;
    			int cur=st.pop();
    			if(st.isEmpty()){
    				need=cur;
    			}
    			else{
    				cur=st.pop();
    				boolean find=false;
    				while(preorder[i]>cur){
    					if(st.isEmpty()){
    						need=cur;
    						find=true;
    						break;
    					}
    					last=cur;
    					cur=st.pop();
    				}
    				if(find==false){
    					st.push(cur);
    					need=last;
    				}
    			}
    			root=preorder[i];
    			st.push(preorder[i]);
    		}
    		else{
    			st.add(preorder[i]);
    			root=preorder[i];
    		}
    	}
        return true;
    }
	public static void main(String[] args) {
		int[] test={1,4,2,3};
		num255 sol=new num255();
		System.out.println(sol.verifyPreorder(test));
	}
	
	
	
//    public boolean find(int root,int begin,int end){
//    	if(begin>=end)
//    		return true;
//    	boolean large=false;
//    	for(int i=begin;i<=end;i++){
//    		if(!large){
//    			if(arr[i]>root){
//    				if(find(arr[begin],begin+1,i-1)==false)
//    					return false;
//    				if(find(arr[i],i+1,end)==false)
//    					return false;
//    				large=true;
//    			}
//    		}
//    		else{
//    			if(arr[i]<root)
//    				return false;
//    		}
//    		if(i==end&&large==false){/////////!!!!!!!!!!remind
//				if(find(arr[begin],begin+1,end)==false)
//					return false;
//    		}
//    	}
//    	return true;
//    }
//
}
