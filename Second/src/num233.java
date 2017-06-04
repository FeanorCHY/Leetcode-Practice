
public class num233 {
    public int countDigitOne(int n) {
        if(n<=0)
            return 0;
        if(n>=1&&n<10)
            return 1;
        long num=n;
        long gap=10,res=0;
        while(n/(gap/10)>0){
            long left=(n/gap)*(gap/10);
            long right=n%(gap/10);
            long cur=(n%gap)/(gap/10);
            if(cur==1)
                res+=left+right+1;
            else if(cur>1)
                res+=left+gap/10;
            else
                res+=left;
            gap*=10;
        }
        return (int)res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
