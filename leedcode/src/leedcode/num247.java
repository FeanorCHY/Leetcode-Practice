package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num247 {
	
    public List<String> findStrobogrammatic(int n) {
    	List<String> list=new ArrayList<String>();
    	List<String> one=new ArrayList<String>();
    	List<String> two=new ArrayList<String>();
		two.add(11+"");
		two.add(69+"");
		two.add(96+"");
		two.add(88+"");
		one.add(0+"");
		one.add(1+"");
		one.add(8+"");
    	if(n==0)
    		return list;
    	else if(n==1){
    		return one;
    	}
    	else if(n==2){
    		return two;
    	}
    	else{
			if(n%2==0){
	    		list.addAll(two);
				two.add("00");
				for(int i=4;i<=n;i=i+2){
		    		List<String> tem=new ArrayList<String>();
	    			for(String each1:two){
	    				for(String each2:list){
	    					tem.add(each2.substring(0,(i-2)/2)+each1+each2.substring((i-2)/2,i-2));
	    				}
	    			}
	    			list=tem;
				}
			}
			else{
				n=n-1;
	    		list.addAll(two);
				two.add("00");
				for(int i=4;i<=n;i=i+2){
		    		List<String> tem=new ArrayList<String>();
	    			for(String each1:two){
	    				for(String each2:list){
	    					tem.add(each2.substring(0,(i-2)/2)+each1+each2.substring((i-2)/2,i-2));
	    				}
	    			}
	    			list=tem;
				}
				n=n+1;
				List<String> tem=new ArrayList<String>();
    			for(String each1:one){
    				for(String each2:list){
    					tem.add(each2.substring(0,(n-1)/2)+each1+each2.substring((n-1)/2,n-1));
    				}
    			}
    			list=tem;
			}
    		return list;
    	}
    }
	public static void main(String[] args) {
		num247 sol=new num247();
		System.out.println(sol.findStrobogrammatic(5));
	}

}
