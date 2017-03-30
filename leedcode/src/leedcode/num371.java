package leedcode;

public class num371 {

	public int getSum(int a, int b) {
		while(b>0){
			int c=a&b;
			a=a^b;
			b=c<<1;
		}
		
		return a;
	}
	public static void main(String[] args) {
		num371 sol=new num371();
		System.out.println(sol.getSum(2, 1));
	}

}
