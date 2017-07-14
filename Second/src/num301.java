import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num301 {
	//  public List<String> removeInvalidParentheses(String s) {
	//  int left=0;
	//  if(s==null)
	//      return new ArrayList<String>();
	//  char[] arr=s.toCharArray();
	//  StringBuilder sb=new StringBuilder();
	//  HashSet<String> res=new HashSet<String>();
	//  int idx=0;
	//  while(idx<arr.length&&arr[idx]!='('){
	//      if(arr[idx]!=')')
	//          sb.append(arr[idx]);
	//      idx++;
	//  }
	 
	//  int end=arr.length-1;
	//  StringBuilder sb2=new StringBuilder();
	//  while(end>=idx&&arr[end]!=')'){
	//      if(arr[end]!='(')
	//          sb2.append(arr[end]);
	//      end--;
	//  }
	//  s=sb.toString()+s.substring(idx,end+1)+sb2.reverse().toString();
	//  arr=s.toCharArray();
	//  if(idx>=end){
	//      res.add(s);
	//      return new ArrayList<String>(res);
	//  }
	//  idx=sb.length();
	//  res.add(sb.toString());
	//  sb=new StringBuilder();
	//  while(idx<arr.length){
	//      if(arr[idx]=='('){
	//          left++;
	//          sb.append(arr[idx]);
	//      }
	//      else if(arr[idx]==')'){
	//          left--;
	//          if(left==0){
	//              sb.append(arr[idx]);
	//              HashSet<String> tem=new HashSet<String>();
	//              for(String str:res){
	//                  tem.add(str+sb.toString());
	//              }
	//              res=tem;
	//              sb=new StringBuilder();
	//          }
	//          else if(left<0){
	//              left=0;
	//              HashSet<String> tem=new HashSet<String>();
	//              for(String str:res){
	//                  tem.add(str+sb.toString());
	//              }
	//              for(String str:res){
	//                  char[] arrt=str.toCharArray();
	//                  for(int i=1;i<arrt.length;i++){
	//                      if(arrt[i]==')'&&arrt[i-1]!=')')
	//                          tem.add(str.substring(0,i)+str.substring(i+1)+sb.toString()+")");
	//                  }
	//              }
	//              res=tem;
	//              sb=new StringBuilder();
	//          }
	//          else
	//              sb.append(arr[idx]);
	//      }
	//      else
	//          sb.append(arr[idx]);
	//      idx++;
	//  }
	//  if(arr.length>=left){
	//      HashSet<String> tem=new HashSet<String>();
	//      tem.add(sb.toString());
	//      for(int i=0;i<left;i++){
	//          HashSet<String> tem2=new HashSet<String>();
	//          for(String str:tem){
	//              arr=str.toCharArray();
	//              for(int j=0;j<arr.length;j++){
	//                  if(arr[j]=='('&&(j==0||arr[j-1]!='(')){
	//                      String insert=str.substring(0,j)+str.substring(j+1);
	//                      if(isValid(insert))
	//                          tem2.add(insert);
	//                  }
	//              }
	//          }
	//          tem=tem2;
	//      }
	//      List<String> list=new ArrayList<String>();
	//      for(String str1:res){
	//          for(String str2:tem)
	//              list.add(str1+str2);
	//      }
	//      if(list.size()==0)
	//      	list.add("");
	//      return list;
	//  }
	//  return new ArrayList<String>(res);
	//}
	//private boolean isValid(String str){
	//  char[] arr=str.toCharArray();
	//  int left=0;
	//  for(char c:arr){
	//      if(c=='(')
	//          left++;
	//      else if(c==')'){
	//          left--;
	//          if(left==-1)
	//              return false;
	//      }
	//  }
	//  return true;
	//}
	
	//bfs
	// public List<String> removeInvalidParentheses(String s) {
	//     if(s==null)
	//         return new ArrayList<String>();
	//     List<String> res=new ArrayList<String>();
	//     HashSet<String> visit=new HashSet<String>();
	//     Queue<String> q=new LinkedList<String>();
	//     q.add(s);
	//     visit.add(s);
	//     while(!q.isEmpty()){
	//         String str=q.poll();
	//         if(isValid(str)){
	//             res.add(str);
	//         }
	//         if(res.size()>0)
	//             continue;
	//         char[] arr=str.toCharArray();
	//         for(int i=0;i<arr.length;i++){
	//             // System.out.println(i+"when "+str);
	//             if((arr[i]!='('&&arr[i]!=')')||(i>0&&arr[i]==arr[i-1]))
	//                 continue;
	//             String tem=str.substring(0,i)+(i==arr.length-1?"":str.substring(i+1));
	//             if(!visit.contains(tem)){
	//                 visit.add(tem);
	//                 q.add(tem);
	//             }
	//         }
	//     }
	//     return res;
	// }
	// private boolean isValid(String str){
	//     char[] arr=str.toCharArray();
	//     int left=0;
	//     for(char c:arr){
	//         if(c=='(')
	//             left++;
	//         else if(c==')'){
	//             left--;
	//             if(left==-1)
	//                 return false;
	//         }
	//     }
	//     return left==0;
	// }
	
	public List<String> removeInvalidParentheses(String s) {
		 if(s==null)
		     return new ArrayList<String>();
		 List<String> res=new ArrayList<String>();
		 search(0,0,s,res,new char[]{'(',')'});
		 return res;
		}
		private void search(int si,int sj,String s,List<String> res,char[] par){
		 char[] arr=s.toCharArray();
		 int left=0;
		 for(int i=si;i<arr.length;i++){
		     if(arr[i]==par[0])
		         left++;
		     else if(arr[i]==par[1])
		         left--;
		     if(left<0){
		         for(int j=sj;j<=i;j++){
		             if(arr[j]==par[1]&&(j==sj||arr[j-1]!=par[1])){
		                 search(i,j,s.substring(0,j)+s.substring(j+1,arr.length),res,par);
		             }
		         }
		         return;
		     }
		 }
		 if(par[0]=='('){
		     search(0,0,new StringBuilder(s).reverse().toString(),res,new char[]{')','('});
		 }
		 else
		     res.add(new StringBuilder(s).reverse().toString());
	}
	public static void main(String[] args) {
		String test="()())()";
		num301 sol=new num301();
		System.out.println(sol.removeInvalidParentheses(test));
	}

}
