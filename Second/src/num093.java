import java.util.LinkedList;
import java.util.List;

public class num093 {

    //what to do with the leading zero? 
    //recursive O(3^4)
    List<String> res=new LinkedList<String>();
    char[] arr;
    public List<String> restoreIpAddresses(String s) {
        if(s==null||s.length()<4||s.length()>12)
            return res;
        arr=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        search(0,4,sb);
        return res;
    }
    private void search(int idx,int rem,StringBuilder sb){
        if(rem==0){
            res.add(sb.toString());
            return;
        }
        int size=sb.length();
        int len=arr.length;
        int end=Math.min(idx+3,len);
        if(arr[idx]=='0')
            end=idx+1;
        int num=0;
        for(int i=idx;i<end;i++){
            num=num*10+arr[i]-'0';
            if(num>255||(rem-1)>len-1-i)
                break;
            if((rem-1)*3<len-1-i)
                continue;
            if(sb.length()>0){
                sb.append(".");
            }
            sb.append(num);
            search(i+1,rem-1,sb);
            sb.setLength(size);
        }
    }
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
		sb.append(1);
	}

}
