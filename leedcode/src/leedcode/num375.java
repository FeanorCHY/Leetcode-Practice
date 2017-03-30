package leedcode;

public class num375 {
    public int getMoneyAmount(int n) {

        int[][] money = new int[n+1][n+1];//全部为0
        for(int i=n-1;i>=1;i--){
        	for(int j=i+1;j<=n;j++){
        		int min=Integer.MAX_VALUE;
        		for(int k=i;k<=j;k++){
        			int tem=k;
        			if(k-1>i&&k+1<j)
        				tem=k+Math.max(money[i][k-1],money[k+1][j]);
        			else if(k-1>i)
        				tem=k+money[i][k-1];
        			else if(k+1<j)
        				tem=k+money[k+1][j];
        			min=Math.min(min, tem);
        		}
        		money[i][j]=min;
        	}
        }
        return money[1][n];
//    	return move(1,n);
    	
    }
    public int move(int low,int high){
    	if(low>=high)
    		return 0;
    	else if(high==low+1)
    		return low;
    	else if(high==low+2)
    		return (high+low)/2;
    	else{
    		int lowest=Integer.MAX_VALUE;
    		for(int i=low;i<=high;i++){
    			lowest=Math.min(lowest,i+Math.max(move(low,i-1),move(i+1,high)));
    		}
    		return lowest;
    	}
    	
    		
    }
	public static void main(String[] args) {
		num375 sol=new num375();
		System.out.println(sol.getMoneyAmount(7));
	}

}
