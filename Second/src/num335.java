
public class num335 {
    public boolean isSelfCrossing(int[] x) {
        if(x==null||x.length<=3)
            return false;
        for(int i=3;i<x.length;i++){
            if(x[i-1]<=x[i-3]&&x[i]>=x[i-2])
                return true;
            if(i>=4){
                if(x[i-1]+(i==4?0:x[i-5])>=x[i-3]&&x[i-1]<=x[i-3]&&x[i]+x[i-4]>=x[i-2]&&x[i-2]>=x[i-4])
                    return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
