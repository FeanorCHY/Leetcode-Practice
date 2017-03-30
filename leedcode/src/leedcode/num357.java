package leedcode;

public class num357 {

    public int countNumbersWithUniqueDigits(int n) {
    	if(n<=0)
    		return 0;
    	int all=10;
    	for(int i=2;i<=n;i++){
    		int count=9;
    		for(int j=2;j<=i;j++){
    			count*=(11-j);
    		}
    		all+=count;
    	}
        return all;
    }
	public static void main(String[] args) {
		num357 sol=new num357();
		System.out.println(sol.countNumbersWithUniqueDigits(3));
	}

}

//if(i>2){
//	rep[i]=(rep[i-1]+1)*9+9;
//	rep[i]-=zero;
//}
//rep[i]+=unique*(i-1);
//zero=zero*9;
//unique=total[i]-rep[i];