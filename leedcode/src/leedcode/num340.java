package leedcode;

import java.util.HashMap;

public class num340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
    	char[] arr=s.toCharArray();
    	HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    	int left=0;
    	int count=0;
    	int max=0;
    	for(int i=0;i<arr.length;i++){
    		if(map.containsKey(arr[i])){
    			if(map.get(arr[i])==0)
    				count++;
    			map.put(arr[i],map.get(arr[i])+1);
    		}
    		else{
    			count++;
    			map.put(arr[i], 1);
    		}
    		if(count>k){
    			max=Math.max(max, i-left);
    			while(count>k){
    				map.put(arr[left],map.get(arr[left])-1);
    				if(map.get(arr[left])==0)
    					count--;
    				left++;
    			}
    		}
    	}
    	return Math.max(max, arr.length-left);
    }
	public static void main(String[] args) {
		num340 sol=new num340();
		System.out.println(sol.lengthOfLongestSubstringKDistinct("bacc", 2));
	}

}
