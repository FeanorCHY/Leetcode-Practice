
public class num161 {

    // public boolean isOneEditDistance(String s, String t) {
    //     if(s==null&&t==null)
    //         return false;
    //     if((s==null||t==null)&&(s.length()==1||t.length()==1))
    //         return false;
    //     char[] arrs=s.toCharArray();
    //     char[] arrt=t.toCharArray();
    //     if(Math.abs(arrs.length-arrt.length)>1)
    //         return false;
    //     int idx1=0,idx2=0;
    //     boolean fault=false;
    //     boolean get=false;
    //     while(idx1<arrs.length&&idx2<arrt.length){
    //         if(arrs[idx1]==arrt[idx2]){
    //             idx1++;
    //             idx2++;
    //         }
    //         else{
    //             get=true;
    //             if(idx1==idx2){
    //                 if(arrt.length>arrs.length)
    //                     idx2++;
    //                 else if(arrt.length<arrs.length)
    //                     idx1++;
    //                 else{
    //                     if(fault)
    //                         return false;
    //                     idx1++;
    //                     idx2++;
    //                     fault=true;
    //                 }
    //             }
    //             else
    //                 return false;
    //         }
    //     }
    //     return get||Math.abs(arrs.length-arrt.length)==1;
    // }
    
    
    //concise one
    public boolean isOneEditDistance(String s, String t) {
        if(s==null&&t==null)
            return false;
        if((s==null||t==null)&&(s.length()==1||t.length()==1))
            return false;
        if(Math.abs(s.length()-t.length())>1)
            return false;
        for(int i=0;i<Math.min(s.length(),t.length());i++){
            if(s.charAt(i)!=t.charAt(i)){
                if(s.length()==t.length())
                    return s.substring(i+1).equals(t.substring(i+1));
                else if(s.length()>t.length())
                    return s.substring(i+1).equals(t.substring(i));
                else
                    return s.substring(i).equals(t.substring(i+1));
            }
        }
        return Math.abs(s.length()-t.length())==1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
