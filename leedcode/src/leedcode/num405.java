package leedcode;

public class num405 {
    public String toHex(int num) {
    	StringBuilder sb=new StringBuilder();
    	long lnum=num;
    	if(num<0){
    		lnum=(long)(Integer.MAX_VALUE&num);
//    		System.out.println(Long.toBinaryString(lnum));
    		lnum+=(long)Integer.MAX_VALUE+1;
    	}
    	else if(num==0)
			return "0";
    			
    	while(lnum>0){
    		long cur=lnum%16;
    		lnum=lnum/16;
    		if(cur>=10){
    			sb.insert(0,(char)('a'+cur-10));
    		}
    		else
    			sb.insert(0,cur);
    	}
    	
        return sb.toString();
    }
	public static void main(String[] args) {
		num405 sol=new num405();
		System.out.println(sol.toHex(-1));
//		System.out.println(Integer.MAX_VALUE&(-1));
	}

}
