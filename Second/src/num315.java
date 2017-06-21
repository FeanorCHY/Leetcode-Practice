import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class num315 {
    //fail TreeSet
// 	class CSNode implements Comparable<CSNode>{
// 		int val;
// 		int fre;
// 		@Override
// 		public int compareTo(CSNode o) {
// 			if(val==o.val)
// 				return fre-o.fre;
// 			return val-o.val;
// 		}
// 		public String toString(){
// 			return "val:"+val+" fre:"+fre;
// 		}
// 		public CSNode(int val,int fre){
// 			this.val=val;
// 			this.fre=fre;
// 		}
		
// 	}
//     public List<Integer> countSmaller(int[] nums) {
//         List<Integer> res=new ArrayList<Integer>(nums.length+1);
//         if(nums==null||nums.length==0)
//             return res;
//         TreeSet<CSNode> set=new TreeSet<CSNode>();
//         for(int i=nums.length-1;i>=0;i--){
//             res.add(set.headSet(new CSNode(nums[i],-1)).size());
//             CSNode up=set.floor(new CSNode(nums[i]+1,-1));
//             set.add(new CSNode(nums[i],(up==null||up.val!=nums[i]?0:up.fre)+1));
//         }
//         List<Integer> tem=new ArrayList<Integer>(nums.length+1);
//         for(int i=res.size()-1;i>=0;i--)
//             tem.add(res.get(i));
//         return tem;
//     }


    //BST Time O(nlogn) Space o(n)
	class CSNode{
		int val;
		int l=0,r=0,dup=1;
		CSNode left,right;
		public CSNode(int val){
		    this.val=val;
		}
		
	}
	int count[];
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res=new ArrayList<Integer>(nums.length+1);
        if(nums==null||nums.length==0)
            return res;
        count=new int[nums.length];
        CSNode root=new CSNode(nums[nums.length-1]);
        for(int i=nums.length-2;i>=0;i--)
            insert(root,nums[i],i);
        for(int i=0;i<nums.length;i++)
            res.add(count[i]);
        return res;
    }
    private CSNode insert(CSNode node,int num,int idx){
        if(node==null)
            return new CSNode(num);
        else if(num<node.val){
            node.l++;
            node.left=insert(node.left,num,idx);
        }
        else if(num>node.val){
            node.r++;
            count[idx]+=node.dup+node.l;
            node.right=insert(node.right,num,idx);
        }
        else{
            node.dup++;
            count[idx]+=node.l;
        }
        return node;
    }


	public static void main(String[] args) {
		num315 sol=new num315();
		int[] test={5,2,6,2,1};
		System.out.println(sol.countSmaller(test));
	}

}
