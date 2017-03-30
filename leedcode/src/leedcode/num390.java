package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num390 {
    public int lastRemaining(int n) {
    	int gap=1;
    	int head=1;
    	int r=n;
    	boolean left=true;
    	while(r>1){
    		if(left||r%2==1){
    			head=head+gap;
    		}
    		gap=gap*2;
    		r=r/2;
    		left=!left;
    	}
    	return head;
    }
	public static void main(String[] args) {
		num390 sol=new num390();
		System.out.println(sol.lastRemaining(14));
	}

}
