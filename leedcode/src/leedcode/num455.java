package leedcode;

import java.util.Arrays;

public class num455 {
    public int findContentChildren(int[] g, int[] s) {
    	Arrays.sort(g);
    	Arrays.sort(s);
    	int idx1=0;
    	int idx2=0;
    	int count=0;
    	while(idx1<g.length&&idx2<s.length){
    		if(g[idx1]>s[idx2])
    			idx2++;
    		else{
    			count++;
    			idx1++;
    			idx2++;
    		}
    	}
    	
    	
        return count;
    }
	public static void main(String[] args) {
		num455 sol=new num455();
		System.out.println(sol.findContentChildren(new int[]{1,2,3,4}, new int[]{1,2,3,4}));
	}

}
