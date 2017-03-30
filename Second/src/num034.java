
public class num034 {

    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        res[0]=-1;
        res[1]=-1;
        if(nums==null||nums.length==0||target>nums[nums.length-1]||target<nums[0])
            return res;
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]<target)
                l=mid+1;
            else if(nums[mid]>target)
                r=mid-1;
            else{
                if(mid==nums.length-1||nums[mid+1]!=target){
                    res[1]=mid;
                    r=mid-1;
                }
                else{
                    int teml=mid+1;
                    while(teml<=r){
                        int m=(teml+r)/2;
                        if(nums[m]==target)
                            teml=m+1;
                        else
                            r=m-1;
                    }
                    res[1]=r;
                }
                if(mid==0||nums[mid-1]!=target){
                    l=mid+1;
                    res[0]=mid;
                }
                else{
                    int temr=mid-1;
                    while(l<=temr){
                        int m=(l+temr)/2;
                        if(nums[m]==target)
                            temr=m-1;
                        else
                            l=m+1;
                    }
                    res[0]=l;
                }
                break;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
