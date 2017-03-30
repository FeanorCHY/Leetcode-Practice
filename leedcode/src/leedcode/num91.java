package leedcode;

public class num91 {

    public int numDecodings(String s) {
    	int len=s.length();
    	if (len==0)
    		return 0;
    	int[] step=new int[len+1];
    	step[0]=1;
    	if(valid(s.substring(0,1)))
    		step[1]=1;
    	else
    		step[1]=0;
    	for(int i=2;i<=len;i++){
    		if(valid(s.substring(i-1,i)))
    			step[i]=step[i-1];
    		if(valid(s.substring(i-2,i)))
    			step[i]=step[i]+step[i-2];
    	}
    	
    	return step[len];
    }
    public boolean valid(String s){
    	if(s.charAt(0)=='0')
    		return false;
    	else{
    		int result=Integer.parseInt(s);
    		if(result>=1&&result<=26)
    			return true;
    		else
    			return false;
    	}
    }
	public static void main(String[] args) {
		num91 sol=new num91();
		System.out.println(sol.numDecodings("102"));
	}

}
