package leedcode;

public class num65 {
    public boolean isNumber(String s) {
    	char[] arr=s.toCharArray();
    	boolean dot=false;
    	boolean sign=false;
    	boolean e=false;
//    	boolean zero=false;
    	boolean num=false;
    	for(int i=0;i<arr.length;i++){
    		switch(arr[i]){
	    		case '.':{
//	    			if(zero){
//	    				zero=false;
//	    				num=true;
//	    			}
	    			if(dot)
	    				return false;
	    			sign=true;
	    			dot=true;
	    			break;
	    		}
	    		case'-':;
	    		case'+':{
	    			if(sign||num)//||zero
	    				return false;
	    			sign=true;
	    			break;
	    		}
//	    		case'0':{
//	    			if(num==false)
//	    				zero=true;
//	    			sign=true;
//	    			break;
//	    		}
	    		case'e':{
	    			if(!num||e)
	    				return false;
	    			num=false;
	    			dot=true;
	    			sign=false;
	    			e=true;
	    			break;
	    		}
	    		case' ':{
	    			if(sign){
	    				for(int j=i+1;j<arr.length;j++){
	    					if(arr[j]!=' ')
	    						return false;
	    				}
	    			}
	    			else{
	    				int j=i+1;
	    				for(;j<arr.length;j++){
	    					if(arr[j]!=' ')
	    						break;
	    				}
	    				if(j==arr.length)
	    					return false;
	    				else
	    					i=j-1;
	    			}
	    			break;
	    		}
	    		default:{
	    			if(arr[i]>='0'&&arr[i]<='9'){
//	    				if(zero)
//	    					return false;
	    				sign=true;
	    				num=true;
	    			}
	    			else
	    				return false;
	    		}
    		}	
    	}
    	if(num==false){
    		return false;
    	}
        return true;
    }

	public static void main(String[] args) {
		num65 sol=new num65();
		System.out.println(sol.isNumber(" 005047e+6"));
	}

}
