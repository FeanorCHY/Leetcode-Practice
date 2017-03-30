import java.util.HashMap;

public class num133 {

    //will neighbours be duplicated? that is 1 contains 2 and 2 coantains 1. will neighbors contain null;
    HashMap<Integer,UndirectedGraphNode> map=new HashMap<Integer,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        UndirectedGraphNode copy=new UndirectedGraphNode(node.label);
        map.put(node.label,copy);
        for(UndirectedGraphNode each:node.neighbors){
            if(map.containsKey(each.label)){
                copy.neighbors.add(map.get(each.label));
            }
            else{
                copy.neighbors.add(cloneGraph(each));
            }
        }
        return copy;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer.valueOf(s)
	}

}
