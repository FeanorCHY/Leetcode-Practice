package leedcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

public class num115 {
	public int numDistinct(String s, String t) {
		char[] arrs=s.toCharArray();
		char[] arrt=t.toCharArray();
		if(arrs.length==0||arrt.length==0)
			return 0;
		int[][] dp=new int[arrs.length][arrt.length];
		dp[0][0]=arrs[0]==arrt[0]?1:0;
		for(int i=1;i<arrs.length;i++){
			dp[i][0]=dp[i-1][0]+(arrs[i]==arrt[0]?1:0);
		}
		for(int i=1;i<arrs.length;i++){
			for(int j=1;j<arrt.length;j++){
				dp[i][j]=dp[i-1][j]+(arrs[i]==arrt[j]?dp[i-1][j-1]:0);
			}
		}
	    return dp[dp.length-1][dp[0].length-1];
	}
	
	
	public int com(int i,int j){
		if(i==j)
			return 1;
		if(i<j)
			return 0;
		int pro=1;
		for(int x=i;x>i-j;x--){
			pro*=x;
		}
		for(int x=2;x<=j;x++){
			pro/=x;
		}
		return pro;
	}

	public static void main(String[] args) {
		num115 sol=new num115();
//		System.out.println(sol.com(2, 3));
		System.out.println(sol.numDistinct("aaabbaaaabbbaaaaba", "abba"));
	}
	public int numDistinct3(String s, String t) {
		char[] arrs=s.toCharArray();
		char[] arrt=t.toCharArray();
		if(arrs.length==0||arrt.length==0)
			return 0;
		List<Character> listsc=new ArrayList<Character>();
		List<Integer> listsi=new ArrayList<Integer>();
		List<Character> listtc=new ArrayList<Character>();
		List<Integer> listti=new ArrayList<Integer>();
		char c=arrs[0];
		int count=1;
		for(int i=1;i<arrs.length;i++){
			if(arrs[i]!=arrs[i-1]){
				listsi.add(count);
				listsc.add(c);
				c=arrs[i];
				count=1;
			}
			else
				count++;
		}
		listsi.add(count);
		listsc.add(c);
		c=arrt[0];
		count=1;
		for(int i=1;i<arrt.length;i++){
			if(arrt[i]!=arrt[i-1]){
				listti.add(count);
				listtc.add(c);
				c=arrt[i];
				count=1;
			}
			else
				count++;
		}
		listti.add(count);
		listtc.add(c);
		int[] sum=new int[listsc.size()+1];
		for(int i=0;i<listtc.size();i++){
			char tc=listtc.get(i);
			int ti=listti.get(i);
			for(int j=1;j<=listsc.size();j++){
				sum[j]=(tc==listsc.get(j-1)?com(listsi.get(j-1),ti):0)*(i==0?1:sum[j])+sum[j-1];//(i==0?0:sum[i-1]);
			}
		}
		
		
		return sum[sum.length-1];
	}
	public int numDistinct2(String s, String t) {
		char[] arrs=s.toCharArray();
		char[] arrt=t.toCharArray();
		int count=0;
		Stack<Integer> st=new Stack<Integer>();
		for(int i=0;i<arrs.length;i++){
			if(arrt[st.size()]==arrs[i]){
				st.push(i);
			}
			if(st.size()==arrt.length||i==arrs.length-1){
				if(st.size()==arrt.length)
					count++;
				if(st.isEmpty())
					return count;
				i=st.pop();
				if(i==arrs.length-1){
	    			if(st.isEmpty())
	    				return count;
					i=st.pop();
				}
			}
		}
		
	    return count;
	}
}
