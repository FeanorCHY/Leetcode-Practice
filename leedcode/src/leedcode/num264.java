package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class num264 {
    public int nthUglyNumber(int n) {
    	int[] list=new int[n];
    	if(n==1)
    		return 1;
    	list[0]=1;
    	int index=0;
    	for(int i=1;i<=n-1;i++){
    		long small=Long.MAX_VALUE;
    		for(int j=index;j<i;j++){
    			long each=list[j];
    			long fac[]=new long[3];
    			fac[0]=each*2;
    			fac[1]=each*3;
    			fac[2]=each*5;
    			if(fac[2]<list[i-1])
    				index=j+1;
    			if(fac[0]>small)
    				break;
    			for(long num:fac){
	    			if(num>list[i-1]&&num<small){
	    				small=num;
	    				break;
	    			}
    			}
    		}
//    		if(i==1575)
//    			System.out.println();
//    		if(small==Integer.MAX_VALUE)
//    			System.out.println();
//    		if(small==list.get(list.size()-1))
//    			System.out.println();
    		list[i]=(int)small;
    	}
    	return list[n-1];
    	
    	
    }
	public static void main(String[] args) {
		num264 sol=new num264();
//		for(int i=1;i<=20;i++)
			System.out.println(sol.nthUglyNumber(1600));
	}

}


//int two=2;
//int three=3;
//int five=5;
//int[] index;
//HashMap<Integer,List<Integer>> mp;
//index=new int[4];
//mp=new HashMap<Integer,List<Integer>>();
//two=2;
//three=3;
//five=5;
////for(int i=0;i<index.length;i++)
////	index[i]=1;
//mp.put(6, new ArrayList<Integer>());
//mp.put(10, new ArrayList<Integer>());
//mp.put(15, new ArrayList<Integer>());
//mp.put(30, new ArrayList<Integer>());
//mp.get(6).add(1);
//mp.get(10).add(1);
//mp.get(15).add(1);
//mp.get(30).add(1);
//if(n==1)
//	return 1;
//int result=1;
//for(int i=2;i<=n;i++){
//	result=merge();
//	System.out.println(result);
//}
//return result;
//}
//public int merge(){
//int small=Math.min(Math.min(two, three), five);
//int i=0;
//int smallest=-1;
//int smallkey=-1;
//for(int key:mp.keySet()){
//	int val=key*mp.get(key).get(index[i++]);
//	if(val<small){
//		small=val;
//		smallest=i-1;
//		smallkey=key;
//	}
//}
//if(smallest!=-1){
//	mp.get(smallkey).add(small);
//	index[smallest]++;
//}
//else{
//	if(small==two){
//		mp.get(6).add(two);
//		mp.get(10).add(two);
//		mp.get(30).add(two);
//		two=two*2;
//	}
//	else if(small==three){
//		mp.get(6).add(three);
//		mp.get(15).add(three);
//		mp.get(30).add(three);
//		three=three*3;
//	}
//	else if(small==five){
//		mp.get(10).add(five);
//		mp.get(15).add(five);
//		mp.get(30).add(five);
//		five=five*5;
//	}
//}
//return small;
//}