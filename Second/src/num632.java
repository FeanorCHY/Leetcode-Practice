import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.List;

public class num632 {
    //merge sort and sliding window Time O(nlogk+n)
    // class PNode{
    //     int val;
    //     int group;
    //     public PNode(int val,int group){
    //         this.val=val;
    //         this.group=group;
    //     }
    //     // public String toString(){
    //     //     return val+"";
    //     // }
    // }
    // public int[] smallestRange(List<List<Integer>> nums) {
    //     List<PNode> merged=merge(nums,0,nums.size()-1);
    //     int[] res={merged.get(0).val,merged.get(merged.size()-1).val};
    //     // System.out.println(merged);
    //     int left=0;
    //     int count[]=new int[nums.size()];
    //     int cur=0;
    //     for(int i=0;i<merged.size();i++){
    //         PNode node=merged.get(i);
    //         if(cur<count.length){
    //             if(count[node.group]==0)
    //                 cur++;
    //         }
    //         count[node.group]++;
    //         while(cur==count.length&&count[merged.get(left).group]>1){
    //             count[merged.get(left++).group]--;
    //         }
    //         if(cur==count.length&&res[1]-res[0]>node.val-merged.get(left).val){//||(res[1]-res[0]==node.val-merged.get(left).val&&res[0]<merged.get(left).val)
    //             res[0]=merged.get(left).val;
    //             res[1]=node.val;
    //         }
    //     }
    //     return res;
    // }
    // private List<PNode> merge(List<List<Integer>> nums,int start,int end){
    //     if(start==end){
    //         List<PNode> list=new ArrayList<PNode>(nums.get(start).size());
    //         for(int each:nums.get(start)){
    //             list.add(new PNode(each,start));
    //         }
    //         return list;
    //     }
    //     int mid=(start+end)/2;
    //     List<PNode> left=merge(nums,start,mid);
    //     List<PNode> right=merge(nums,mid+1,end);
    //     List<PNode> res=new ArrayList<PNode>(left.size()+right.size());
    //     int idx1=0,idx2=0;
    //     while(idx1<left.size()||idx2<right.size()){
    //         if(idx1==left.size())
    //             res.add(right.get(idx2++));
    //         else if(idx2==right.size())
    //             res.add(left.get(idx1++));
    //         else{
    //             if(left.get(idx1).val>=right.get(idx2).val){
    //                 res.add(right.get(idx2++));
    //             }
    //             else{
    //                 res.add(left.get(idx1++));
    //             }
    //         }
    //     }
    //     return res;
    // }
    
    //PriorityQueue Time O(nlogk)
    class PNode{
        int val;
        int group;
        int idx;
        int len;
        public PNode(int val,int group,int idx,int len){
            this.val=val;
            this.group=group;
            this.idx=idx;
            this.len=len;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<PNode> pq=new PriorityQueue<PNode>(new Comparator<PNode>(){
            @Override
            public int compare(PNode node1,PNode node2){
                if(node1.val==node2.val)
                    return (node2.len-node2.idx)-(node1.len-node1.idx);
                return node1.val-node2.val;
            }
        });
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            List<Integer> list=nums.get(i);
            pq.add(new PNode(list.get(0),i,0,list.size()));
            max=Math.max(list.get(0),max);
        }
        int[] res={pq.peek().val,max};
        while(pq.size()==nums.size()){
            PNode node=pq.poll();
            if(max-node.val<res[1]-res[0]){
                res[1]=max;
                res[0]=node.val;
            }
            if(node.idx+1<node.len){
                node.idx++;
                node.val=nums.get(node.group).get(node.idx);
                pq.add(node);
                max=Math.max(node.val,max);
            }
        }
        
        return res;
    }
	public static void main(String[] args) {
		List<Integer> list=new LinkedList<Integer>();
		
	}

}
