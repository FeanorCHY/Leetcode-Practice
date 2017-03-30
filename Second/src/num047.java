import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class num047 {


    //backtracking with sorting
    List<List<Integer>> res=new LinkedList<List<Integer>>();
    int[] nums;
    boolean[] visit;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null||nums.length==0)
            return res;
        Arrays.sort(nums);
        this.nums=nums;
        this.visit=new boolean[nums.length];
        build(new LinkedList<Integer>());
        return res;
    }
    private void build(List<Integer> list){
        if(list.size()==nums.length){
            res.add(new LinkedList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visit[i]){
                visit[i]=true;
                list.add(nums[i]);
                build(list);
                visit[i]=false;
                while(i+1<nums.length&&nums[i]==nums[i+1])
                    i++;
                list.remove(list.size()-1);
            }
        }
    }
	public static void main(String[] args) {
		int[] test={1,1,2};
		num047 sol=new num047();
		sol.permuteUnique(test);
	}

}
