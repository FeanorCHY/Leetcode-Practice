package leedcode;

public class num408 {
    public boolean validWordAbbreviation(String word, String abbr) {
    	char[] warr=word.toCharArray();
    	char[] arr=abbr.toCharArray();
    	int idx1=0,idx2=0;
    	while(idx2<arr.length){
    		int num=0;
    		if(idx2<arr.length&&arr[idx2]=='0'){
    			return false;
    		}
    		while(idx2<arr.length&&arr[idx2]>='0'&&arr[idx2]<='9'){
    			num=num*10+arr[idx2]-'0';
    			idx2++;
    		}
    		idx1+=num;
    		if(idx1==warr.length&&idx2==arr.length)
    			return true;
    		if(idx1>=warr.length||idx2>=arr.length||warr[idx1]!=arr[idx2])
    			return false;
    		idx1++;
    		idx2++;
    	}
    	
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
