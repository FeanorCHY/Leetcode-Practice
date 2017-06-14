import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num336 {
    //lower cases?
    // class PPNode{
    //     PPNode[] next=new PPNode[26];
    //     LinkedList<Integer> pos=new LinkedList<Integer>();
    //     LinkedList<Integer> rev=new LinkedList<Integer>();
    // }
    // PPNode root=new PPNode();
    // private void add(String str,int idx){
    //     char[] arr=str.toCharArray();
    //     PPNode node =root;
    //     for(char c:arr){
    //         if(node.next[c-'a']==null)
    //             node.next[c-'a']=new PPNode();
    //         node=node.next[c-'a'];
    //     }
    //     node.pos.add(idx);
    //     node =root;
    //     for(int i=arr.length-1;i>=0;i--){
    //         char c=arr[i];
    //         if(node.next[c-'a']==null)
    //             node.next[c-'a']=new PPNode();
    //         node=node.next[c-'a'];
    //     }
    //     node.rev.add(idx);
    // }
    // private void check(List<List<Integer>> res,String word,int idx){
    //     char[] arr=word.toCharArray();
    //     PPNode node =root;
    //     for(int i=0;i<=arr.length;i++){
    //         if(node.rev.size()>0&&isPal(word.substring(i))){
    //             for(int idx2:node.rev){
    //                 long mark=(((long)idx)<<31)+(long)idx2;
    //                 if(!visit.contains(mark)&&idx!=idx2){
    //                     ArrayList<Integer> list=new ArrayList<Integer>(2);
    //                     visit.add(mark);
    //                     list.add(idx);
    //                     list.add(idx2);
    //                     res.add(list);
    //                 }
    //             }
    //         }
    //         if(i==arr.length)//take care of the last character
    //             continue;
    //         if(node.next[arr[i]-'a']==null)
    //             break;
    //         node=node.next[arr[i]-'a'];
    //     }
    //     PPNode tem=node;
    //     node =root;
    //     for(int i=arr.length-1;i>=-1;i--){
    //         if(node.pos.size()>0&&isPal(word.substring(0,i+1))){
    //             for(int idx2:node.pos){
    //                 long mark=(((long)idx2)<<31)+(long)idx;
    //                 if(!visit.contains(mark)&&idx!=idx2){
    //                     ArrayList<Integer> list=new ArrayList<Integer>(2);
    //                     visit.add(mark);
    //                     list.add(idx2);
    //                     list.add(idx);
    //                     res.add(list);
    //                 }
    //             }
    //         }
    //         if(i==-1)//take care of the last character
    //             continue;
    //         if(node.next[arr[i]-'a']==null)
    //             break;
    //         node=node.next[arr[i]-'a'];
    //     }
    // }
    // HashSet<Long> visit=new HashSet<Long>();
    // public List<List<Integer>> palindromePairs(String[] words) {
    //     List<List<Integer>> res=new ArrayList<List<Integer>>();
    //     if(words==null||words.length==0)
    //         return res;
    //     for(int i=0;i<words.length;i++)
    //         add(words[i],i);
    //     for(int i=0;i<words.length;i++)
    //         check(res,words[i],i);
    //     return res;
        
    // }
    // private boolean isPal(String str){
    //     char arr[]=str.toCharArray();
    //     int l=0,r=arr.length-1;
    //     while(l<r){
    //         if(arr[l++]!=arr[r--])
    //             return false;
    //     }
    //     return true;
    // }
    
    
    
    //optimized Time O(nl) n:number of words; l:length of word
    // class PPNode{
    //     PPNode[] next=new PPNode[26];
    //     int idx=-1;
    // }
    // PPNode pos=new PPNode();
    // PPNode rev=new PPNode();
    // private void add(String str,int idx){
    //     char[] arr=str.toCharArray();
    //     PPNode node =pos;
    //     for(char c:arr){
    //         if(node.next[c-'a']==null)
    //             node.next[c-'a']=new PPNode();
    //         node=node.next[c-'a'];
    //     }
    //     node.idx=idx;
        
    //     node =rev;
    //     for(int i=arr.length-1;i>=0;i--){
    //         char c=arr[i];
    //         if(node.next[c-'a']==null)
    //             node.next[c-'a']=new PPNode();
    //         node=node.next[c-'a'];
    //     }
    //     node.idx=idx;
    // }
    // private void check(List<List<Integer>> res,String word,int idx){
    //     char[] arr=word.toCharArray();
    //     PPNode node =rev;
    //     for(int i=0;i<=arr.length;i++){
    //         if(node.idx>=0&&isPal(word.substring(i))){
    //             long mark=(((long)idx)<<31)+(long)node.idx;
    //             if(!visit.contains(mark)&&idx!=node.idx){
    //                 ArrayList<Integer> list=new ArrayList<Integer>(2);
    //                 visit.add(mark);
    //                 list.add(idx);
    //                 list.add(node.idx);
    //                 res.add(list);
    //             }
    //         }
    //         if(i==arr.length)//take care of the last character
    //             continue;
    //         if(node.next[arr[i]-'a']==null)
    //             break;
    //         node=node.next[arr[i]-'a'];
    //     }
    //     node =pos;
    //     for(int i=arr.length-1;i>=-1;i--){
    //         if(node.idx>=0&&isPal(word.substring(0,i+1))){
    //             long mark=(((long)node.idx)<<31)+(long)idx;
    //             if(!visit.contains(mark)&&idx!=node.idx){
    //                 ArrayList<Integer> list=new ArrayList<Integer>(2);
    //                 visit.add(mark);
    //                 list.add(node.idx);
    //                 list.add(idx);
    //                 res.add(list);
    //             }
    //         }
    //         if(i==-1)//take care of the last character
    //             continue;
    //         if(node.next[arr[i]-'a']==null)
    //             break;
    //         node=node.next[arr[i]-'a'];
    //     }
    // }
    // HashSet<Long> visit=new HashSet<Long>();
    // public List<List<Integer>> palindromePairs(String[] words) {
    //     List<List<Integer>> res=new ArrayList<List<Integer>>();
    //     if(words==null||words.length==0)
    //         return res;
    //     for(int i=0;i<words.length;i++)
    //         add(words[i],i);
    //     for(int i=0;i<words.length;i++)
    //         check(res,words[i],i);
    //     return res;
        
    // }
    // private boolean isPal(String str){
    //     char arr[]=str.toCharArray();
    //     int l=0,r=arr.length-1;
    //     while(l<r){
    //         if(arr[l++]!=arr[r--])
    //             return false;
    //     }
    //     return true;
    // }
    
    
    
    //HashMap Time O(nl^2)
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>(); 
        if (words == null || words.length < 2) return ret;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) map.put(words[i], i);
        for (int i=0; i<words.length; i++) {
            // System.out.println(words[i]);
            for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        ret.add(list);
                        // System.out.printf("isPal(str1): %s\n", list.toString());
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        ret.add(list);
                        // System.out.printf("isPal(str2): %s\n", list.toString());
                    }
                }
            }
        }
        return ret;
    }
    
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
