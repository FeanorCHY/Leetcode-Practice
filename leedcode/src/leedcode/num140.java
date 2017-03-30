package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class num140 {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s,dict,map);
    }

    public ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo){
        if(memo.containsKey(s)) return memo.get(s);
        ArrayList<String> result = new ArrayList<String>();
        int n = s.length();
        if(n <= 0) return result;
        for(int len = 1; len <= n; ++len){
            String subfix = s.substring(0,len);
            if(dict.contains(subfix)){
                if(len == n){
                    result.add(subfix);
                }else{
                    String prefix = s.substring(len);
                    ArrayList<String> tmp = wordBreakHelper(prefix, dict, memo);
                    for(String item:tmp){
                        item = subfix + " " + item;
                        result.add(item);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    }
	public static void main(String[] args) {
//		StringBuilder sb=new StringBuilder();
//		sb.append("123456789");
//		sb.delete(6, sb.length());
//		System.out.println(sb.toString());
		num140 sol=new num140();
		String[] test={"cat", "cats", "and", "sand", "dog"};
		Set<String> set=new HashSet<String>();
		for(int i=0;i<test.length;i++){
			set.add(test[i]);
		}
		System.out.println(sol.wordBreak("catsanddog",set));
		
	}

}


//HashMap<Integer,List<Integer>> hm=new HashMap<Integer,List<Integer>>();
//List<String> result=new ArrayList<String>();
//String s;
//public List<String> wordBreak(String s, Set<String> wordDict) {
//	this.s=s;
//	hm.put(0, new ArrayList<Integer>());
//	char[] arr=s.toCharArray();
//	for(int i=1;i<=arr.length;i++){
//		List<Integer> list=new ArrayList<Integer>();
//		for(int index:hm.keySet()){
//			if(wordDict.contains(s.substring(index,i))){
//				list.add(index);
//			}
//		}
//		if(list.size()>0)
//			hm.put(i, list);
//	}
//	build(new StringBuilder(),s.length());
//	return result;
//}
//public void build(StringBuilder sb,int index){
//	if(index==0){
//		result.add(sb.toString());
//		return;
//	}
//	List<Integer> list=hm.get(index);
//	if(list==null)
//		return;
//	for(int each:list){
//		int len=sb.length();
//		sb.insert(0,(each==0?"":" ")+s.substring(each, index));
//		build(sb,each);
//		sb.delete(0, index-each+(each==0?0:1));
//	}
//}
