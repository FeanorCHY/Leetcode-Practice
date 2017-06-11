import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class num218 {

    //PriorityQueue Time O(nlogn) space O(n)
    // class Node{
    //     int hi;
    //     long end;
    //     public Node(long end,int hi){
    //         this.end=end;
    //         this.hi=hi;
    //     }
    // }
    // public List<int[]> getSkyline(int[][] buildings) {
    //     List<int[]> res=new ArrayList<int[]>(buildings.length);
    //     if(buildings==null||buildings.length==0)
    //         return res;
    //     PriorityQueue<Node> pq=new PriorityQueue<Node>(new Comparator<Node>(){
    //         @Override
    //         public int compare(Node n1,Node n2){
    //             if(n1.hi==n2.hi)
    //                 return (int)(n2.end-n1.end);
    //             return n2.hi-n1.hi;
    //         }
    //     });
    //     int cur=0;
    //     long right=(long)Integer.MAX_VALUE+1;
    //     for(int i=0;i<buildings.length;i++){
    //         int[] build=buildings[i];
    //         while((long)build[0]>right){
    //             Node node=pq.poll();
    //             if(node.end<=right)//nice
    //                 continue;
    //             res.add(new int[]{right==((long)Integer.MAX_VALUE+1)?Integer.MAX_VALUE:(int)right,node.hi});
    //             right=node.end;
    //             cur=node.hi;
    //         }
    //         if(build[2]>cur){
    //             if(right>(long)build[1])//nice
    //                 pq.add(new Node(right,cur));
    //             cur=build[2];
    //             right=(long)build[1];
    //             if(i>0&&build[0]==res.get(res.size()-1)[0])//not the last point but the last array point
    //                 res.get(res.size()-1)[1]=build[2];
    //             else
    //                 res.add(new int[]{build[0],build[2]});
    //         }
    //         else if(build[2]==cur)
    //             right=Math.max(right,(long)build[1]);
    //         else if((long)build[1]>right)
    //             pq.add(new Node(build[1],build[2]));
    //     }
    //     while(!pq.isEmpty()){
    //         Node node=pq.poll();
    //         if(node.end<=right)//nice
    //             continue;
    //         res.add(new int[]{right==((long)Integer.MAX_VALUE+1)?Integer.MAX_VALUE:(int)right,node.hi});
    //         right=node.end;
    //         cur=node.hi;
    //     }
    //     return res;
    // }
    
    
    //divide and conquer Time O(nlogn) space O(n)
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings==null||buildings.length==0)
            return new ArrayList<int[]>();
        return divide(0,buildings.length-1,buildings);
    }
    private LinkedList<int[]> divide(int start,int end,int[][] buildings){
        if(start==end){
            LinkedList<int[]> list=new LinkedList<int[]>();
            list.add(new int[]{buildings[start][0],buildings[start][2]});
            list.add(new int[]{buildings[start][1],0});
            return list;
        }
        else{
            int mid=(start+end)/2;
            return merge(divide(start,mid,buildings),divide(mid+1,end,buildings));
        }
    }
    private LinkedList<int[]> merge(LinkedList<int[]> list1,LinkedList<int[]> list2){
        int h1=0,h2=0,h=0,x=0;
        LinkedList<int[]> res=new LinkedList<int[]>();
        while(!list1.isEmpty()&&!list2.isEmpty()){
            if(list1.getFirst()[0]<list2.getFirst()[0]){
                h1=list1.getFirst()[1];
                h=Math.max(h2,h1);
                x=list1.getFirst()[0];
                list1.removeFirst();
            }
            else if(list1.getFirst()[0]>list2.getFirst()[0]){
                h2=list2.getFirst()[1];
                h=Math.max(h1,h2);
                x=list2.getFirst()[0];
                list2.removeFirst();
            }
            else{
                x=list2.getFirst()[0];
                h1=list1.getFirst()[1];
                h2=list2.getFirst()[1];
                h=Math.max(h1,h2);
                list2.removeFirst();
                list1.removeFirst();
            }
            if(res.isEmpty()||res.getLast()[1]!=h){
                res.add(new int[]{x,h});
            }
        }
        res.addAll(list1);
        res.addAll(list2);
        return res;
    }
	public static void main(String[] args) {
		int[][] test
			={{0,5,7},{5,10,7},{5,10,12},{10,15,7},{15,20,7},{15,20,12},{20,25,7}};
//			={{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//			={{0,2147483647,2147483647}};
		num218 sol=new num218();
		for(int[] each:sol.getSkyline(test)){
			System.out.println(Arrays.toString(each));
		}
	}

}
