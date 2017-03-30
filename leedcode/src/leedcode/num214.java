package leedcode;

import java.util.Stack;

public class num214 {
	public String shortestPalindrome(String s) {
		String str=s+"#"+new StringBuilder(s).reverse().toString();
		char[] arr=str.toCharArray();
		int k=0;
		int next[]=new int[arr.length];
		for(int i=1;i<arr.length;i++){
			if(arr[i]==arr[k]){
				k++;
			}
			else{
				while(k>0&&arr[k]!=arr[i]){
					k=next[k-1];
				}
				if(arr[i]==arr[k]){
					k++;
				}
			}
			next[i]=k;
		}
		return new StringBuilder(s.substring(k)).reverse()+s;
    }  
	public static void main(String[] args) {
		String test="aaaaaab";
		num214 sol=new num214();
		System.out.println(sol.shortestPalindrome(test));
				
	}

}





//public String shortestPalindrome(String s) {
//	char[] arr=s.toCharArray();
//	int left=0;
//	int right=arr.length-1;
//	StringBuilder sb=new StringBuilder();
//	if(s.length()<=1)
//		return s;
//	char ch=arr[0];
//	while(left<right){
//		if(arr[left]==arr[right]){
//			sb.append(arr[left]);
//    		if(ch!='1'){
//    			if(ch!=arr[left]){
//    				ch='1';
//    			}
//    		}
//			left++;
//			right--;
//		}
//		else{
//			sb.append(arr[right]);
//			if(ch=='1'||ch!=arr[right])
//				left=0;
//    		if(ch!='1'){
//    			if(ch!=arr[left]){
//    				ch='1';
//    			}
//    		}
//			right--;
//		}
//	}
//    return right==left?(sb.toString()+arr[left]+sb.reverse().toString()):(sb.toString()+sb.reverse().toString());
//}

////KMP算法  
//public int[] getTable(String s)  
//{  
//    int len=s.length();  
//    int[] table=new int[len];  
//    char[] a=s.toCharArray();  
//    //i是从1开始  
//    for(int i=1,k=0;i<len;i++)  
//    {  
//        while(k>0&&a[i]!=a[k])  
//        {  
//            k=table[k-1];  
//        }  
//        if(a[i]==a[k])  
//            k++;  
//        table[i]=k;  
//    }  
//	String test="abaa#aaba";
//    return table;  
//}