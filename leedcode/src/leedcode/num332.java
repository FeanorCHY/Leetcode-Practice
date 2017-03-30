package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class num332 {
	HashMap<String,List<String>> map=new HashMap<String,List<String>>(); 
	HashMap<String,Integer> ticket=new HashMap<String,Integer>();
	List<String> list=new ArrayList<String>();
	int len=0;
    public List<String> findItinerary(String[][] tickets) {
    	Arrays.sort(tickets,new Comparator<String[]>(){

			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[1].compareTo(o2[1]);
			}
    		
    	});
    	len=tickets.length;
    	for(String[] strArr:tickets){
    		if(map.containsKey(strArr[0])){
    			map.get(strArr[0]).add(strArr[1]);
    		}
    		else{
    			List<String> tem=new ArrayList<String>();
    			tem.add(strArr[1]);
    			map.put(strArr[0], tem);
    		}
    		String str=strArr[0]+strArr[1];
    		if(ticket.containsKey(str)){
    			ticket.replace(str,ticket.get(str)+1);
    		}
    		else{
    			ticket.put(str, 1);
    		}
    	}
    	list.add("JFK");
    	deep("JFK");
        return list;
    }
    public boolean deep(String last){
    	if(list.size()==len+1){
    		return true;
    	}
    	if(map.get(last)==null)//check if none of tickets
    		return false;
    	for(String next:map.get(last)){
    		int left=ticket.get(last+next);
    		if(left==0)
    			continue;
    		ticket.replace(last+next, left-1);
    		list.add(next);
    		if(deep(next))
    			return true;
    		ticket.replace(last+next, left);
    		list.remove(list.size()-1);//or it will remove first of that element
    	}
    	return false;
    }
	public static void main(String[] args) {
//		String[][] test={{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
//		String[][] test={{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		String[][] test={{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
		num332 sol=new num332();
		System.out.println(sol.findItinerary(test));

	}

}
