package leedcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class XORTrie {
	XORTrie[] sub;
    public XORTrie() {
    	sub = new XORTrie[2];
    }
}
public class num421 {
	public int findMaximumXOR(int[] nums) {
        int max = 0;
        XORTrie root=new XORTrie();
        for(int num:nums){
        	XORTrie node=root;
	        for(int i=31;i>=0;i--){
	        	int cur=(num>>i)&1;
	        	if(node.sub[cur]==null)
	        		node.sub[cur]=new XORTrie();
	        	node=node.sub[cur];
	        }
        }
        for(int num:nums){
        	XORTrie node=root;
        	int sum=0;
	        for(int i=31;i>=0;i--){
	        	int cur=(num>>i)&1;
	        	if(node.sub[cur^1]!=null){
	        		sum+=1<<i;
	        		node=node.sub[cur^1];
	        	}
	        	else{
	        		node=node.sub[cur];
	        	}
	        	
	        }
	        max=Math.max(max, sum);
        }
        
        return max;
    }
	public static void main(String[] args) {
		int test[]={3, 10, 5, 25, 2, 8};
		num421 sol=new num421();
		System.out.println(sol.findMaximumXOR(test));
	}

}


//for(int i = 31; i >= 0; i--){
//    mask = mask | (1 << i);
//    Set<Integer> set = new HashSet<>();
//    for(int num : nums){
//        set.add(num & mask);
//    }
//    int tmp = max | (1 << i);
//    System.out.println(Integer.toBinaryString(tmp));
//    for(int prefix : set){
//        if(set.contains(tmp ^ prefix)) {
//            max = tmp;
//            break;
//        }
//    }
//}






//class NumTrie{
//	char c;
//	NumTrie zero;
//	NumTrie one;
////	List<Integer> list=new ArrayList<Integer>();
//	public NumTrie(char c){
//		this.c=c;
//		this.zero=null;
//		this.one=null;
//	}
//}
//public int search(NumTrie root,int num){
//	int count=0;
//	char arr[]=new StringBuilder(Integer.toBinaryString(num)).reverse().toString().toCharArray();
//	NumTrie node=root;
//	int bit=1;
//	for(int i=0;i<arr.length;i++){
//		if(arr[i]=='1'&&node.zero!=null){
//			count=count+bit;
//			node=node.zero;
//		}
//		else if(arr[i]=='0'&&node.one!=null){
//			count=count+bit;
//			node=node.one;
//		}
//		else{
//			if(node.zero!=null)
//				node=node.zero;
//			else if(node.one!=null)
//				node=node.one;
//			else{
//				count+=(bit&num)^0;
//				break;
//			}
//		}
//		bit=bit<<1;
//	}
//	return count;
//}
//public void addNumTrie(NumTrie root,int num){
//	char arr[]=new StringBuilder(Integer.toBinaryString(num)).reverse().toString().toCharArray();
//	NumTrie node=root;
//	for(int i=0;i<arr.length;i++){
////		node.list.add(num);
//		if(arr[i]=='1'){
//			if(node.one==null){
//				node.one=new NumTrie(arr[i]);
//			}
//			node=node.one;
//		}
//		else{
//			if(node.zero==null)
//				node.zero=new NumTrie(arr[i]);
//			node=node.zero;
//		}
//	}
//}
//NumTrie root=new NumTrie('\0');
//public int findMaximumXOR(int[] nums) {
//	int max=0;
//	for(int num:nums)
//		addNumTrie(root,num);
//	for(int num:nums)
//		max=Math.max(max,search(root,num));
//	
//	return max;
//}