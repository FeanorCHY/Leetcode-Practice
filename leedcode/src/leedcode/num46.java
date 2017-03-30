package leedcode;
import java.util.*;
public class num46 {

	List<List<Integer>> arr=new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
    	ArrayList<Integer> arrl=new ArrayList<Integer>();
    	for(int i=0;i<nums.length;i++)
    		arrl.add(nums[i]);
    	per(new ArrayList<Integer>(),arrl);
        return arr;
    }
    public void per(ArrayList<Integer> left,ArrayList<Integer> right)
    {
    	if(right.isEmpty())
    		arr.add(left);
    	else{
	    	for(Integer each:right)
	    	{
	    		ArrayList<Integer> temleft=(ArrayList<Integer>)left.clone();
	    		temleft.add(each);
	    		ArrayList<Integer> temright=(ArrayList<Integer>)right.clone();
	    		temright.remove(each);
	    		per(temleft,temright);
	    	}
    	}
//    	ArrayList<Integer> tem=(ArrayList<Integer>)list.clone();
    }
	public static void main(String[] args) {
		num46 sol = new num46();
		int[] test={3,5,6};
		List<List<Integer>> testarr=sol.permute(test);
		System.out.println(testarr);
	}

}
