
public class num238 {

    //zero, will product over MAX_VALUE?
    public int[] productExceptSelf(int[] nums) {
        if(nums==null)
            return null;
        int n=nums.length;
        int[] res=new int[n];
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        int product=1;
        for(int i=n-2;i>=0;i--){
            product=product*nums[i+1];
            res[i]=res[i]*product;
        }
        return res;
    }
    
    //faster?
    // public int[] productExceptSelf(int[] nums) {
    //     int leng = nums.length;
    //     int[] ret = new int[leng];
    //     if(leng == 0)
    //         return ret;
    //     int runningprefix = 1;
    //     for(int i = 0; i < leng; i++){
    //         ret[i] = runningprefix;
    //         runningprefix*= nums[i];
    //     }
    //     int runningsufix = 1;
    //     for(int i = leng -1; i >= 0; i--){
    //         ret[i] *= runningsufix;
    //         runningsufix *= nums[i];
    //     }
    //     return ret;
        
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
