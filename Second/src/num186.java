
public class num186 {

    //O(N);
    public void reverseWords(char[] s) {
        if(s==null||s.length==0)
            return;
        reverse(s,0,s.length-1);
        int left=0;
        while(left<s.length){
            int right=left+1;
            while(right<s.length&&s[right]!=' ')
                right++;
            reverse(s,left,right-1);
            left=right+1;
        }
    }
    private void reverse(char[] arr,int l,int r){
        while(l<r){
            char tem=arr[l];
            arr[l]=arr[r];
            arr[r]=tem;
            r--;
            l++;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
