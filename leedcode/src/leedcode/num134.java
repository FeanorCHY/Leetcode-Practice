package leedcode;

public class num134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	if(gas.length==1)
    		if(gas[0]<cost[0])
    			return -1;
    		else
    			return 0;
    	boolean begin=false;
    	for(int i=0;i<gas.length;i++){
    		if(gas[i]<cost[i]){
    			begin=false;
    			continue;
    		}
    		else{
    			if(begin==false){
    				begin=true;
    			}
    			else{
    				continue;
    			}
    			int index=i;
    			int oil=0;
    			while((index+1)%gas.length!=i){
    				if(oil+gas[index]-cost[index]<0)
    					break;
    				else{
    					oil=oil+gas[index]-cost[index];
    				}
    				index=(index+1)%gas.length;
    			}
        		if((index+1)%gas.length==i&&oil+gas[index]-cost[index]>=0)//<0
        			return i;
    		}
    	}
    	
    	
        return -1;
    }
	public static void main(String[] args) {
		int[] gas={2,4};
		int[] cost={3,4};
		num134 sol=new num134();
		System.out.println(sol.canCompleteCircuit(gas, cost));
	}

}
