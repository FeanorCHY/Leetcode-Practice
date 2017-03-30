import java.util.LinkedList;
import java.util.List;

public class Codec271 {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder res=new StringBuilder();
        for(String str:strs){
            if(str==null)
                res.append("/");
            else{
                res.append(str.length()).append('/').append(str);
            }
        }
        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res=new LinkedList<String>();
        char[] arr=s.toCharArray();
        int idx=0;
        while(idx<arr.length){
            if(arr[idx]=='/'){
                idx++;
                res.add(null);
            }
            else{
                int num=0;
                while(arr[idx]!='/')
                    num=num*10+arr[idx++]-'0';
                idx++;
                // StringBuilder sb=new StringBuilder(num);
                // for(int i=0;i<num;i++)
                //     sb.append(arr[idx++]);
                res.add(s.substring(idx,idx+num));
                idx+=num;
            }
        }
        return res;
    }
}
