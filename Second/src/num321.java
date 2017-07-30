import java.util.Arrays;

public class num321 {

    //recursive TLE
    // private boolean greater(int[] nums1,int[] nums2,int i,int j){
    //     for(;i<nums1.length&&j<nums2.length;j++,i++){
    //         if(nums1[i]>nums2[j])
    //             return true;
    //         else if(nums1[i]<nums2[j])
    //             return false;
    //     }
    // 	if(i==nums1.length)
    // 		return false;
    // 	else if(j==nums2.length)
    // 		return true;
    //     return false;
    // }
    // public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    //     if(k<=0||nums1==null||nums2==null)
    //         return new int[0];
    //     int idx1=0,idx2=0;
    //     int[] res=new int[k];
    //     int m=nums1.length,n=nums2.length;
    //     for(int i=0;i<k;i++){
    //         int max1=-1,i1=0;
    //         int rest=k-i-(n-idx2);
    //         for(int j=idx1;j<=Math.min(m-1,m-rest);j++){
    //             if(nums1[j]>max1){
    //                 max1=nums1[j];
    //                 i1=j;
    //             }
    //             if(max1==9)
    //             	break;
    //         }
    //         rest=k-i-(m-idx1);
    //         int max2=-1,i2=0;
    //         for(int j=idx2;j<=Math.min(n-1,n-rest);j++){
    //             if(nums2[j]>max2){
    //                 max2=nums2[j];
    //                 i2=j;
    //             }
    //             if(max2==9)
    //             	break;
    //         }
    //         if(max1!=max2||i==k-1){
    //             res[i]=Math.max(max1,max2);
    //             if(max1>max2)
    //                 idx1=i1+1;
    //             else
    //                 idx2=i2+1;
    //         }
    //         else if(m-i1+n-i2-2>=k-i-2){
    //             res[i]=max2;
    //             if(i1==m-1)
    //             	idx2=i2+1;
    //             else if(i2==n-1)
    //             	idx1=i1+1;
    //             else if(nums1[i1+1]<max1&&nums2[i2+1]<max1){
    //             	res[++i]=max1;
    //                 idx1=i1+1;
    //                 idx2=i2+1;
    //             }
    //             else if(nums1[i1+1]>nums2[i2+1]){
    //             	idx1=i1+1;
    //             }
    //             else
    //             	idx2=i2+1;
    //         }
    //         else{
    //             res[i++]=max1;
    //             int[] copy1=ArrCopy(nums1,i1+1);
    //             int[] copy2=ArrCopy(nums2,idx2);
    //             int[] res1=maxNumber(copy1,copy2,k-i);
    //             copy1=ArrCopy(nums1,idx1);
    //             copy2=ArrCopy(nums2,i2+1);
    //             int[] res2=maxNumber(copy1,copy2,k-i);
    //             for(int j=0;j<res1.length;j++){
    //                 if(res1[j]>res2[j]){
    //                     while(j<res1.length)
    //                         res[i++]=res1[j++];
    //                     break;
    //                 }
    //                 else if(res1[j]<res2[j]){
    //                     while(j<res1.length)
    //                         res[i++]=res2[j++];
    //                     break;
    //                 }
    //                 else
    //                     res[i++]=res1[j];
    //             }
    //             break;
    //         }
    //     }
    //     return res;
    // }
    // private int[] ArrCopy(int[] num,int idx){
    //     int[] copy=new int[num.length-idx];
    //     for(int i=idx;i<num.length;i++)
    //         copy[i-idx]=num[i];
    //     return copy;
    // }
    
    
    //search all possible greedy combination
    // public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    //     if(k<=0||nums1==null||nums2==null)
    //         return new int[0];
    //     int[] res=new int[k];
    //     int m=nums1.length,n=nums2.length;
    //     for(int i=Math.max(0,k-n);i<=Math.min(k,m);i++){
    //         int[] mix=merge(getArray(nums1,i),getArray(nums2,k-i));
    //         if(greater(mix,res,0,0))
    //             res=mix;
    //     }
    //     return res;
    // }
    // private int[] merge(int[] nums1,int[] nums2){
    //     int m=nums1.length,n=nums2.length;
    //     int[] res=new int[nums1.length+nums2.length];
    //     int idx1=0,idx2=0;
    //     for(int i=0;i<m+n;i++){
    //         if(greater(nums1,nums2,idx1,idx2))
    //             res[i]=nums1[idx1++];
    //         else
    //             res[i]=nums2[idx2++];
    //     }
    //     return res;
    // }
    // private boolean greater(int[] nums1,int[] nums2,int i,int j){
    //     for(;i<nums1.length&&j<nums2.length;j++,i++){
    //         if(nums1[i]>nums2[j])
    //             return true;
    //         else if(nums1[i]<nums2[j])
    //             return false;
    //     }
    // 	if(i==nums1.length)
    // 		return false;
    // 	else if(j==nums2.length)
    // 		return true;
    //     return false;
    // }
    // private int[] getArray(int[] nums,int k){
    //     int[] res=new int[k];
    //     if(k==0)
    //     	return res;
    //     int i=0,j=0;
    //     while(i<nums.length){
    //         while(k-j+1<=nums.length-i&&j>0&&nums[i]>res[j-1])
    //             j--;
    //         if(j<k)
    //         	res[j++]=nums[i];
    //         i++;
    //     }
    //     return res;
    // }
    
    
    
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int get_from_nums1 = Math.min(nums1.length, k);
        int[] ans = new int[k];
        for (int i = Math.max(k - nums2.length, 0); i <= get_from_nums1; i++) {
            int[] res1 = new int[i];
            int[] res2 = new int[k - i];
            int[] res = new int[k];
            res1 = solve(nums1, i);
            res2 = solve(nums2, k - i);
            int pos1 = 0, pos2 = 0, tpos = 0;
            
            while (res1.length > 0 && res2.length > 0 && pos1 < res1.length && pos2 < res2.length) {
                if (compare(res1, pos1, res2, pos2))
                    res[tpos++] = res1[pos1++];
                else
                    res[tpos++] = res2[pos2++];
            }
            while (pos1 < res1.length)
                res[tpos++] = res1[pos1++];
            while (pos2 < res2.length)
                res[tpos++] = res2[pos2++];

            if (!compare(ans, 0, res, 0))
                ans = res;
        }

        return ans;
    }

    public boolean compare(int[] nums1, int start1, int[] nums2, int start2) {
        for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
            if (nums1[start1] > nums2[start2]) return true;
            if (nums1[start1] < nums2[start2]) return false;
        }
        return start1 != nums1.length;
    }

    public int[] solve(int[] nums, int k) {
        int[] res = new int[k];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
                len--;
            }
            if (len < k)
                res[len++] = nums[i];
        }
        return res;
    }

	public static void main(String[] args) {
		int[] test1={6,3,9,0,5,6};
		int[] test2={2,2,5,2,1,4,4,5,7,8,9,3,1,6,9,7,0};
		num321 sol=new num321();
		System.out.println(Arrays.toString(sol.maxNumber(test1, test2, 23)));
	}

}
