package leedcode;

public class num161 {
    public boolean isOneEditDistance(String s, String t) {
    	if(Math.abs(s.length()-t.length())>1)
    		return false;
    	if(s.length()==0&&t.length()==0)
    		return false;
    	char[] sArr=s.toCharArray();
    	char[] tArr=t.toCharArray();
    	if(s.length()==t.length()){
    		boolean one=false;
    		for(int i=0;i<sArr.length;i++){
    			if(sArr[i]!=tArr[i]){
    				if(one==false)
    					one=true;
    				else
    					return false;
    			}
    		}
    		if(one==true)
    			return true;
    		else
    			return false;
    	}
    	else{
    		int index1=0;
    		int index2=0;
    		boolean plus=false;
    		while(index1!=sArr.length&&index2!=tArr.length){
    			if(sArr[index1]!=tArr[index2]){
    				if(plus==false){
	    				if(sArr.length<tArr.length)
	    					index2++;
	    				else
	    					index1++;
	    				plus=true;
    				}
    				else
    					return false;
    			}
    			else{
    				index1++;
    				index2++;
    			}
    				
    		}
    		if(plus==true)
    			return true;
    		else{
    			if(index2==tArr.length||index1==sArr.length)
    				return true;
        		else
        			return false;
    		}
    	}
    }
	public static void main(String[] args) {
		num161 sol=new num161();
		System.out.println(sol.isOneEditDistance("23", "123"));
		
	}

}
