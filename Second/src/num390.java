
public class num390 {
    //N! failed
    // public int lastRemaining(int n) {
    //     if(n<=2)
    //         return n;
    //     List<Integer> list=new ArrayList<Integer>();
    //     for(int i=1;i<=n;i++)
    //         list.add(i);
    //     boolean start=true;
    //     while(list.size()>1){
    //         List<Integer> tem=new ArrayList<Integer>();
    //         if(start){
    //             int i=1;
    //             for(;i<list.size();i=i+2)
    //                 tem.add(list.get(i));
                
    //         }
    //         else{
    //             int i=(list.size())%2;
    //             for(;i<list.size();i=i+2)
    //                 tem.add(list.get(i));
    //         }
    //         // System.out.println(tem);
    //         list=tem;
    //         start=!start;
    //     }
    //     return list.get(0);
    // }
    
    
    //gap stepping logN
    // public int lastRemaining(int n) {
    //     if(n<=2)
    //         return n;
    //     int remain=n,gap=1,first=1;
    //     boolean left=true;
    //     while(remain>1){
    //         if(left||remain%2==1){
    //             first+=gap;
    //         }
    //         left=!left;
    //         remain=remain>>1;
    //         gap=gap<<1;
    //     }
    //     return first;
    // }
    
    
    //backtracking O(logN)
    public int lastRemaining(int n) {
        if(n<=2)
            return n;
        return left(n);
    }
    private int left(int n){
        if(n<=2)
            return n;
        return right(n/2)*2;
    }
    private int right(int n){
        if(n<=2)
            return 1;
        if(n%2==1){
            return 2*left(n/2);
        }
        else
            return 2*left(n/2)-1;
    }
	public static void main(String[] args) {
		num390 sol=new num390();
		sol.lastRemaining(5);
	}

}
