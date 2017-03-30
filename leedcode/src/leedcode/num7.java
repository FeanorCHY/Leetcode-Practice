package leedcode;

public class num7 {
    static int reverse(int x) {
    	int rem=0;
    	long sum=0;
    	int shang=x;
    	while(shang!=0)
    	{
    		rem=shang%10;
    		shang=shang/10;
    		sum=sum*10+(long)rem;
    	}
    	if(sum>Integer.MAX_VALUE)
    		return 0;
        return (int)sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1534236469));
		System.out.println(Integer.MAX_VALUE);
	}

}
