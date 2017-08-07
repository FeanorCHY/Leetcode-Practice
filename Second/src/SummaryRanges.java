import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
//TreeMap
public class SummaryRanges {

  TreeMap<Integer,Interval> map;
  /** Initialize your data structure here. */
  public SummaryRanges() {
      map=new TreeMap<Integer,Interval>();
  }
  //Time O(logN)
  public void addNum(int val) {
      Integer fl=map.floorKey(val);
      if(fl==null||map.get(fl).end<val-1){
          map.put(val,new Interval(val,val));
          fl=val;
      }
      else if(map.get(fl).end==val-1)
          map.get(fl).end=val;
      if(map.containsKey(val+1)){
          map.get(fl).end=map.get(val+1).end;
          map.remove(val+1);
      }
  }
  
  public List<Interval> getIntervals() {
      return new LinkedList<Interval>(map.values());
  }
}