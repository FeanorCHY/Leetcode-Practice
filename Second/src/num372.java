import java.util.HashMap;

public class num372 {

    //will b contains leading zero? will the loop over Integer limit?
    //O(length of b)
    public int superPow(int a, int[] b) {
        if(a==1337)
            return 0;
        if(a>1337)
            a=a%1337;
        if(a==1||b==null)
            return 1;
        int t=(a*a)%1337;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(1,a);
        map.put(0,1);
        int pow=1;
        while(t!=a){
            map.put(++pow,t);
            t=(t*a)%1337;
        }
        int idx=0;
        int cur=1;
        int len=Integer.toString(pow).length();
        int rem=0;
        while(idx<b.length){
            rem=rem*10+b[idx++];
            rem=rem%pow;
        }
        return map.get(rem);
    }
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}

}
