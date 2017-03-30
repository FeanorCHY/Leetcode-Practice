
public class num152 {

    //two pass
    // public int maxProduct(int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     long pro=1;
    //     long max=Integer.MIN_VALUE;
    //     boolean get=false;
    //     for(int num:nums){
    //         max=Math.max(max,num);
    //         if(num==0){
    //             pro=1;
    //             get=false;
    //         }
    //         else{
    //             pro*=(long)num;
    //             max=Math.max(max,pro);
    //             get=true;
    //         }
    //     }
    //     pro=1;
    //     get=false;
    //     for(int i=nums.length-1;i>=0;i--){
    //         if(nums[i]==0){
    //             pro=1;
    //             get=false;
    //         }
    //         else{
    //             pro*=(long)nums[i];
    //              max=Math.max(max,pro);
    //             get=true;
    //         }
    //     }
    //     return (int)max;
    // }
    //zero input? Integer limit?
    //xxxxx-3xxx-5xx-3xx-5xx-2xxxx
    //one pass
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        long pro=1;
        long max=Integer.MIN_VALUE;
        long first=Integer.MIN_VALUE;
        boolean get=false;
        for(int num:nums){
            max=Math.max(max,num);
            if(num==0){
                if(get){
                    if(pro<0&&pro!=first){
                        max=Math.max(max,pro/first);
                    }
                    first=Integer.MIN_VALUE;
                    pro=1;
                    get=false;
                }
            }
            else{
                pro*=(long)num;
                max=Math.max(max,pro);
                get=true;
                if(num<0&&first==Integer.MIN_VALUE)
                    first=pro;
            }
        }
        if(get&&pro<0&&pro!=first){
            max=Math.max(max,pro/first);
        }
        return (int)max;
    }
    
    //simple and easy
    // public int maxProduct(int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     int maxnow=nums[0];
    //     int minnow=nums[0];
    //     int max=nums[0];
    //     for(int i=1;i<nums.length;i++){
    //         int x1=nums[i]*maxnow;
    //         int x2=nums[i]*minnow;
    //         maxnow=Math.max(Math.max(x1,x2),nums[i]);
    //         minnow=Math.min(Math.min(x1,x2),nums[i]);
    //         // System.out.println("maxnow:"+maxnow);
    //         // System.out.println("minnow:"+minnow);
    //         max=Math.max(max,maxnow);
    //     }
    //     return max;
    // }
    
    //switch
    // public int maxProduct(int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     int max=nums[0];
    //     int min=nums[0];
    //     int res=nums[0];
    //     for(int i=1;i<nums.length;i++){
    //         if(nums[i]<0){
    //             max^=min;
    //             min^=max;
    //             max^=min;
    //         }
    //         max=Math.max(nums[i],nums[i]*max);
    //         min=Math.min(nums[i]*min,nums[i]);
    //         res=Math.max(res,max);
    //     }
    //     return res;
    // }
	public static void main(String[] args) {
		int[] test={-2,0,-1};
		num152 sol=new num152();
		System.out.println(sol.maxProduct(test));
	}

}
