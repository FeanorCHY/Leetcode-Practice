import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num030 {
    //dp+trie Time O(N) Space O(N)
    //lower cases?
    // class FSNode{
    //     FSNode[] next=new FSNode[26];
    //     int count=0;
    // }
    // FSNode root=new FSNode();
    // private void insert(String str){
    //     char[] arr=str.toCharArray();
    //     FSNode node=root;
    //     for(char c:arr){
    //         if(node.next[c-'a']==null)
    //             node.next[c-'a']=new FSNode();
    //         node=node.next[c-'a'];
    //     }
    //     node.count++;
    // }
    // public List<Integer> findSubstring(String s, String[] words) {
    //     if(s==null||words==null||words.length==0||s.length()==0)
    //         return new ArrayList<Integer>();
    //     List<Integer> res=new ArrayList<Integer>(s.length());
    //     for(String str:words)
    //         insert(str);
    //     int len=words.length;
    //     char[] arr=s.toCharArray();
    //     boolean[] fail=new boolean[arr.length];
    //     FSNode[] dp=new FSNode[arr.length];
    //     int wid=words[0].length();
    //     for(int i=0;i+len*wid<=arr.length;i++){
    //         if(search(len,wid,i,arr,fail,dp))
    //             res.add(i);
    //     }
    //     return res;
    // }
    // private boolean search(int rest,int wid,int idx,char[] arr,boolean[] fail,FSNode[] dp){
    //     if(rest==0)
    //         return true;
    //     else if(idx==arr.length)
    //         return false;
    //     if(fail[idx]||idx+wid>arr.length)
    //         return false;
    //     if(dp[idx]==null){
    //         FSNode node=root;
    //         for(int i=idx;i<idx+wid;i++){
    //             if(node.next[arr[i]-'a']==null){
    //                 fail[idx]=true;
    //                 return false;
    //             }
    //             node=node.next[arr[i]-'a'];
    //         }
    //         dp[idx]=node;
    //     }
    //     if(dp[idx].count==0)
    //         return false;
    //     else{
    //         dp[idx].count--;
    //         boolean out=search(rest-1,wid,idx+wid,arr,fail,dp);
    //         dp[idx].count++;
    //         return out;
    //     }
    // }
    
    //HashMap Time O(N^2) Space O(N)
    // public static List<Integer> findSubstring(String S, String[] L) {
    //     List<Integer> res = new ArrayList<Integer>();
    //     if(S==null||L==null||L.length==0||S.length()==0||L[0].length()*L.length>S.length())
    //         return new ArrayList<Integer>();
    //     int count[]=new int[L.length];
    //     int wid=L[0].length();
    //     HashMap<String,Integer> map=new HashMap<String,Integer>(L.length);
    //     for(int i=0;i<L.length;i++){
    //         if(!map.containsKey(L[i]))
    //             map.put(L[i],i);
    //         count[map.get(L[i])]++;
    //     }
    //     for(int i=0;i+wid*L.length<=S.length();i++){
    //         int[] copy=count.clone();
    //         for(int j=0;j<L.length;j++){
    //             String str=S.substring(i+j*wid,i+(j+1)*wid);
    //             if(map.containsKey(str)&&copy[map.get(str)]>0){
    //                 copy[map.get(str)]--;
    //                 if(j==L.length-1)
    //                     res.add(i);
    //             }
    //             else
    //                 break;
    //         }
    //     }
    //     return res;
    // }
    
    //sliding window
	public List<Integer> findSubstring(String s, String[] words) {
		int N = s.length();
		List<Integer> indexes = new ArrayList<Integer>(s.length());
		if (words.length == 0) {
			return indexes;
		}
		int M = words[0].length();
		if (N < M * words.length) {
			return indexes;
		}
		int last = N - M + 1;
		
		//map each string in words array to some index and compute target counters
		Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
		int [][] table = new int[2][words.length];
		int failures = 0, index = 0;
		for (int i = 0; i < words.length; ++i) {
			Integer mapped = mapping.get(words[i]);
			if (mapped == null) {
				++failures;
				mapping.put(words[i], index);
				mapped = index++;
			}
			++table[0][mapped];
		}
		
		//find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
		int [] smapping = new int[last];
		for (int i = 0; i < last; ++i) {
			String section = s.substring(i, i + M);
			Integer mapped = mapping.get(section);
			if (mapped == null) {
				smapping[i] = -1;
			} else {
				smapping[i] = mapped;
			}
		}
		
		//fix the number of linear scans
		for (int i = 0; i < M; ++i) {
			//reset scan variables
			int currentFailures = failures; //number of current mismatches
			int left = i, right = i;
			Arrays.fill(table[1], 0);
			//here, simple solve the minimum-window-substring problem
			while (right < last) {
				while(right<last&&smapping[right]>=0&&table[1][smapping[right]]<table[0][smapping[right]]){
					table[1][smapping[right]]++;
					right+=M;
				}
				if(right-left==M*words.length){
					indexes.add(left);
					table[1][smapping[left]]--;
					left+=M;
				}
				else{
					if(right==left){
						left+=M;
						right+=M;
					}
					else{
						table[1][smapping[left]]--;
						left+=M;
					}
				}
			}
			
		}
		return indexes;
	}
	public static void main(String[] args) {
		String s="barfoothefoobarman";
		String[] test={"foo", "bar"};
		num030 sol=new num030();
		System.out.println(sol.findSubstring(s, test));

	}

}
