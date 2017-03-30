package leedcode;

public class num344 {
    public String reverseString(String s) {
    	char[] arr=s.toCharArray();
    	int l=0;
    	int r=arr.length-1;
    	while(l<r){
    		char tem=arr[l];
    		arr[l]=arr[r];
    		arr[r]=tem;
    		l++;
    		r--;
    	}
    	
        return String.valueOf(arr);
    }
	public static void main(String[] args) {
		
	}

}
