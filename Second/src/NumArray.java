// public class NumArray {

//     int[] sum;
//     int[] nums;
//     int len;
//Time: O(NlogN) Space O(N)
//     public NumArray(int[] nums) {
//         if(nums==null||nums.length==0)
//             return;
//         this.nums=nums;
//         this.len=nums.length;
//         sum=new int[len+1];
//         for(int i=0;i<len;i++){
//             int num=i+1;
//             while(num<=len){
//                 sum[num]+=nums[i];
//                 num+=lowbit(num);
//             }
//         }
//     }
    //O(logN)
//     public void update(int i, int val) {
//         int dif=val-nums[i];
//         nums[i]=val;
//         int num=i+1;
//         while(num<=len){
//             sum[num]+=dif;
//             num+=lowbit(num);
//         }
//     }
    //O(logN)
//     public int sumRange(int i, int j) {
//         return sumUp(j+1)-sumUp(i);
//     }
//     private int sumUp(int num){
//         int res=0;
//         while(num>0){
//             res+=sum[num];
//             num-=lowbit(num);
//         }
//         return res;
//     }
//     private int lowbit(int num){
//         return num&(-num);
//     }
// }






//Sqrt decomposition
// public class NumArray {
//     int[] sq;
//     int[] nums;
//     int len;
//     //Time: O(sqrt(N)) Space: O(sqrt(N))
//     public NumArray(int[] nums) {
//         if(nums==null||nums.length==0)
//             return;
//         this.nums=nums;
//         this.len=(int)Math.ceil(Math.sqrt(nums.length));
//         sq=new int[len];
//         for(int i=0;i<nums.length;i++){
//             sq[i/len]+=nums[i];
//         }
//     }
//     //O(1)
//     public void update(int i, int val) {
//         sq[i/len]=sq[i/len]+val-nums[i];
//         nums[i]=val;
//     }
//     //0(sqrt(N))
//     public int sumRange(int i, int j) {
//         int res=0;
//         for(int k=i/len+1;k<=j/len-1;k++)
//             res+=sq[k];
//         if(j/len>i/len){
//             if(i%len==0)
//                 res+=sq[i/len];
//             else{
//                 for(int k=i;k%len>0;k++)
//                     res+=nums[k];
//             }
//             if(j%len==len-1)
//                 res+=sq[j/len];
//             else{
//                 for(int k=(j/len)*len;k<=j;k++)
//                     res+=nums[k];
//             }
//         }
//         else{
//             for(;i<=j;i++)
//                 res+=nums[i];
//         }
//         return res;
//     }
// }




//Segment Tree
public class NumArray {
    int[] tree;
    int n;
    //Time: O(N) Space: O(N)
    public NumArray(int[] nums) {
        if(nums==null||nums.length==0)
            return;
        this.n=nums.length;
        tree=new int[n*2];
        for(int i=0;i<n;i++)
            tree[i+n]=nums[i];
        for(int i=n-1;i>=0;i--)
            tree[i]=tree[i*2+1]+tree[i*2];
    }
    //O(logN)
    public void update(int i, int val) {
        int pos=i+n;
        int dif=val-tree[pos];
        // System.out.println("update");
        while(pos>=0){
            tree[pos]+=dif;
            if(pos==0)
                break;
            pos=pos/2;
        }
    }
    //0(logN)
    public int sumRange(int i, int j) {
        // System.out.println("sum");
        int res=0;
        i+=n;
        j+=n;
        while(i<=j){
            if(i%2==1){
                res+=tree[i++];
            }
            if(j%2==0){
                res+=tree[j--];
            }
            i/=2;
            j/=2;
        }
        return res;
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */