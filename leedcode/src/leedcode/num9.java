package leedcode;

import java.util.ArrayList;

public class num9 {

    static boolean isPalindrome(int x) {
    	if(x<0)
    		return false;
    	ArrayList<Integer> al=new ArrayList<Integer>();
    	int remain=x;
    	while(remain!=0)
    	{
    		al.add(remain%10);
    		remain=remain/10;
    	}
    	while(!al.isEmpty())
    	{
    		if(al.get(0)!=al.get(al.size()-1))
    		{
    			return false;
    		}
    		al.remove(al.size()-1);
    		if(!al.isEmpty())
    			al.remove(0);
    	}
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(-2147447412));
	}

}
