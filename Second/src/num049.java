import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class num049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z
    
        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(String str:strs){
            char[] arr=str.toCharArray();
            int key=1;
            for(char c:arr){
                key*=prime[c-'a'];
            }
            if(map.containsKey(key)){
                res.get(map.get(key)).add(str);
            }
            else{
                List<String> list=new ArrayList<String>();
                list.add(str);
                res.add(list);
                map.put(key,res.size()-1);
            }
        }
        return res;
    }
    //will the length of string over Integer limit
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     List<List<String>> res=new ArrayList<List<String>>();
    //     HashMap<String,List<String>> map=new HashMap<String,List<String>>();
    //     for(String str:strs){
    //         String par=parse(str);
    //         // char[] arr=str.toCharArray();
    //         // Arrays.sort(arr);
    //         // String par=new String(arr);
    //         if(map.containsKey(par)){
    //             map.get(par).add(str);
    //         }
    //         else{
    //             List<String> list=new ArrayList<String>();
    //             list.add(str);
    //             map.put(par,list);
    //         }
    //     }
    //     System.out.println(map.keySet());
    //     return new ArrayList<List<String>>(map.values());
    // }
    // private String parse(String str){
    //     StringBuilder res=new StringBuilder();
    //     char[] arr=str.toCharArray();
    //     int[] alp=new int[26];
    //     for(char each:arr){
    //         alp[each-'a']++;
    //     }
    //     for(int i=0;i<26;i++){
    //         if(alp[i]>0){
    //             res.append(alp[i]+""+(char)(i+'a'));
    //         }
    //     }
    //     return res.toString();
    // }

	public static void main(String[] args) {
		HashMap map;
		System.out.println(2+""+(char)(3+'a'));
		
		String par=new String();
	}

}
