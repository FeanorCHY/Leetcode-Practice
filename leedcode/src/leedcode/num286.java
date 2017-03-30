package leedcode;

import java.util.Arrays;
import java.util.LinkedList;

public class num286 {
    public void wallsAndGates(int[][] rooms) {
    	LinkedList<Integer> x=new LinkedList<Integer>();
    	LinkedList<Integer> y=new LinkedList<Integer>();
        for(int i=0;i<rooms.length;i++){
        	for(int j=0;j<rooms[0].length;j++){
        		if(rooms[i][j]==0){
        			x.add(i);
        			y.add(j);
        		}
        	}
        }
        fill(x,y,rooms);
    }
    public void fill(LinkedList<Integer> x,LinkedList<Integer> y,int[][] rooms){
    	int num=1;
    	while(!x.isEmpty()){
	    	LinkedList<Integer> nextx=new LinkedList<Integer>();
	    	LinkedList<Integer> nexty=new LinkedList<Integer>();
	    	while(!x.isEmpty()){
	    		int w1=x.removeFirst();
	    		int w2=y.removeFirst();
	    		fill(rooms,w1+1,w2,nextx,nexty,num);
	    		fill(rooms,w1-1,w2,nextx,nexty,num);
	    		fill(rooms,w1,w2+1,nextx,nexty,num);
	    		fill(rooms,w1,w2-1,nextx,nexty,num);
	    	}
			num++;
			x=nextx;
			y=nexty;
    	}
    }
    public void fill(int[][] rooms,int x,int y,LinkedList<Integer> lx,LinkedList<Integer> ly,int dis){
    	if(x>=rooms.length||x<0||y>=rooms[0].length||y<0)
    		return;
    	else{
    		if(rooms[x][y]>dis){
    			rooms[x][y]=dis;
    			lx.add(x);
    			ly.add(y);
    		}
    	}
    }
	public static void main(String[] args) {
		int[][] test={{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
		num286 sol=new num286();
		sol.wallsAndGates(test);
		for(int i=0;i<test.length;i++){
			System.out.println(Arrays.toString(test[i]));
		}
	}

}
