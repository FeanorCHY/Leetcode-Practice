
public class num360 {
    //one pass Time O(N)
    // public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    //     if(nums==null||nums.length==0)
    //         return new int[0];
    //     int n=nums.length;
    //     int[] res=new int[n];
    //     if(a==0){
    //         if(b==0){
    //             Arrays.fill(res,c);
    //         }
    //         else if(b>0){
    //             for(int i=0;i<n;i++)
    //                 res[i]=nums[i]*b+c;
    //         }
    //         else{
    //             for(int i=0;i<n;i++)
    //                 res[i]=nums[n-1-i]*b+c;
    //         }
    //         return res;
    //     }
    //     double mid=-(double)b/(2.0*a);
    //     int idx=Bsearch(nums,mid);
    //     int cur=0;
    //     if(a<0)
    //         cur=n-1;
    //     int l=idx-1;
    //     int r=idx;
    //     while(l>=0||r<n){
    //         int val;
    //         if(l<0)
    //             val=nums[r++];
    //         else if(r>=n)
    //             val=nums[l--];
    //         else if(Math.abs(nums[r]*1.0-mid)>Math.abs(nums[l]*1.0-mid))
    //             val=nums[l--];
    //         else
    //             val=nums[r++];
    //         res[cur]=a*val*val+val*b+c;
    //         if(a>0)
    //             cur++;
    //         else
    //             cur--;
    //     }
    //     return res;
    // }
    // private int Bsearch(int[] nums,double target){
    //     int l=0,r=nums.length-1;
    //     while(l<=r){
    //         int mid=(l+r)/2;
    //         double val=nums[mid]*1.0;
    //         if(val==target)
    //             return mid;
    //         else if(val>target)
    //             r=mid-1;
    //         else
    //             l=mid+1;
    //     }
    //     return l;
    // }
    
    //optimized one pass
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums==null||nums.length==0)
            return new int[0];
        int n=nums.length;
        int[] res=new int[n];
        int cur=0;
        if(a>=0)
            cur=n-1;
        int l=0;
        int r=n-1;
        while(l<=r){
            if(a>=0){
                res[cur--]=getVal(nums,l,a,b,c)>getVal(nums,r,a,b,c)?getVal(nums,l++,a,b,c):getVal(nums,r--,a,b,c);
            }
            else{
                res[cur++]=getVal(nums,l,a,b,c)>getVal(nums,r,a,b,c)?getVal(nums,r--,a,b,c):getVal(nums,l++,a,b,c);
            }
        }
        return res;
    }
    private int getVal(int[] nums,int idx,int a,int b,int c){
        return nums[idx]*nums[idx]*a+b*nums[idx]+c;
    }
	public static void main(String[] args) {
	}

}
