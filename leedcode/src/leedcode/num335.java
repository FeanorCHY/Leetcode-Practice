package leedcode;

public class num335 {
	public boolean isSelfCrossing(int[] x) {
		if(x.length<4)
			return false;
		for(int i=3;i<x.length;i++){
			if(i>=3){
				if(x[i]>x[i-2]&&x[i-1]<x[i-3])
					return true;
			}
			if(i>=4){
				if(x[i-1]<=x[i-3]&&x[i-1]+(i==4?0:x[i-5])>=x[i-3]&&x[i]>=x[i-2]-x[i-4]&&x[i-2]>=x[i-4])
					return true;
			}
			
		}
		return false;
    }
	public static void main(String[] args) {
		int test[]={3,3,4,2,2};
		num335 sol=new num335();
		System.out.println(sol.isSelfCrossing(test));
	}

}



//public boolean isSelfCrossing(int[] x) {
//	
//	if(x.length<4)
//		return false;
//	int[] dis=new int[x.length+1];
//	dis[0]=Integer.MAX_VALUE;
//	dis[1]=Integer.MAX_VALUE;
//	dis[2]=Integer.MAX_VALUE;
////	boolean over=true;
//	for(int i=2;i<x.length;i++){
//		if(x[i]>=dis[i])
//			return true;
//		if(x[i]<=x[i-2]){
//			dis[i+1]=x[i-1];
//		}
//		else
//			dis[i+1]=Integer.MAX_VALUE;
//	}
//	return false;
//}