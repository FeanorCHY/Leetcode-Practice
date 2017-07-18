import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class num126 {

    //dfs+trie TLE
    // class FLNode{
    //     FLNode next[]=new FLNode[26];
    //     boolean used=false;
    // }
    // FLNode root=new FLNode();
    // private void insert(String str){
    //     FLNode node=root;
    //     for(char c:str.toCharArray()){
    //         if(node.next[c-'a']==null)
    //             node.next[c-'a']=new FLNode();
    //         node=node.next[c-'a'];
    //     }
    // }
    // int min;
    // public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    //     if(wordList==null||wordList.size()==0)
    //         return new ArrayList<List<String>>();
    //     this.min=wordList.size()+1;
    //     List<List<String>>[] res=new List[wordList.size()+1];
    //     for(String str:wordList)
    //         insert(str);
    //     FLNode self=isContained(beginWord.toCharArray(),0,root);
    //     if(self!=null)
    //         self.used=true;
    //     List<String> list=new ArrayList<String>(wordList.size()+1);
    //     list.add(beginWord);
    //     search(res,list,beginWord,endWord,1);
    //     for(int i=1;i<res.length;i++){
    //         if(res[i]!=null)
    //             return res[i];
    //     }
    //     return new ArrayList<List<String>>();
    // }
    // private void search(List<List<String>> res[],List<String> list,String cur,String target,int l){
    //     if(l>min)
    //         return;
    //     if(cur.equals(target)){
    //         if(res[list.size()]==null)
    //             res[list.size()]=new ArrayList<List<String>>(res.length);
    //         res[list.size()].add(new ArrayList<String>(list));
    //         min=Math.min(min,list.size());
    //         return;
    //     }
    //     char[] arr=cur.toCharArray();
    //     FLNode node=root;
    //     for(int i=0;i<arr.length;i++){
    //         char c=arr[i];
    //         for(char ch='a';ch<='z';ch++){
    //             if(ch!=c){
    //                 arr[i]=ch;
    //                 FLNode last=isContained(arr,i,node);
    //                 if(last!=null&&!last.used){
    //                     last.used=true;
    //                     String str=new String(arr);
    //                     list.add(str);
    //                     search(res,list,str,target,l+1);
    //                     list.remove(list.size()-1);
    //                     last.used=false;
    //                 }
    //                 arr[i]=c;
    //             }
    //         }
    //         node=node.next[c-'a'];
    //         if(node==null)
    //             return;
    //     }
    // }
    // private FLNode isContained(char[] arr,int idx,FLNode node){
    //     for(int i=idx;i<arr.length;i++){
    //         char c=arr[i];
    //         if(node.next[c-'a']==null)
    //             return null;
    //         node=node.next[c-'a'];
    //     }
    //     return node;
    // }
    
    
    
    // public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    //     List<List<String>> res=new LinkedList<List<String>>();
    //     if(wordList==null||wordList.size()==0)
    //         return new ArrayList<List<String>>();
    //     Queue<List<String>> q=new LinkedList<List<String>>();
    //     HashSet<String> set=new HashSet<String>(wordList);
    //     HashSet<String> visit=new HashSet<String>();
    //     visit.add(beginWord);
    //     if(!set.contains(endWord))
    //         return res;
    //     set.remove(beginWord);
    //     List<String> list=new ArrayList(wordList.size()+1);
    //     list.add(beginWord);
    //     q.add(list);
    //     boolean find=false;;
    //     while(!find&&!q.isEmpty()){
    //         int size=q.size();
    //         HashSet<String> hs=new HashSet<String>();
    //         for(int t=0;t<size;t++){
    //             list=q.poll();
    //             String s=list.get(list.size()-1);
    //             char[] arr=s.toCharArray();
    //             for(int i=0;i<arr.length;i++){
    //                 char tem=arr[i];
    //                 for(char c='a';c<='z';c++){
    //                     arr[i]=c;
    //                     String str=new String(arr);
    //                     if(set.contains(str)){
    //                         List<String> tl=new ArrayList(list);
    //                         tl.add(str);
    //                         hs.add(str);
    //                         if(str.equals(endWord)){
    //                             find=true;
    //                             res.add(tl);
    //                         }
    //                         else
    //                         	q.add(tl);
    //                     }
    //                 }
    //                 arr[i]=tem;
    //             }
    //         }
    //         set.removeAll(hs);
    //     }
    //     return res;
    // }
    
    public List<List<String>> findLadders(String start, String end, List<String> words) {
        Set<String> dict=new HashSet(words);
        if(!dict.contains(end))
            return new ArrayList<List<String>>();
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        set1.add(start);
        set2.add(end);
        
        HashMap<String,List<String>> map=new HashMap<String,List<String>>();
        search(map,set1,set2,dict,false);
        List<List<String>> res=new ArrayList<List<String>>();
        List<String> list=new ArrayList<String>();
        list.add(start);
        construct(map,end,start,res,list);
        return res;
    }
    private boolean search(HashMap<String,List<String>> map,Set<String> set1,Set<String> set2,Set<String> dict,boolean flip){
        if (set1.isEmpty()) {
          return false;
        }
        boolean find=false;
        if(set1.size()>set2.size()){
            return search(map,set2,set1,dict,!flip);
        }
        dict.removeAll(set1);
        dict.removeAll(set2);
        Set<String> set = new HashSet<String>();
        for(String str:set1){
            char[] arr=str.toCharArray();
            for(int i=0;i<arr.length;i++){
                char tem=arr[i];
                for(char c='a';c<='z';c++){
                    arr[i]=c;
                    String s=new String(arr);
                    String key=!flip?str:s;
                    String value=flip?str:s;
                    List<String> list=map.containsKey(key)?map.get(key):new ArrayList<String>();
                    if(set2.contains(s)){
                        find=true;
                        list.add(value);
                        map.put(key, list);
                    }
                    else if(dict.contains(s)){
                    	list.add(value);
                    	map.put(key, list);
                        set.add(s);
                    }
                }
                arr[i]=tem;
            }
        }
        return find||search(map,set2,set,dict,!flip);
    }
    private void construct(HashMap<String,List<String>> map,String end,String cur,List<List<String>> res,List<String> list){
    	if(cur.equals(end)){
    		List<String> tem=new ArrayList<String>(list);
    		res.add(tem);
    		return;
    	}
    	if(!map.containsKey(cur))
    		return;
    	for(String next:map.get(cur)){
    		list.add(next);
    		construct(map,end,next,res,list);
    		list.remove(list.size()-1);
    	}
    }
	public static void main(String[] args) {
//		String[] test={"ted","tex","red","tax","tad","den","rex","pee"};
//		List<String> wordList=new ArrayList<String>();
//		for(String t:test)
//			wordList.add(t);
//		num126 sol=new num126();
//		System.out.println(sol.findLadders("red", "tax", wordList));
		

		String[] test={"hot","dog"};
		List<String> wordList=new ArrayList<String>();
		for(String t:test)
			wordList.add(t);
		num126 sol=new num126();
		System.out.println(sol.findLadders("hot", "dog", wordList));
	}

}
