import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num364 {

    //Store value in List: Time: O(N) Space: O(N) 
    // public int depthSumInverse(List<NestedInteger> nestedList) {
    //     if(nestedList==null||nestedList.size()==0)
    //         return 0;
    //     List<Integer> list=new ArrayList<Integer>();
    //     Stack<List<NestedInteger>> st=new Stack<List<NestedInteger>>();
    //     Stack<Integer> idx=new Stack<Integer>();
    //     List<NestedInteger> cur=nestedList;
    //     int i=0;
    //     while(i<cur.size()||!st.isEmpty()){
    //         while(!st.isEmpty()&&i==cur.size()){//take care of end
    //             i=idx.pop();
    //             cur=st.pop();
    //         }
    //         if(st.isEmpty()&&i==cur.size())
    //             break;
    //         if(list.size()==st.size())//take care of starting list [[x,x,x],x,x,x]
    //             list.add(0);
    //         NestedInteger tem=cur.get(i++);
    //         if(tem.isInteger()){
    //             list.set(st.size(),list.get(st.size())+tem.getInteger());
    //         }
    //         else{
    //             st.push(cur);
    //             idx.push(i);
    //             i=0;
    //             cur=tem.getList();
    //         }
    //     }
    //     int res=0;
    //     int size=list.size();
    //     i=0;
    //     for(;i<list.size();i++){
    //         res+=list.get(i)*(size-i);
    //     }
    //     return res;
    // }
    
    
    //BFS
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList==null||nestedList.size()==0)
            return 0;
        Queue<Integer> sum=new LinkedList<Integer>();
        Queue<List<NestedInteger>> q=new LinkedList<List<NestedInteger>>();
        q.add(nestedList);
        while(!q.isEmpty()){
            int size=q.size();
            int num=0;
            for(int i=0;i<size;i++){
                List<NestedInteger> list=q.poll();
                for(NestedInteger each:list){
                    if(each.isInteger())
                        num+=each.getInteger();
                    else
                        q.add(each.getList());
                }
            }
            sum.add(num);
        }
        int res=0;
        while(!sum.isEmpty()){
            res+=sum.size()*sum.poll();
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
