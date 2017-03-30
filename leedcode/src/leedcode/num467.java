package leedcode;

public class num467 {
    public int findSubstringInWraproundString(String p) {
    	char[] arr=p.toCharArray();
    	int[] alp=new int[26];
    	if(arr.length==0)
    		return 0;
    	int rep=1;
    	alp[arr[0]-'a']=1;
    	for(int i=1;i<arr.length;i++){
    		if(arr[i]==arr[i-1]+1||(arr[i]=='a'&&arr[i-1]=='z'))
    			rep++;
    		else{
    			rep=1;
    		}
			alp[arr[i]-'a']=Math.max(alp[arr[i]-'a'], rep);
    	}
    	int res=0;
    	for(int i=0;i<26;i++){
    		res+=alp[i];
    	}
        return res;
    }
	public static void main(String[] args) {
		num467 sol=new num467();
		System.out.println(sol.findSubstringInWraproundString("zaba"));
	}

}
