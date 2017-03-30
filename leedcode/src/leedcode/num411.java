package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class TrieAbb{
	char cur;
	HashMap<Character,TrieAbb> map;
	public TrieAbb(char c){
		this.map=new HashMap<Character,TrieAbb>();
		this.cur=c;
	}
}
public class num411 {
	public void addTrie(TrieAbb node,String str){
		if(str.length()==0)
			return;
		char first=str.charAt(0);
		if(node.map.containsKey(first)){
			addTrie(node.map.get(first),str.substring(1));
		}
		else{
			TrieAbb tem=new TrieAbb(first);
			node.map.put(first, tem);
			addTrie(tem,str.substring(1));
		}
	}
	public boolean isAbb(TrieAbb node,String str,int pos){
		if(str.length()==0)
			return true;
		if(pos>0){
			for(TrieAbb each:node.map.values())
				if(isAbb(each,str,pos-1))
					return true;
		}
		else{
			char[] arr=str.toCharArray();
			int idx=0;
			int num=0;
			while(idx<arr.length&&arr[idx]>='0'&&arr[idx]<='9'){
				num+=arr[idx]-'0';
				idx++;
			}
			if(num>0){
				String next=str.substring(idx);
				if(isAbb(node,next,num))
					return true;
			}
			else{
				if(node.map.containsKey(str.charAt(0))&&isAbb(node.map.get(str.charAt(0)),str.substring(1),0))
					return true;
			}
		}
		return false;
		
	}
	public void genAbb(int len,int s,StringBuilder sb){
		boolean isnum=sb.length()>0&&sb.charAt(sb.length()-1)>='0'&&sb.charAt(sb.length()-1)<='9';
		if(len==1){
			if(!isnum&&tar.length>s)
				array.add(sb.toString()+(tar.length-s));
			if(s==tar.length-1)
				array.add(sb.toString()+tar[s]);
		}
		else{
			int last=sb.length();
			if(s<tar.length){
				sb.append(tar[s]);
				genAbb(len-1,s+1,sb);
				sb.delete(last, sb.length());
			}
			if(!isnum){
				for(int i=2;i<=tar.length-s;i++){
					sb.append(i);
					genAbb(len-1,s+i,sb);
					sb.delete(last, sb.length());
				}
			}
		}
	}
	char[] tar;
	ArrayList<String> array=new ArrayList<String>();
    public String minAbbreviation(String target, String[] dictionary) {
    	tar=target.toCharArray();
    	TrieAbb root=new TrieAbb('\0');
    	int len=target.length();
    	for(String str:dictionary){
    		if(str.length()==len){
    			addTrie(root,str);
    		}
    	}
    	if(root.map.size()==0)
    		return len+"";
    	int l=1;
    	int r=tar.length;
    	String res="";
    	while(l<=r){
    		int mid=(l+r)/2;
    		array.clear();
    		genAbb(mid,0,new StringBuilder());
    		int tem=l;
			l=mid+1;
    		for(String each:array){
    			if(!isAbb(root,each,0)){
    				r=mid-1;
    				res=each;
    				l=tem;
    				break;
    			}
    		}
    	}
    	return res;
    }

	public static void main(String[] args) {
		String[] str={"kkk"};//{"plain", "amber", "blade"};
		num411 sol=new num411();
		System.out.println(sol.minAbbreviation("apple", str));
	}

}

//class Node{ // Trie Node
//    Node[] nodes;
//    boolean isWord;
//    Node(){
//        nodes = new Node[26];
//        isWord = false;
//    }
//    void add(String str){ // add a word to Trie
//        if (str.length() == 0) isWord=true; // end of a word
//        else {
//            int idx = str.charAt(0)-'a'; // insert a new node
//            if (nodes[idx] == null) 
//            	nodes[idx] = new Node();
//            nodes[idx].add(str.substring(1));
//        }
//    }
//    boolean isAbbr(String abbr, int num){
//        if ( num > 0){ // number of '*'
//            for (Node node : nodes){ 
//                if (node != null && node.isAbbr(abbr, num-1)) return true; 
//            }
//            return false; // not exist in the dictionary
//        } else {
//            if (abbr.length()==0) return isWord; // at the end of the addr
//            int idx=0; // get the number of '*' at the start of the abbr
//            while (idx < abbr.length() && abbr.charAt(idx) >='0' && abbr.charAt(idx) <='9' ) {
//                num = (num*10) + (abbr.charAt(idx++)-'0'); 
//            }
//            if (num>0) 
//            	return isAbbr(abbr.substring(idx),num); // start with number
//            else { // start with non-number
//                if (nodes[abbr.charAt(0)-'a'] != null )   
//                    return nodes[abbr.charAt(0)-'a'].isAbbr(abbr.substring(1), 0);
//                else 
//                	return false; // not exist in the dictionary 
//            }
//        }
//    }
//}
//
//void getAbbs(char[] cc, int s, int len, StringBuilder sb, List<String> abbs){ //DFS with backtracking
//    boolean preNum = (sb.length() > 0 ) && (sb.charAt(sb.length()-1) >= '0') && (sb.charAt(sb.length()-1) <= '9');
//    if (len == 1)  { 
//        if ( s  < cc.length) {
//            if (s==cc.length-1) abbs.add(sb.toString() + cc[s]); // add one char
//            if (! preNum ) abbs.add(sb.toString() + (cc.length-s) ); // add a number
//        }
//    } else if (len > 1 ) {
//        int last = sb.length();
//        for (int i=s+1; i < cc.length; i++ ){
//            if (! preNum) { // add a number
//                sb.append(i-s);
//                getAbbs(cc, i, len-1, sb, abbs);
//                sb.delete(last, sb.length());
//            }
//            if (i==s+1) { // add one char
//                sb.append(cc[s]);
//                getAbbs(cc, s+1, len-1, sb, abbs);
//                sb.delete(last, sb.length());
//                break;
//            }
//        }
//    }
//}
//
//public String minAbbreviation(String target, String[] dictionary) {
//    List<String> dict = new ArrayList();
//    int len = target.length();
//    for (String str : dictionary) 
//    	if (str.length() == len ) 
//    		dict.add(str);
//    if (dict.isEmpty()) 
//    	return ""+len;
//    Node root = new Node();
//    for (String str : dict) 
//    	root.add(str);
//    char[] cc = target.toCharArray();
//    String ret = null;
//
//    int min = 1, max = len; 
//    while (max >= min) {
//        int mid = min+(max-min)/2;
//        List<String> abbs = new ArrayList();
//        getAbbs(cc, 0, mid, new StringBuilder(), abbs);
//        boolean conflict = true;
//        for (String abbr: abbs){
//            if ( ! root.isAbbr(abbr,0) ) {
//                conflict = false;
//                ret = abbr;
//                break;
//            } 
//        }
//        if (conflict) {
//            min = mid+1;
//        } else {
//            max = mid-1;
//        }
//    }
//    return ret;
//}