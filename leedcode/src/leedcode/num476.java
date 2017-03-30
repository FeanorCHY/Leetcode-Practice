package leedcode;

public class num476 {
    public int findComplement(int num) {
    	int i=num;
        // HD, Figure 3-1
        i |= (i >>  1);
        i |= (i >>  2);
        i |= (i >>  4);
        i |= (i >>  8);
        i |= (i >> 16);
    	
    	
        return ~num&i;
    }
	public static void main(String[] args) {
		num476 sol=new num476();
		System.out.println(sol.findComplement(16));
	}

}
