package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num293 {
    public List<String> generatePossibleNextMoves(String s) {
    	char[] arr=s.toCharArray();
    	List<String> res=new ArrayList<String>();
    	for(int i=0;i<arr.length-1;i++){
    		if(arr[i]=='+'&&arr[i+1]=='+'){
    			arr[i]='-';
    			arr[i+1]='-';
    			res.add(String.valueOf(arr));
    			arr[i]='+';
    			arr[i+1]='+';
    			
    		}
    	}
    	
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
