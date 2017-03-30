package leedcode;

import java.util.List;
import java.util.ArrayList;

public class num294 {
    public boolean canWin(String s) {
    	if(s.length()==0||s.length()==1)
    		return false;
    	boolean[] barr=new boolean[s.length()];
    	char[] arr=s.toCharArray();
    	for(int i=0;i<barr.length;i++){
    		if(arr[i]=='+')
    			barr[i]=true;
    		else
    			barr[i]=false;
    	}
    	
    	
    	
    	return tryWin(barr);
    }
    public boolean tryWin(boolean[] barr){
    	for(int i=0;i<barr.length-1;i++){
    		if(barr[i]&&barr[i+1]){
    			barr[i]=false;
    			barr[i+1]=false;
    			if(!tryWin(barr)){
    				barr[i]=true;
    				barr[i+1]=true;
    				return true;
    			}
    			else{
    				barr[i]=true;
    				barr[i+1]=true;
    			}
    		}
    	}
    	
    	return false;
    }
	public static void main(String[] args) {
		num294 sol=new num294();
		System.out.println(sol.canWin("+++++"));
	}

}
//
//int oe[];
//public boolean canWin(String s) {
//	int count=0;
//	int max=Integer.MIN_VALUE;
//	List<Integer> list=new ArrayList<Integer>();
//	char[] arr=s.toCharArray();
//	if(arr.length==0)
//		return false;
//	for(int i=0;i<arr.length;i++){
//		if(arr[i]=='+')
//			count++;
//		if((arr[i]=='-'||i==arr.length-1)&&count!=0){
//			if(count>max)
//				max=count;
//			list.add(count);
//			count=0;
//		}
//	}
//	if(max<0)
//		return false;
//	oe=new int[max+1];
//	for(int i=1;i<=max;i++){
//		if(i==1)
//			oe[i]=2;
//		else if(i==2||i==3)
//			oe[i]=1;
//		else if(i==4)
//			oe[i]=3;
//		else
//			oe[i]=ove(i);
//	}
//	int count3=0;
//	int sum=0;
//	for(int each:list){
//		if(oe[each]==3)
//			count3++;
//		else
//			sum+=oe[each];
//	}
//	if(count3==0){
//		return sum%2==1;
//	}
//	else
//		return count3%2==1;
//}
//public int ove(int n){
//	int left=n-2;
//	boolean odd=false;
//	boolean even=false;
//	for(int i=0;i<=n/2;i++){
//		if(oe[i]==3||oe[left-i]==3){
//			if((oe[i]+oe[left-i])==6)
//				odd=true;
//			else
//				even=true; 
//		}
//		else if((oe[i]+oe[left-i])%2==0){
//			odd=true;
//		}
//		else if((oe[i]+oe[left-i])%2==1){
//			even=true;
//		}
//	}
//	if(odd&&even)
//		return 3;
//	else if(odd)
//		return 1;
//	else
//		return 2;
//}