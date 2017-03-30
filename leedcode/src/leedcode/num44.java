package leedcode;

public class num44 {
    public boolean isMatch(String s, String p) {
    	char[] arr1=s.toCharArray();
    	char[] arr2=p.toCharArray();
    	int ss=-1;
    	int sp=-1;
    	int inx1=0;
    	int inx2=0;
    	for(;inx1<arr1.length;){
    		if(inx2==arr2.length){
    			if(inx1==arr1.length)
    				return true;
    			if(sp==-1)
    				return false;
    			else{
    				inx1=++ss;
    				inx2=sp;
    			}
    			continue;
    		}
    		if(arr1[inx1]==arr2[inx2]||arr2[inx2]=='?'){
    			inx1++;
    			inx2++;
    			continue;
    		}
    		else if(arr2[inx2]=='*'){
    			ss=inx1;
    			while(inx2<arr2.length&&arr2[inx2]=='*'){
    				inx2++;
    			}
    			sp=inx2;
    		}
    		else{
    			if(sp==-1)
    				return false;
    			else{
    				inx1=++ss;
    				inx2=sp;
    			}
    			
    		}
    	}
    	if(inx1!=arr1.length)
    		return false;
    	while(inx2<arr2.length){
    		if(arr2[inx2++]!='*')
    			return false;
    	}
    	
        return true;
    }
    public boolean tryMarch(String s,String p){
    	return false;
    }
	public static void main(String[] args) {
		num44 sol=new num44();
		System.out.println(sol.isMatch("aa","*"));
	}

}
