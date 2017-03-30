import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class num068 {

    //if the any words longer than L? what if only one world on a line?
    public List<String> fullJustify(String[] words, int L) {
        if(words==null||words.length==0)
            return new LinkedList<String>();
        int idx=0;
        List<String> res=new ArrayList<String>(words.length);
        while(idx<words.length){
            if(words[idx].length()==L){//one word can take whole line
                res.add(words[idx++]);
                continue;
            }
            StringBuilder sb=new StringBuilder();
            int i=idx+1,sum=words[idx].length();
            while(i<words.length&&sum+words[i].length()+1<=L){
                sum+=words[i++].length()+1;
            }
            int n=i-idx;
            if(n==1){
                sb.append(words[idx++]);
                for(int j=sum;j<L;j++){
                    sb.append(' ');
                }
            }
            else if(i==words.length){
                while(idx<words.length){
                    sb.append(words[idx++]);
                    if(idx!=words.length)
                        sb.append(' ');
                }
                while(sum<L){
                    sb.append(' ');
                    sum++;
                }
            }
            else{
                int num=(L-sum)/(n-1);
                int ex=(L-sum)-num*(n-1);
                while(idx<i){
                    sb.append(words[idx++]);
                    if(idx!=i){
                        sb.append(' ');
                        for(int k=0;k<num;k++){
                            sb.append(' ');
                        }
                        if(ex>0){
                            sb.append(' ');
                            ex--;
                        }
                    }
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
