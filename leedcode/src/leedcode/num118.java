package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num118 {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	for(int i=0;i<numRows;i++){
    		List<Integer> list=new ArrayList<Integer>();
    		list.add(1);
    		if(i>1){
    			List<Integer> last=res.get(i-1);
    			for(int j=1;j<last.size();j++){
    				list.add(last.get(j-1)+last.get(j));
    			}
    		}
    		if(i>0){
    			list.add(1);    			
    		}
    		res.add(list);
    	}
    	
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
