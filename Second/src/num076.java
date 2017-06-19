import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class num076 {

    //Queue Time: o(n) Space o(n)
    public String minWindow(String s, String t) {
        if(s==null||t==null||s.length()==0||t.length()==0)
            return "";
        char[] arrs=s.toCharArray();
        char[] arrt=t.toCharArray();
        int[] alp=new int[256];
        HashSet<Character> hs=new HashSet<Character>();
        for(char c:arrt){
            if(alp[c]==0)
                hs.add(c);
            alp[c]++;
        }
        Queue<Integer> q=new LinkedList<Integer>();
        int count=hs.size();
        int i=0;
        for(;i<arrs.length;i++){
            if(hs.contains(arrs[i])){
                q.add(i);
                alp[arrs[i]]--;
                if(alp[arrs[i]]==0){
                    count--;
                    if(count==0)
                        break;
                }
            }
        }
        if(count>0)
            return "";
        while(!q.isEmpty()&&alp[arrs[q.peek()]]<0)
            alp[arrs[q.poll()]]++;
        String res=s.substring(q.peek(),++i);
        for(;i<arrs.length;i++){
            if(hs.contains(arrs[i])){
                q.add(i);
                alp[arrs[i]]--;
                while(!q.isEmpty()&&alp[arrs[q.peek()]]<0)
                    alp[arrs[q.poll()]]++;
                if(!q.isEmpty()&&i-q.peek()+1<res.length())
                    res=s.substring(q.peek(),i+1);
            }
        }
        return res;
    }
	public static void main(String[] args) {
		num076 sol=new num076();
		System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
	}

}
