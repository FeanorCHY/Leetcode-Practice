import java.util.Arrays;
import java.util.PriorityQueue;

public class num253 {

    
    //sort O(N^2);
    // public int minMeetingRooms(Interval[] ints) {
    //     if(ints==null||ints.length==0)
    //         return 0;
    //     Arrays.sort(ints,new Comparator<Interval>(){
    //         @Override
    //         public int compare(Interval e1,Interval e2){
    //             return e1.start-e2.start;
    //         }
    //     });
    //     List<Interval> list=new LinkedList<Interval>();
    //     for(Interval intv:ints){
    //         boolean suc=false;
    //         for(Interval each:list){
    //             if(intv.start>=each.end){
    //                 suc=true;
    //                 each.end=intv.end;
    //                 break;
    //             }
    //         }
    //         if(!suc){
    //             list.add(intv);
    //         }
    //     }
    //     return list.size();
    // }
    
    
    
    //optimized sort O(NlogN);
    // public int minMeetingRooms(Interval[] ints) {
    //     if(ints==null||ints.length==0)
    //         return 0;
    //     Arrays.sort(ints,new Comparator<Interval>(){
    //         @Override
    //         public int compare(Interval e1,Interval e2){
    //             return e1.start-e2.start;
    //         }
    //     });
    //     PriorityQueue<Integer> pq = new PriorityQueue<Integer>(ints.length);
    //     for(Interval intv:ints){
    //         if(pq.isEmpty())
    //             pq.add(intv.end);
    //         else if(pq.peek()>intv.start){
    //             pq.add(intv.end);
    //         }
    //         else{
    //             pq.poll();
    //             pq.add(intv.end);
    //         }
    //     }
    //     return pq.size();
    // }
    
    
    
    
    
    //sort starts and ends O(NlogN);
    public int minMeetingRooms(Interval[] ints) {
        if(ints==null||ints.length==0)
            return 0;
        int[] starts=new int[ints.length];
        int[] ends=new int[ints.length];
        for(int i=0;i<ints.length;i++){
            starts[i]=ints[i].start;
            ends[i]=ints[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res=0;
        int idx=0;
        for(int i=0;i<starts.length;i++){
            if(starts[i]<ends[idx])
                res++;
            else
                idx++;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(2);
		pq.add(1);
		pq.add(3);
		System.out.println(pq.poll());
	}

}
