import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class num347 {
    //what if two numbers at kth position
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>res=new LinkedList<Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        if(map.size()<=k)
            return new LinkedList<Integer>(map.keySet());
        int[] fres=new int[map.size()];
        int index=0;
        for(int each:map.values())
            fres[index++]=each;
        int pivot=-1;
        int start=0;
        int end=fres.length-1;
        while(pivot!=k){
            pivot=find(fres,start,end);
            System.out.println(pivot);
            if(pivot+1>k)
                end=pivot-1;
            else if(pivot+1<k)
                start=pivot+1;
            else
                break;
            while(pivot+1<fres.length&&pivot+1<k&&fres[pivot+1]==fres[pivot])
                pivot++;
            while(pivot-1>=0&&pivot+1>k&&fres[pivot-1]==fres[pivot])
                pivot--;
        }
        for(int key:map.keySet()){
            if(map.get(key)>=fres[pivot])
                res.add(key);
        }
        return res;
        
    }
    private int find(int[] nums,int l,int r){
        int pivot=l++;
        while(l<=r){
            while(l<=r&&nums[l]>=nums[pivot])
                l++;
            while(l<=r&&nums[r] <nums[pivot])
                r--;
            if(l<r){
                nums[l]^=nums[r];
                nums[r]^=nums[l];
                nums[l]^=nums[r];
            }
        }
        if(pivot!=r){
            nums[pivot]^=nums[r];
            nums[r]^=nums[pivot];
            nums[pivot]^=nums[r];
        }
        return r;
    }

	public static void main(String[] args) {
		num347 sol=new num347();
		int[] test={5,2,5,3,5,3,1,1,3};
		System.out.println(sol.topKFrequent(test, 2));
//		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
//		map.values();
	}

}
