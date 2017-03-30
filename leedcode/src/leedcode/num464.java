package leedcode;

import java.util.HashMap;

public class num464 {
	int maxint;
	int tar;
	boolean[] visit;
	HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
    public boolean canIWin(int maxint, int tar) {
        int sum = (1+maxint)*maxint/2;
        if(sum < tar) return false;
        if(tar <= 0) return true;
    	visit=new boolean[maxint+1];
    	this.maxint=maxint;
    	this.tar=tar;
    	return tryWin(0);
    }
    private boolean tryWin(int pre){
    	for(int i=maxint;i>=1;i--){
    		if(visit[i])
    			continue;
    		if(pre+i>=tar)
    			return true;
    		else if(pre+i==tar-1){
		    	map.put(translate(visit), false);
    			return false;
    		}
    		else{
    			visit[i]=true;
    			if(map.containsKey(translate(visit))){
    				if(!map.get(translate(visit))){
	        			visit[i]=false;
	    				return true;
    				}
    			}
    			else{
	    			if(!tryWin(pre+i)){
	        			visit[i]=false;
	    		    	map.put(translate(visit), true);
	    				return true;
	    			}
    			}
    			visit[i]=false;
    		}
    	}
    	map.put(translate(visit), false);
    	return false;
    }
    private int translate(boolean[] arr){
    	int res=0;
    	for(int i=0;i<arr.length;i++){
    		res=res<<1;
    		if(arr[i])
    			res+=1;
    	}
    	return res;
    }
	public static void main(String[] args) {
		num464 sol=new num464();
		System.out.println(sol.canIWin(10, 40));
	}

}
