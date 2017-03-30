
public class num279 {
    // array instead of map
    int[] fre=null;
    public int numSquares(int n) {
        if(fre==null)
            fre=new int[n+1];
        if(fre[n]>0)
            return fre[n];
        int sq=(int)Math.sqrt(n);
        if(n==sq*sq){
            fre[n]=1;
            return 1;
        }
        int min=Integer.MAX_VALUE;
        for(int i=sq;i>=1;i--){
            min=Math.min(min,1+numSquares(n-i*i));
            if(min==2)
                break;
        }
        fre[n]=min;
        return min;
    }
    
    
    
    
    // HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    // int[] fre=null;
    // public int numSquares(int n) {
    //     if(fre==null)
    //         fre=new int[n+1];
    //     if(map.containsKey(n))
    //         return map.get(n);
    //     int sq=(int)Math.sqrt(n);
    //     if(n==sq*sq){
    //         map.put(n,1);
    //         return 1;
    //     }
    //     int min=Integer.MAX_VALUE;
    //     for(int i=sq;i>=1;i--){
    //         min=Math.min(min,1+numSquares(n-i*i));
    //         if(min==2)
    //             break;
    //     }
    //     map.put(n,min);
    //     return min;
    // }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
