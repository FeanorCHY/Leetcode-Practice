package leedcode;

public class num125 {
    public boolean isPalindrome(String s) {
    	if(s.length()==0)
    		return true;
    	if(s==null)
    		return false;
    	char[] arr=s.toCharArray();
    	int l=0;
    	int r=arr.length-1;
    	while(l<arr.length){
    		if(!((arr[l]>='0'&&arr[l]<='9')||(arr[l]>='a'&&arr[l]<='z')||(arr[l]>='A'&&arr[l]<='Z')))
    			l++;
    		else
    			break;
    	}
    	while(r>=0){
    		if(!((arr[r]>='0'&&arr[r]<='9')||(arr[r]>='a'&&arr[r]<='z')||(arr[r]>='A'&&arr[r]<='Z')))
    			r--;
    		else
    			break;
    	}
    	while(l<r){
    		if(arr[l]>='a'&&arr[l]<='z')
    			arr[l]-='a'-'A';
    		if(arr[r]>='a'&&arr[r]<='z')
    			arr[r]-='a'-'A';
    		if(arr[l++]!=arr[r--])
    			return false;
        	while(l<arr.length){
        		if(!((arr[l]>='0'&&arr[l]<='9')||(arr[l]>='a'&&arr[l]<='z')||(arr[l]>='A'&&arr[l]<='Z')))
        			l++;
        		else
        			break;
        	}
        	while(r>=0){
        		if(!((arr[r]>='0'&&arr[r]<='9')||(arr[r]>='a'&&arr[r]<='z')||(arr[r]>='A'&&arr[r]<='Z')))
        			r--;
        		else
        			break;
        	}
    		
    	}
    	return true;
    }
	public static void main(String[] args) {
		num125 sol=new num125();
//		System.out.println((int)'A');
		System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
	}

}
