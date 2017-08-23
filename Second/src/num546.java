import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class num546 {
    //bytes as memory TLE 
// class ByteArrayWrapper
// {
//     byte[] data;

//     public ByteArrayWrapper(byte[] data)
//     {
//         if (data == null)
//         {
//             throw new NullPointerException();
//         }
//         this.data = data;
//     }

//     @Override
//     public boolean equals(Object other)
//     {
//         if (!(other instanceof ByteArrayWrapper))
//         {
//             return false;
//         }
//         return Arrays.equals(data, ((ByteArrayWrapper)other).data);
//     }

//     @Override
//     public int hashCode()
//     {
//         return Arrays.hashCode(data);
//     }
// }
// public int removeBoxes(int[] boxes) {
//     int res=0;
//     if(boxes==null||boxes.length==0)
//         return res;
//     return search(new byte[13],boxes,new HashMap<ByteArrayWrapper,Integer>());
// }
// private int search(byte[] visit,int[] boxes,HashMap<ByteArrayWrapper,Integer> dp){
//     if(dp.containsKey(new ByteArrayWrapper(visit)))
//         return dp.get(new ByteArrayWrapper(visit));
//     int cur=0;
//     List<Integer> idx=new LinkedList<Integer>();
//     int count=0;
//     int num=0;
//     for(int i=0;i<boxes.length;i++){
//         if((visit[i/8]&(1<<(i%8)))!=0)
//             continue;
//         else{
//             if(count==0){
//                 num=boxes[i];
//                 count++;
//             }
//             else if(num==boxes[i]){
//                 count++;
//             }
//             else{
//                 cur=Math.max(cur,count*count+search(visit,boxes,dp));
//                 count=1;
//                 num=boxes[i];
//                 for(int each:idx){
//                     visit[each/8]-=(1<<(each%8));
//                 }
//                 idx=new LinkedList<Integer>();
//             }
//             idx.add(i);
//             visit[i/8]|=(1<<(i%8));
//         }
//     }
//     if(count>0){
//         cur=Math.max(cur,count*count+search(visit,boxes,dp));
//         for(int each:idx){
//             visit[each/8]-=(1<<(each%8));
//         }
//     }
//     dp.put(new ByteArrayWrapper(visit.clone()),cur);
//     return cur;
// }
    
//dp Top Down
public int removeBoxes(int[] boxes) {
    if(boxes==null||boxes.length==0)
        return 0;
    return search(new int[boxes.length+1][boxes.length+1][boxes.length+1],0,boxes.length-1,0,boxes);
}
private int search(int[][][] dp,int l,int r,int k,int[] boxes){
    if(l>r)
        return 0;
    if(dp[l][r][k]>0)
        return dp[l][r][k];
    int res=(k+1)*(k+1)+search(dp,l+1,r,0,boxes);
    for(int m=l+1;m<=r;m++){
        if(boxes[m]==boxes[l])
            res=Math.max(res,search(dp,l+1,m-1,0,boxes)+search(dp,m,r,k+1,boxes));
    }
    dp[l][r][k]=res;
    return res;
}
	public static void main(String[] args) {
		num546 sol=new num546();
		int[] test={1, 3, 2, 2, 2, 3, 4, 3, 1};
		System.out.println(sol.removeBoxes(test));
//		byte[] bys=new byte[13];
//		bys[3]|=4;
//		System.out.print(bys[2]);
//		byte[] bys2=new byte[13];
//		bys2[3]|=4;
//		ByteArrayWrapper x1=new ByteArrayWrapper(bys);
//		ByteArrayWrapper x2=new ByteArrayWrapper(bys2);
//		System.out.println(Arrays.hashCode(bys));
//		System.out.println(Arrays.hashCode(bys2));
//		System.out.println(x1.hashCode());
//		System.out.println(x2.hashCode());
	}

}
