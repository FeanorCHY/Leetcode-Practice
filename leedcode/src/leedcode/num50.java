package leedcode;

public class num50 {

    public double myPow(double x, int n) {
    	if(n==0)
    		return 1;
    	if(n<0){
    		x=1/x;
    		n=-n;
    	}
    		
    	return power(x,n);
    }
    public double power(double x,int n){
    	if(n==0)
    		return 1;
    	double result=power(x,n/2);
    	if(n%2==0){
    		result=result*result;
    	}
    	else
    		result=result*result*x;
    	return result;
    }
	public static void main(String[] args) {
		num50 sol=new num50();
		System.out.println(sol.myPow(10, -5));

	}

}

//if(x==0||x==1){
//	return x;
//}
//if(n==0){
//	return 1;
//}
//boolean ne=false;
//if(x<0){
//	x=-x;
//	if(Math.abs(n)%2==1)
//		ne=true;
//}
//
//if(n<0){
////	ne=true;
//	n=-n;
//	x=1/x;
//}
//double result=x;
//int pow=1;
//while(pow*2<=n){
//	result=result*result;
//	pow=pow<<1;
//}
//int curPow=pow;
//double curX=result;
//while(pow!=n){
//	curPow=curPow>>1;
//	curX=Math.sqrt(curX);
//	if(curPow+pow<=n){
//		pow=curPow+pow;
//		result=result*curX;
//	}
//}
//if(ne)
//	result=-result;
//return result;