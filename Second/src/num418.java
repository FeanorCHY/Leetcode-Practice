
public class num418 {
    //Binary Search O(rows*logN) Space O(N)
    //what if the word length is longer than the cols? what if sentence is an empty array
    // public int wordsTyping(String[] sentence, int rows, int cols) {
    //     if(sentence==null||cols==0||sentence.length==0)
    //         return 0;
    //     int n=sentence.length;
    //     int[] acd=new int[n];
    //     acd[0]=sentence[0].length();
    //     for(int i=1;i<n;i++){
    //         acd[i]=acd[i-1]+sentence[i].length();
    //     }
    //     int idx=0;
    //     int res=0,total=acd[n-1]+n;
    //     while(rows>0){
    //         int rest=cols;
    //         if(idx>0){
    //             int tem=Bsearch(acd,idx,rest);
    //             if(tem>idx)
    //                 rest=rest-(acd[tem-1]-(idx==0?0:acd[idx-1])+tem-idx);
    //             idx=tem;
    //             if(idx==n){
    //                 idx=0;
    //                 res++;
    //             }
    //             if(rest<0)
    //                 rest=0;
    //         }
    //         if(idx==0){
    //             int greed=(rest+1)/total;
    //             rest=rest-greed*total;
    //             res+=greed; 
    //             if(rest>0)
    //                 idx=Bsearch(acd,idx,rest);
    //         }
    //         rows--;
    //     }
    //     return res;
    // }
    // private int Bsearch(int[] acd,int left,int rest){
    //     int r=acd.length-1;
    //     int l=left,offset=(left==0?0:acd[left-1]);
    //     if(acd[left]-offset>rest)
    //         return left;
    //     while(l<=r){
    //         int mid=(l+r)/2;
    //         int ocp=acd[mid]-offset+mid-left;
    //         if(ocp==rest)
    //             return mid+1;
    //         else if(ocp>rest)
    //             r=mid-1;
    //         else
    //             l=mid+1;
    //     }
    //     return l;
    // }
    
    
    
    //loopping Time: O(rows*max(k)+N)
    // public int wordsTyping(String[] sentence, int rows, int cols) {
    //     if(sentence==null||cols==0||sentence.length==0)
    //         return 0;
    //     int n=sentence.length;
    //     StringBuilder sb=new StringBuilder();
    //     for(String str:sentence)
    //         sb.append(str).append(" ");
    //     char[] arr=sb.toString().toCharArray();
    //     int len=arr.length;
    //     int start=0;
    //     for(int i=0;i<rows;i++){
    //         start+=cols;
    //         if(arr[start%len]==' ')
    //             start++;
    //         else
    //             while(arr[(start-1+len)%len]!=' ')
    //                 start--;
    //     }
    //     return start/len;
    // }
    
    
    //cashing Time O(N*w+rows)
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if(sentence==null||cols==0||sentence.length==0)
            return 0;
        int n=sentence.length;
        int[] next=new int[n];
        int[] gain=new int[n];
        for(int i=0;i<n;i++){
            int cur=i;
            int count=0;
            int len=0;
            while(len+sentence[cur].length()<=cols){
                len+=sentence[cur].length()+1;
                cur++;
                if(cur==n){
                    count++;
                    cur=0;
                }
            }
            gain[i]=count;
            next[i]=cur;
        }
        int res=0;
        int idx=0;
        for(int i=0;i<rows;i++){
            res+=gain[idx];
            idx=next[idx];
        }
        return res;
    }
	public static void main(String[] args) {
		String[] test=
			{"hello","world"};
//			{"a","bcd","e"};
		num418 sol=new num418();
		System.out.println(sol.wordsTyping(test, 2, 8));
	}

}
