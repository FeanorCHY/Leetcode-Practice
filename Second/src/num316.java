
public class num316 {

//    public String removeDuplicateLetters(String s) {
//        if(s==null||s.length()==0)
//            return "";
//        char[] arr=s.toCharArray();
//        int[] alp=new int[26];
//        int start=0;
//        boolean[] visit=new boolean[26];
//        for(char c:arr)
//            alp[c-'a']++;
//        StringBuilder res=new StringBuilder();
//        for(char c='a';c<='z';c++){
//            if(visit[c-'a']||alp[c-'a']==0)
//                continue;
//            visit[c-'a']=true;
//            StringBuilder pre=new StringBuilder();
//            for(int i=start;i<arr.length;i++){
//                if(arr[i]==c){
//                    pre.append(c);
//                    start=i+1;
//                    break;
//                }
//                else{
//                    alp[arr[i]-'a']--;
//                    if(alp[arr[i]-'a']==0&&!visit[arr[i]-'a']){
//                        StringBuilder sb=new StringBuilder();
//                        for(int k=start;k<i;k++){
//                            if(arr[k]<arr[i]&&!visit[arr[k]-'a'])
//                                sb.append(arr[k]);
//                        }
//                        for(char c1:sb.toString().toCharArray())
//                            visit[c1-'a']=true;
//                        pre.append(removeDuplicateLetters(sb.toString())).append(arr[i]);
//                        start=i+1;
//                    }
//                }
//            }
//            res.append(pre.toString());
//            
//        }
//        return res.toString();
//    }
	

    boolean[] visit=new boolean[26];
    public String removeDuplicateLetters(String s) {
        if(s==null||s.length()==0)
            return "";
        char[] arr=s.toCharArray();
        int[] alp=new int[26];
        for(char c:arr)
            alp[c-'a']++;
        int pos=-1;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            char c=arr[i];
            if(visit[c-'a'])
                continue;
            if(pos==-1)
                pos=i;
            if(arr[pos]>c)
                pos=i;
            if(--alp[c-'a']==0){
                visit[arr[pos]-'a']=true;
                res.append(arr[pos]);
                if(arr[pos]!=c)
                    res.append(removeDuplicateLetters(s.substring(pos+1,i+1)));
                else
                    return res.toString()+removeDuplicateLetters(s.substring(pos+1));
                pos=-1;
                
            }
        }
        return res.toString();
        
    }

	public static void main(String[] args) {
		num316 sol=new num316();
		String test
			="acbac";
//			="bcabc";
//			="thesqtitxyetpxloeevdeqifkz";//"hesitxyplovdqfkz"
		System.out.println(sol.removeDuplicateLetters(test));
	}
}
