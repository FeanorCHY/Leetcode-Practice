import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class num215 {
    
    //is there duplicates? what for 111222? what if nums is null
    //Time O(N)～O(N^2), Space O(1)
    // int k;
    // int[] nums;
    // public int findKthLargest(int[] nums, int k) {
    //     this.k=k;
    //     this.nums=nums;
    //     return find(0,nums.length-1);
    // }
    // private int find(int start,int end){
    //     if(start==end)
    //         return nums[start];
    //     int r=end;
    //     int l=start;
    //     int pivot=start++;
    //     while(start<=end){
    //         while(start<=end&&nums[start]>nums[pivot])
    //             start++;
    //         while(start<=end&&nums[end]<=nums[pivot])
    //             end--;
    //         if(start<end){
    //             nums[start]^=nums[end];
    //             nums[end]^=nums[start];
    //             nums[start]^=nums[end];
    //         }
    //     }
    //     // System.out.println(pivot);
    //     if(pivot!=end){
    //         nums[pivot]^=nums[end];
    //         nums[end]^=nums[pivot];
    //         nums[pivot]^=nums[end];
    //     }
    //     if(end+1==k)
    //         return nums[end];
    //     else if(end+1>k){
    //         return find(l,end-1);
    //     }
    //     else
    //         return find(end+1,r);
    // }
    
    
    //quick sort with shuffle
    //Time O(N)～O(N^2), Space O(1)
    int k;
    int[] nums;
    public int findKthLargest(int[] nums, int k) {
        this.k=k;
        this.nums=nums;
        shuffle(nums);
        return find(0,nums.length-1);
    }
    private int find(int start,int end){
        if(start==end)
            return nums[start];
        int r=end;
        int l=start;
        int pivot=start++;
        while(start<=end){
            while(start<=end&&nums[start]>nums[pivot])
                start++;
            while(start<=end&&nums[end]<=nums[pivot])
                end--;
            if(start<end){
                nums[start]^=nums[end];
                nums[end]^=nums[start];
                nums[start]^=nums[end];
            }
        }
        // System.out.println(pivot);
        if(pivot!=end){
            nums[pivot]^=nums[end];
            nums[end]^=nums[pivot];
            nums[pivot]^=nums[end];
        }
        if(end+1==k)
            return nums[end];
        else if(end+1>k){
            return find(l,end-1);
        }
        else
            return find(end+1,r);
    }
    
    private void shuffle(int a[]) {
    
        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    
    
    
    
    //PriorityQueue 
    //Time: O(NlogK) Space: O(K)
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
    //     // k=nums.length+1-k;
    //     for(int num:nums){
    //         pq.add(num);
    //         if(pq.size()>k)
    //             pq.poll();
    //     }
    //     return pq.peek();
    // }
    
    
    
    
    //PriorityQueue 
    //Time: O((N+k)logN) Space: O(N)
    // public int findKthLargest(int[] nums, int k) {
    //     // PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>(){
    //     //         @Override
    //     //         public int compare(Integer x1,Integer x2){
    //     //             return x2-x1;
    //     //         }
            
    //     //     });
    //     PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
    //     k=nums.length+1-k;
    //     for(int num:nums)
    //         pq.add(num);
    //     for(int i=0;i<k-1;i++)
    //         pq.poll();
    //     return pq.peek();
    // }

	public static void main(String[] args) {
		num215 sol=new num215();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer x1,Integer x2){
                return x2-x1;
            }
        
        });
        pq.add(5);
        pq.add(1);
        pq.add(9);
        pq.add(2);
        System.out.println(pq.poll());
		int[] test={2,0};
		System.out.println(sol.findKthLargest(test, 1));
	}

}
