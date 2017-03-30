package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num227 {

    public int calculate(String s) {
    	int sum=0;
    	List<List<String>> listlist=divid(s);
    	for(String str:listlist.get(1)){
    		sum=sum+multi(str);
    	}
    	for(String str:listlist.get(0)){
    		sum=sum-multi(str);
    	}
        return sum;
    }
    public int multi(String s){
    	int left=0;
    	int output=0;
    	int mul=0;
    	char[] arr=s.toCharArray();
    	for(int i=0;i<arr.length;i++){
    		if(arr[i]==' '&&i!=arr.length-1)
    			continue;
    		else if(arr[i]>='0'&&arr[i]<='9'){
    			left=left*10+arr[i]-'0';
    		}
    		else if(arr[i]=='*'||arr[i]=='/'){
    			if(mul==0){
    				output=left;
    				left=0;
    			}
    			else if(mul==1){
    				output=output*left;
    				left=0;
    			}
    			else{
    				output=output/left;
    				left=0;
    			}
				if(arr[i]=='*')
					mul=1;
				else
					mul=2;
			}
    		if(i==arr.length-1){
    			if(mul==0)
    				return left;
    			else if(mul==1){
    				return output*left;
    			}
    			else
    				return output/left;
    		}
    	}
    	return left;
    }
    public List<List<String>> divid(String s){
    	List<List<String>> listlist=new ArrayList<List<String>>();
    	char[] arr=s.toCharArray();
    	List<String> plus=new ArrayList<String>();
    	List<String> minus=new ArrayList<String>();
    	int last=arr.length;
    	for(int i=arr.length-1;i>=0;i--){
    		if(arr[i]=='+'){
				plus.add(s.substring(i+1,last));
				last=i;
    		}
    		else if(arr[i]=='-'){
				minus.add(s.substring(i+1,last));
				last=i;
			}
    	}
    	plus.add(s.substring(0,last));
    	listlist.add(minus);
    	listlist.add(plus);
    	return listlist;
    }
    
	public static void main(String[] args) {
		num227 sol=new num227();
		System.out.println(sol.calculate("-12*2+54-1"));
	}

}
//
//else if(arr[i]=='+'||arr[i]=='-'){
//	if(mul==0){
//		output=left;
//	}
//	else if(mul==1){
//		output=output*left;
//	}
//	else{
//		output=output/left;
//	}
//	if(arr[i]=='+')
//		return output+calculate(s.substring(i+1)); 
//	else
//		return output-calculate(s.substring(i+1)); 
//}