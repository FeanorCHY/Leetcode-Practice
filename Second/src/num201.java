
public class num201 {

    //eat right
    public int rangeBitwiseAnd(int m, int n) {
        int res=0;
        if(m==0)
            return 0;
        int fac=0;
        while(m!=n){
            m>>=1;
            n>>=1;
            fac++;
        }
        return m<<fac;
    }
    
    
    //gap break
    // public int rangeBitwiseAnd(int m, int n) {
    //     int res=0;
    //     for(int i=30;i>=0;i--){
    //         int mask=1<<i;
    //         if((m&mask)>0&&(n&mask)>0)
    //             res|=mask;
    //         else if((m&mask)==0&&(n&mask)==0)
    //             continue;
    //         else
    //             break;
    //     }
    //     return res;
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
