package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Alist{
	int len;
	long last;
	long diff;
	public Alist(long last,long diff,int len){
		this.last=last;
		this.diff=diff;
		this.len=len;
	}
	public String toString(){
		return "[ last="+last+",diff="+diff+",len="+len+"]";
	}
}
public class num446 {
	public int numberOfArithmeticSlices(int[] A) {
		int res=0;
		HashMap<Long,Integer>[] map=new HashMap[A.length];
		for(int i=0;i<A.length;i++){
			map[i]=new HashMap<Long,Integer>();
			for(int j=0;j<i;j++){
				long diff=(long)A[i]-(long)A[j];
				if(diff>Integer.MAX_VALUE||diff<Integer.MIN_VALUE)
					continue;
				int count=map[j].getOrDefault(diff, 0);
				map[i].put(diff, map[i].getOrDefault(diff,0)+count+1);
				res+=count;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] test={2,2,3,4};
		num446 sol=new num446();
		System.out.println(sol.numberOfArithmeticSlices(test));
	}

}






//public int numberOfArithmeticSlices(int[] A) {
//	List<Integer> list=new ArrayList<Integer>();
//	if(A.length<3)
//		return 0;
//	List<Alist> lista=new ArrayList<Alist>();
//	int count=0;
//	for(int i=0;i<A.length;i++){
//		for(int j=0;j<lista.size();j++){
//			Alist each=lista.get(j);
//			if(A[i]-each.last==each.diff){
//				each.last=A[i];
//				each.len++;
//				if(each.len>=3)
//					count++;
//			}
//			if(each.diff==0&&each.last!=A[i]){
//				lista.add(new Alist(A[i],A[i]-each.last,2));
//				
//			}
//		}
//		lista.add(new Alist(A[i],0,1));
//	}
//	return count;
//}
//private int cal(int len){
//	if(len<3)
//		return 0;
//	
//	return (1+len-2)*(len-2)/2;
//}