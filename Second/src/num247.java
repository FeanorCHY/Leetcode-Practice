import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num247 {
    //recursive Time O(5^N) Space O(1)
    // char[] digit={'1','8','6','9','0'};
    // char[] rev={'1','8','9','6','0'};
    // List<String> res;
    // boolean odd;
    // public List<String> findStrobogrammatic(int n) {
    //     res=new ArrayList<String>((int)Math.pow(5,n/2+1));
    //     if(n<=0)
    //         return res;
    //     if(n%2==1)
    //         odd=true;
    //     else
    //         odd=false;
    //     search((n+1)/2,new StringBuilder(),new StringBuilder());
    //     // if(n==1)//special case when n=1
    //     //     res.add("0");
    //     return res;
    // }
    // private void search(int cur,StringBuilder begin,StringBuilder end){
    //     if(cur==0){
    //         res.add(begin.toString()+end.toString());
    //         return;
    //     }
    //     int size=digit.length;
    //     if(cur==1&&odd){//no 6 9 in the middle
    //         size=2;
    //     }
    //     else if(begin.length()==0)//no zero in the beginning
    //         size--;
    //     for(int i=0;i<size;i++){
    //         begin.append(digit[i]);
    //         if(cur>1||!odd)
    //             end.insert(0,rev[i]);
    //         search(cur-1,begin,end);
    //         begin.deleteCharAt(begin.length()-1);
    //         if(cur>1||!odd)
    //             end.deleteCharAt(0);
    //     }
    //     if(cur==1&&odd){
    //         begin.append(0);
    //         search(cur-1,begin,end);
    //         begin.deleteCharAt(begin.length()-1);
    //     }
    // }
    
    
    
    //backtracking Time O(5^N) Space O(1)
    public List<String> findStrobogrammatic(int n) {
        if(n<0)
            n=0;
        return search(n,n);
    }
    private List<String> search(int rest,int n){
        if(rest==0)
            return new ArrayList<String>(Arrays.asList(""));//remember to add ""
        if(rest==1)
            return new ArrayList<String>(Arrays.asList("0","1","8"));
        List<String> list=search(rest-2,n);
        List<String> res=new ArrayList<String>();
        for(String str:list){
            if(rest!=n)
                res.add("0"+str+"0");
            res.add("1"+str+"1");
            res.add("8"+str+"8");
            res.add("6"+str+"9");
            res.add("9"+str+"6");
        }
        return res;
    }
	public static void main(String[] args) {
		Math.pow(5, 5);
		StringBuilder sb=new StringBuilder();

	}

}
