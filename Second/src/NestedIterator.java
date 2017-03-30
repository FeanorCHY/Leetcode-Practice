import java.util.List;
import java.util.Stack;

public class NestedIterator {

    List<NestedInteger> cur;
    int idx;
    Stack<List<NestedInteger>> st1;
    Stack<Integer> st2;
    public NestedIterator(List<NestedInteger> nestedList) {
        cur=nestedList;
        idx=0;
        st1=new Stack<List<NestedInteger>>();
        st2=new Stack<Integer>();
        move();
    }
    private void move(){
        while(idx==cur.size()&&!st1.isEmpty()){
            cur=st1.pop();
            idx=st2.pop()+1;
        }
        while(idx<cur.size()&&!cur.get(idx).isInteger()){
            if(cur.get(idx).getList()==null||cur.get(idx).getList().size()==0){
                idx++;
                while(idx==cur.size()&&!st1.isEmpty()){
                    cur=st1.pop();
                    idx=st2.pop()+1;
                }
            }
            else{
                st1.push(cur);
                st2.push(idx);
                cur=cur.get(idx).getList();
                idx=0;
            }
        }
    }
//    @Override
    public Integer next() {
        int res=cur.get(idx++).getInteger();
        move();
        return res;
    }

//    @Override
    public boolean hasNext() {
        return idx!=cur.size();
    }

}
