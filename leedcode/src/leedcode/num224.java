package leedcode;

import java.util.Stack;

public class num224 {
    public int calculate(String s) {
    	char[] arr=s.toCharArray();
    	int num=0;
    	int sum=0;
    	int pos=1;
    	int sign=1;
    	Stack<Integer> st=new Stack<Integer>();
    	for(int i=0;i<arr.length;i++){
    		if(arr[i]==' ')
    			continue;
    		else if(arr[i]>='0'&&arr[i]<='9'){
    			num=num*10+sign*pos*(arr[i]-'0');
    		}
    		else if(arr[i]=='+'){
    			sum+=num;
    			num=0;
    			sign=1;
    		}
    		else if(arr[i]=='-'){
    			sum+=num;
    			num=0;
    			sign=-1;
    		}
    		else if(arr[i]=='('){
    			sum+=num;
    			num=0;
    			st.add(pos);
    			pos=sign*pos;
    			sign=1;
    		}
    		else if(arr[i]==')'){
    			sum+=num;
    			num=0;
    			if(!st.isEmpty())
    				pos=st.pop();
    		}
    		
    	}

		sum+=num;
        return sum;
    }
	public static void main(String[] args) {
		num224 sol=new num224();
		System.out.println(sol.calculate("1-(5)"));
	}

}
