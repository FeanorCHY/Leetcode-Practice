package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num282 {
	List<String> res=new ArrayList<String>();
	int target;
	char[] arr;
    public List<String> addOperators(String num, int target) {
    	this.target=target;
    	arr=num.toCharArray();
    	if(arr.length==0)
    		return res;
        traverse("",0,0,0);
    	return res;
    }
    public void traverse(String str,int pos,long sum,long multi){
    	if(pos==arr.length){
    		if(sum==target)
    			res.add(str);
    		return;
    	}
    	long val=0;
    	for(int i=pos;i<arr.length;i++){
    		if(arr[pos]=='0'&&i!=pos)
    			break;
    		val=val*10+arr[i]-'0';
    		if(pos==0){
    			traverse(str+val,i+1,sum+val,val);
    		}
    		else{
	    		traverse(str+"+"+val,i+1,sum+val,val);
	    		traverse(str+"-"+val,i+1,sum-val,-val);
	    		traverse(str+"*"+val,i+1,sum-multi+multi*val,multi*val);
    		}
    	}
    	
    }
	public static void main(String[] args) {
		num282 sol=new num282();
		System.out.println(sol.addOperators("105", 5));
	}

}




//public List<String> addOperators(String num, int target) {
//    List<String> rst = new ArrayList<String>();
//    if(num == null || num.length() == 0) return rst;
//    helper(rst, "", num, target, 0, 0, 0);
//    return rst;
//}
//public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
//    if(pos == num.length()){
//        if(target == eval)
//            rst.add(path);
//        return;
//    }
//    for(int i = pos; i < num.length(); i++){
//        if(i != pos && num.charAt(pos) == '0') break;
//        long cur = Long.parseLong(num.substring(pos, i + 1));
//        if(pos == 0){
//            helper(rst, path + cur, num, target, i + 1, cur, cur);
//        }
//        else{
//            helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
//            
//            helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
//            
//            helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
//        }
//    }
//}