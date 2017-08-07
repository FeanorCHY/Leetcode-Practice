import java.util.HashSet;

public class num403 {
    public boolean canCross(int[] stones) {
        if(stones==null||stones.length<=1)
            return true;
        HashSet<Integer> set=new HashSet<Integer>();
        for(int each:stones)
            set.add(each);
        int target=stones[stones.length-1];
        HashSet<Long> fail=new HashSet<Long>();
        return search(0,target,set,0,fail);
    }
    private boolean search(int pre,int target,HashSet<Integer> set,int cur,HashSet<Long> fail){
        if(cur==target)
            return true;
        else if(cur>target)
            return false;
        else if(fail.contains((long)cur*(long)pre))
            return false;
        if((set.contains(cur+pre+1)&&search(pre+1,target,set,cur+pre+1,fail))||(pre-1>0&&set.contains(cur+pre-1)&&search(pre-1,target,set,cur+pre-1,fail))||(pre>0&&set.contains(cur+pre)&&search(pre,target,set,cur+pre,fail)))
            return true;
        fail.add((long)cur*(long)pre);
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
