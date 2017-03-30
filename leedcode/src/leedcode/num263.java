package leedcode;

public class num263 {
	int[] ugly={2,3,5};
    public boolean isUgly(int num) {
    	if(num==1)
    		return true;
    	if(num==0)
    		return false;
    	for(int each:ugly){
    		while(num%each==0){
    			num=num/each;
    		}
    	}
    	
    	
        return num==1;
    }
	public static void main(String[] args) {
		
	}

}
