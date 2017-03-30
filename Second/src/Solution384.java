import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution384 {


    int[] nums;
    int[] copy;
    List<int[]> list=new ArrayList<int[]>();
    boolean[] visit;
    Random ran=new Random();
    //null input
    public Solution384(int[] nums) {
        this.nums=nums;
        this.visit=new boolean[nums.length];
        copy=new int[nums.length];
        produce(0);
    }
    private void produce(int level){
        if(level==nums.length){
            System.out.println(list.size());
            System.out.println(level);
            list.add(copy.clone());
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visit[i])
                continue;
            visit[i]=true;
            copy[level]=nums[i];
            produce(level+1);
            visit[i]=false;
        }
    }
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        return list.get(ran.nextInt(list.size()));
    }
}
