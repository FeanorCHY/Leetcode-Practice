package leedcode;

public class num461 {
    public int hammingDistance(int x, int y) {
    	
        return Integer.bitCount(x^y);
    }
	public static void main(String[] args) {
		num461 sol=new num461();
		System.out.println(sol.hammingDistance(1, 4));
	}

}
