package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class wsNode{
	char c;
	HashMap<Character,wsNode> map;
	int id=-1;
	List<Integer> list;
	public wsNode(char c){
		this.c=c;
		this.map=new HashMap<Character,wsNode>();
		this.list=new ArrayList<Integer>();
	}
}
public class num425 {
	private void addNode(String str, wsNode root,int id){
		wsNode node=root;
		char[] arr=str.toCharArray();
		for(int i=0;i<arr.length;i++){
			node.list.add(id);
			if(!node.map.containsKey(arr[i])){
				node.map.put(arr[i], new wsNode(arr[i]));
			}
			node=node.map.get(arr[i]);
		}
		node.id=id;
	}
	List<List<String>> res=new ArrayList<List<String>>();
	String[] words;
	wsNode root;
	int size;
    public List<List<String>> wordSquares(String[] words) {
    	if(words.length==0)
    		return res;
    	root=new wsNode('\0');
    	this.words=words;
    	size=words[0].length();
    	for(int i=0;i<words.length;i++)
    		addNode(words[i],root,i);
    	search(0,new ArrayList<Integer>());
        return res;
    }
    private void search(int index,List<Integer> list){
    	if(index==size){
    		List<String> tem=new ArrayList<String>(); 
    		for(int each:list){
    			tem.add(words[each]);
    		}
    		res.add(tem);
    		return;
    	}
    	if(index==0){
        	for(int i=0;i<words.length;i++){
        		list.add(i);
        		search(1,list);
        		list.remove(0);
        	}
    	}
    	else{
			int len=list.size();
			StringBuilder sb=new StringBuilder();
			wsNode node=root;
    		for(int i=0;i<list.size();i++){
    			if(!node.map.containsKey(words[list.get(i)].charAt(len)))
    				return;
    			node=node.map.get(words[list.get(i)].charAt(len));
    			sb.append(node.c);
    		}
    		for(int each:node.list){
    			list.add(each);
    			search(index+1,list);
    			list.remove(list.size()-1);
    		}
//    		getrest(index,list,node,size-index,sb);
    	}
    }
	private void getrest(int index,List<Integer> list,wsNode node,int left,StringBuilder sb){
		int len=sb.length();
		if(left==0){
			list.add(node.id);
			search(index+1,list);
			list.remove(list.size()-1);
		}
		else{
			for(char c:node.map.keySet()){
				sb.append(c);
				getrest(index,list,node.map.get(c),left-1,sb);
				sb.setLength(len);
			}
		}
	}
	public static void main(String[] args) {
		String[] test={"area","lead","wall","lady","ball"};
		num425 sol=new num425();
		System.out.println(sol.wordSquares(test));
	}

}
