import java.util.HashSet;

public class num291 {
    //what the hell.. p(a)==p(b) only if a==b
    
//  public boolean wordPatternMatch(String p, String s) {
//      if(p==null||s==null)
//          return false;
//      char[] arrp=p.toCharArray();
//      char[] arrs=s.toCharArray();
//      StringBuilder[] sbs=new StringBuilder[26];
//      HashSet<String> visit=new HashSet<String>();
//      return search(sbs,arrp,arrs,0,0,visit);
//  }
//  private boolean search(StringBuilder[] sbs,char[] arrp,char[] arrs,int idx1,int idx2,HashSet<String> visit){
//      // if(sbs[arrp[idx1]-'a']==null)
//      //     sbs[arrp[idx1]-'a']=new StringBuilder();
//      if(idx1==arrp.length){
//          return idx2==arrs.length;
//      }
//      StringBuilder sb=sbs[arrp[idx1]-'a'];
//      if(sb==null){
//          sb=new StringBuilder();
//          sbs[arrp[idx1]-'a']=sb;
//          for(int i=idx2;i<arrs.length;i++){
//              sb.append(arrs[i]);
//              if(visit.contains(sb.toString()))
//                  continue;
//              visit.add(sb.toString());
//              if(search(sbs,arrp,arrs,idx1+1,i+1,visit)){
//                  return true;
//              }
//              visit.remove(sb.toString());
//          }
//          sbs[arrp[idx1]-'a']=null;
//      }
//      else if(isMatch(sb.toString().toCharArray(),arrs,idx2)){
//          return search(sbs,arrp,arrs,idx1+1,idx2+sb.length(),visit);
//      }
//      return false;
          
//  }
//  private boolean isMatch(char[] arrp,char[] arrs,int idx){
//      if(arrp.length+idx-1>=arrs.length)
//          return false;
//      for(int i=0;i<arrp.length;i++){
//          if(arrs[idx+i]!=arrp[i])
//              return false;
//      }
//      return true;
//  }
 
 
 //slightly advanced backtracking Time O(?)
 public boolean wordPatternMatch(String p, String s) {
     if(p==null||s==null)
         return false;
     char[] arrp=p.toCharArray();
     char[] arrs=s.toCharArray();
     StringBuilder[] sbs=new StringBuilder[26];
     HashSet<String> visit=new HashSet<String>();
     return search(sbs,arrp,arrs,0,0,visit);
 }
 private boolean search(StringBuilder[] sbs,char[] arrp,char[] arrs,int idx1,int idx2,HashSet<String> visit){
     // if(sbs[arrp[idx1]-'a']==null)
     //     sbs[arrp[idx1]-'a']=new StringBuilder();
     if(idx1==arrp.length){
         return idx2==arrs.length;
     }
     StringBuilder sb=sbs[arrp[idx1]-'a'];
     if(sb==null){
         sb=new StringBuilder();
         sbs[arrp[idx1]-'a']=sb;
         int endPoint = arrs.length-1;
         for(int i=arrp.length-1; i>idx1; i--) {
             endPoint -= sbs[arrp[i]-'a']==null ? 1 :sbs[arrp[i]-'a'].length();
         }
         for(int i=idx2;i<=endPoint;i++){
             sb.append(arrs[i]);
             if(visit.contains(sb.toString()))
                 continue;
             visit.add(sb.toString());
             if(search(sbs,arrp,arrs,idx1+1,i+1,visit)){
                 return true;
             }
             visit.remove(sb.toString());
         }
         sbs[arrp[idx1]-'a']=null;
     }
     else if(idx2+sb.length()<=arrs.length&&isMatch(sb.toString().toCharArray(),arrs,idx2)){
         return search(sbs,arrp,arrs,idx1+1,idx2+sb.length(),visit);
     }
     return false;
          
 }
 private boolean isMatch(char[] arrp,char[] arrs,int idx){
     if(arrp.length+idx-1>=arrs.length)
         return false;
     for(int i=0;i<arrp.length;i++){
         if(arrs[idx+i]!=arrp[i])
             return false;
     }
     return true;
 }
	public static void main(String[] args) {
		num291 sol=new num291();
		System.out.println(sol.wordPatternMatch("abab", "redblueredblue"));
	}

}
