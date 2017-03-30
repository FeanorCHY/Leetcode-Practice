import java.util.LinkedList;

public class num395 {

    //two pointer O(N^2)
    public int longestSubstring(String s, int k) {
        if(s==null||s.length()==0||k>s.length())
            return 0;
        if(k<=1)
            return s.length();
        int max=0;
        char[] arr=s.toCharArray();
        for(int i=1;i<=26;i++){
            int left=0;
            int right=0;
            int cur=0,count=0;
            int[] alp=new int[26];
            for(;right<arr.length;){
                if(alp[arr[right]-'a']==0)
                    count++;
                if(++alp[arr[right]-'a']==k)
                    cur++;
                right++;
                while(count>i){
                    if(alp[arr[left]-'a']==k)
                        cur--;
                    if(--alp[arr[left]-'a']==0)
                        count--;
                    left++;
                }
                if(count==cur){
                    max=Math.max(max,right-left);
                }
            }
        }
        
        
        
        return max;
    }


    //divide and conquer with recursive O(N^2)
    // public int longestSubstring(String s, int k) {
    //     if(s==null||s.length()==0||k>s.length())
    //         return 0;
    //     if(k<=1)
    //         return s.length();
    //     char[] arr=s.toCharArray();
    //     int cur=0,count=0,left=0;
    //     int[] alp=new int[26];
    //     for(int i=0;i<arr.length;i++){
    //         if(alp[arr[i]-'a']==0)
    //             count++;
    //         if(++alp[arr[i]-'a']==k)
    //             cur++;
    //     }
    //     if(cur==0)
    //         return 0;
    //     if(count==cur)
    //         return s.length();
    //     int last=0;
    //     int res=0;
    //     for(int i=0;i<arr.length;i++){
    //         if(alp[arr[i]-'a']<k){
    //             if(last==i||i-last<k)
    //                 last=last+1;
    //             else{
    //                 res=Math.max(res,longestSubstring(s.substring(last,i),k));
    //                 last=i+1;
    //             }
    //         }
    //     }
    //     res=Math.max(res,longestSubstring(s.substring(last,arr.length),k));
    //     return res;
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> pos=new LinkedList<Integer>();
//		pos.get;
	}

}
