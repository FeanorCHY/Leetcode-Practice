
public class num007 {

    // public int reverse(int x) {
    //     if(x<10&&x>-10)
    //         return x;
    //     long sign=1;
    //     long val=x;
    //     if(x<0){
    //         sign=-1;
    //         val=-val;
    //     }
    //     long res=0;
    //     while(val>0){
    //         res=res*10+val%10;
    //         val=val/10;
    //     }
    //     if(res*sign>(long)Integer.MAX_VALUE||res*sign<(long)Integer.MIN_VALUE)//check the overflow
    //         return 0;
    //     return (int)(sign*res);
    // }
    
    
    public int reverse(int x) {
        if(x<10&&x>-10)
            return x;
        int res=0;
        
        while(x!=0){
            int tem=res*10+x%10;
            if(tem/10!=res)//if overflow
                return 0;
            res=tem;
            x/=10;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
