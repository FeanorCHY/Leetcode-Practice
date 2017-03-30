package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num444 {
	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
		int map[]=new int[org.length+1];
		Arrays.fill(map, -1);
		int check[]=new int[org.length];
		for(int i=0;i<org.length;i++){
			map[org[i]]=i;
		}
		for(int i=0;i<seqs.length;i++){
			int[] each=seqs[i];
			if(each.length==0)
				continue;
			int pre=each[0];
			if(pre>org.length||pre<0||map[pre]==-1)
				return false;
			for(int j=1;j<each.length;j++){
				int cur=each[j];
				if(cur>org.length||cur<0||map[cur]==-1)
					return false;
				check[map[pre]]=Math.max(check[map[pre]], org.length-map[cur]+1);
				pre=cur;
			}
			check[map[pre]]=Math.max(check[map[pre]],1);
		}
		for(int i=0;i<check.length;i++){
			if(check[i]!=org.length-i)
				return false;
		}
        return true;
    }
	public static void main(String[] args) {
		int[][] seqs=
				{{1,2},{1,3},{2,3}};
		int[] test={1,2,3};
		num444 sol=new num444();
		System.out.println(sol.sequenceReconstruction(test, seqs));
	}

}




//public boolean sequenceReconstruction(int[] org, int[][] seqs) {
//	if(seqs.length==0&&org.length!=0)
//		return false;
//	int[] deg=new int[org.length+1];
//	List<int[]> edge=new ArrayList<int[]>(seqs.length);
//	for(int[] each:seqs){
//		for(int i=1;i<each.length;i++){
//			if(each[i]>=deg.length||each[i]<=0)
//				return false;
//			edge.add(new int[]{each[i-1],each[i]});
//			deg[each[i]]++;
//		}
//	}
//	Queue<Integer> q=new LinkedList<Integer>();
//	for(int i=1;i<deg.length;i++){
//		if(deg[i]==0)
//			q.add(i);
//	}
//	if(q.size()!=1)
//		return false;
//	int count=q.size();
//	while(!q.isEmpty()){
//		int cur=q.poll();
//		boolean add=false;
//		for(int i=0;i<edge.size();i++){
//			int[] each=edge.get(i);
//			if(each[0]==cur){
//    			edge.remove(i);
//    			i--;
//				deg[each[1]]--;
//    			if(deg[each[1]]==0){
//    				if(add)
//    					return false;
//    				count++;
//    				add=true;
//    				q.add(each[1]);
//    			}
//			}
//		}
//	}
//	return count==org.length;
//}
