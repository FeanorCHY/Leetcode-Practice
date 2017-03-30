package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class Build{
	int left;
	int right;
	int hi;
	Build(int left,int right,int hi){
		this.left=left;
		this.right=right;
		this.hi=hi;
	}
	void change(int left,int right,int hi){
		this.left=left;
		this.right=right;
		this.hi=hi;
	}
}
public class num218 {
	
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new LinkedList<int[]>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>(){
          public int compare(Integer a, Integer b) {
        	  return b - a;
          }
        });
        List<int[]> list=new ArrayList<int[]>();
        for(int i=0;i<buildings.length;i++){
        	list.add(new int[]{buildings[i][0],buildings[i][2]});
        	list.add(new int[]{buildings[i][1],-buildings[i][2]});
        }
        Collections.sort(list,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[0]==o2[0])?(o2[1]-o1[1]):(o1[0]-o2[0]);
			}
        });
        int cur=0;
        int pre=0;
        for(int i=0;i<list.size();i++){
        	int[] each=list.get(i);
        	if(each[1]>0){
    			pq.add(each[1]);
    			cur=pq.peek();
        	}
        	else{
    			pq.remove(-each[1]);
    			cur=(pq.isEmpty()?0:pq.peek());
        	}
    		if(cur!=pre){
    			res.add(new int[]{each[0],cur});
    			pre=cur;
    		}
        	
        }
        
        return res;
    }
	public static void main(String[] args) {
		num218 sol=new num218();
		int test[][]={{0,2,3},{2,5,3}};//{{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8} };
		List<int[]> res=sol.getSkyline(test);
		for(int[] each:res){
			System.out.println(Arrays.toString(each));
		}
	}

}


//PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,
//        new Comparator<Integer>() {
//            public int compare(Integer a, Integer b) {
//                return b - a;
//            }
//        });
//List<int[]> bl = new ArrayList<int[]>();
//for (int i = 0; i < buildings.length; i++) {
//    bl.add(new int[] { buildings[i][0], buildings[i][2] });
//    bl.add(new int[] { buildings[i][1], -buildings[i][2] });
//}
//Collections.sort(bl, new Comparator<int[]>() {
//    public int compare(int[] a, int[] b) {
//        return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
//    }
//});
//int pre = 0, cur = 0;
//for (int i = 0; i < bl.size(); i++) {
//    int[] b = bl.get(i);
//    if (b[1] > 0) {
//        maxHeap.add(b[1]);
//        cur = maxHeap.peek();
//    } else {
//        maxHeap.remove(-b[1]);
//        cur = (maxHeap.peek() == null) ? 0 : maxHeap.peek();
//    }
//    if (cur != pre) {
//        res.add(new int[] { b[0], cur });
//        pre = cur;
//    }
//}
//return res;


//List<int[]> res=new ArrayList<int[]>();
//Stack<Build> st=new Stack<Build>();
//Build cur=null; 
//for(int i=0;i<buildings.length;i++){
//	if(cur==null){
//		cur=new Build(buildings[i][0],buildings[i][1],buildings[i][2]);
//		int[] arr={buildings[0][0],buildings[0][1]};
//		res.add(arr);
//	}
//	else{
//		if(cur.right<buildings[i][1]){
//			if(st.peek().hi>buildings[i][2]){
//    			int[] tem={cur.right,st.peek().hi};
//    			res.add(tem);
//				cur=st.pop();
//				st.push(new Build(buildings[i][0],buildings[i][1],buildings[i][2]));
//			}
//			if(buildings[i][1]>st.peek().right){
//				st.pop();
//			}
//			
//		}
//		if(buildings[i][2]>cur.hi){
//			if(cur.right<buildings[0][1]){
//    			int[] tem={cur.right,0};
//    			res.add(tem);
//			}
//			else{
//				st.add(push);
//			}
//			int[] arr={buildings[i][0],buildings[i][1]};
//			res.add(arr);
//			cur=new Build(buildings[i][0],buildings[i][1],buildings[i][2]);
//		}
//	}
//}




//List<int[]> res=new ArrayList<int[]>(); 
//int height[]=new int[buildings[buildings.length-1][1]+2];
//if(buildings.length==0)
//	return res;
//Stack<Build> st=new Stack<Build>();
//st.push(new Build(0,height.length,0));
//Build cur=new Build(buildings[0][0],buildings[0][1],buildings[0][2]);
//int index=1;
//for(int i=cur.left;i<height.length;i++){
//	if(index==buildings.length){
//		if(i<=cur.right)
//			height[i]=cur.hi;
//		else{
//			height[i]=0;
//		}
//	}
//	else{
//		if(cur.right<i){
//			while(cur.right<i&&!st.isEmpty()){
//				cur=st.pop();
//			}
//		}
//		if(cur.hi<buildings[index][2]){
//			st.push(cur);
//			cur=new Build(buildings[index][0],buildings[index][1],buildings[index][2]);
//		}
//		
//		height[i]=cur.hi;
//	}
//}
//int[] arr={buildings[0][0],buildings[0][2]};
//res.add(arr);
//for(int i=cur.left;i<height.length;i++){
//	if(height[i]!=arr[1]){
//		arr=new int[2];
//		arr[0]=i-1;
//		arr[1]=height[i];
//		res.add(arr);
//	}
//}
//
//
//return res;
