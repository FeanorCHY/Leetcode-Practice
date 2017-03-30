import java.util.LinkedList;
import java.util.List;

public class num216 {

    List<List<Integer>> res=new LinkedList<List<Integer>>();
    int n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n<1||k<1||n>45)
            return res;
        this.n=n;
        search(k,1,0,new LinkedList<Integer>());
        return res;
    }
    private void search(int k,int idx,int pre,List<Integer> list){
        if(k==1){
            if(n-pre>=idx&&n-pre<=9){
                List<Integer> tem=new LinkedList<Integer>(list);
                tem.add(n-pre);
                res.add(tem);
            }
            return;
        }
        for(int i=idx;i<=9;i++){
            if(pre+i*k>n)
                return;
            if(i+pre<n){
                list.add(i);
                search(k-1,i+1,pre+i,list);
                list.remove(list.size()-1);
            }
            else{
                return;
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
