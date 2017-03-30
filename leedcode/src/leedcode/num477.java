package leedcode;

class HMnode{
	HMnode[] child=new HMnode[2];
	int num=0;
	public HMnode(){
		child[0]=null;
		child[1]=null;
	}
}
public class num477 {
	int len;
	HMnode root=new HMnode();
	private void addHMnode(int num){
		HMnode node=root;
		for(int i=len-1;i>=0;i++){
			int cur=(num>>i)&1;
			if(node.child[cur]!=null){
				node=node.child[cur];
			}
			else{
				node.child[cur]=new HMnode();
				node=node.child[cur];
			}
		}
	}
//	int or=0;
//	for(int num:nums){
//		or=or|num;
//	}
//	len=Integer.toBinaryString(or).length();
//	
    public int totalHammingDistance(int[] nums) {
    	int[][] bit=new int[2][32];
    	int sum=0;
    	for(int i=0;i<nums.length;i++){
    		for(int j=31;j>=0;j--){
    			int cur=(nums[i]>>j)&1;
    			sum+=bit[1-cur][j];
    			bit[cur][j]++;
    		}
    	}
    	
    	return sum;
    }
	public static void main(String[] args) {
		int[] test={4, 14, 2};
		num477 sol=new num477();
		System.out.println(sol.totalHammingDistance(test));
	}

}
