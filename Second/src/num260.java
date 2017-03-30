
public class num260 {


    public int[] singleNumber(int[] nums) {
    	int xor=0;
    	for(int each:nums){
    		xor=xor^each;
    	}
    	xor=xor&(~(xor-1));
    	int result[]=new int[2];
    	for(int each:nums){
    		if((each&xor)==0)
    			result[0]=result[0]^each;
    		else
    			result[1]=result[1]^each;
    	}
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
