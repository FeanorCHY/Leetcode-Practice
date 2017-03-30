package leedcode;

public class num186 {
    public void reverseWords(char[] s) {
    	int last=0;
        for(int i=0;i<s.length;i++){
        	if(s[i]==' '||i==s.length-1){
        		
        		int begin=last;
        		int end=i-1;
        		if(i==s.length-1)
        			end=i;
        		last=i+1;
        		while(begin<end)
        		{
        			char tem=s[begin];
        			s[begin]=s[end];
        			s[end]=tem;
        			begin++;
        			end--;
        		}
        	}
        }

		int begin=0;
		int end=s.length-1;
		while(begin<end)
		{
			char tem=s[begin];
			s[begin]=s[end];
			s[end]=tem;
			begin++;
			end--;
		}
    }
	public static void main(String[] args) {
		String test="I am a handson man";
		num186 sol=new num186();
		sol.reverseWords(test.toCharArray());
		System.out.println(new String(test));
	}

}
