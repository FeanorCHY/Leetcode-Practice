import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class num131 {

    //HashSet and backtracking
    // HashSet<Long> set=new HashSet<Long>();
    // char[] arr;
    // String s;
    // List<List<String>> res=new LinkedList<List<String>>();
    // public List<List<String>> partition(String s) {
    //     if(s==null||s.length()==0)
    //         return res;
    //     arr=s.toCharArray();
    //     this.s=s;
    //     search(0,new LinkedList<String>());
    //     return res;
    // }
    // private void search(long idx,List<String> list){
    //     if(idx==arr.length){
    //         res.add(new LinkedList<String>(list));
    //         return;
    //     }
    //     for(long i=idx;i<arr.length;i++){
    //         if(valid(idx,i)){
    //             list.add(s.substring((int)idx,(int)i+1));
    //             search(i+1,list);
    //             list.remove(list.size()-1);
    //         }
    //     }
    // }
    // private boolean valid(long from,long to){
    //     while(from<to){
    //         if(set.contains(from+(to<<31))){
    //             return true;
    //         }
    //         if(arr[(int)from]!=arr[(int)to])
    //             return false;
    //         from++;
    //         to--;
    //     }
    //     set.add(from+(to<<31));
    //     return true;
    // }
    
    
    //dynamic programming and backtracking Time:O(N^2) Space: O(N^2)
    // int[][] dp;
    // char[] arr;
    // String s;
    // List<List<String>> res=new LinkedList<List<String>>();
    // public List<List<String>> partition(String s) {
    //     if(s==null||s.length()==0)
    //         return res;
    //     arr=s.toCharArray();
    //     this.s=s;
    //     dp=new int[s.length()][s.length()];
    //     search(0,new LinkedList<String>());
    //     return res;
    // }
    // private void search(int idx,List<String> list){
    //     if(idx==arr.length){
    //         res.add(new LinkedList<String>(list));
    //         return;
    //     }
    //     for(int i=idx;i<arr.length;i++){
    //         if(valid(idx,i)){
    //             list.add(s.substring(idx,i+1));
    //             search(i+1,list);
    //             list.remove(list.size()-1);
    //         }
    //     }
    // }
    // private boolean valid(int from,int to){
    //     int ff=from;
    //     int ft=to;
    //     while(from<to){
    //         if(dp[from][to]>0){
    //             if(dp[from][to]==1){
    //                 dp[ff][ft]=1;
    //                 return true;
    //             }
    //             else{
    //                 dp[ff][ft]=2;
    //                 return false;
    //             }
    //         }
    //         if(arr[from]!=arr[to]){
    //             dp[ff][ft]=2;
    //             return false;
    //         }
    //         from++;
    //         to--;
    //     }
    //     dp[ff][ft]=1;
    //     return true;
    // }
    
    
    
    
    //backtracking with not memory Time:O(N^2) Space: O(1)
    // int[][] dp;
    // char[] arr;
    // String s;
    // List<List<String>> res=new LinkedList<List<String>>();
    // public List<List<String>> partition(String s) {
    //     if(s==null||s.length()==0)
    //         return res;
    //     arr=s.toCharArray();
    //     this.s=s;
    //     // dp=new int[s.length()][s.length()];
    //     search(0,new LinkedList<String>());
    //     return res;
    // }
    // private void search(int idx,List<String> list){
    //     if(idx==arr.length){
    //         res.add(new LinkedList<String>(list));
    //         return;
    //     }
    //     for(int i=idx;i<arr.length;i++){
    //         if(valid(idx,i)){
    //             list.add(s.substring(idx,i+1));
    //             search(i+1,list);
    //             list.remove(list.size()-1);
    //         }
    //     }
    // }
    // private boolean valid(int from,int to){
    //     int ff=from;
    //     int ft=to;
    //     while(from<to){
    //         if(arr[from]!=arr[to]){
    //             return false;
    //         }
    //         from++;
    //         to--;
    //     }
    //     return true;
    // }
    
    
    
    //iterative with dynamic programming
    public List<List<String>> partition(String s) {
        if(s==null||s.length()==0)
            return new LinkedList<List<String>>();
        char[] arr=s.toCharArray();
        int len=s.length();
        List<List<String>> res[]=new List[len+1];
        res[0]=new LinkedList<List<String>>();
        res[0].add(new LinkedList<String>());
        boolean[][] dp=new boolean[len][len];
        for(int i=0;i<len;i++){
            res[i+1]=new LinkedList<List<String>>();
            
            for(int left=0;left<=i;left++){
                if(arr[i]==arr[left]&&(i-left<=2||dp[left+1][i-1])){
                    dp[left][i]=true;
                    String str=s.substring(left,i+1);
                    for(List<String> tem:res[left]){
                        List<String> list=new LinkedList<String>(tem);
                        list.add(str);
                        res[i+1].add(list);
                    }
                }
            }
        }
        return res[len];
    }
	public static void main(String[] args) {
		num131 sol=new num131();
		System.out.println(sol.partition("ssssss").size());
		Iterator<Integer> i=new ArrayList<Integer>().iterator();
	}

}
