import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class num040 {

    //O(N!)
    List<List<Integer>> res=new LinkedList<List<Integer>>();
    int[] cans;
    public List<List<Integer>> combinationSum2(int[] cans, int target) {
        if(cans==null||cans.length==0)
            return res;
        Arrays.sort(cans);
        this.cans=cans;
        search(0,target,new ArrayList<Integer>(cans.length));
        return res;
    }
    private void search(int idx,int rest,List<Integer> list){
        for(int i=idx;i<cans.length;i++){
            if(i>idx&&cans[i]==cans[i-1])//take care of duplicate result
                continue;
            if(rest==cans[i]){
                list.add(cans[i]);
                res.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
            else if(rest>cans[i]){
                list.add(cans[i]);
                search(i+1,rest-cans[i],list);
                list.remove(list.size()-1);
            }
            else
                return;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
