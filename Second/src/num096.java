import java.util.Arrays;

public class num096 {

    //Math O(N)
    public int numTrees(int n) {
        if(n<0)
            return 0;
        if(n==0||n==1)
            return 1;
        long ans=1;
        for(long i=n+1;i<=2*n;i++){
            ans=ans*i/(i-n);
        }
//        for(long i=2;i<=n;i++)
//            ans/=i;
        return (int)(ans/((long)n+1));
    }
    
    
    //dynamic programming with iterative 
    //O(NlogN)
    // public int numTrees(int n) {
    //     if(n<0)
    //         return 0;
    //     if(n==0||n==1)
    //         return 1;
    //     int[] dp=new int[n+1];
    //     dp[0]=1;
    //     dp[1]=1;
    //     for(int i=2;i<=n;i++){
    //         for(int l=0;l<i/2;l++){
    //             dp[i]+=2*dp[l]*dp[i-1-l];
    //         }
    //         if(i%2==1){
    //             dp[i]+=dp[i/2]*dp[i/2];
    //         }
    //     }
    //     return dp[n];
    // }
    
    
    //what if empty tree?
    //backtracking. O(NlogN)
    // HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    // public int numTrees(int n) {
    //     if(n<0)
    //         return 0;
    //     if(n==0||n==1)
    //         return 1;
    //     if(map.containsKey(n))
    //         return map.get(n);
    //     int sum=0;
    //     for(int l=0;l<n/2;l++){
    //         sum+=2*numTrees(l)*numTrees(n-1-l);
    //     }
    //     if(n%2==1)
    //         sum+=numTrees(n/2)*numTrees(n/2);
    //     map.put(n,sum);
    //     return sum;
    // }
	public static void main(String[] args) {
		num096 sol=new num096();
		sol.numTrees(3);
	}

}
