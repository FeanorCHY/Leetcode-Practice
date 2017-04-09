import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class num140 {
    //are words in dictionary all valid? can single word be counted as result
    //HashSet+memorization Time O(2^N) Space O(2^N)
    // HashSet<String> set;
    // List<String> dp[];
    // String s;
    // public List<String> wordBreak(String s, List<String> wordDict) {
    //     set=new HashSet<String>(wordDict);
    //     List<String> res=new LinkedList<String>();
    //     if(s==null||s.length()==0||wordDict==null||wordDict.size()==0)
    //         return res;
    //     dp=new List[s.length()];
    //     this.s=s;
    //     return search(0);
    // }
    // private List<String> search(int idx){
    //     if(dp[idx]!=null)
    //         return dp[idx];
    //     List<String> res=new LinkedList<String>();
    //     for(int i=idx;i<s.length();i++){
    //         String sub=s.substring(idx,i+1);
    //         if(set.contains(sub)){
    //             if(i+1==s.length()){
    //                 res.add(sub);
    //                 break;
    //             }
    //             List<String> next=search(i+1);
    //             for(String str:next)
    //                 res.add(sub+" "+str);
    //         }
    //     }
    //     dp[idx]=res;
    //     return res;
    // }
    
    
    
    //Trie
    class TrieNode{
        TrieNode[] next=new TrieNode[256];
        boolean end=false;
    }
    TrieNode root=new TrieNode();
    List<String> dp[];
    char[] arr;
    private void add(String str){
        char[] starr=str.toCharArray();
        TrieNode node=root;
        for(int i=0;i<starr.length;i++){
            if(node.next[starr[i]]==null)
                node.next[starr[i]]=new TrieNode();
            node=node.next[starr[i]];
        }
        node.end=true;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s==null||s.length()==0||wordDict==null||wordDict.size()==0)
            return new LinkedList<String>();
        for(String str:wordDict)
            add(str);
        dp=new List[s.length()];
        this.arr=s.toCharArray();
        return search(0);
    }
    private List<String> search(int idx){
        if(dp[idx]!=null)
            return dp[idx];
        List<String> res=new ArrayList<String>();
        TrieNode node=root;
        int cur=idx;
        StringBuilder sb=new StringBuilder(arr.length);
        while(node!=null&&cur<arr.length){
            sb.append(arr[cur]);
            node=node.next[arr[cur++]];
            if(node!=null&&node.end){
                if(cur==arr.length){
                    res.add(sb.toString());
                    break;
                }
                List<String> next=search(cur);
                for(String str:next)
                    res.add(sb.toString()+" "+str);
            }
        }
        dp[idx]=res;
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
