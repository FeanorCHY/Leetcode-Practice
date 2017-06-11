
public class num164 {
    //stupid sort and find O(NlogN)
    // public int maximumGap(int[] nums) {
    //     if(nums==null||nums.length<2)
    //         return 0;
    //     Arrays.sort(nums);
    //     int res=0;
    //     for(int i=1;i<nums.length;i++){
    //         res=Math.max(res,nums[i]-nums[i-1]);
    //     }
    //     return res;
    // }
    
    
    //bucket sort Time:O(N) Space O(N)
    // public int maximumGap(int[] nums) {
    //     if(nums==null||nums.length<2)
    //         return 0;
    //     int left=Integer.MAX_VALUE,right=Integer.MIN_VALUE;
    //     for(int num:nums){
    //         left=Math.min(left,num);
    //         right=Math.max(right,num);
    //     }
    //     int len=nums.length;
    //     int gap=(right-left)/(len-1);
    //     int[] min=new int[len],max=new int[len];
    //     for(int i=0;i<len;i++){
    //         min[i]=Integer.MAX_VALUE;
    //         max[i]=Integer.MIN_VALUE;
    //     }
    //     int res=gap;
    //     for(int num:nums){
    //         int idx=getIdx(left,gap,num);
    //         min[idx]=Math.min(min[idx],num);
    //         max[idx]=Math.max(max[idx],num);
    //     }
    //     int last=max[0];
    //     for(int i=1;i<nums.length;i++){
    //         if(min[i]==Integer.MAX_VALUE)
    //             continue;
    //         res=Math.max(res,min[i]-last);
    //         last=max[i];
    //     }
    //     return res;
    // }
    // private int getIdx(int min,int gap,int value){
    //     return (value-min)/(gap+1);
    // }
    
    
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<2)
            return 0;
        int max=Integer.MIN_VALUE;
        for(int num:nums)
            max=Math.max(max,num);
        int exp=1;
        while(exp<=max){
            int[] aux=new int[nums.length];
            int digit[]=new int[10];
            for(int num:nums){
                digit[(num/exp)%10]++;
            }
            for(int i=1;i<10;i++)
                digit[i]+=digit[i-1];
            for(int i=nums.length-1;i>=0;i--){
                aux[--digit[(nums[i]/exp)%10]]=nums[i];
            }
            nums=aux;
            exp*=10;
        }
        int res=0;
        for(int i=1;i<nums.length;i++){
            res=Math.max(res,nums[i]-nums[i-1]);
        }
        
        return res;
    }
	public static void main(String[] args) {
		num164 sol=new num164();
		int[] test={36,9,0,25,81,49,64,16,1,4};
		sol.maximumGap(test);
	}

}
