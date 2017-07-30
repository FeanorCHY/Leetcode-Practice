
public class num340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null||k<=0)
            return 0;
        char[] arr=s.toCharArray();
        int[] alp=new int[256];
        int left=0,res=0,count=0;
        for(int i=0;i<arr.length;i++){
            alp[arr[i]]++;
            if(alp[arr[i]]==1){
                count++;   
            }
            while(count>k){
                alp[arr[left]]--;
                if(alp[arr[left++]]==0)
                    count--;
            }
            res=Math.max(res,i-left+1);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
