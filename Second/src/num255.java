
public class num255 {
    //Time: O(N^2) Space O(1)
    // public boolean verifyPreorder(int[] pre) {
    //     if(pre==null)
    //         return false;
    //     if(pre.length<=1)
    //         return true;
    //     int min=-1;
    //     int max=-1;
    //     for(int i=1;i<pre.length;i++){
    //         if(pre[i]<pre[i-1]){
    //             if(min>=0&&pre[i]<=pre[min])
    //                 return false;
    //             max=i-1;
    //         }
    //         else if(pre[i]>pre[i-1]){
    //             if(max!=-1&&pre[i]>pre[max]){
    //                 int k=max;
    //                 while(k>=0&&pre[i]>pre[k]){
    //                     if(min==-1||pre[k]>=pre[min])
    //                         min=k;
    //                     k--;
    //                 }
    //                 max=k;
    //             }
    //             else if(max==-1||pre[i]<pre[max])
    //                 min=i-1;
    //             else
    //                 return false;
    //         }
    //         else
    //             return false;
    //     }
    //     return true;
    // }
    
    
    //concise one Time: O(N) Space O(1)
    public boolean verifyPreorder(int[] pre) {
        if(pre==null)
            return false;
        if(pre.length<=1)
            return true;
        int idx=-1,min=Integer.MIN_VALUE;
        for(int p:pre){
            if(p<=min)
                return false;
            while(idx>=0&&p>pre[idx])
                min=pre[idx--];
            pre[++idx]=p;
        }
        return true;
    }
	public static void main(String[] args) {
		int[] test={10,6,3,8,7,9};
		num255 sol=new num255();
		sol.verifyPreorder(test);
	}

}
