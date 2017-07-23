
public class num004 {

//    public double findMedianSortedArrays(int A[], int B[]) {
//       int n = A.length;
//       int m = B.length;
//       // the following call is to make sure len(A) <= len(B).
//       // yes, it calls itself, but at most once, shouldn't be
//       // consider a recursive solution
//       if (n > m)
//           return findMedianSortedArrays(B, A);
//   
//       // now, do binary search
//       int k = (n + m - 1) / 2;
//       int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
//       while (l < r) {
//           int midA = (l + r) / 2;
//           int midB = k - midA;
//           if (A[midA] < B[midB])
//               l = midA + 1;
//           else
//               r = midA;
//       }
//       
//       // after binary search, we almost get the median because it must be between
//       // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1] 
//   
//       // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
//       // and there are some corner cases we need to take care of.
//       int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
//       if (((n + m) & 1) == 1)
//           return (double) a;
//   
//       // if (n+m) is even, the median can be calculated by 
//       //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
//       // also, there are some corner cases to take care of.
//       int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
//       return (a + b) / 2.0;
//    }
	
	
	
	

    public double findMedianSortedArrays(int A[], int B[]) {
        if(A.length>B.length){
            int[] C=A;
            A=B;
            B=C;
        }
        int n = A.length;
        int m = B.length;
        int k=(m+n-1)/2;
        int l=0,r=Math.min(n-1,k);
        while(l<=r){
            int mid1=(l+r)/2;
            int mid2=k-mid1;
            if(A[mid1]>=B[mid2])
                r=mid1-1;
            else
                l=mid1+1;
        }
        int a=Math.max(r>=0?A[r]:B[k-l],k-l>=0?B[k-l]:A[r]);
        if(((m+n)&1)==1){
            return (double)a;
        }
        int b=Math.min(l<n?A[l]:B[k-r],k-r<m?B[k-r]:A[l]);
        return (a+b)/2.0;
    }
	public static void main(String[] args) {
//		int[] test1={2,3,4};
//		int[] test2={1,5,9};
//		int[] test1={1,2};
//		int[] test2={3,4};

		int[] test1={1,2,3,4,5,6};
		int[] test2={1};
		
				
		num004 sol=new num004();
		System.out.println(sol.findMedianSortedArrays(test1, test2));
	}

}
