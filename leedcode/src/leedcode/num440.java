package leedcode;

public class num440 {
	public int findKthNumber(int n, int k) {
		long cur=1;
		k--;
		while(k>0){
			int step=search(n,cur,cur+1);
			if(k-step>=0){
				k-=step;
				cur++;
			}
			else{
				k--;
				cur*=10;
			}
		}
		return (int)cur;
	}
	private int search(int n,long s1,long s2){
		int step=0;
		while(s1<=n){
			long cur=Math.min(s2, n+1)-s1;
			step+=cur;
			s1*=10;
			s2*=10;
		}
		return step;
	}
	public static void main(String[] args) {
		num440 sol=new num440();
		System.out.println(sol.findKthNumber(13, 4));
	}

}

















//public int findKthNumber(int n, int k) {
//    int curr = 1;
//    k = k - 1;
//    while (k > 0) {
//        int steps = calSteps(n, curr, curr + 1);
//        if (steps <= k) {
//            curr += 1;
//            k -= steps;
//        } else {
//            curr *= 10;
//            k -= 1;
//        }
//    }
//    return curr;
//}
////use long in case of overflow
//public int calSteps(int n, long n1, long n2) {
//    int steps = 0;
//    while (n1 <= n) {
//        steps += Math.min(n + 1, n2) - n1;
//        n1 *= 10;
//        n2 *= 10;
//    }
//    return steps;
//}


//public int findKthNumber(int n, int k) {
//	int count=1;
//	long cur=1;
//	while(count<k){
//		if(cur*10<=n){
//			cur*=10;
//		}
//		else if(cur%10!=9&&cur+1<=n){
//			cur++;
//		}
//		else{
//			if(cur+1>n)
//				cur=cur/10;
//			while(cur%10==9){
//				cur=cur/10;
//			}
//			cur++;
//		}
////		System.out.println(cur);
//		count++;
//	}
//    return (int)cur;
//}