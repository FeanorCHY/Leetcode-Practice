package leedcode;

import java.util.Arrays;
import java.util.Comparator;

class FInterval{
	Interval intv;
	int index;
	FInterval(Interval intv,int index){
		this.intv=intv;
		this.index=index;
	}
}
public class num436 {
	FInterval[] fints;
    public int[] findRightInterval(Interval[] intvs) {
    	fints=new FInterval[intvs.length];
    	int[] res=new int[intvs.length];
    	for(int i=0;i<intvs.length;i++){
    		fints[i]=new FInterval(intvs[i],i);
    	}
    	Arrays.sort(fints,new Comparator<FInterval>(){

			@Override
			public int compare(FInterval o1, FInterval o2) {
				// TODO Auto-generated method stub
				return o1.intv.start==o2.intv.start?(o1.intv.end-o2.intv.end):(o1.intv.start-o2.intv.start);
			}
    	});
    	for(int i=0;i<fints.length;i++){
    		int tem=Bsearch(i+1,fints[i].intv.end);
    		res[fints[i].index]=tem==-1?-1:fints[tem].index;
    	}
    	return res;
    }
    private int Bsearch(int l,int tar){
    	int r=fints.length-1;
    	while(l<=r){
    		int mid=(l+r)/2;
    		if(fints[mid].intv.start==tar)
    			return mid;
    		else if(fints[mid].intv.start>tar)
    			r=mid-1;
    		else
    			l=mid+1;
    	}
    	if(l==fints.length)
    		return -1;
    	return l;
    }
	public static void main(String[] args) {
		int[][] test=
				{ {3,4}, {2,3}, {1,2} };
		Interval[] intvs=new Interval[test.length];
		for(int i=0;i<test.length;i++){
			intvs[i]=new Interval(test[i][0],test[i][1]);
		}
		num436 sol=new num436();
		System.out.println(Arrays.toString(sol.findRightInterval(intvs)));
	}

}
