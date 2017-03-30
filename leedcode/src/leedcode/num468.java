package leedcode;

public class num468 {
    public String validIPAddress(String IP) {
    	char[] arr=IP.toCharArray();
    	if(arr.length<=1)
    		return "Neither";
    	if(IP.contains(".")){
    		if(arr[0]=='.')
    			return "Neither";
    		int num=0;
    		int count=0;
    		for(int i=0;i<arr.length;i++){
    			if(arr[i]>='0'&&arr[i]<='9'){
    				if(arr[i]=='0'&&num==0){
    					if(i+1<arr.length&&arr[i+1]!='.')
    						return "Neither";
    				}
    				num=num*10+arr[i]-'0';
    				if(num>255)
    					return "Neither";
    					
    			}
    			else if(arr[i]=='.'){
    				if(i==arr.length-1||num>255||arr[i+1]=='.'||count>=3)
    					return "Neither";
    				num=0;
    				count++;
    			}
    			else 
    				return "Neither";
    		}
			if(count!=3)
				return "Neither";
			return "IPv4";
    	}
    	else{
    		if(arr[0]==':')
    			return "Neither";
    		int num=0;
    		int count=0;
    		for(int i=0;i<arr.length;i++){
    			if((arr[i]>='0'&&arr[i]<='9')||(arr[i]>='a'&&arr[i]<='f')||(arr[i]>='A'&&arr[i]<='F')){
    				num++;
    			}
    			else if(arr[i]==':'){
    				if(num==0||num>4||i==arr.length-1||arr[i+1]==':')
    					return "Neither";
    				num=0;
    				count++;
    			}
    			else
    				return "Neither";
    		}
    		if(count!=7||num==0||num>4)
    			return "Neither";
			return "IPv6";
    	}
    }

	public static void main(String[] args) {
		num468 sol=new num468();
		System.out.println(sol.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
	}

}
