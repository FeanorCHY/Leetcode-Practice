package leedcode;

import java.util.TreeSet;

public class num363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = 0;
        if (m > 0) n = matrix[0].length;
        if (m * n == 0) return 0;
        
        int M = Math.max(m, n);
        int N = Math.min(m, n);
        
        int ans = Integer.MIN_VALUE;
        for (int x = 0; x < N; x++) {
            int sums[] = new int[M];
            for (int y = x; y < N; y++) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                int num = 0;
                for (int z = 0; z < M; z++) {
                    sums[z] += m > n ? matrix[z][y] : matrix[y][z];
                    num += sums[z];
                    if (num <= k) ans = Math.max(ans, num);
                    Integer i = set.ceiling(num - k);
                    if (i != null) ans = Math.max(ans, num - i);
                    set.add(num);
                }
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		int[][] test={{1,0,1},{0,-2,3}};
		num363 sol=new num363();
		System.out.println(sol.maxSumSubmatrix(test, 3));
	}

}





//int max=Integer.MIN_VALUE;
//for(int i=0;i<matrix.length;i++){
//	for(int j=0;j<matrix[0].length;j++){
//		if(i>0){
//			matrix[i][j]+=matrix[i-1][j];
//			if(j>0)
//				matrix[i][j]+=matrix[i][j-1]-matrix[i-1][j-1];
//		}
//		else{
//			if(j>0)
//				matrix[i][j]+=matrix[i][j-1];
//		}
////		if(i>0&&j>0){
//			for(int m=-1;m<=i-1;m++){
//				for(int n=-1;n<=j-1;n++){
//					int outcome=matrix[i][j];
//					if(m>=0)
//						outcome-=matrix[m][j];
//					if(n>=0)
//						outcome-=matrix[i][n];
//					if(m>=0&&n>=0)
//						outcome+=matrix[m][n];
//    				if(outcome<=k){
//    					max=Math.max(outcome, max);
//    				}	
//				}
//			}
////		}
//		
//		
//		
//	}
//}
//
//
//return max;
