import java.util.ArrayList;
import java.util.HashMap;
//what does '-' mean
//code one by one /
//public class Codec535 {

//   HashMap<String,Integer> map=new HashMap<String,Integer>();
//   ArrayList<String> list=new ArrayList<String>();
//   public Codec535(){
//       map.put("http:/",0);
//       map.put("https:/",1);
//       map.put("",2);
//       map.put("ftp:/",3);
//       list.add("http:/");
//       list.add("https:/");
//       list.add("");
//       list.add("ftp:/");
//   }
//   // Encodes a URL to a shortened URL.
//   public String encode(String longUrl) {
//       StringBuilder key=new StringBuilder();
//       StringBuilder post=new StringBuilder();
//       int i=0;
//       while(longUrl.charAt(i)!='/')
//           i++;
//       post.append(map.get(longUrl.substring(0,i+1))).append('#');
//       longUrl=longUrl.substring(i+2);
//       char[] arr=longUrl.toCharArray();
//       int idx=0;
//       while(idx<arr.length){
//           int r=idx;
//           while(r<arr.length&&arr[r]!='/')
//               r++;
//           String str=longUrl.substring(idx,r++);
//           if(r<arr.length){
//               if(!map.containsKey(str)){
//                   map.put(str,list.size());
//                   list.add(str);
//               }
//               post.append(map.get(str)).append('#');
//           }
//           else{
//               key.append("http://").append(str).append(".com/").append(post.toString());
//               if(r==arr.length)
//                   key.append(2).append('#');
//           }
//           idx=r;
//       }
//       return key.toString();
//   }

//   // Decodes a shortened URL to its original URL.
//   public String decode(String shortUrl) {
//       StringBuilder res=new StringBuilder();
//       shortUrl=shortUrl.substring(7);
//       char[] arr=shortUrl.toCharArray();
//       int idx=0;
//       while(idx<arr.length&&arr[idx]!='/')
//           idx++;
//       if(idx==arr.length)
//           return shortUrl;
//       int l=idx+1;
//       while(l<arr.length){
//           int num=0;
//           while(arr[l]!='#'){
//               num=num*10+arr[l]-'0';
//               l++;
//           }
//           if(num==2){
//               arr[idx-4]='/';
//               shortUrl=new String(arr);
//           	idx++;
//           }
//           else
//           	res.append(list.get(num)).append('/');
//           l++;
//       }
//       res.append(shortUrl.substring(0,idx-4));
//       return res.toString();
//   }
//}


public class Codec535 {

  HashMap<String,String> map=new HashMap<String,String>();
  char[] arr;
  String key="0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
  int n;
  public Codec535(){
      arr=key.toCharArray();
      n=arr.length;
  }
  int idx=1; 
  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
      StringBuilder sb=new StringBuilder();
      int cur=idx;
      while(cur>0){
          sb.append(arr[cur%n]);
          cur/=n;
      }
      map.put(sb.toString(),longUrl);
      return "http://tinyurl.com/"+sb.toString();
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
      return map.get(shortUrl.substring(19));
  }
}



//Your Codec object will be instantiated and called as such:
//Codec codec = new Codec();
//codec.decode(codec.encode(url));