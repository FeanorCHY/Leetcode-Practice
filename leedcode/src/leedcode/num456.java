package leedcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair132{
    int min, max;
    public Pair132(int min, int max){
        this.min = min;
        this.max = max;
    }
}
public class num456 {
    public boolean find132pattern(int[] nums) {
    	Stack<Pair132> st=new Stack<Pair132>();
    	for(int each:nums){
    		if(st.isEmpty()||st.peek().min>each)
    			st.push(new Pair132(each,each));
    		else if(st.peek().min<each){
    			Pair132 last=st.pop();
    			if(last.max>each)
    				return true;
    			else{
    				last.max=each;
    				while(!st.isEmpty()&&st.peek().max<=each)
    					st.pop();
    				if(!st.isEmpty()&&st.peek().min<each)
    					return true;
    				st.push(last);
    			}
    		}
    	}
        return false;
    }
	public static void main(String[] args) {
		int[] test={7,10,3,5,1,8};
		num456 sol=new num456();
		System.out.println(sol.find132pattern(test));
	}

}




//public boolean find132pattern(int[] nums) {
//	long min=(long)Integer.MAX_VALUE+1;
//	long max=(long)Integer.MIN_VALUE-1;
//	List<Integer> listn=new ArrayList<Integer>();
//	List<Integer> listx=new ArrayList<Integer>();
//	for(int each:nums){
//		for(int i=0;i<listn.size();i++){
//			if(each>listn.get(i)&&each<listx.get(i))
//				return true;
//		}
//		if(min>(long)Integer.MAX_VALUE){
//			min=each;//Math.min((long)each, min)
//		}
//		else{
//			
//			if(min>each){
//				if(max<(long)Integer.MIN_VALUE)
//					min=each;
//				else{
//					listn.add((int)min);
//					listx.add((int)max);
//					min=each;
//					max=(long)Integer.MIN_VALUE-1;
//				}
//			}
//			else if(min<each){
//				if(max>each)
//					return true;
//				else if(each>min+1)
//					max=Math.max((long)each, max);
//			}
//		}
//		
//	}
//	
//	return false;
//}