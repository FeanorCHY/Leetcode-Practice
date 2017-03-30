import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class num022 {//

    //iterative
    public List<String> generateParenthesis(int n)
    {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
        
        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();
            
            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            
            lists.add(list);
        }
        
        return lists.get(lists.size() - 1);
    }
    
    
    //backtracking
    // List<String> res=new ArrayList<String>();
    // int n;
    // public List<String> generateParenthesis(int n) {
    //     this.n=n;
    //     serach(0,0,new StringBuilder());
    //     return res;
    // }
    // private void serach(int cur,int tol,StringBuilder sb){
    //     if(cur==0&&tol==n){
    //         res.add(sb.toString());
    //         return;
    //     }
    //     if(tol<n){
    //         sb.append("(");
    //         serach(cur+1,tol+1,sb);
    //         sb.deleteCharAt(sb.length()-1);
    //     }
    //     if(cur>0){
    //         sb.append(")");
    //         serach(cur-1,tol,sb);
    //         sb.deleteCharAt(sb.length()-1);
    //     }
    // }
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
	}

}
