//doubly linked list TLE
// public class MedianFinder {
//     class MFNode{
//         MFNode next;
//         MFNode pre;
//         int val;
//         public MFNode(int val){
//             this.val=val;
//         }
//     }
//     MFNode head;
//     MFNode tail;
//     MFNode mid;
//     int len;
//     /** initialize your data structure here. */
//     public MedianFinder() {
//         this.head=new MFNode(Integer.MIN_VALUE);
//         this.tail=new MFNode(Integer.MAX_VALUE);
//         len=0;
//         head.next=tail;
//         tail.pre=head;
//         this.mid=head;
//     }
//     //O(N)
//     public void addNum(int num) {
//         MFNode node=new MFNode(num);
//         MFNode search=null;
//         if(num>=mid.val)
//             search=mid;
//         else
//             search=head;
//         MFNode last=null;
//         while(search!=null&&num>=search.val){
//             last=search;
//             search=search.next;
//         }
//         insert(last,node);
//         if(num>=mid.val){
//             if(len%2==0)
//                 mid=mid.next;
//         }
//         else{
//             if(len%2==1)
//                 mid=mid.pre;
//         }
//         len++;
//     }
//     private void insert(MFNode cur,MFNode node){
//         cur.next.pre=node;
//         node.next=cur.next;
//         cur.next=node;
//         node.pre=cur;
//     }
//     public double findMedian() {
//         if(len%2==0)
//             return (mid.val+mid.next.val)/2.0;
//         else
//             return mid.val*1.0;
//     }
// }

//two heap
// public class MedianFinder {
//     PriorityQueue<Integer> small;
//     PriorityQueue<Integer> large;
//     double mid;
//     /** initialize your data structure here. */
//     public MedianFinder() {
//         small =new PriorityQueue<Integer>(new Comparator<Integer>(){
//             @Override
//             public int compare(Integer o1,Integer o2){
//                 return o2-o1;
//             }
//         });
//         large =new PriorityQueue<Integer>();
//         mid=0;
//     }
//     //O(NlogN)
//     public void addNum(int num) {
//         if(num>=mid){
//             large.add(num);
//         }
//         else
//             small.add(num);
//         if(small.size()==large.size()+2)
//             large.add(small.poll());
//         else if(small.size()+2==large.size())
//             small.add(large.poll());
//         if(small.size()==large.size())
//             mid=(small.peek()+large.peek())/2.0;
//         else if(small.size()>large.size())
//             mid=small.peek();
//         else
//             mid=large.peek();
//     }
//     public double findMedian() {
//         return mid;
//     }
// }





//two heap
public class MedianFinder {
    class MFNode{
        MFNode left;
        MFNode right;
        MFNode parent;
        int val;
        public MFNode(int val){
            this.val=val;
        }
    }
    MFNode root;
    MFNode mid1,mid2;
    int len=0;
    /** initialize your data structure here. */
    public MedianFinder() {
        root=null;
        mid1=null;
        mid2=null;
    }
    //avg O(NlogN)
    public void addNum(int num) {
        len++;
        MFNode node=root;
        MFNode add=new MFNode(num);
        if(root==null){
            root=add;
            mid1=root;
        }
        else{
            while(add.parent==null){
                if(num>=node.val){
                    if(node.right==null){
                        node.right=add;
                        add.parent=node;
                    }
                    else
                        node=node.right;
                }
                else{
                    if(node.left==null){
                        node.left=add;
                        add.parent=node;
                    }
                    else
                        node=node.left;
                }
            }
            if(num>=mid1.val){
                if(mid2==null){
                    mid2=larger(mid1);
                }
                else{
                    if(num<mid2.val)
                        mid1=add;
                    else
                        mid1=mid2;
                    mid2=null;
                }
            }
            else{
                if(mid2==null){
                    mid2=mid1;
                    mid1=less(mid2);
                }
                else{
                    mid2=null;
                }
            }
        }
    }
    private MFNode less(MFNode node){
        if(node.left!=null){
            node=node.left;
            while(node.right!=null)
                node=node.right;
            return node;
        }
        else{
            MFNode parent=node.parent;
            while(parent.right!=node){
                node=parent;
                parent=parent.parent;
            }
            return parent;
        }
    }
    private MFNode larger(MFNode node){
        if(node.right!=null){
            node=node.right;
            while(node.left!=null)
                node=node.left;
            return node;
        }
        else{
            MFNode parent=node.parent;
            while(parent.left!=node){
                node=parent;
                parent=parent.parent;
            }
            return parent;
        }
    }
    public double findMedian() {
        if(mid2==null)
            return mid1.val;
        else
            return (mid1.val+mid2.val)/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */