import java.util.HashMap;
import java.util.HashSet;

public class num166 {
    //what if den is Integer.MAX_VALUE
    public String fractionToDecimal(int nume, int deno) {
        StringBuilder res=new StringBuilder();
        long num=Math.abs((long)nume);
        long den=Math.abs((long)deno);//be care of transformation
        if((long)nume*(long)deno<0)
            res.append('-');
        res.append(num/den);
        if(nume%deno==0)
            return res.toString();
        res.append('.');
        num=num%den;
        HashMap<Long,Integer> map=new HashMap<Long,Integer>();
        while(num!=0&&!map.containsKey(num)){
            map.put(num,res.length());
            num=num*10;
            long got=num/den;
            num=num%den;
            res.append(got);
        }
        if(num!=0){
            res.insert(map.get(num),"(");
            res.append(')');
        }
        return res.toString();
    } 

	public static void main(String[] args) {
		num166 sol=new num166();
		System.out.println(sol.fractionToDecimal(-1,-2147483648));
	}

}
