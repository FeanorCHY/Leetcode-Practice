package leedcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class cell{
	int x;
	int y;
	int h;
	public cell(int x,int y,int h){
		this.x=x;
		this.y=y;
		this.h=h;
	}
}
public class num407 {
	public int trapRainWater(int[][] hm) {
		if(hm.length<=2)
			return 0;
		PriorityQueue<cell> pq=new PriorityQueue<cell>(new Comparator<cell>(){

			@Override
			public int compare(cell o1, cell o2) {
				// TODO Auto-generated method stub
				return o1.h-o2.h;
			}

		});
		boolean visit[][]=new boolean[hm.length][hm[0].length];
		for(int i=0;i<hm.length;i++){
			visit[i][0]=true;
			visit[i][hm[0].length-1]=true;
			pq.offer(new cell(i,0,hm[i][0]));
			pq.offer(new cell(i,hm[0].length-1,hm[i][hm[0].length-1]));
		}
		for(int i=1;i<hm[0].length-1;i++){
			visit[0][i]=true;
			visit[hm.length-1][i]=true;
			pq.offer(new cell(0,i,hm[0][i]));
			pq.offer(new cell(hm.length-1,i,hm[hm.length-1][i]));
		}
		int[] dx={1,0,-1,0};
		int[] dy={0,1,0,-1};
		int sum=0;
		while(!pq.isEmpty()){
			cell c=pq.poll();
			for(int i=0;i<4;i++){
				int x=c.x+dx[i];
				int y=c.y+dy[i];
				if(x>0&&x<visit.length&&y>0&&y<visit[0].length&&!visit[x][y]){
					visit[x][y]=true;
					sum+=Math.max(0, c.h-hm[x][y]);
					pq.offer(new cell(x,y,Math.max(hm[x][y], c.h)));
				}
			}
		}
        return sum;
    }

	public static void main(String[] args) {
		int[][] test={{9,9,9,9,9,9,8,9,9,9,9},{9,0,0,0,0,0,1,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,9,9,9,9,9,9,9,9,9,9}};
		num407 sol=new num407();
		System.out.println(sol.trapRainWater(test));
	}

}

//
//public int trapRainWater(int[][] hm) {
//	if(hm.length==0||hm==null)
//		return 0;
//	int[][] rain=new int[hm.length][hm[0].length]; //[[9,9,9,9,9,9,8,9,9,9,9],[9,0,0,0,0,0,1,0,0,0,9],[9,0,0,0,0,0,0,0,0,0,9],[9,0,0,0,0,0,0,0,0,0,9],[9,9,9,9,9,9,9,9,9,9,9]]
//	for(int i=0;i<hm.length;i++){
//		int max=0;
//		for(int j=0;j<hm[0].length;j++){
//			max=Math.max(max, hm[i][j]);
//			rain[i][j]=max;
//		}
//		max=0;
//		for(int j=hm[0].length-1;j>=0;j--){
//			max=Math.max(max, hm[i][j]);
//			if(max<rain[i][j])
//				rain[i][j]=max;
//		}
//	}
//	for(int i=0;i<hm[0].length;i++){
//		int max=0;
//		for(int j=0;j<hm.length;j++){
//			max=Math.max(max, hm[j][i]);
//			if(max<rain[j][i])
//				rain[j][i]=max;
//		}
//		max=0;
//		for(int j=hm.length-1;j>=0;j--){
//			max=Math.max(max, hm[j][i]);
//			if(max<rain[j][i])
//				rain[j][i]=max;
//		}
//	}
//	int sum=0;
//	for(int i=1;i<hm.length-1;i++){
//		for(int j=1;j<hm[0].length-1;j++){
//			int con= Math.min(rain[i-1][j], Math.min(rain[i+1][j], Math.min(rain[i][j+1], rain[i][j-1])));
//			sum+=Math.max(0,con-hm[i][j]);
//		}
//	}
//	return sum;
//}