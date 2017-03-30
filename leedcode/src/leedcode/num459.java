package leedcode;

public class num459 {
    public boolean repeatedSubstringPattern(String str) {
    	int[] next=new int[str.length()];
    	char[] arr=str.toCharArray();
    	if(arr.length<=1)
    		return true;
    	int k=0;
    	for(int i=1;i<arr.length;i++){
    		if(arr[i]==arr[k])
    			k++;
    		else{
    			while(k!=0&&arr[i]!=arr[k]){
					k=next[k-1];
				}
    			if(arr[i]==arr[k])
    				k++;
    		}
    		next[i]=k;
    	}
    	
    	if(next[next.length-1]!=0&&arr.length%(arr.length-next[next.length-1])==0)
    		return true;
    	else
    		return false;
    }
	public static void main(String[] args) {
		num459 sol=new num459();
		System.out.println(sol.repeatedSubstringPattern("abac"));
	}

}
