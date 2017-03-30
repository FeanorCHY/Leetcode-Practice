package leedcode;

public class num132 {
//	int min;
	boolean[][] valid;
    public int minCut(String s) {
    	char[] arr=s.toCharArray();
    	valid=new boolean[arr.length][arr.length];
    	for(int i=0;i<arr.length;i++){
    		valid[0][i]=true;
    	}
    	int min[]=new int[arr.length];
    	for(int i=1;i<arr.length;i++){
    		min[i]=i;
    		for(int j=i;j>=0;j--){
				if(j==0||((j==1||valid[j-2][i-1])&&arr[i]==arr[i-j])){
					if(i-j-1==-1){
						min[i]=0;
					}
					else
						min[i]=Math.min(min[i], 1+min[i-j-1]);
					valid[j][i]=true;
				}
    		}
    	}
    	
        return min[arr.length-1];
    }
	public static void main(String[] args) {
		num132 sol=new num132();
		System.out.println(sol.minCut("aaabaa"));
	}
//    public int best(int index){
//    	if(valid[index][index])
//    		return 0;
//    	int m=index;
//    	for(int i=index;i>=0;i--){
//    		if(valid[i][index]){
//    			m=Math.min(m,1+ best(index-i-1));
//    		}
//    	}
//    	
//    	
//    	return m;
//    }

}
