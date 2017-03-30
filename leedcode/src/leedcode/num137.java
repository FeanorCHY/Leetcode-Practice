package leedcode;

import java.util.HashMap;

public class num137 {
    public int singleNumber(int[] nums) {
    	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
    	for(int num:nums){
    		if(!hm.containsKey(num))
    			hm.put(num, 1);
    		else{
    			if(hm.get(num)<2)
    				hm.replace(num, hm.get(num)+1);
    			else
    				hm.remove(num);
    		}
    	}
    	for(Integer x:hm.keySet()){
    		return x;
    	}
    	return 1;
    }
    

	public static void main(String[] args) {
		int[] test={0,0,0,5};
		num137 sol=new num137();
//		System.out.println(Integer.toBinaryString(((~-2)+1)));
//		System.out.println(1<<30);
		System.out.println(sol.singleNumber(test));
	}

}


//int x=1<<30;
//int result=0;
//while(x!=0){
//	int tem=0;
//	for(int j=0;j<nums.length;j++){
//		tem=tem+nums[j]/x;
//		nums[j]=nums[j]%x;
//	}
//	result=result+(tem%3)*x;
//	x=x>>1;
//}
//return result;




//int ones = 0, twos = 0;
//for(int i = 0; i < nums.length; i++){
//	System.out.println("twos:"+Integer.toBinaryString(~twos));
//ones = (ones ^ nums[i]) & ~twos;
//System.out.println("ones:"+Integer.toBinaryString(~ones));
//twos = (twos ^ nums[i]) & ~ones;
//}
//return ones;