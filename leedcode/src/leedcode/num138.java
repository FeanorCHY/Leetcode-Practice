package leedcode;

import java.util.HashMap;

public class num138 {
    public RandomListNode copyRandomList(RandomListNode head) {
    	HashMap<RandomListNode,RandomListNode> hm=new HashMap<RandomListNode,RandomListNode>();
    	RandomListNode chead=null;
    	RandomListNode node=head;
    	RandomListNode last=null;
    	while(node!=null){
    		RandomListNode cnode=null;
    		if(node==head){
    			chead=new RandomListNode(head.label);
    			hm.put(head, chead);
    			cnode=chead;
    		}
    		else{
        		if(hm.containsKey(node)){
        			cnode=hm.get(node);
        		}
        		else{
        			cnode=new RandomListNode(node.label);
        			hm.put(node,cnode);
        		}
    			
    		}
    		if(last==null)
    			last=cnode;
    		else{
    			last.next=cnode;
    			last=cnode;
    		}
    		if(node.random!=null){
    			if(hm.containsKey(node.random)){
    				cnode.random=hm.get(node.random);
    			}
    			else{
    				cnode.random=new RandomListNode(node.random.label);
        			hm.put(node.random,cnode.random);
        				
    			}
    		}
    		node=node.next;
    	}
    	
    	return chead;
    }
	public static void main(String[] args) {
		RandomListNode node=new RandomListNode(1);
		node.next=new RandomListNode(2);
		node.next.next=new RandomListNode(3);
		num138 sol=new num138();
		node=sol.copyRandomList(node);
		while(node!=null){
			System.out.println(node.label+" ran:"+(node.random==null?"null":node.random.label));//+" ran:"+node.random==null?"":node.random.label
			node=node.next;
		}
	}

}
