import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Node{
	int val;
	public Node(int val){
		this.val=val;
	}
}
public class test {
	public static void main(String[] args) {
//		int x=Integer.MAX_VALUE+Integer.MAX_VALUE+3;
//		System.out.println(x);
//		System.out.println(Integer.toBinaryString(x));
		
//		PriorityQueue<Node> pq=new PriorityQueue<Node>(new Comparator<Node>(){
//			@Override
//			public int compare(Node n1,Node n2){
//				return n1.val-n2.val;
//			}
//		});
//		Node t=new Node(8);
//		pq.add(t);
//		pq.add(new Node(4));
//		pq.add(new Node(2));
//		pq.add(new Node(5));
//		t.val=1;
//		pq.remove(t);
//		pq.add(t);
//		System.out.println(pq.poll().val);
//		System.out.println(pq.poll().val);
//		
//		LinkedHashMap<Integer,Integer> map=new LinkedHashMap<Integer,Integer>();
//		map.put(2, 4);
//		map.put(1,3);
//		map.put(-1,3);
//		System.out.println(map.keySet());
//		LinkedHashMap<Integer,Integer> map2=new LinkedHashMap<Integer, Integer>(10, 0.75f, true);
		
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		
		
	}
	public class Process implements Runnable {
        @Override
        public void run() {
        	System.out.println(1);
        }
    }

}
