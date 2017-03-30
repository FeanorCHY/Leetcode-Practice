package leedcode;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num133 {
	Map<Integer,UndirectedGraphNode> reached=new HashMap<Integer,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node==null)
    		return null;
        return copyNode(node);
    }
    public UndirectedGraphNode copyNode(UndirectedGraphNode node1){
    	UndirectedGraphNode newNode=new UndirectedGraphNode(node1.label);
		reached.put(newNode.label, newNode);
		for(UndirectedGraphNode each:node1.neighbors){
			if(!reached.containsKey(each.label)){
				UndirectedGraphNode newCopy=copyNode(each);
				newNode.neighbors.add(newCopy);
			}
			else
				newNode.neighbors.add(reached.get(each.label));
		}
		return newNode;
    }
	public static void main(String[] args) {
	}

}
