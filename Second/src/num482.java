
public class num482 {

    //O(N)
    // public String licenseKeyFormatting(String S, int K) {
    //     if(S==null)
    //         return "";
    //     K=Math.max(K,0);
    //     char[] arr=S.toCharArray();
    //     int idx=0;
    //     for(char c:arr){
    //         if(c!='-'){
    //             if(c>='a'&&c<='z')
    //                 c-='a'-'A';
    //             arr[idx++]=c;
    //         }
    //     }
    //     if(K==0)
    //         return S.substring(0,idx);
    //     StringBuilder res=new StringBuilder();
    //     for(int i=0;i<idx%K;i++){
    //         res.append(arr[i]);
    //     }
    //     if(res.length()>0&&idx>K)
    //         res.append('-');
    //     int count=0;
    //     for(int i=idx%K;i<idx;i++){
    //         if(count==K){
    //             count=0;
    //             res.append('-');
    //         }
    //         res.append(arr[i]);
    //         count++;
    //     }
    //     return res.toString();
    // }
    
    
    //concise answear
    public String licenseKeyFormatting(String S, int K) {
        if(S==null)
            return "";
        K=Math.max(K,0);
        char[] arr=S.toCharArray();
        StringBuilder res=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]!='-'){
                if(res.length()%(K+1)==K)
                    res.append('-');
                res.append(arr[i]);
            }
        }
        return res.reverse().toString().toUpperCase();
    }
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
	}

}
