
public class num357 {

    //O(N)
    public int countNumbersWithUniqueDigits(int n) {
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        if(n==1)
            return 10;
        int res=10;
        int num=9;
        int cur=9;
        n=Math.min(n,10);
        for(int i=2;i<=n;i++){
            num*=cur--;
            res+=num;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
