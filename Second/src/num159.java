
public class num159 {

    //sliding window Time O(n) Space O(1)
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s==null||s.length()<=2)
            return s.length();
        char[] arr=s.toCharArray();
        int[] alp=new int[256];
        int count=0,left=0,res=0;
        for(int i=0;i<arr.length;i++){
            if(alp[arr[i]]==0){
                count++;
                while(count>2){
                    if(--alp[arr[left++]]==0)
                        count--;
                }
            }
            alp[arr[i]]++;
            res=Math.max(res,i-left+1);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
