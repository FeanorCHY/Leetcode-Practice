import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class num241 {

    //do not parse first
    // public List<Integer> diffWaysToCompute(String input) {
    //     List<Integer> res = new ArrayList<Integer>();
    //     for (int i = 0; i < input.length(); i++) {
    //         char c = input.charAt(i);
    //         if (c == '-' || c == '+' || c == '*') {
    //             String a = input.substring(0, i);
    //             String b = input.substring(i + 1);
    //             List<Integer> al = diffWaysToCompute(a);
    //             List<Integer> bl = diffWaysToCompute(b);
    //             for (int x : al) {
    //                 for (int y : bl) {
    //                     if (c == '-') {
    //                         res.add(x - y);
    //                     } else if (c == '+') {
    //                         res.add(x + y);
    //                     } else if (c == '*') {
    //                         res.add(x * y);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     if (res.size() == 0) res.add(Integer.valueOf(input));
    //     return res;
    // }
    //what if invalid character?  what if unmatched operation? leading zero? leading minus ?
    //O(N^2)
    List<Character> sign=new ArrayList<Character>();
    List<Integer> nums=new ArrayList<Integer>();
    public List<Integer> diffWaysToCompute(String input) {
        // List<Integer> res=new LinkedList<Integer>();
        char[] arr=input.toCharArray();
        int num=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>='0'&&arr[i]<='9'){
                num=num*10+arr[i]-'0';
            }
            else {
                nums.add(num);
                sign.add(arr[i]);
                num=0;
            }
        }
        nums.add(num);
        return search(0,nums.size()-1);
    }
    private List<Integer> search(int start,int end){
        List<Integer> res=new LinkedList<Integer>();
        if(start==end){
            res.add(nums.get(start));
            return res;
        }
        else if(start+1==end){
            switch(sign.get(start)){
                case '+':{
                    res.add(nums.get(start)+nums.get(end));
                    break;
                }
                case '-':{
                    res.add(nums.get(start)-nums.get(end));
                    break;
                }
                case '*':{
                    res.add(nums.get(start)*nums.get(end));
                    break;
                }
            }
            return res;
        }
        
        for(int mid=start;mid<end;mid++){
            List<Integer> left=search(start,mid);
            List<Integer> right=search(mid+1,end);
            for(int l:left){
                for(int r:right){
                    switch(sign.get(mid)){
                        case '+':{
                            res.add(l+r);
                            break;
                        }
                        case '-':{
                            res.add(l-r);
                            break;
                        }
                        case '*':{
                            res.add(l*r);
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		int x=0;
		switch(x){
			case 0:{
				
			}
			case 1:{
				break;
			}
		}
	}

}
