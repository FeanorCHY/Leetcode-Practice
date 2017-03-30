import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class num015 {
    //will sum over Integer limit
    //hashset has conflict when num size is large.
    public List<List<Integer>> threeSum(int[] num) {
        // Arrays.sort(num);
        sort(num,0,num.length-1);
        List<List<Integer>> res = new LinkedList<>(); 
        if(num.length<3)
            return res;
        for (int i = 0; i < num.length-2; i++) {
            if(i>0&&num[i]==num[i-1])
                continue;
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if(num[lo]+num[i]>0)
                        break;
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
              }
            }
        }
        return res;
        // List<List<Integer>> res=new ArrayList<List<Integer>>();
        // if(nums.length<3)
        //     return res;
            
        // // sort(nums,0,nums.length-1);
        // for(int i=0;i<nums.length-2&&nums[i]<=0;i++){
        //     if(i>0&&nums[i]==nums[i-1])
        //         continue;
        //     int lo=i+1,hi=nums.length-1,sum=-nums[i];
        //     while(lo<hi){
        //         if(nums[lo]+nums[i]>0)
        //             break;
        //         if(nums[lo]+nums[hi]==sum){
        //             List<Integer> list=new ArrayList<Integer>();
        //             list.add(nums[lo]);
        //             list.add(nums[hi]);
        //             list.add(-sum);
        //             res.add(list);
        //             lo++;
        //             hi--;
        //             while(lo<=hi&&nums[lo]==nums[lo-1]) lo++;
        //             while(lo<=hi&&nums[hi]==nums[hi+1]) hi--;
        //         }
        //         else if(nums[lo]+nums[hi]>sum)
        //             hi--;
        //         else
        //             lo++;
        //     }
            
        // }
        // return res;
    }
    
    //O(n^2) with HashSet
    // public List<List<Integer>> threeSum(int[] nums) {
    //     List<List<Integer>> res=new ArrayList<List<Integer>>();
    //     if(nums.length<3)
    //         return res;
    //     HashSet<Integer> set=new HashSet<Integer>();
    //     for(int each:nums)
    //         set.add(each);
    //     sort(nums,0,nums.length-1);
    //     for(int i=0;i<nums.length-2;i++){
    //         if(i>0&&nums[i]==nums[i-1])
    //             continue;
    //         for(int j=i+1;j<nums.length-1;j++){
    //             if(j>i+1&&nums[j]==nums[j-1])
    //                 continue;
    //             if(-nums[i]-nums[j]<nums[j]||(-nums[i]-nums[j]==nums[j]&&nums[j+1]!=nums[j]))
    //                 break;
    //             if(set.contains(-nums[i]-nums[j])){
    //                 List<Integer> list=new ArrayList<Integer>();
    //                 list.add(nums[i]);
    //                 list.add(nums[j]);
    //                 list.add(-nums[i]-nums[j]);
    //                 res.add(list);
    //             }
    //         }
    //     }
    //     return res;
    // }
    public void sort(int[] nums,int low,int high){
        if(low>=high)
            return;
        int l=low;
        int r=high;
        int pivot=low++;
        while(low<=high){
            while(low<=high&&nums[low]<=nums[pivot])
                low++;
            if(low<=high){
                while(low<=high&&nums[high]>=nums[pivot])
                    high--;
            }
            if(low<nums.length&&low<high){
                int tem=nums[low];
                nums[low]=nums[high];
                nums[high]=tem;
            }
        }
        int tem=nums[high];
        nums[high]=nums[pivot];
        nums[pivot]=tem;
        sort(nums,l,high-1);
        sort(nums,high+1,r);
    }
	public static void main(String[] args) {
		int[] test={-1, 0, 1, 2, -1, -4};
		num015 sol=new num015(); 
		sol.sort(test, 0, test.length-1);
		System.out.println(Arrays.toString(test));
	}

}
