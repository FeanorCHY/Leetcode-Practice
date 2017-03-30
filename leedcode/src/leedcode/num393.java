package leedcode;

public class num393 {
    public boolean validUtf8(int[] data) {
    	if(data.length==0)
    		return false;
    	int head=0;
    	while(head<data.length){
	    	int num=8-Integer.toBinaryString((~data[head])&255).length();
	    	if(num>4||num==1)
	    		return false;
	    	if(num==0)
	    		head++;
	    	else{
		    	for(int i=head+1;i<head+num;i++){
		    		if(i>=data.length||8-Integer.toBinaryString((~data[i])&255).length()!=1)
		    			return false;
		    	}
		    	head+=num;
	    	}
    	}
    	return true;
    }
	public static void main(String[] args) {
//		System.out.println(Integer.toBinaryString(17));
		int[] test={240,162,138,147,17};
		num393 sol=new num393();
		System.out.println(sol.validUtf8(test));
	}

}
