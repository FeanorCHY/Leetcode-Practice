package leedcode;

import java.util.HashSet;

public class num345 {
    public String reverseVowels(String s) {
    	Character[] vow={'a','e','i','o','u','A','E','I','O','U'};
    	HashSet<Character> set=new HashSet<Character>();
    	for(char each:vow)
    		set.add(each);
    	char[] arr=s.toCharArray();
    	int l=0;
    	int r=arr.length-1;
    	StringBuilder sb=new StringBuilder();
    	while(l<r){
			if(set.contains(arr[l])&&set.contains(arr[r])){
				char tem=arr[l];
				arr[l]=arr[r];
				arr[r]=tem;
				l++;
				r--;
			}
			else{
				while(l<r&&!set.contains(arr[l])){
					l++;
				}
				while(l<r&&!set.contains(arr[r])){
					r--;
				}
			}
    	}
    	
        return String.valueOf(arr);
    }
	public static void main(String[] args) {
		num345 sol=new num345();
//		StringBuilder sb=new StringBuilder("1234");
//		sb.insert(3, "a");
//		System.out.println(sb.toString());
		System.out.println(sol.reverseVowels("leetcode"));
	}

}
