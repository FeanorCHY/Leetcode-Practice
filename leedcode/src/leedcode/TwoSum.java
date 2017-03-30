package leedcode;

import java.util.HashSet;
import java.util.TreeSet;

public class TwoSum {
	HashSet<Integer> num=new HashSet<Integer>();
	HashSet<Integer> dup=new HashSet<Integer>();
    // Add the number to an internal data structure.
	public void add(int number) {
		if(num.contains(number)){
			dup.add(number);
		}
		else{
			num.add(number);
		}
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int num1:num){
	        int num2 = value - num1;
	        if ((num1 == num2 && dup.contains(num1) ) || (num1 != num2 && num.contains(num2))) 
	        	return true;
	    }
	    return false;
//		if(value%2==0&&dup.contains(value/2))
//			return true;
//		else{
//			for(int each:num){
//				if(value%2==0&&each==value/2)
//					continue;
//				if(num.contains(value-each))
//					return true;
//			}
//			return false;
//		}
	}
}
