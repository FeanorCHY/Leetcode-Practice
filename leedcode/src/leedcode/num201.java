package leedcode;

public class num201 {
    public int rangeBitwiseAnd(int m, int n) {
    	if(m==0)
    		return 0;
    	char[] bm=Integer.toBinaryString(m).toCharArray();
    	char[] bn=Integer.toBinaryString(n).toCharArray();
    	if(bm.length!=bn.length)
    		return 0;
    	int result=1<<(bm.length-1);
    	int cur=result;
    	for(int i=1;i<bm.length;i++){
    		if(bm[i]!=bn[i])
    			return result;
    		else{
    			cur>>=1;
				if(bm[i]=='1')
					result+=cur;
    		}
    	}
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
