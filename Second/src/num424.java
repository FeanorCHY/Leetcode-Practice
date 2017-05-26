
public class num424 {
//  //sliding window Time O(N)
//  public int characterReplacement(String s, int k) {
//      if(s==null)
//          return 0;
//      if(s.length()<=1||k>=s.length())
//          return s.length();
//      boolean has[]=new boolean[26];
//      char[] arr=s.toCharArray();
//      for(char c:arr){
//          has[c-'A']=true;
//      }
//      int max=0;
//      for(int i=0;i<26;i++){
//          if(!has[i])
//              continue;
//          char c=(char)('A'+i);
//          int cur=0,left=0,len=0;
//          for(int j=0;j<arr.length;j++){
//              if(arr[j]==c){
//                  len++;
//              }
//              else{
//                  if(k==0){
//                      len=0;
//                  }
//                  else if(cur==k){
//                      while(arr[left]==c){
//                      	left++;
//                          len--;
//                      }
//                      left++;
//                  }
//                  else{
//                      len++;
//                      cur++;
//                  }
//              }
////                if(max==11)
////                	System.out.println(c);
//              max=Math.max(max,len);   
//          }
//      }
//      return max;
//  }


 //optimized sliding window
 public int characterReplacement(String s, int k) {
     if(s==null)
         return 0;
     if(s.length()<=1||k>=s.length())
         return s.length();
     int res=0;
     char[] arr=s.toCharArray();
     int[] count=new int[26];
     int max=0,left=0;
     for(int i=0;i<arr.length;i++){
         max=Math.max(max,++count[arr[i]-'A']);
         if(i-left+1-max>k)
             count[arr[left++]-'A']--;
         res=Math.max(i-left+1,res);
     }
     return res;
 }
	public static void main(String[] args) {
		num424 sol=new num424();
//		System.out.println(sol.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
		System.out.println(sol.characterReplacement("BABBBABCAAAAA", 2));
	}

}
