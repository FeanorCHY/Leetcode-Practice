import java.util.HashMap;
import java.util.HashSet;
//public class AllOne {
//class AONode{
//  int num;
//  String str;
//  public AONode(int num,String str){
//      this.num=num;
//      this.str=str;
//  }
//}
//class NumNode{
//  int num;
//  HashSet<AONode> hs;
//  public NumNode(int num){
//  	this.num=num;
//      hs=new HashSet<AONode>();
//  }
//  NumNode next;
//  NumNode pre;
//}
//NumNode head,tail;
//HashMap<String,AONode> map=new HashMap<String,AONode>();
//HashMap<Integer,NumNode> NumMap=new HashMap<Integer,NumNode>();
///** Initialize your data structure here. */
//public AllOne() {
//  head=new NumNode(0);
//  tail=new NumNode(Integer.MAX_VALUE);
//  head.next=tail;
//  tail.pre=head;
//  NumMap.put(0,head);
//}

///** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
//public void inc(String key) {
//  if(!map.containsKey(key))
//      map.put(key,new AONode(0,key));
//  AONode node=map.get(key);
//  NumNode Num=NumMap.get(node.num);
//  NumNode next=getNext(Num);
//  next.hs.add(node);
//  Num.hs.remove(node);
//  if(Num.hs.size()==0&&Num.num!=0)
//      RemoveNode(Num);
//  node.num++;
//}
//private void RemoveNode(NumNode node){
//  node.next.pre=node.pre;
//  node.pre.next=node.next;
//  node.next=null;
//  node.pre=null;
//  NumMap.remove(node.num);
//}
//private NumNode getNext(NumNode node){
//  if(node.next.num==node.num+1)
//      return node.next;
//  NumNode next=new NumNode(node.num+1);
//  NumMap.put(node.num+1,next);
//  next.next=node.next;
//  node.next.pre=next;
//  node.next=next;
//  next.pre=node;
//  return next;
//}

///** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
//public void dec(String key) {
//  if(!map.containsKey(key))
//      return;
//  AONode node=map.get(key);
//  NumNode Num=NumMap.get(node.num);
//  NumNode pre=getPre(Num);
//  if(pre.num!=0)
//      pre.hs.add(node);
//  else
//      map.remove(key);
//  Num.hs.remove(node);
//  if(Num.hs.size()==0)
//      RemoveNode(Num);
//  node.num--;
//}

//private NumNode getPre(NumNode node){
//  if(node.pre.num==node.num-1)
//      return node.pre;
//  NumNode pre=new NumNode(node.num-1);
//  NumMap.put(node.num-1,pre);
//  pre.pre=node.pre;
//  node.pre.next=pre;
//  node.pre=pre;
//  pre.next=node;
//  return pre;
//}
///** Returns one of the keys with maximal value. */
//public String getMaxKey() {
//  if(map.size()==0)
//      return "";
//  return tail.pre.hs.iterator().next().str;
//}

///** Returns one of the keys with Minimal value. */
//public String getMinKey() {
 
//  if(map.size()==0)
//      return "";
//  return head.next.hs.iterator().next().str;
//}
//}



public class AllOne {

	class NumNode{
	 int num;
	 HashSet<String> hs;
	 public NumNode(int num){
	 	this.num=num;
	     hs=new HashSet<String>();
	 }
	 NumNode next;
	 NumNode pre;
	}
	NumNode head,tail;
	HashMap<String,Integer> map=new HashMap<String,Integer>();
	HashMap<Integer,NumNode> NumMap=new HashMap<Integer,NumNode>();
	/** Initialize your data structure here. */
	public AllOne() {
	 head=new NumNode(0);
	 tail=new NumNode(Integer.MAX_VALUE);
	 head.next=tail;
	 tail.pre=head;
	 NumMap.put(0,head);
	}
	
	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
	 if(!map.containsKey(key))
	     map.put(key,0);
	 int count=map.get(key);
	 map.put(key,count+1);
	 NumNode node=NumMap.get(count);
	 NumNode next=getNeibor(node,1);
	 next.hs.add(key);
	 node.hs.remove(key);
	 if(node.hs.size()==0&&node.num!=0)
	     RemoveNode(node);
	}
	private void RemoveNode(NumNode node){
	 node.next.pre=node.pre;
	 node.pre.next=node.next;
	 node.next=null;
	 node.pre=null;
	 NumMap.remove(node.num);
	}
	private NumNode getNeibor(NumNode node,int offset){
	 if(NumMap.containsKey(node.num+offset))
	     return NumMap.get(node.num+offset);
	 NumNode next=new NumNode(node.num+offset);
	 NumMap.put(next.num,next);
	 if(offset==1)
	     addAfter(node,next);
	 else
	     addAfter(node.pre,next);
	 return next;
	}
	private void addAfter(NumNode node,NumNode insert){
	 insert.next=node.next;
	 node.next.pre=insert;
	 node.next=insert;
	 insert.pre=node;
	}
	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key) {
	 if(!map.containsKey(key))
	     return;
	 int count=map.get(key);
	 map.put(key,count-1);
	 NumNode node=NumMap.get(count);
	 NumNode pre=getNeibor(node,-1);
	 if(pre.num!=0)
	     pre.hs.add(key);
	 else
	     map.remove(key);
	 pre.hs.add(key);
	 node.hs.remove(key);
	 if(node.hs.size()==0)
	     RemoveNode(node);
	}
	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
	 if(map.size()==0)
	     return "";
	 return tail.pre.hs.iterator().next();
	}
	
	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
	 if(map.size()==0)
	     return "";
	 return head.next.hs.iterator().next();
	}
}

