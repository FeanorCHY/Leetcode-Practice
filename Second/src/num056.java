import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class num056 {

    
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

        List<Interval> ret = new ArrayList<>();
        Interval prev = null;
        for (Interval inter : intervals) {
            if (  prev==null || inter.start>prev.end ) {
                ret.add(inter);
                prev = inter;
            } else if (inter.end>prev.end) {
                // Modify the element already in list
                prev.end = inter.end;
            }
        }
        return ret;
    }
    
    
    //sort start and end
    // public List<Interval> merge(List<Interval> list) {
    // 	List<Interval> res = new ArrayList<Interval>();
    // 	if(list==null||list.size()==0)
    // 	    return res;
    // 	int n = list.size();
    // 	int[] start=new int[n];
    // 	int[] end=new int[n];
    // 	for(int i=0;i<list.size();i++){
    // 	    start[i]=list.get(i).start;
    // 	    end[i]=list.get(i).end;
    // 	}
    // 	Arrays.sort(start);
    // 	Arrays.sort(end);
    // 	for(int i=0,j=0;i<n;i++){
    // 	    if(i==n-1||start[i+1]>end[i]){
    // 	        res.add(new Interval(start[j],end[i]));
    // 	        j=i+1;
    // 	    }
    // 	}
    // 	return res;
    // }
    
//    public List<Interval> merge(List<Interval> intervals) {
//        if(intervals==null||intervals.size()<=1)
//            return intervals;
//        int n=intervals.size();
//        List<Interval> res=new ArrayList<Interval>(intervals.size());//output
//        int[] starts=new int[n];//all starts
//        int[] ends=new int[n];//all starts
//        int pos=0;
//        for(Interval each:intervals){
//            starts[pos]=each.start;
//            ends[pos++]=each.end;
//        }
//        Arrays.sort(starts);
//        Arrays.sort(ends);
//        int idx1=0,idx2=0;
//        int s=0,last=-1;
//        while(idx2<n){
//            if(idx1<n&&starts[idx1]<=ends[idx2]){//attention! = //if the start not closed, increase number of non-closed interval
//                s++;
//                if(last==-1)
//                    last=idx1;
//                idx1++;
//            }
//            else{
//                s--;//close one interval
//                if(s==0){//if all previous intervals closed, add all merged intervals
//                    res.add(new Interval(starts[last],ends[idx2]));
//                    last=-1;
//                }
//                idx2++;
//            }
//        }
//        return res;
//    }
    
    //failed
    //can I change the original input? can I refer to original input elements?
    //O(NlogN)
    // public List<Interval> merge(List<In terval> intervals) {
    //     List<Interval> res=new ArrayList<Interval>();
    //     Collections.sort(intervals,new Comparator<Interval>(){
    //         @Override
            
    //         public int compare(Interval i1,Interval i2){
    //             if(i1.start==i2.start){
    //                 return i1.end-i2.end;
    //             }
    //             else
    //                 return i1.start-i2.start;
    //         }
            
            
    //         });
    //     // sort(intervals,0,intervals.size()-1);
    //     for(int i=0;i<intervals.size();i++){
    //         if(res.size()==0||intervals.get(i).start>res.get(res.size()-1).end)
    //             res.add(intervals.get(i));
    //         else if(intervals.get(i).end>res.get(res.size()-1).end)
    //             res.get(res.size()-1).end=intervals.get(i).end;
    //     }
    //     return res;
    // }
    // private void sort(List<Interval> list,int start,int end){
    //     if(start>=end)
    //         return;
    //     int tem=end;
    //     int pivot=start++;
    //     while(start<=end){
    //         while(start<=end&&compare(list.get(start),list.get(pivot))<=0)
    //             start++;
    //         while(start<=end&&compare(list.get(end),list.get(pivot))>0)
    //             end--;
    //         if(start<end)
    //             swap(list,start++,end--);
    //     }
    //     if(end!=pivot)
    //         swap(list,end,pivot);
    //     sort(list,pivot,end-1);
    //     sort(list,end+1,tem);
    // }
    // private void swap(List<Interval> list,int x1,int x2){
    //     Interval tem=list.get(x1);
    //     list.add(x2,tem);
    //     tem=list.remove(x2+1);
    //     list.add(x1,tem);
    //     list.remove(x1+1);
    // }
    // private int compare(Interval i1,Interval i2){
    //     if(i1.start==i2.start){
    //         return i1.end-i2.end;
    //     }
    //     else
    //         return i1.start-i2.start;
    // }
	public static void main(String[] args) {
		List<Interval> intervals;
	}

}
