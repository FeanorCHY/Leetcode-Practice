package leedcode;

import java.util.HashMap;

public class num159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
		char[] arr=s.toCharArray();
    	HashMap<Character,Integer> cur=new HashMap<Character,Integer>();
    	int max=2;
    	int left=0;
    	int count=0;
    	if(arr.length<=2)
    		return arr.length;
		for(int i=0;i<arr.length;i++){
			if(!cur.containsKey(arr[i])||cur.get(arr[i])==0){
				cur.put(arr[i], 1);
				count++;
				if(count==3){
					max=Math.max(max, i-left);
					while(count==3){
						cur.put(arr[left],cur.get(arr[left])-1);
						if(cur.get(arr[left])==0)
							count--;
						left++;
					}
				}
			}
			else{
				cur.put(arr[i], cur.get(arr[i])+1);
			}
		}
		max=Math.max(max, arr.length-left);
		return max;
    }
	public static void main(String[] args) {
	}

}
