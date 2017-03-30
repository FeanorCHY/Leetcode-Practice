import java.util.LinkedList;
import java.util.List;

public class num060 {

    //what if k is larger than n!
    //O(N^2)
    public String getPermutation(int n, int k) {
        if(n<1)
            return null;
        List<Long> list=new LinkedList<Long>();
        for(long i=1;i<=n;i++){
            list.add(i);
        }
        long kk=k-1;
        StringBuilder res=new StringBuilder();
        long total=1;
        for(long i=2;i<n;i++){
            total*=i;
        }
        for(long i=n-1;i>=0;i--){
            res.append(list.remove((int)(kk/total)));
            kk=kk%total;
            if(i>0)
                total=total/i;
        }
        return res.toString();
    }
	public static void main(String[] args) {
		List<Integer> list=new LinkedList<Integer>();
		list.add(9);
		list.add(8);
		list.add(3);
		list.add(2);
		System.out.println(list.remove(2));
	}

}
