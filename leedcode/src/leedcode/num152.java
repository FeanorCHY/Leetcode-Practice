package leedcode;

public class num152 {///a lot of cases
    public int maxProduct(int[] nums) {
    	if(nums.length==1)
    		return nums[0];
    	int product=1;
    	int minus=-1;
    	boolean start=false;
    	boolean isMinus=false;
    	int largest=Integer.MIN_VALUE;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==0&&largest<0){
    			largest=0;
    		}
    		if(nums[i]==0){
    			if(start){
    				isMinus=false;
	    			if(product<0&&minus<i-1){
	    				int larger=1;
	    				for(int j=minus+1;j<i;j++){
	    					larger=larger*nums[j];
	    				}
	    				if(larger>largest){
	    					largest=larger;
	    				}
	    			}
	    			if(i==nums.length-1)
	    				return largest;
	    			else{
	    				while(nums[++i]==0){
	    					if(i==nums.length-1)
	    						return largest;
	    				}
	    				product=nums[i];
		    			if(product>largest){
		    				largest=product;
		    			}
			    		if(nums[i]<0&&isMinus==false){
			    			minus=i;
			    			isMinus=true;
			    		}
    				}
    			}
    		}
    		else{
	    		product=product*nums[i];
	    		start=true;
	        	if(product>largest)
	        		largest=product;
	    		if(nums[i]<0&&isMinus==false){
	    			minus=i;
	    			isMinus=true;
	    		}
    		}
    	}
    	if(product>largest&&start)
    		largest=product;
		if(product<0&&minus!=nums.length-1){
			int larger=1;
			for(int j=minus+1;j<nums.length;j++){
				larger=larger*nums[j];
			}
			if(larger>largest){
				largest=larger;
			}
		}
    	
    	
        return largest;
    }
	public static void main(String[] args) {
		int test[]={-5,0,2};
		num152 sol=new num152();
		System.out.println(sol.maxProduct(test));
	}

}
