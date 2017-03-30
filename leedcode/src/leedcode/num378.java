package leedcode;

import java.util.PriorityQueue;

class Element implements Comparable<Element>{

	int x;
	int y;
	int val;
	Element(int x,int y,int val){
		this.x=x;
		this.y=y;
		this.val=val;
	}
	@Override
	public int compareTo(Element o) {
		// TODO Auto-generated method stub
		return this.val-o.val;
	}
	
}
public class num378 {
    public int kthSmallest(int[][] matrix, int k) {
    	PriorityQueue<Element> pq=new PriorityQueue<Element>();
    	pq.add(new Element(0,0,matrix[0][0]));
    	boolean[][] visited=new boolean[matrix.length][matrix[0].length];
    	visited[0][0]=true;
    	for(int i=0;i<k-1;i++){
    		Element el=pq.poll();
    		if(el.y+1<matrix.length&&!visited[el.x][el.y+1]){
    			visited[el.x][el.y+1]=true;
    			pq.add(new Element(el.x,el.y+1,matrix[el.x][el.y+1]));
    		}
    		if(el.x+1<matrix[0].length&&!visited[el.x+1][el.y]){
    			visited[el.x+1][el.y]=true;
    			pq.add(new Element(el.x+1,el.y,matrix[el.x+1][el.y]));
    		}
    		
    	}
    	
    	return pq.poll().val;
    }
	public static void main(String[] args) {
		num378 sol=new num378();
		int[][] test ={{ 1,  5,  9},{10, 11, 13},{12, 13, 15}};
		System.out.println(sol.kthSmallest(test, 9));
	}

}
