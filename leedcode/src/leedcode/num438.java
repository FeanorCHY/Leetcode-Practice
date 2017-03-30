package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class num438 {
    public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> res= new ArrayList<Integer>();
    	char[] arrs=s.toCharArray();
    	char[] arrp=p.toCharArray();
    	int[] map=new int[26];
    	for(int i=0;i<arrp.length;i++){
			map[arrp[i]-'a']++;
    	}
    	int left=0;
    	int count=p.length();
    	for(int i=0;i<arrs.length;i++){
    		if(--map[arrs[i]-'a']>=0)
    			count--;
    		if(count==0)
    			res.add(left);
    		if(i-left+1==p.length()&&map[arrs[left++]-'a']++>=0){
    			count++;
    		}
    			
    	}
    	
    	return res;
    }
	public static void main(String[] args) {
		num438 sol=new num438();
		System.out.println(sol.findAnagrams("cbaebabacd", "abc"));
	}

}




//public List<Integer> findAnagrams(String s, String p) {
//	List<Integer> res= new ArrayList<Integer>();
//	char[] arrs=s.toCharArray();
//	char[] arrp=p.toCharArray();
//	HashMap<Character,Integer> map=new HashMap<Character,Integer>();
//	for(int i=0;i<arrp.length;i++){
//		map.put(arrp[i], map.getOrDefault(arrp[i], 0)+1);
//	}
//	int left=0;
//	int count=0;
//	HashMap<Character,Integer> cur=new HashMap<Character,Integer>();
//	for(int i=0;i<arrs.length;i++){
//		if(!map.containsKey(arrs[i])){
//			cur.clear();
//			left=i+1;
//			count=0;
//		}
//		else{
//			cur.put(arrs[i], cur.getOrDefault(arrs[i], 0)+1);
//			int com=cur.get(arrs[i]).compareTo(map.get(arrs[i]));
//			if(com==0){
//				count++;
//				if(count==map.size()){
//					res.add(left);
//    				count--;
//    				cur.put(arrs[left], cur.getOrDefault(arrs[left], 0)-1);
//    				left++;
//				}
//			}
//			else if(com>0){
//				while(arrs[left]!=arrs[i]){
//					if(cur.getOrDefault(arrs[left], 0).equals(map.getOrDefault(arrs[left], 0)))
//							count--;
//					cur.put(arrs[left], cur.getOrDefault(arrs[left], 0)-1);
//					left++;
//				}
//				cur.put(arrs[left], cur.getOrDefault(arrs[left], 0)-1);
//				left++;
//			}
//		}
//	}
//	
//	return res;
//}
