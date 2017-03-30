
public class num029 {
    //over Integer Limit? 
    //MIn/-1>MAX
    //O(N) N:bit
    public int divide(int dividend, int divisor) {
        long minus=1;
        long dd=dividend;
        long dr=divisor;
            
        if(dd<0&&dr<0){
            dd=-dd;
            dr=-dr;
            minus=1;
        }
        else if(dd<0){
            dd=-dd;
            minus=-1;
        }
        else if(dr<0){
            minus=-1;
            dr=-dr;
        }
        if(dd==0)
            return 0;
        else if(dr==0)
            return Integer.MAX_VALUE;
        else if(dd<dr)
            return 0;
         
        long val=dr;
        long res=1;
        while((val)<=dd){
            val=val<<1;
            res=res<<1;
        }
        val=val>>1;
        res=res>>1;
        
        for(long i=val>>1,j=res>>1;j>0;i=i>>1,j=j>>1){
            if(val+i<=dd){
                val+=i;
                res+=j;
            }
        }
        // System.out.println(res*minus);
        if(res*minus<=Integer.MIN_VALUE){
            
            return Integer.MIN_VALUE;
        }
        else if(res*minus>=Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int)(res*minus);
    }
	public static void main(String[] args) {
		num029 sol=new num029();
		System.out.println(sol.divide(-2147483648, 1));
	}

}
