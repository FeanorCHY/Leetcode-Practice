import java.util.ArrayList;
import java.util.List;

public class num320 {
    //recursive O(2^N)
    // public List<String> generateAbbreviations(String word) {
    //     List<String> res=new LinkedList<String>();
    //     if(word==null)
    //         return res;
    //     res.add(word);
    //     if(word.length()==0)
    //         return res;
    //     int len=word.length();
    //     for(int i=1;i<=len;i++){
    //         for(int j=0;j<=len-i;j++){
    //             // System.out.println(j+i);
    //             // System.out.println("len : "+len);
    //             String prefix=word.substring(0,j)+i+(j+i<word.length()?word.substring(j+i,j+i+1):"");
    //             if(j+1+i>=len){
    //                 res.add(prefix);
    //                 continue;
    //             }
    //             List<String> rest=generateAbbreviations(word.substring(j+1+i));
    //             for(String str:rest){
    //                 res.add(prefix+str);
    //             }
    //         }
    //     }
    //     return res;
    // }
    
    
    
    
    //recursive O(2^N) with HashMap
    // HashMap<String,List<String>> map=new HashMap<String,List<String>>();
    // public List<String> generateAbbreviations(String word) {
    //     List<String> res=new LinkedList<String>();
    //     if(word==null)
    //         return res;
    //     if(map.containsKey(word))
    //         return map.get(word);
    //     res.add(word);
    //     if(word.length()==0)
    //         return res;
    //     int len=word.length();
    //     for(int i=1;i<=len;i++){
    //         for(int j=0;j<=len-i;j++){
    //             // System.out.println(j+i);
    //             // System.out.println("len : "+len);
    //             String prefix=word.substring(0,j)+i+(j+i<word.length()?word.substring(j+i,j+i+1):"");
    //             if(j+1+i>=len){
    //                 res.add(prefix);
    //                 continue;
    //             }
    //             List<String> rest=generateAbbreviations(word.substring(j+1+i));
    //             for(String str:rest){
    //                 res.add(prefix+str);
    //             }
    //         }
    //     }
    //     map.put(word,res);
    //     return res;
    // }
    
    
    //backtracking
    // char[] arr;
    // List<String> res = new LinkedList<String>();
    // public List<String> generateAbbreviations(String word) {
    //     if(word==null)
    //         return res;
    //     arr=word.toCharArray();
    //     search(0,new StringBuilder(),0);
    //     return res;
    // }
    // private void search(int pos,StringBuilder cur,int num){
    //     int len=cur.length();
    //     if(pos==arr.length){
    //         if(num>0)
    //             cur.append(num);
    //         res.add(cur.toString());
    //     }
    //     else{
    //         search(pos+1,cur,num+1);
    //         if(num>0)
    //             cur.append(num);
    //         cur.append(arr[pos]);
    //         search(pos+1,cur,0);
            
    //     }
    //     cur.setLength(len);
    // }
    
    
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        for (int x = 0; x < (1 << word.length()); ++x) // loop through all possible x
            ans.add(abbr(word, x));
        return ans;
    }

    // build the abbreviation for word from number x
    private String abbr(String word, int x) {
        StringBuilder builder = new StringBuilder();
        int k = 0, n = word.length(); // k is the count of consecutive ones in x
        for (int i = 0; i < n; ++i, x >>= 1) {
            if ((x & 1) == 0) { // bit is zero, we keep word.charAt(i)
                if (k != 0) { // we have abbreviated k characters
                    builder.append(k);
                    k = 0; // reset the counter k
                }
                builder.append(word.charAt(i));
            }
            else // bit is one, increase k
                ++k;
        }
        if (k != 0) builder.append(k); //don't forget to append the last k if non zero
        return builder.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
