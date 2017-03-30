import java.util.List;

public class ZigzagIterator {

    List<Integer> v1;
    List<Integer> v2;
    int idx1=0,idx2=0;
    boolean first=true;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1=v1;
        this.v2=v2;
        if(v1==null||v1.size()==0)
            first=false;
    }

    public int next() {
        int res;
        if(first){
            res=v1.get(idx1++);
            if(idx2<v2.size())
                first=!first;
        }
        else{
            res=v2.get(idx2++);
            if(idx1<v1.size())
                first=!first;
        }
        return res;
    }

    public boolean hasNext() {
        if(v1==null&&v2==null)
            return false;
        return idx2<v2.size()||idx1<v1.size();
    }
}
