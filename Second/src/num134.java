
public class num134 {

    //one pass O(N^2)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||cost==null||cost.length!=gas.length||gas.length==0)
            return -1;
        int n=gas.length;
        int dif[] =new int[n];
        for(int i=0;i<n;i++){
            dif[i]=gas[i]-cost[i];
        }
        for(int i=0;i<n;i++){
            if(dif[i]<0)
                continue;
            int val=0;
            for(int j=0;j<n;j++){
                val+=dif[(i+j)%n];
                if(val<0)
                    break;
            }
            if(val>=0)
                return i;
            while(i<n&&dif[i]>0)
                i++;
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
