package leedcode;

public class num342 {
    public boolean isPowerOfFour(int num) {
    	int last=num&(-num);
    	if(num==0)
    		return false;
    	if((last&num)!=num)
    		return false;
    	if((Integer.toBinaryString(last).length()-1)%2!=0)
    		return false;
    	else
    		return true;
    }
	public static void main(String[] args) {
		num342 sol=new num342();
		System.out.println(sol.isPowerOfFour(0));
	}

}
