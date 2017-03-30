import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class num039 {
    //does order matter
    List<List<Integer>> res=new LinkedList<List<Integer>>();
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length==0)
            return res;
        this.nums=candidates;
        this.target=target;
        Arrays.sort(candidates);
        search(0,0,new LinkedList<Integer>());
        return res;
    }
    private void search(int index,int sum,LinkedList<Integer> list){
        for(int i=index;i<nums.length;i++){
            if(sum+nums[i]>target)
                return;
            else if(sum+nums[i]==target){
                list.add(nums[i]);
                res.add(new LinkedList<Integer>(list));
                list.removeLast();
                return;
            }
            else{
                list.add(nums[i]);
                search(i,sum+nums[i],list);
                list.removeLast();
            }
                
        }
    }

	public static void main(String[] args) {
	    List<List<Integer>> res=new LinkedList<List<Integer>>();
	    LinkedList<Integer> list=new LinkedList<Integer>();

	}

}
