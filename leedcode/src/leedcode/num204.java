package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num204 {
    public int countPrimes(int n) {
    	boolean[] notP=new boolean[n];
    	int count=0;
        for(int i=2;i<n;i++){
        	if(!notP[i]){
        		count++;
        		for(int j=2;i*j<n;j++){
        			notP[i*j]=true;
        		}
        	}
        }
        return count;
    }
	public static void main(String[] args) {
		num204 sol=new num204();
		System.out.println(sol.countPrimes(5));
	}

}







//List<Integer> prime=new ArrayList<Integer>();
//public int countPrimes(int n) {
//	if(n<=2)
//		return 0;
//	prime.add(2);
//	for(int i=3;i<n;i++){
//		if(isPrime(i))
//			prime.add(i);
//	}
//    return prime.size();
//}
//private boolean isPrime(int num){
//	for(int i=0;i<prime.size();i++){
//		if(prime.get(i)>Math.sqrt(num))
//			break;
//		if(num%prime.get(i)==0)
//			return false;
//	}
//	return true;
//}