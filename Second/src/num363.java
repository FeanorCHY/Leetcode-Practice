import java.util.Arrays;
import java.util.TreeSet;

public class num363 {

    //TreeSet Time O(min(m,n)^2*max(m,n)*log(max(m,n))) Space O(m)
    // public int maxSumSubmatrix(int[][] matrix, int k) {
    //     if(matrix==null||matrix.length==0||matrix[0].length==0)
    //         return -1;
    //     int m=matrix.length;
    //     int n=matrix[0].length;
    //     int res=Integer.MIN_VALUE;
    //     for(int i=0;i<Math.min(m,n);i++){
    //         res=Math.max(res,Search(matrix,k,i,i));
    //     }
    //     return res;
    // }
    // private int Search(int[][] matrix,int k,int x,int y){
    //     int m=matrix.length;
    //     int n=matrix[0].length;
    //     int[] XSum=new int[n];
    //     int[] LXSum=new int[n];
    //     int res=Integer.MIN_VALUE;
    //     TreeSet<Integer> sets[]=new TreeSet[n];
    //     for(int j=y;j<n;j++){
    //         sets[j]=new TreeSet<Integer>();
    //         sets[j].add(0);
    //     }
    //     for(int i=x;i<m;i++){
    //         TreeSet<Integer> set=new TreeSet<Integer>();
    //         set.add(0);
    //         for(int j=y;j<n;j++){
    //             XSum[j]=(j==0?0:XSum[j-1])+matrix[i][j];
    //             int sum=XSum[j]+LXSum[j];
    //             LXSum[j]=sum;
    //             Integer ce=set.ceiling(sum-k);
    //             res=Math.max(ce==null?res:sum-ce,res);
    //             Integer up=sets[j].ceiling(sum-k);
    //             res=Math.max(up==null?res:sum-up,res);
    //             set.add(sum);
    //             sets[j].add(sum);
    //         }
    //     }
    //     return res;
    // }
    
    
    //if small Column then transposed: TreeSet Time O(m*mn*logn) Space O(m)
    // public int maxSumSubmatrix(int[][] matrix, int k) {
    //     if(matrix==null||matrix.length==0||matrix[0].length==0)
    //         return -1;
    //     int m=Math.min(matrix.length,matrix[0].length);
    //     int n=Math.max(matrix.length,matrix[0].length);
    //     int res=Integer.MIN_VALUE;
    //     for(int i=0;i<m;i++){
    //         res=Math.max(res,Search(matrix,k,i,0,matrix.length<=matrix[0].length,m,n));
    //         if (res == k) return k;
    //     }
    //     return res;
    // }
    // private int Search(int[][] matrix,int k,int x,int y,boolean BigCol,int m,int n){
    //     int[] XSum=new int[n];
    //     int[] LXSum=new int[n];
    //     int res=Integer.MIN_VALUE;
    //     for(int i=x;i<m;i++){
    //         TreeSet<Integer> set=new TreeSet<Integer>();
    //         set.add(0);
    //         for(int j=y;j<n;j++){
    //             XSum[j]=(j==0?0:XSum[j-1])+(BigCol?matrix[i][j]:matrix[j][i]);
    //             int sum=XSum[j]+LXSum[j];
    //             LXSum[j]=sum;
    //             Integer ce=set.ceiling(sum-k);
    //             res=Math.max(ce==null?res:sum-ce,res);
    //             set.add(sum);
    //             if (res == k) return k;
    //         }
    //     }
    //     return res;
    // }
    
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return -1;
        int m=Math.min(matrix.length,matrix[0].length);
        int n=Math.max(matrix.length,matrix[0].length);
        int res=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            res=Math.max(res,Search(matrix,k,i,matrix.length<=matrix[0].length,m,n));
            if (res == k) return k;
        }
        return res;
    }
    private int Search(int[][] matrix,int k,int x,boolean BigCol,int m,int n){
        int[] XSum=new int[n];
        int[] LXSum=new int[n+1];
        int res=Integer.MIN_VALUE;
        for(int i=x;i<m;i++){
            for(int j=0;j<n;j++){
                XSum[j]+=(BigCol?matrix[i][j]:matrix[j][i]);
                LXSum[j+1]=XSum[j]+LXSum[j];
            }
            res=Math.max(res,merge(LXSum,0,n,k));
            if (res == k) return k;
        }
        return res;
    }
    private int merge(int[] sum,int start,int end,int k){
        if(start==end)
            return Integer.MIN_VALUE;
        int mid=(start+end)/2;
        int res=merge(sum,start,mid,k);
        if(res==k)
            return k;
        res=Math.max(merge(sum,mid+1,end,k),res);
        if(res==k)
            return k;
        int[] ans=new int[end-start+1];
        int idx1=start,idx2=mid+1;
        while(idx1<=mid&&idx2<=end){
            if(sum[idx2]-sum[idx1]>k)
                idx1++;
            else
                res=Math.max(sum[idx2++]-sum[idx1],res);
            if(res==k)
                return k;
        }
        idx1=start;
        idx2=mid+1;
        for(int i=0;i<ans.length;i++){
            if(idx1>mid)
                ans[i]=sum[idx2++];
            else if(idx2>end)
                ans[i]=sum[idx1++];
            else if(sum[idx2]>sum[idx1])
                ans[i]=sum[idx1++];
            else
                ans[i]=sum[idx2++];
        }
        for(int i=0;i<ans.length;i++){
            sum[start+i]=ans[i];
        }
        return res;
    }
	
	public static void main(String[] args) {
//		int[][] test={{1,0,1},{0,-2,3}};
//		int[][] test={{2,2,-1}};
		int[][] test={{27,5,-20,-9,1,26,1,12,7,-4,8,7,-1,5,8},{16,28,8,3,16,28,-10,-7,-5,-13,7,9,20,-9,26},{24,-14,20,23,25,-16,-15,8,8,-6,-14,-6,12,-19,-13},{28,13,-17,20,-3,-18,12,5,1,25,25,-14,22,17,12},{7,29,-12,5,-5,26,-5,10,-5,24,-9,-19,20,0,18},{-7,-11,-8,12,19,18,-15,17,7,-1,-11,-10,-1,25,17},{-3,-20,-20,-7,14,-12,22,1,-9,11,14,-16,-5,-12,14},{-20,-4,-17,3,3,-18,22,-13,-1,16,-11,29,17,-2,22},{23,-15,24,26,28,-13,10,18,-6,29,27,-19,-19,-8,0},{5,9,23,11,-4,-20,18,29,-6,-4,-11,21,-6,24,12},{13,16,0,-20,22,21,26,-3,15,14,26,17,19,20,-5},{15,1,22,-6,1,-9,0,21,12,27,5,8,8,18,-1},{15,29,13,6,-11,7,-6,27,22,18,22,-3,-9,20,14},{26,-6,12,-10,0,26,10,1,11,-10,-16,-18,29,8,-8},{-19,14,15,18,-10,24,-9,-7,-19,-14,23,23,17,-5,6}};
		for(int[] t:test){
			System.out.println(Arrays.toString(t));
		}
		num363 sol=new num363();
		System.out.println(sol.maxSumSubmatrix(test, -100));
	}

}
