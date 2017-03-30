package leedcode;

import java.util.Stack;

public class num316 {
	public String removeDuplicateLetters(String str) {
		int count[]=new int[26];
		char[] arr=str.toCharArray();
		boolean[] visit=new boolean[26];
		for(char each:arr){
			count[each-'a']++;
		}
		Stack<Character> st=new Stack<Character>();
		for(char each:arr){
			count[each-'a']--;
			if(visit[each-'a'])
				continue;
			while(!st.isEmpty()&&each<st.peek()&&count[st.peek()-'a']>0){
				visit[st.pop()-'a']=false;
			}
			visit[each-'a']=true;
			st.push(each);
		}
		StringBuilder sb=new StringBuilder();
		while(!st.isEmpty()){
			sb.insert(0,st.pop());
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String test="cbcdab";
		num316 sol=new num316();
		System.out.println(sol.removeDuplicateLetters(test));
	}
	

}


//public String removeDuplicateLetters(String s) {
//	TreeMap<Character,ArrayList<Integer>> map=new TreeMap<Character,ArrayList<Integer>>();
//	char arr[]=s.toCharArray();
//	StringBuilder sb=new StringBuilder();
//	boolean dup[]=new boolean[arr.length];
//	for(int i=0;i<arr.length;i++){
//		if(map.containsKey(arr[i])){
//			map.get(arr[i]).add(i);
//			dup[i]=true;
//		}
//		else{
//			ArrayList<Integer> tem=new ArrayList<Integer>();
//			tem.add(i);
//			map.put(arr[i], tem);
//		}
//	}
//	ArrayList<Integer> res=new ArrayList<Integer>();
//	for(int i=0;i<arr.length;i++){
//		if(map.get(arr[i]).size()==1){
//			res.add(i);
//			map.remove(arr[i]);
//		}
//	}
//	for(char key:map.keySet()){
//		int idx=0;
//		boolean add=false;
//		for(int each:map.get(key)){
//			while(idx<res.size()&&each>res.get(idx))
//				idx++;
//			if(idx==res.size()){
//				res.add(each);
//				add=true;
//				break;
//			}
//			if(arr[res.get(idx)]<key)
//				continue;
//			else{
//				res.add(idx, each);
//				add=true;
//				break;
//			}
//		}
//		if(!add){
//			int last=map.get(key).get(map.get(key).size()-1);
//			res.add(idx, last);
//		}
//	}
//	for(int each:res){
//		sb.append(arr[each]);
//	}
//	return sb.toString();
//}
