package leedcode;

public class num165 {
    public int compareVersion(String version1, String version2) {
    	char[] arr1=version1.toCharArray();
    	char[] arr2=version2.toCharArray();
    	int idx1=0;
    	int idx2=0;
    	while(idx1<arr1.length&&idx2<arr2.length){
    		int num1=0;
    		int num2=0;
    		while(idx1<arr1.length&&arr1[idx1]!='.'){
    			num1=num1*10+arr1[idx1++]-'0';
    		}
    		while(idx2<arr2.length&&arr2[idx2]!='.'){
    			num2=num2*10+arr2[idx2++]-'0';
    		}
    		if(num1<num2)
    			return -1;
    		else if(num1>num2)
    			return 1;
    		else{
    			idx1++;
    			idx2++;
    		}
    			
    	}
    	if(idx1>=arr1.length&&idx2>=arr2.length){
    		return 0;
    	}
    	else if(idx1>=arr1.length){
    		while(idx2<arr2.length){
    			if(arr2[idx2]!='.'&&arr2[idx2]!='0')
    				return -1;
    			idx2++;
    		}
    		return 0;
    	}
    	else{
    		while(idx1<arr1.length){
    			if(arr1[idx1]!='.'&&arr1[idx1]!='0')
    				return 1;
    			idx1++;
    		}
    		return 0;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
