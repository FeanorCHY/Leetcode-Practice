import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class num089 {
	public List<Integer> grayCode(int n) {
	    List<Integer> result = new LinkedList<>();
	    for (int i = 0; i < 1<<n; i++) result.add(i ^ (i>>1));
	    return result;
	}
    //can the code have duplicate? will the num over Integer limit? does the negative number count?
//    public List<Integer> grayCode(int n) {
//        List<Integer> res=new ArrayList<Integer>();
//        int num=1<<n;
//        boolean visit[]=new boolean[num];
//        int val=0;
//        visit[0]=true;
//        res.add(val);
//        if(n<=0)
//            return res;
//        while(res.size()<=num){
//            boolean add=false;
//            for(int i=0;i<n;i++){
//                if(!visit[val^(1<<n)]){
//                    val=val^(1<<n);
//                    visit[val]=true;
//                    res.add(val);
//                    add=true;
//                    break;
//                }
//            }
//            if(!add)
//                break;
//        }
//        return res;
//    }

	public static void main(String[] args) {
		num089 sol=new num089();
		System.out.println(sol.grayCode(3));
//		System.out.println((1^1)<<3);
	}
}
