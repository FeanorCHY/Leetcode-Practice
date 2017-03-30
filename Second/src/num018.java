import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class num018 {
    //HashMap failed: cannot avoid duplicates
    // public List<List<Integer>> fourSum(int[] nums, int target) {
    //     List<List<Integer>> res=new LinkedList<List<Integer>>();
    //     if(nums==null||nums.length<4)
    //         return res;
    //     HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    //     Arrays.sort(nums);
    //     for(int each:nums){
    //         if(map.containsKey(each))
    //             map.put(each,map.get(each)+1);
    //         else
    //             map.put(each,1);
    //     }
    //     // System.out.println(Arrays.toString(nums));
    //     for(int i=0;i<nums.length-3;i++){
    //         map.put(nums[i],map.get(nums[i])-1);
    //         for(int j=i+1;j<nums.length-2;j++){
    //             map.put(nums[j],map.get(nums[j])-1);
    //             int sum1=nums[i]+nums[j];
    //             // if(sum1+nums[nums.length-1]+nums[nums.length-2]<target||sum1+nums[j+1]+nums[j+2]>target){
    //             //     map.put(nums[j],map.get(nums[j])+1);
    //             //     System.out.println("break j at "+j);
    //             //     break;
    //             // }
    //             for(int k=j+1;k<=(j+nums.length)/2;k++){
    //                 map.put(nums[k],map.get(nums[k])-1);
    //                 int sum=sum1+nums[k];
    //                 // if(sum+nums[nums.length-1]<target||sum+nums[k+1]>target){
    //                 //     map.put(nums[k],map.get(nums[k])+1);
    //                 //     System.out.println("break k at "+k);
    //                 //     break;
    //                 // }
    //                 // System.out.println(map);
    //                 // System.out.println(target-sum);
    //                 if(map.get(target-sum)!=null&&map.get(target-sum)>0){
    //                     List<Integer> list=new LinkedList<Integer>();
    //                     list.add(nums[i]);
    //                     list.add(nums[j]);
    //                     list.add(nums[k]);
    //                     list.add(target-sum);
    //                     res.add(list);
    //                 }
    //                 map.put(nums[k],map.get(nums[k])+1);
    //             }
    //             map.put(nums[j],map.get(nums[j])+1);
    //         }
    //         map.put(nums[i],map.get(nums[i])+1);
    //     }
    //     return res;
    // }
    
    
    
    
    //take care of duplicates
    //two pointers: O(n^3) optimized with too large and too small
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        if(nums==null||nums.length<4)
            return res;
        int len=nums.length;
        Arrays.sort(nums);
		int max = nums[len - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;
        for(int i=0;i<len-3;i++){
            if(i>0&&nums[i]==nums[i-1]||nums[i] + 3 * max < target)
                continue;
			if (4 * nums[i] > target) // z is too large
				break;
            for(int j=i+1;j<len-2;j++){
                int sum=nums[i]+nums[j];
                if(j>i+1&&nums[j]==nums[j-1]||sum+2*max<target)
                    continue;
                if(nums[i]+3*nums[j]>target)
                    break;
                int left=j+1,right=len-1;
                while(left<right){
                    if(sum+nums[left]+nums[right]==target){
                        List<Integer> list=new LinkedList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        left++;
                        while(right>left&&nums[left]==nums[left-1])
                            left++;
                        right--;
                        while(right>left&&nums[right]==nums[right+1])
                            right--;
                    }
                    else if(sum+nums[left]+nums[right]>target){
                        right--;
                        while(right>left&&nums[right]==nums[right+1])
                            right--;
                    }
                    else{
                        left++;
                        while(right>left&&nums[left]==nums[left-1])
                            left++;
                    }
                }
            }
        }
        return res;
    }
    
    
    
    
    
//     public List<List<Integer>> fourSum(int[] nums, int target) {
// 		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
// 		int len = nums.length;
// 		if (nums == null || len < 4)
// 			return res;

// 		Arrays.sort(nums);

// 		int max = nums[len - 1];
// 		if (4 * nums[0] > target || 4 * max < target)
// 			return res;
// 		int i, z;
// 		for (i = 0; i < len; i++) {
// 			z = nums[i];
// 			if (i > 0 && z == nums[i - 1])// avoid duplicate
// 				continue;
// 			if (z + 3 * max < target) // z is too small
// 				continue;
// 			if (4 * z > target) // z is too large
// 				break;
// 			if (4 * z == target) { // z is the boundary
// 				if (i + 3 < len && nums[i + 3] == z)
// 					res.add(Arrays.asList(z, z, z, z));
// 				break;
// 			}

// 			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
// 		}

// 		return res;
// 	}

// 	/*
// 	 * Find all possible distinguished three numbers adding up to the target
// 	 * in sorted array nums[] between indices low and high. If there are,
// 	 * add all of them into the ArrayList fourSumList, using
// 	 * fourSumList.add(Arrays.asList(z1, the three numbers))
// 	 */
// 	public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
// 			int z1) {
// 		if (low + 1 >= high)
// 			return;

// 		int max = nums[high];
// 		if (3 * nums[low] > target || 3 * max < target)
// 			return;

// 		int i, z;
// 		for (i = low; i < high - 1; i++) {
// 			z = nums[i];
// 			if (i > low && z == nums[i - 1]) // avoid duplicate
// 				continue;
// 			if (z + 2 * max < target) // z is too small
// 				continue;

// 			if (3 * z > target) // z is too large
// 				break;

// 			if (3 * z == target) { // z is the boundary
// 				if (i + 1 < high && nums[i + 2] == z)
// 					fourSumList.add(Arrays.asList(z1, z, z, z));
// 				break;
// 			}

// 			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
// 		}

// 	}

// 	/*
// 	 * Find all possible distinguished two numbers adding up to the target
// 	 * in sorted array nums[] between indices low and high. If there are,
// 	 * add all of them into the ArrayList fourSumList, using
// 	 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
// 	 */
// 	public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
// 			int z1, int z2) {

// 		if (low >= high)
// 			return;

// 		if (2 * nums[low] > target || 2 * nums[high] < target)
// 			return;

// 		int i = low, j = high, sum, x;
// 		while (i < j) {
// 			sum = nums[i] + nums[j];
// 			if (sum == target) {
// 				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

// 				x = nums[i];
// 				while (++i < j && x == nums[i]) // avoid duplicate
// 					;
// 				x = nums[j];
// 				while (i < --j && x == nums[j]) // avoid duplicate
// 					;
// 			}
// 			if (sum < target)
// 				i++;
// 			if (sum > target)
// 				j--;
// 		}
// 		return;
// 	}
	public static void main(String[] args) {
		num018 sol=new num018();
		int nums[]={1, 0, -1, 0, -2, 2};
		System.out.println(sol.fourSum(nums, 0));
		
	}

}
