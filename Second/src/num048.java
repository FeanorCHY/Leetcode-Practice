
public class num048 {
	public int findDuplicate(int[] nums) {
	    int n = nums.length;
	    for(int i=0;i<nums.length;i++) nums[i]--;
	    int slow = n-1;
	    int fast = n-1;
	    do{
	        slow = nums[slow];
	        fast = nums[nums[fast]];
	    }while(slow != fast);
	    slow = n-1;
	    while(slow != fast){
	        slow = nums[slow];
	        fast = nums[fast];
	    }
	    return slow+1;
	}
	public static void main(String[] args) {
		num048 sol=new num048();
		int[] test={4,1,3,2,5,2};
		System.out.println(sol.findDuplicate(test));
	}

}
