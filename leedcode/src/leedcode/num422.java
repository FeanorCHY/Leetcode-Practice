package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num422 {
    public boolean validWordSquare(List<String> words) {
    	for(int i=0;i<words.size();i++){
    		String str=words.get(i);
    		if(str.length()>words.size())
    			return false;
    		for(int j=0;j<str.length();j++){
    			if(i>=words.get(j).length()||words.get(j).charAt(i)!=str.charAt(j))
    				return false;
    		}
    	}
        return true;
    }
	public static void main(String[] args) {
		num422 sol=new num422();
		List<String> test=new ArrayList<String>();
		test.add("abc");
		test.add("b");
		System.out.println(sol.validWordSquare(test));
	}

}
