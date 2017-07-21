import java.util.LinkedList;
import java.util.Queue;

public class num269 {

    //bfs
    // class AONode{
    //     boolean[] next=new boolean[26];
    //     int inlink=0;
    // }
    // public String alienOrder(String[] words) {
    //     if(words==null||words.length==0)
    //         return "";
    //     AONode[] alp=new AONode[26];
    //     for(String word:words){
    //         for(char c:word.toCharArray())//each word must be added
    //             alp[c-'a']=new AONode();
    //     }
    //     for(int i=1;i<words.length;i++){
    //         char[] arr=words[i].toCharArray();
    //         char[] arr0=null;
    //         if(i>0)
    //             arr0=words[i-1].toCharArray();
    //         for(int j=0;j<arr.length;j++){
    //             if(j<arr0.length&&arr0[j]!=arr[j]){
    //                 char last=arr0[j];
    //                 char c=arr[j];
    //                 if(!alp[last-'a'].next[c-'a']){
    //                     alp[last-'a'].next[c-'a']=true;
    //                     alp[c-'a'].inlink++;   
    //                 }
    //                 break;
    //             }
    //         }
    //     }
    //     int c=0;
    //     Queue<AONode> q=new LinkedList<AONode>();
    //     int n=0;
    //     StringBuilder res=new StringBuilder();
    //     for(int i=0;i<26;i++){
    //         if(alp[i]!=null){
    //             n++;
    //             if(alp[i].inlink==0){
    //                 res.append((char)(i+'a'));
    //                 q.add(alp[i]);
    //             }
    //         }
    //     }
    //     int count=q.size();
    //     while(!q.isEmpty()){
    //         AONode node=q.poll();
    //         for(int i=0;i<26;i++){
    //             if(node.next[i]){
    //                 alp[i].inlink--;
    //                 if(alp[i].inlink==0){
    //                     count++;
    //                     res.append((char)(i+'a'));
    //                     q.add(alp[i]);
    //                 }
    //             }
    //         }
    //     }
    //     return count==n?res.toString():"";
    // }
    
    
    //dfs
    public String alienOrder(String[] words) {
        if(words==null||words.length==0)
            return "";
        boolean[][] adj=new boolean[26][26];
        int[] visit=new int[26];
        for(String word:words){
            for(char c:word.toCharArray())//each word must be added
                visit[c-'a']=1;
        }
        for(int i=1;i<words.length;i++){
            char[] arr1=words[i-1].toCharArray();
            char[] arr2=words[i].toCharArray();
            for(int j=0;j<Math.min(arr1.length,arr2.length);j++){
                if(arr1[j]!=arr2[j]){
                    adj[arr1[j]-'a'][arr2[j]-'a']=true;
                    break;
                }
            }
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<26;i++){
            if(visit[i]==1){
                if(!search(adj,visit,i,res))
                    return "";
            }         
        }
        return res.reverse().toString();
    }
    private boolean search(boolean[][] adj,int[] visit,int last,StringBuilder res){
        visit[last]=2;
        for(int i=0;i<26;i++){
            if(adj[last][i]&&visit[i]==2)
                return false;
            if(adj[last][i]&&visit[i]==1){
                if(!search(adj,visit,i,res))
                    return false;
            }
        }
        visit[last]=3;
        res.append((char)(last+'a'));
        return true;
    }
	public static void main(String[] args) {
		num269 sol=new num269();
		String[] test={"za","zb","ca","cb"};
		System.out.println(sol.alienOrder(test));
	}

}
