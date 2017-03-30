package leedcode;

import java.util.HashMap;

public class num76 {
    public String minWindow(String s, String t) {
    	HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    	char[] tarr=t.toCharArray();
    	for(int i=0;i<tarr.length;i++){
    		if(!map.containsKey(tarr[i]))
    			map.put(tarr[i], 1);
    		else
    			map.put(tarr[i], map.get(tarr[i])+1);
    	}
    	int count=0;
    	int len=map.size();
    	int size=0;
    	char[] arr=s.toCharArray();
    	int left=-1;
    	int minLeft=-1;
    	int minLen=0;
    	HashMap<Character,Integer> cur=new HashMap<Character,Integer>();
    	for(int i=0;i<arr.length;i++){
    		if(map.containsKey(arr[i])){
				if(left==-1){
					left=i;
				}
    			if(cur.containsKey(arr[i]))
    				cur.put(arr[i], cur.get(arr[i])+1);
    			else
    				cur.put(arr[i],1);
    			if((int)cur.get(arr[i])==(int)map.get(arr[i])){
    				count++;
    				if(count==len&&minLeft==-1){
    					minLeft=left;
    					minLen=i-minLeft+1;
    				}
    			}
    			else if(arr[i]==arr[left]&&cur.get(arr[i])>map.get(arr[i])){
    				while(cur.get(arr[left])-1>=map.get(arr[left])){
    					cur.put(arr[left],cur.get(arr[left])-1);
    					left++;
    					while(!map.containsKey(arr[left])){
    						left++;
    					}
    				}
    				if(i-left+1<minLen){
    					minLen=i-left+1;
    					minLeft=left;
    				}
    			}
    		}
    		
    	}
    	
    	
    	if(minLeft==-1)
    		return "";
    	return s.substring(minLeft,minLeft+minLen);
    }
	public static void main(String[] args) {
		num76 sol=new num76();
		System.out.println(sol.minWindow("BCADEEFGA", "AABCDEFG"));
	}

}
//if(map.containsKey(arr[i])){
//	if(map.get(arr[i])==-1){
//		count++;
//		if(left==-1)
//			left=i;
//	}
//	else{
//		if(map.get(arr[i])==left){
//			int newLeft=s.length();
//			map.put(arr[i], i);
//			for(int each:map.values()){
//				if(each!=-1)
//					newLeft=Math.min(newLeft, each);
//			}
//			left=newLeft;
//			if(i-left+1<minLen&&count==len){
//				minLen=i-left+1;
//				minLeft=left;
//			}
//		}
//	}
//	map.put(arr[i], i);
//	if(count==len&&minLeft==-1){
//		minLeft=left;
//		minLen=i-left+1;
//	}
//}
