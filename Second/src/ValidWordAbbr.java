import java.util.HashMap;
import java.util.HashSet;
//what for word of length 1
//public class ValidWordAbbr {

//  //MapMapSet Time:(nk)
//  HashMap<Integer,HashMap<Integer,HashSet<String>>> map=new HashMap<Integer,HashMap<Integer,HashSet<String>>>();
//  public ValidWordAbbr(String[] dictionary) {
//      for(String str:dictionary){
//          if(!map.containsKey(str.length()))
//              map.put(str.length(),new HashMap<Integer,HashSet<String>>());
//          HashMap<Integer,HashSet<String>> sub=map.get(str.length());
//          int num=0;
//          if(str.length()>=1)
//              num+=str.charAt(0);
//          if(str.length()>=2)
//              num=(num<<10)+str.charAt(str.length()-1);
//          if(!sub.containsKey(num))
//              sub.put(num,new HashSet<String>());
//          sub.get(num).add(str);
//      }
//  }
//  //Time:(k)
//  public boolean isUnique(String word) {
//      if(!map.containsKey(word.length()))
//          return true;
//      HashMap<Integer,HashSet<String>> sub=map.get(word.length());
//      int num=0;
//      if(word.length()>=1)
//          num+=word.charAt(0);
//      if(word.length()>=2)
//          num=(num<<10)+word.charAt(word.length()-1);
//      if(!sub.containsKey(num))
//          return true;
//      if(sub.get(num).size()>1)
//          return false;
//      if(sub.get(num).contains(word))
//          return true;
//      return false;
//  }
//}



//smart one
public class ValidWordAbbr {
 //abb Map Time:(nk)
 HashMap<String,String> map=new HashMap<String,String>();
 public ValidWordAbbr(String[] dictionary) {
     for(String str:dictionary){
         String abb=abbr(str);
         if(!map.containsKey(abb))
             map.put(abb,str);
         else{
             if(!map.get(abb).equals(str))
                 map.put(abb,"");
         }
             
     }
 }
 private String abbr(String str){
     if(str.length()<=2)
         return str;
     else
         return str.charAt(0)+Integer.toString(str.length()-2)+str.charAt(str.length()-1);
 }
 //Time:(k)
 public boolean isUnique(String word) {
     String abb=abbr(word);
     return !map.containsKey(abb)||map.get(abb).equals(word);
 }
}

/**
* Your ValidWordAbbr object will be instantiated and called as such:
* ValidWordAbbr obj = new ValidWordAbbr(dictionary);
* boolean param_1 = obj.isUnique(word);
*/