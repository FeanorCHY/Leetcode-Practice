import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class num249 {
    //will there be an empty string?
    //HashMap store the list with same length O(N^2*K) K is the length of string N is the length of input
    // private List<List<String>> res=new LinkedList<List<String>>();
    // HashMap<Integer,List<List<String>>> map=new HashMap<Integer,List<List<String>>>();
    // public List<List<String>> groupStrings(String[] strings) {
    //     for(String str:strings){
    //         if(!map.containsKey(str.length())){
    //             List<List<String>> listlist=new LinkedList<List<String>>();
    //             List<String> list=new LinkedList<String>();
    //             list.add(str);
    //             listlist.add(list);
    //             map.put(str.length(),listlist);
    //             res.add(list);
    //         }
    //         else{
    //             boolean add=false;
    //             for(List<String> list:map.get(str.length())){
    //                 if(compareStr(str.toCharArray(),list.get(0).toCharArray())){
    //                     list.add(str);
    //                     add=true;
    //                     break;
    //                 }
    //             }
    //             if(!add){
    //                 List<String> list=new LinkedList<String>();
    //                 list.add(str);
    //                 map.get(str.length()).add(list);
    //                 res.add(list);
    //             }
    //         }
    //     }
    //     return res;
    // }
    // private boolean compareStr(char[] arr1,char[] arr2){
    //     if(arr1.length==0)
    //         return true;
    //     int dif=(arr1[0]-arr2[0]+26)%26;
    //     for(int i=1;i<arr1.length;i++){
    //         if((arr1[i]-arr2[i]+26)%26!=dif){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    
    
    //HashMap normalize each string O(N*K)
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res=new ArrayList<List<String>>(strings.length);
        HashMap<String,List<String>> map=new HashMap<String,List<String>>();
        for(String str:strings){
            char[] arr=str.toCharArray();
            if(arr.length==0){
                List<String> list=new ArrayList<String>(strings.length);
                list.add(str);
                res.add(list);
                continue;
            }
            char dif=(char)(arr[0]-'a');
            StringBuilder sb=new StringBuilder();
            for(char c:arr){
                char tem=(char)(c-dif);
                if(tem-'a'<0)
                    tem+=26;
                sb.append(tem);
            }
            if(!map.containsKey(sb.toString())){
                List<String> list=new ArrayList<String>(strings.length);
                list.add(str);
                res.add(list);
                map.put(sb.toString(),list);
            }
            else
                map.get(sb.toString()).add(str);
        }
        return res;
    }
	public static void main(String[] args) {
		System.out.println((-25)%5);
	}

}
