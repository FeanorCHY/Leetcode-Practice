package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num47 {

	List<List<Integer>> arr=new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
    	ArrayList<Integer> arrl=new ArrayList<Integer>();
    	for(int i=0;i<nums.length;i++)
    		arrl.add(nums[i]);
    	per(new ArrayList<Integer>(),arrl);
        return arr;
    }
    public void per(ArrayList<Integer> left,ArrayList<Integer> right)
    {
    	ArrayList<Integer> rightCopy=new ArrayList<Integer>(); 
    	if(right.isEmpty())
    		arr.add(left);
    	else{
	    	for(Integer each:right)
	    	{
	    		if(!rightCopy.contains(each)){
	    			rightCopy.add(each);
		    		ArrayList<Integer> temleft=(ArrayList<Integer>)left.clone();
		    		temleft.add(each);
		    		ArrayList<Integer> temright=(ArrayList<Integer>)right.clone();
		    		temright.remove(each);
		    		per(temleft,temright);
	    		}
	    	}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
