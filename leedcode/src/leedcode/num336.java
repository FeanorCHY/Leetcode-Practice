package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


public class num336 {
	public List<List<Integer>> palindromePairs(String[] words) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    HashMap<String,Integer> map=new HashMap<String,Integer>();
	    for(int i=0;i<words.length;i++)
	    	map.put(words[i], i);
	    for(int i=0;i<words.length;i++){
	    	for(int j=0;j<=words[i].length();j++){
	    		String str1=words[i].substring(0,j);
	    		String str2=words[i].substring(j);
	    		String rev1=new StringBuilder().append(str1).reverse().toString();
	    		String rev2=new StringBuilder().append(str2).reverse().toString();
	    		if(isPalindrome(str1)&&map.containsKey(rev2)&&map.get(rev2)!=i){
	    			List<Integer> tem=new ArrayList<Integer>();
	    			tem.add(map.get(rev2));
	    			tem.add(i);
	    			res.add(tem);
	    		}
	    		if(isPalindrome(str2)&&map.containsKey(rev1)&&map.get(rev1)!=i&&str2.length()!=0){
	    			List<Integer> tem=new ArrayList<Integer>();
	    			tem.add(i);
	    			tem.add(map.get(rev1));
	    			res.add(tem);
	    		}
	    	}
	    }
	    return res;
	}

	private boolean isPalindrome(String str) {
		char[] arr= str.toCharArray();
		int start=0;
		int end=arr.length-1;
		while(start<end){
			if(arr[start++]!=arr[end--])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String test[]={"abcd", "dcba", "lls", "s", "sssll"};
		num336 sol=new num336();
		System.out.println(sol.palindromePairs(test));
	}

}





//class PPNode{
//	int word;
//	int count;
//	char c;
//	HashMap<Character,PPNode> map;
//	PPNode(char c){
//		this.c=c;
//		this.word=-1;
//		count=0;
//		map=new HashMap<Character,PPNode>();
//	}
//}

//private void addTrie(PPNode root,String str,int id){
//	if(str.length()==0)
//		root.word=id;
//	char[] arr=str.toCharArray();
//	PPNode node=root;
//	for(int i=0;i<arr.length;i++){
//		if(node.map.containsKey(arr[i])){
//			node=node.map.get(arr[i]);
//		}
//		else{
//			node.map.put(arr[i], new PPNode(arr[i]));
//			node=node.map.get(arr[i]);
//			node.count++;
//		}
//	}
//	node.word=id;
//}
//private void getpal(String str,int id,boolean rev){
//	if(root.word>=0&&root.word!=id&&checkPal(str)&&rev){
//		List<Integer> tem=new ArrayList<Integer>();
//		tem.add(root.word);
//		tem.add(id);
//		res.add(tem);
//		tem=new ArrayList<Integer>();
//		tem.add(id);
//		tem.add(root.word);
//		res.add(tem);
//	}
//	PPNode node=root;
//	char[] arr=str.toCharArray();
//	for(int i=0;i<arr.length;i++){
//		if(node.map.containsKey(arr[i])){
//			node=node.map.get(arr[i]);
//			if(node.word!=-1){
//				if((i==arr.length-1&&node.word!=id)||(i<arr.length-1&&checkPal(str.substring(i+1)))){
//					List<Integer> tem=new ArrayList<Integer>();
//					if(rev){
//						tem.add(node.word);
//						tem.add(id);
//					}
//					else{
//						tem.add(id);
//						tem.add(node.word);
//						
//					}
//					res.add(tem);
//				}
//			}
//		}
//		else
//			return;
//	}
//}
//private boolean checkPal(String str){
//	char[] arr= str.toCharArray();
//	int start=0;
//	int end=arr.length-1;
//	while(start<end){
//		if(arr[start++]!=arr[end--])
//			return false;
//	}
//	return true;
//}
//PPNode root;
//List<List<Integer>> res=new ArrayList<List<Integer>>();
//public List<List<Integer>> palindromePairs(String[] words) {
//	StringBuilder sb=new StringBuilder();
//	root=new PPNode('\0');
//	for(int i=0;i<words.length;i++){
//		addTrie(root,sb.append(words[i]).reverse().toString(),i);
//		addTrie(root,words[i],i);
//		sb=new StringBuilder();
//	}
//	for(int i=0;i<words.length;i++){
//		getpal(words[i],i,false);
//		getpal(sb.append(words[i]).reverse().toString(),i,true);
//		sb=new StringBuilder();
//	}
//	return res;
//}