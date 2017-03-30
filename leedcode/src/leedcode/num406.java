package leedcode;

import java.util.Arrays;
import java.util.Comparator;

class QNode{
	int height;
	int num;
	QNode next;
	public QNode(int height,int num){
		this.height=height;
		this.num=num;
		next=null;
	}
}
public class num406 {
	
    public int[][] reconstructQueue(int[][] people) {
    	Arrays.sort(people,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]==o2[0]?(o1[1]-o2[1]):(o2[0]-o1[0]);
			}
    	});
    	int[][] res=new int[people.length][2];
    	QNode head=null;
    	for(int i=0;i<people.length;i++){
    		QNode node=new QNode(people[i][0],people[i][1]);
    		if(head==null)
    			head=node;
    		else{
        		if(node.num==0){
        			node.next=head;
        			head=node;
        		}
        		else{
            		int count=0;
            		QNode next=head;
	    			while(next!=null){
	    				if(next.height>=node.height){
	    					count++;
	    				}
	    				if(count==node.num){
	    					node.next=next.next;
	    					next.next=node;
	    				}
    					next=next.next;
	    			}
        		}
    		}
    	}
    	int index=0;
    	while(head!=null){
    		res[index][0]=head.height;
    		res[index++][1]=head.num;
    		head=head.next;
    	}
        return res;
    }
	public static void main(String[] args) {
		int[][] test={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		num406 sol=new num406();
		sol.reconstructQueue(test);
	}

}
