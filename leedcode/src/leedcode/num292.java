package leedcode;

import java.util.HashMap;

public class num292 {
    public boolean canWinNim(int n) {
    	if(n%4==0)
    		return false;
    	else
    		return true;
    }
	public static void main(String[] args) {
		num292 sol=new num292();
		System.out.println(sol.canWinNim(5));
	}

}
