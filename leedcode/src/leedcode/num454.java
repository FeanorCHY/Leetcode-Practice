package leedcode;

import java.util.Arrays;
import java.util.HashMap;

public class num454 {
//	int[] da={1,0,0,0};
//	int[] db={0,1,0,0};
//	int[] dc={0,0,1,0};
//	int[] dd={0,0,0,1};
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<A.length;i++){
			for(int j=0;j<B.length;j++){
				map.put(-A[i]-B[j], map.getOrDefault(-A[i]-B[j], 0)+1);
			}
		}
		int count=0;
		for(int i=0;i<C.length;i++){
			for(int j=0;j<D.length;j++){
				count+=map.getOrDefault(C[i]+D[j], 0);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] test={{1},{-1},{0},{1}};
		num454 sol=new num454();
		System.out.println(sol.fourSumCount(test[0], test[1], test[2], test[3]));
	}

}






//int count=0;
//int len;
//int[][] arr;
//int[] max=new int[4];
//int[] min=new int[4];
//HashMap<Integer,Integer>[] map=new HashMap[3];
//public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//	len=A.length;
//	if(len==0)
//		return 0;
//	Arrays.sort(A);
//	Arrays.sort(B);
//	Arrays.sort(C);
//	Arrays.sort(D);
//	int[][] tem={A,B,C,D};
//	arr=tem;
//	for(int i=0;i<map.length;i++){
//		map[i]=new HashMap<Integer,Integer>();
//	}
//	for(int i=0;i<len;i++){
//		if(map[2].containsKey(-arr[3][i]))
//			map[2].put(-arr[3][i], map[2].get(-arr[3][i])+1);
//		else
//			map[2].put(-arr[3][i],1);
//	}
//	for(int i=2;i>=0;i--){
//		max[i]=arr[i+1][len-1]+max[i+1];
//	}
//	for(int i=2;i>=0;i--){
//		min[i]=arr[i+1][0]+min[i+1];
//	}
//	search(0,0);
//	return count;
//}
//private void search(int index,int pre){
////	if(index>0&&map[index-1].containsKey(pre)){
////		count+=map[index-1].get(pre);
////		return;
////	}
//	if(index<=1){
//		Bsearch(index,pre);
//	}
//	else if(index==2){
//		int thisc=0;
//		for(int i=len-1;i>=0&&(pre+arr[index][i]+max[index])>=0;i--){
//			if(map[index].containsKey(pre+arr[index][i]))
//				thisc+=map[index].get(pre+arr[index][i]);
//		}
//		count+=thisc;
//		map[index-1].put(pre,thisc);
//	}
//}
//private void Bsearch(int index,int pre){
//	int l=0;
//	int r=len-1;
//	while(l<=r){
//		int mid=(l+r)/2;
//		if(arr[index][mid]+max[index]+pre<0){
//			r=mid-1;
//		}
//		else if(arr[index][mid]+min[index]+pre>0)
//			l=mid+1;
//		else{
//    		for(int i=mid;i>=0&&arr[index][i]+max[index]+pre>=0;i--){
//    			if(map[index].containsKey(pre+arr[index][i])){
//    				count+=map[index].get(pre+arr[index][i]);
//    			}
//    			else
//    				search(index+1,pre+arr[index][i]);
//    		}
//    		for(int i=mid+1;i<len&&arr[index][i]+min[index]+pre<=0;i++){
//    			if(map[index].containsKey(pre+arr[index][i])){
//    				count+=map[index].get(pre+arr[index][i]);
//    			}
//    			else
//    				search(index+1,pre+arr[index][i]);
//    		}
//			return;
//		}
//			
//	}
//}