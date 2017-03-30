package leedcode;

public class num434 {
    public int countSegments(String s) {
    	char[] arr=s.toCharArray();
    	boolean seg=false;
    	int count=0;
    	for(int i=0;i<arr.length;i++){
    		if(seg&&arr[i]==' '){
    			seg=false;
    			
    		}
    		else if(!seg&&arr[i]!=' '){
    			seg=true;
    			count++;
    		}
    	}
    	
        return count;
    }
	public static void main(String[] args) {
		num434 sol=new num434();
		System.out.println(sol.countSegments("Hello, my name is John"));
	}

}
