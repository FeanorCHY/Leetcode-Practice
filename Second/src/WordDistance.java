import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//hashmap to store distance. good for search
// public class WordDistance {
//     HashMap<String,HashMap<String,Integer>> map=new HashMap<String,HashMap<String,Integer>>();
//      //O(k*N^2)
//     public WordDistance(String[] words) {
//         if(words==null)
//             return;
//         for(int i=0;i<words.length;i++){
//             if(!map.containsKey(words[i])){
//                 map.put(words[i],new HashMap<String,Integer>());
//             }
//             HashMap<String,Integer> cur=map.get(words[i]);
//             for(int j=i+1;j<words.length;j++){
//                 if(!map.containsKey(words[j]))
//                     map.put(words[j],new HashMap<String,Integer>());
//                 if(!cur.containsKey(words[j])||cur.get(words[j])>Math.abs(i-j)){
//                     cur.put(words[j],Math.abs(i-j));
//                     map.get(words[j]).put(words[i],Math.abs(i-j));
//                 }
//             }
//         }
//     }
        //O(1)
//     public int shortest(String word1, String word2) {
//         // String str=word1.compareTo(word2)>0?word2+"_"+word1:word1+"_"+word2;
//         return map.get(word1).get(word2);
//     }
// }



//hash map to store position. good for initiate. worst when all one word[a a a a a a a a a b b b b b b b  b b]
public class WordDistance {
    //O(kN)
    HashMap<String,List<Integer>> map=new HashMap<String,List<Integer>>();
    public WordDistance(String[] words) {
        if(words==null)
            return;
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])){
                map.put(words[i],new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }
    //O(m^2)
    // public int shortest(String word1, String word2) {
    //     int res=Integer.MAX_VALUE;
    //     for(int each1:map.get(word1)){
    //         for(int each2:map.get(word2)){
    //             res=Math.min(res,Math.abs(each1-each2));
    //         }
    //     }
    //     return res;
    // }
    
    
    //optimized O(m)
    public int shortest(String word1, String word2) {
        int res=Integer.MAX_VALUE;
        List<Integer> list1=map.get(word1);
        List<Integer> list2=map.get(word2);
        for(int i=0,j=0;i<list1.size()&&j<list2.size();){
            res=Math.min(res,Math.abs(list1.get(i)-list2.get(j)));
            if(list1.get(i)>list2.get(j))
                j++;
            else
                i++;
        }
        return res;
    }
}