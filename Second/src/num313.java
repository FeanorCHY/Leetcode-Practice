import java.util.Arrays;

public class num313 {

    
    //O(Nlog(K)) Space O(k+n)
    // class Prime{
    //     int p;
    //     int idx;
    //     int val;
    //     public Prime(int p,int idx,int val){
    //         this.p=p;
    //         this.idx=idx;
    //         this.val=val;
    //     }
    // }
    // public int nthSuperUglyNumber(int n, int[] primes) {
    //     if(n==1||primes==null||primes.length==0)
    //         return 1;
    //     int dp[]=new int[n];
    //     dp[0]=1;
    //     PriorityQueue<Prime> pq=new PriorityQueue<Prime>(new Comparator<Prime>(){
    //         @Override
    //         public int compare(Prime p1,Prime p2){
    //             return p1.val-p2.val;
    //         }
    //     });
    //     for(int each:primes){
    //         pq.add(new Prime(each,0,each));
    //     }
    //     for(int i=1;i<n;i++){
    //         Prime cur=pq.poll();
    //         dp[i]=cur.val;
    //         cur.idx++;
    //         cur.val=cur.p*dp[cur.idx];
    //         pq.add(cur);
    //         while(pq.peek().val==dp[i]){
    //             Prime eq=pq.poll();
    //             eq.idx++;
    //             eq.val=eq.p*dp[eq.idx];
    //             pq.add(eq);
    //         }
    //     }
    //     return dp[n-1];
    // }
    
    
    //O(NK) Space O(k+n)
    // public int nthSuperUglyNumber(int n, int[] primes) {
    //     if(n==1||primes==null||primes.length==0)
    //         return 1;
    //     int idx[]=new int[primes.length];
    //     int dp[]=new int[n];
    //     dp[0]=1;
    //     for(int i=1;i<n;i++){
    //         int min=Integer.MAX_VALUE;
    //         List<Integer> list=new LinkedList<Integer>();
    //         for(int j=0;j<primes.length;j++){
    //             int tem=primes[j]*dp[idx[j]];
    //             if(min==tem){
    //                 list.add(j);
    //             }
    //             else if(tem<min){
    //                 min=tem;
    //                 list.clear();
    //                 list.add(j);
    //             }
    //         }
    //         for(int each:list)
    //             idx[each]++;
    //         dp[i]=min;
    //     }
    //     return dp[n-1];
    // }
    
    
    
    
    //optimized O(NK) Space O(k+n)
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1||primes==null||primes.length==0)
            return 1;
        int idx[]=new int[primes.length];
        int val[]=new int[primes.length];
        Arrays.fill(val,1);
        int dp[]=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                if(val[j]==dp[i-1]){
                    val[j]=dp[idx[j]++]*primes[j];
                }
                min=Math.min(min,val[j]);
            }
            dp[i]=min;
        }
        return dp[n-1];
    }
    
    
    
    
    // public int nthSuperUglyNumber(int n, int[] primes) {
    //     int[] ugly = new int[n];
    //     int[] idx = new int[primes.length];
    //     int[] val = new int[primes.length];
    //     Arrays.fill(val, 1);

    //     int next = 1;
    //     for (int i = 0; i < n; i++) {
    //         ugly[i] = next;
            
    //         next = Integer.MAX_VALUE;
    //         for (int j = 0; j < primes.length; j++) {
    //             //skip duplicate and avoid extra multiplication
    //             if (val[j] == ugly[i]) 
    //                 val[j] = ugly[idx[j]++] * primes[j];
    //             //find next ugly number
    //             next = Math.min(next, val[j]);
    //         }
    //     }

    //     return ugly[n - 1];
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
