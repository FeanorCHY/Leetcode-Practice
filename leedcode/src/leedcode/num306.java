package leedcode;

public class num306 {
    public boolean isAdditiveNumber(String num) {
    	if(num.length()<3)
    		return false;
    	for(int i=2;i<=(num.length()*2)/3;i++){
    		for(int len1=1;len1<i;len1++){
    			int len2=i-len1;
    			if(tryBuild(len1,len2,num))
    				return true;
    		}
    	}
    	
    	
        return false;
    }
    public boolean tryBuild(int len1,int len2,String num){
    	if((len1>1&&num.substring(0,1).equals("0"))||(len2>1&&num.substring(len1,len1+1).equals("0"))){
    		return false;
    	}
    	long num1=Long.parseLong(num.substring(0,len1));
    	long num2=Long.parseLong(num.substring(len1,len2+len1));
    	int index=len1+len2;
    	String sum=Long.toString(num1+num2);
    	while(sum.length()+index<=num.length()){
    		String sumStr=num.substring(index,sum.length()+index);
//    		if(sumStr.substring(0,1).equals("0"))
//    			return false;
    		if(!sumStr.equals(sum))
    			return false;
    		num1=num2;
    		num2=Long.parseLong(sum);
    		sum=Long.toString(num1+num2);
    		index=index+sumStr.length();
    	}
    	if(index!=num.length())
    		return false;
    	return true;
    }
	public static void main(String[] args) {
		String test="1991000199299498797";
		num306 sol=new num306();
//		System.out.println(Integer.parseInt("9910001992"));
		System.out.println(sol.isAdditiveNumber(test));
	}

}
