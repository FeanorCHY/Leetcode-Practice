package leedcode;

public class num29 {

    public int divide(int dividend, int divisor) {
    	long dividend1=dividend;
    	long divisor1=divisor;
    	if(dividend1==-2147483648&&divisor1==1)
    		return -2147483648;
    	if(dividend1==-2147483648&&divisor1==-1)
    		return 2147483647;
//    	if(dividend1==-2147483648)
//    		dividend1=-2147483647;
    	if(divisor1==0)
    		return Integer.MAX_VALUE;
    	boolean minus=false;
    	if((long)dividend1*(long)divisor1<0){
    		minus=true;
    	}
    	if(dividend1<0)
    		dividend1=-dividend1;
    	if(divisor1<0)
    		divisor1=-divisor1;
    	if(dividend1<divisor1)
    		return 0;
    	long result=0;
    	long sor=divisor1;
    	long sum=0;
    	while((sor<<1)<(long)dividend1){
    		sor<<=1;
    	}
    	while(sor>=divisor1){
    		if(sum+sor<=(long)dividend1){
	        	sum=sum+sor;
	        	result=result+sor/divisor1;
    		}
        	sor>>=1;
    		
    	}
    	if(sum+divisor1==(long)dividend1){
    		result++;
    	}
    	
    	
    	if(minus==true)
    		result=-result;
        return (int)result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		num29 sol=new num29();
		System.out.println(sol.divide(-2147483648, 2));
		System.out.println();
	}

}
