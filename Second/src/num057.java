import java.util.ArrayList;
import java.util.List;

public class num057 {
    public List<Interval> insert(List<Interval> intvs, Interval intv) {
        if(intvs==null||intv==null)
            return new ArrayList<Interval>();
        List<Interval> res=new ArrayList<Interval>(intvs.size()+1);
        boolean insert=false;
        for(Interval each:intvs){
            if(!insert){
                if(each.end<intv.start){
                    res.add(each);
                    continue;
                }
                else{
                    if(each.start>intv.end){
                        res.add(intv);
                        res.add(each);
                    }
                    else{
                        intv.start=Math.min(intv.start,each.start);
                        intv.end=Math.max(intv.end,each.end);
                        res.add(intv);
                    }
                    insert=true;
                }
            }
            else{
                if(intv.end>=each.start)
                    intv.end=Math.max(intv.end,each.end);
                else
                    res.add(each);
            }
        }
        if(!insert)
            res.add(intv);
        return res;
    }
}
