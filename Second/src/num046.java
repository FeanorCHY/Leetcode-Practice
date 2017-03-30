import java.util.ArrayList;
import java.util.List;

public class num046 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0)
            return res;
        List<Integer> list=new ArrayList<Integer>();
        list.add(nums[0]);
        res.add(list);
        for(int i=1;i<nums.length;i++){
            List<List<Integer>> tem=new ArrayList<List<Integer>>();
            for(List<Integer> each:res){
                for(int j=0;j<=each.size();j++){
                    List<Integer> copy=new ArrayList<Integer>(each);
                    copy.add(j,nums[i]);
                    tem.add(copy);
                }
            }
            res=tem;
        }
        return res;
    }
	public static void main(String[] args) {
        List<Integer> copy=new ArrayList<Integer>();
        copy.add(2);
        List<Integer> each=new ArrayList<Integer>(copy);
        each.add(3);
        System.out.println(each);
	}

}
