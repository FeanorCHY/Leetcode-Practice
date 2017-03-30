package leedcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class num399 {
	HashMap<String,HashMap<String,Double>> map=new HashMap<String,HashMap<String,Double>>();
	HashSet<String> visit;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    	double[] res=new double[queries.length];
    	for(int i=0;i<equations.length;i++){
    		if(map.containsKey(equations[i][0])){
    			map.get(equations[i][0]).put(equations[i][1], values[i]);
    		}
    		else{
    			HashMap<String,Double> tem= new HashMap<String,Double>();
    			tem.put(equations[i][1], values[i]);
    			map.put(equations[i][0], tem);
    		}
    		if(map.containsKey(equations[i][1])){
    			map.get(equations[i][1]).put(equations[i][0], 1/values[i]);
    		}
    		else{
    			HashMap<String,Double> tem= new HashMap<String,Double>();
    			tem.put(equations[i][0], 1/values[i]);
    			map.put(equations[i][1], tem);
    		}
    	}
    	for(int i=0;i<res.length;i++){
    		visit=new HashSet<String>();
    		visit.add(queries[i][0]);
    		res[i]=getVal(queries[i][0],queries[i][1]);
    	}
        return res;
    }
    public double getVal(String from,String to){
    	if(!map.containsKey(from)||!map.containsKey(to))
    		return -1;
    	if(from.equals(to))
    		return 1;
    	HashMap<String,Double> next=map.get(from);
    	if(next.containsKey(to))
    		return next.get(to);
    	for(String each:next.keySet()){
    		if(visit.contains(each))
    			continue;
    		else
    			visit.add(each);
    		double got=getVal(each,to);
    		if(got>=0){
    			next.put(to, next.get(each)*got);
        		if(map.containsKey(to)){
        			map.get(to).put(from,1/(next.get(each)*got));
        		}
        		else{
        			HashMap<String,Double> tem= new HashMap<String,Double>();
        			tem.put(from, 1/(next.get(each)*got));
        			map.put(to, tem);
        		}
    			return next.get(each)*got; 
    		}
    	}
    	return -1;
    }
    
	public static void main(String[] args) {
		String[][] equations = {{"x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"}};
		double values[]={3.0,4.0,5.0,6.0};
		String[][] queries={{"x1","x5"},{"x5","x2"},{"x2","x4"},{"x2","x2"},{"x2","x9"},{"x9","x9"}};
		num399 sol=new num399();
		System.out.println(Arrays.toString(sol.calcEquation(equations, values, queries)));
	}

}
