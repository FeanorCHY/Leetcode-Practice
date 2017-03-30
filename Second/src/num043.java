import java.util.Arrays;
import java.util.HashMap;

public class num043 {
    // public String multiply(String num1, String num2) {
    //     int n1 = num1.length(), n2 = num2.length();
    //     int[] products = new int[n1 + n2];
    //     for (int i = n1 - 1; i >= 0; i--) {
    //         for (int j = n2 - 1; j >= 0; j--) {
    //             int d1 = num1.charAt(i) - '0';
    //             int d2 = num2.charAt(j) - '0';
    //             products[i + j + 1] += d1 * d2;
    //         }
    //     }
    //     int carry = 0;
    //     for (int i = products.length - 1; i >= 0; i--) {
    //         int tmp = (products[i] + carry) % 10;
    //         carry = (products[i] + carry) / 10;
    //         products[i] = tmp;
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     for (int num : products) sb.append(num);
    //     while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
    //     return sb.length() == 0 ? "0" : sb.toString();
    // }
    //add with staggering
    //O(MN+M+N)
    public String multiply(String num1, String num2) {
        if(num1==null||num2==null||num1.length()==0||num2.length()==0)
            return "0";
        if(num1.equals("0")||num2.equals("0"))
            return "0";
        char[] arr1=num1.toCharArray();
        char[] arr2=num2.toCharArray();
        int m=arr1.length;
        int n=arr2.length;
        int[] p=new int[m+n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                p[i + j +1] += (arr1[i]-'0')*(arr2[j]-'0');
            }
        }
        // int carry = 0;
        // for (int i = p.length - 1; i >= 0; i--) {
        //     int tmp = (p[i] + carry) % 10;
        //     carry = (p[i] + carry) / 10;
        //     p[i] = tmp;
        // }
        // StringBuilder sb = new StringBuilder();
        // for(int i=p.length-1;i>=0;i--){
        // 	if(i==0&&p[i]==0)
        // 		break;
        //     sb.append((char)(p[i]+'0'));
        // }
        // return sb.length() == 0 ? "0" : sb.reverse().toString();
        StringBuilder res = new StringBuilder();
        int plus=0;
        for(int i=p.length-1;i>=1;i--){
            int sum=plus+p[i];
            plus=sum/10;
            sum=sum%10;
            res.append((char)(sum+'0'));
        }
        if(plus>0)
            res.append((char)(plus+'0'));
        return res.reverse().toString();
    }
    
    
    
    
    //add with staggering with optimization
    //O(MN)
    // public String multiply(String num1, String num2) {
    //     if(num1==null||num2==null||num1.length()==0||num2.length()==0)
    //         return "0";
    //     if(num1.equals("0")||num2.equals("0"))
    //         return "0";
    //     char[] arr1=num1.toCharArray();
    //     char[] arr2=num2.toCharArray();
    //     int m=arr1.length;
    //     int n=arr2.length;
    //     int[] p=new int[m+n];
    //     for(int i=m-1;i>=0;i--){
    //         for(int j=n-1;j>=0;j--){
    //             int p2=i+j+1;
    //             int p1=p2-1;
    //             int sum=p[p2]+(arr1[i]-'0')*(arr2[j]-'0');
    //             p[p2]=sum%10;
    //             p[p1]+=sum/10;
    //         }
    //     }
    //     // System.out.println(Arrays.toString(p));
    //     StringBuilder res=new StringBuilder();
    //     for(int pp : p) if(!(res.length() == 0 && pp == 0)) res.append(pp);
    //     return res.reverse().reverse().toString();
    // }
    
    
    
    
    //add with scan with hashtable
    //O(MN)
    // public String multiply(String num1, String num2) {
    //     if(num1==null||num2==null||num1.length()==0||num2.length()==0)
    //         return "0";
    //     if(num1.equals("0")||num2.equals("0"))
    //         return "0";
    //     StringBuilder res=new StringBuilder();
    //     HashMap<Integer,String> map=new HashMap<Integer,String>();
    //     map.put(1,new StringBuilder(num2).reverse().toString());
    //     char[] arr1=num1.toCharArray();
    //     char[] arr2=num2.toCharArray();
    //     for(int i=arr1.length-1;i>=0;i--){
    //         if(arr1[i]=='0'){
    //             res.append("0");//attention zero inside
    //             continue;
    //         }
    //         String pro=map.get(arr1[i]-'0');
    //         int pos=arr1.length-1-i;
    //         int mul=arr1[i]-'0';
    //         if(pro==null){
    //             StringBuilder sb=new StringBuilder();
    //             int plus=0;
    //             for(int j=arr2.length-1;j>=0;j--){
    //                 int sum=plus+(arr2[j]-'0')*mul;
    //                 plus=sum/10;
    //                 sum=sum%10;
    //                 sb.append((char)(sum+'0'));
    //             }
    //             if(plus>0)
    //                 sb.append((char)(plus+'0'));
    //             pro=sb.toString();
    //             map.put(mul,pro);
    //         }
    //         char[] arr=pro.toCharArray(); 
    //         StringBuilder tem=new StringBuilder();
    //         int plus=0;
    //         for(int j=0;j<arr.length;j++){
    //             if(j+pos>=res.length()){
    //                 res.append('0');
    //             }
    //             int sum=plus+arr[j]-'0'+((j+pos)<res.length()?res.charAt(pos+j)-'0':0);
    //             plus=sum/10;
    //             sum=sum%10;
    //             res.setCharAt(pos+j, (char)(sum+'0'));
    //         }
    //         if(plus>0){
    //             if(pos+arr.length>=res.length()){
    //                 res.append('0');
    //             }
    //             res.setCharAt(pos+arr.length, (char)(plus+'0'));
    //         }
    //     }
    //     return res.reverse().toString();
    // }
	public static void main(String[] args) {
		num043 sol=new num043();
//		StringBuilder res=new StringBuilder("123124");
		System.out.println(sol.multiply("1", "1"));
	}

}
