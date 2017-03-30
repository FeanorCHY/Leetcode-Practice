package leedcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Stack;

public class num354 {
	int[][] env;
	int max=1;
	int dp[];
	HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
    public int maxEnvelopes(int[][] env) {
    	if(env.length==0)
    		return 0;
    	this.env=env;
    	Arrays.sort(env,new Comparator<int[]>(){
			@Override
			public int compare(int[] arr1, int[] arr2) {
	            if(arr1[0] == arr2[0])
	                return arr2[1] - arr1[1];
	            else
	                return arr1[0] - arr2[0];
			}    		
    	});
        dp = new int[env.length];
        int len = 0;
        for(int[] envelope : env){
        	if(len==0){
        		dp[len++]=envelope[1];
        		continue;
        	}
            int index = binary( 0, len-1, envelope[1]);
            if(index<0||index>len)
            	index=0;
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }
	public int binary( int left, int right, int val) {
	    while(left <= right) {
	        int mid = (left+right)/2;
	        if(dp[mid] >= val) {
	            right = mid - 1;
	        }
	        // 相等也要替换这个值;
	        else {
	            left = mid + 1;
	        }
	    }
	    return left;
	}
    private void find(int index){
    	boolean add=false;
    	for(int i=index+1;i<env.length;i++){
			if(env[i][0]>env[index][0]&&env[i][1]>env[index][1]){
				add=true;
				find(i);
				if(!map.containsKey(index)||map.get(index)< map.get(i)+1){
					map.put(index, map.get(i)+1);
					max=Math.max(max, map.get(index));
				}
			}
    	}
    	if(!add)
    		map.put(index, 1);
    }
	public static void main(String[] args) {
		int[][] test={{46,89},{50,53},{52,68},{72,45},{77,81}};
		num354 sol=new num354();
		System.out.println(sol.maxEnvelopes(test));
	}

}




//Stack<Integer> st=new Stack<Integer>();
//st.add(0);
//int max=-1;
//int index=0;
//boolean del=true;
//while(!st.isEmpty()){
//	if(del){
//		st.pop();
//		del=false;
//	}
//	boolean add=false;
//	for(int i=index+1;i<env.length;i++){
//		if(env[i][0]>env[index][0]&&env[i][1]>env[index][1]){
//			if(map.containsKey(i)){
//				max=Math.max(max, map.get(i));
//				if(!map.containsKey(index)||map.get(index)< map.get(i)+1)
//					map.put(index, map.get(i)+1);
//				continue;
//			}
//			st.push(index);
////			ict.push(i);
//			index=i;
//			add=true;
//			break;
//		}
//	}
//	if(!add){
//		max=Math.max(max, st.size()+1);
//		map.put(index, 1);
//		if(!st.isEmpty()){
//			int tem=index;
//			index=st.pop();
//			if(!map.containsKey(index)||map.get(index)< map.get(tem)+1)
//				map.put(index, map.get(tem)+1);
//			if(st.isEmpty()){
//				st.push(index);
//				del=true;
//			}
//		}
//		else{
//			while(map.containsKey(++index));
//			if(index==env.length)
//				break;
//			st.push(index);
//			del=true;
//		}
//	}
//}
