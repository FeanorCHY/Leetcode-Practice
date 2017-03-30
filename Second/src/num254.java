import java.util.LinkedList;
import java.util.List;

public class num254 {
    //Recursive O(N!)
    // public List<List<Integer>> getFactors(int n) {
    //     if(n<4)
    //         return new LinkedList<List<Integer>>();
    //     return search(2,n);
    // }
    // private List<List<Integer>> search(int pre,int n){
    //     List<List<Integer>> ret=new LinkedList<List<Integer>>();
    //     for(int i=pre;i<=Math.sqrt(n);i++){
    //         if(n%i==0){
    //             List<Integer> list=new LinkedList<Integer>();
    //             list.add(i);
    //             list.add(n/i);
    //             ret.add(list);
    //             List<List<Integer>> listlist=search(i,n/i);
    //             for(List<Integer> tem:listlist){
    //                 list=new LinkedList<Integer>();
    //                 list.add(i);
    //                 list.addAll(tem);
    //                 ret.add(list);
    //             }
    //         }
    //     }
    //     return ret;
    // }
    
    
    
    
    //backtracking O(N!)
    List<List<Integer>> res=new LinkedList<List<Integer>>();
    public List<List<Integer>> getFactors(int n) {
        if(n<4)
            return new LinkedList<List<Integer>>();
        search(2,n,new LinkedList<Integer>());
        return res;
    }
    private void search(int pre,int n,LinkedList<Integer> list){
        for(int i=pre;i<=Math.sqrt(n);i++){
            if(n%i==0){
                list.add(i);
                list.add(n/i);
                res.add(new LinkedList(list));
                list.removeLast();
                search(i,n/i,list);
                list.removeLast();
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
