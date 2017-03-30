package leedcode;

public class num441 {
    public int arrangeCoins(int n) {
        return (int)(((long)-1+(long)Math.sqrt((long)1+8*(long)n))/2);
    }
	public static void main(String[] args) {
		num441 sol=new num441();
		System.out.println(sol.arrangeCoins(5));
	}

}
