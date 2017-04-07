import java.util.LinkedList;
import java.util.List;

public class num267 {
    //if "a" a Palindromes? lower case only?
    //backtracking Time O(A(N,N)) Space O(1)
    List<String> res;
    String odd=null;
    public List<String> generatePalindromes(String s) {
        res=new LinkedList<String>();
        if(s==null||s.length()==0)
            return res;
        char[] arr=s.toCharArray();
        int count[]=new int[256];//all character inclusive
        for(char c:arr)
            count[c]++;
        for(int i=0;i<256;i++){
            if(count[i]%2==1){
                if(odd==null){
                    odd=(char)i+"";
                    count[i]--;
                }
                else
                    return res;
            }
            count[i]/=2;//each one should be divied by two
        }
        if(odd==null)
            odd="";//remember odd should not be null
        search(count,new StringBuilder());
        return res;
    }
    private void search(int[] count,StringBuilder sb){
        boolean add=false;
        for(int i=0;i<256;i++){
            if(count[i]>0){
                add=true;
                count[i]--;
                sb.append((char)i);
                search(count,sb);
                sb.deleteCharAt(sb.length()-1);
                count[i]++;
            }
        }
        if(!add){
            res.add(sb.toString()+odd+sb.reverse().toString());
            sb.reverse();
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append("123456");
		sb.reverse();
		System.out.println(sb.toString());
	}

}
