package leedcode;

import java.util.HashMap;
import java.util.HashSet;

public class num395 {
	char[] arr;
	int k;
	public int longestSubstring(String s, int k) {
	    arr= s.toCharArray();
	    this.k=k;
	    return dc(0,s.length());
	}
	public int dc(int start,int end){
		if(end-start<k)
			return 0;
		int count[]=new int[26];
		for(int i=start;i<end;i++){
			count[arr[i]-'a']++;
		}
		for(int i=start;i<end;i++){
			if(count[arr[i]-'a']==0)
				continue;
			if(count[arr[i]-'a']<k){
				int left=dc(start,i);
				int right=dc(i+1,end);
				return Math.max(right, left);
			}
		}
		return end-start;
	}
	public static void main(String[] args) {
		num395 sol=new num395();
		System.out.println(sol.longestSubstring("ababbc", 2));
	}

}


//private int helper(char[] str, int start, int end,  int k){
//    if(end<start) return 0;
//    if(end-start<k) return 0;//substring length shorter than k.
//    int[] count = new int[26];
//    for(int i = start;i<end;i++){
//        int idx = str[i]-'a';
//        count[idx]++;
//    }
//    for(int i = 0;i<26;i++){
//        if(count[i]==0)continue;//i+'a' does not exist in the string, skip it.
//        if(count[i]<k){
//            for(int j = start;j<end;j++){
//                if(str[j]==i+'a'){
//                    int left = helper(str,start,j,k);
//                    int right = helper(str,j+1,end,k);
//                    return Math.max(left,right);
//                }
//            }
//        }
//    }
//    return end-start;
//}




//public int longestSubstring(String s, int k) {
//	char[] arr=s.toCharArray();
//	if(k==1)
//		return arr.length;
//	int max=0;
//	for(int i=0;i<arr.length;i++){
//		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
//		int count=0;
//		for(int j=i;j<arr.length;j++){
//			if(map.containsKey(arr[j])){
//				map.put(arr[j], map.get(arr[j])+1);
//    			if(map.get(arr[j])==k){
//    				count--;
//    			}
//    			if(count==0)
//    				max=Math.max(max, j-i+1);
//			}
//			else{
//				map.put(arr[j], 1);
//				count++;
//			}
//		}
//		
//	}
//	return max;
//}