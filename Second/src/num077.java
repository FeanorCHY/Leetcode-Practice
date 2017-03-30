import java.util.LinkedList;
import java.util.List;

public class num077 {

    List<List<Integer>> res=new LinkedList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        if(n<=0||k<=0){
            res.add(new LinkedList<Integer>());
            return res;
        }
        search(n,k,1,new LinkedList<Integer>());
        return res;
    }
    private void search(int n,int rest,int index,LinkedList<Integer> list){
        if(rest==0){
            res.add(new LinkedList<Integer>(list));
            return;
        }
        for(int i=index;i<=n;i++){
            list.add(i);
            search(n,rest-1,i+1,list);
            list.removeLast();
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
