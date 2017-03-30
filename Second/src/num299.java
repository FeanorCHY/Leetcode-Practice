
public class num299 {
    //0A0B?
    // public String getHint(String secret, String guess) {
    //     int bull=0,cow=0;
    //     char[] sarr=secret.toCharArray();
    //     char[] garr=guess.toCharArray();
    //     int[] g=new int[10];
    //     int[] s=new int[10];
    //     for(int i=0;i<sarr.length;i++){
    //         if(sarr[i]==garr[i])
    //             bull++;
    //         else{
    //             g[garr[i]-'0']++;
    //             s[sarr[i]-'0']++;
    //         }
    //     }
    //     for(int i=0;i<10;i++)
    //         cow+=Math.min(g[i],s[i]);
    //     return bull+"A"+cow+"B";
    // }
    
    
    //concise one
    public String getHint(String secret, String guess) {
        int bull=0,cow=0;
        char[] sarr=secret.toCharArray();
        char[] garr=guess.toCharArray();
        int[] g=new int[10];
        for(int i=0;i<sarr.length;i++){
            if(sarr[i]==garr[i])
                bull++;
            else{
                if((g[garr[i]-'0']++<0))
                    cow++;
                if(g[sarr[i]-'0']-->0)
                    cow++;
            }
        }
        return bull+"A"+cow+"B";
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
