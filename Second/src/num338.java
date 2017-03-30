
public class num338 {

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
          ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }
  // public int[] countBits(int num) {
  //     int[] res=new int[num+1];
  //     if(num==0)
  //         return res;
  //     int cur=1;
  //     int idx=0;
  //     int i=1;
  //     while(cur<=num){
  //         while(idx<cur&&i<=num){
  //             res[i++]=res[idx++]+1;
  //         }
  //         if(i>num)
  //             break;
  //         cur=cur<<1;
  //         idx=0;
  //     }
  //     return res;
  // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
