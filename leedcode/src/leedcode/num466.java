package leedcode;

import java.util.ArrayList;
import java.util.HashMap;

public class num466 {
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		int cnt1=0,cnt2=0,i=0,j=0;
		char[] arr1=s1.toCharArray();
		char[] arr2=s2.toCharArray();
		while(cnt1<n1){
			if(arr1[i]==arr2[j]){
				j++;
				if(j==arr2.length){
					j=0;
					cnt2++;
				}
			}
			i++;
			if(i==arr1.length){
				i=0;
				cnt1++;
			}
		}
		return cnt2/n2;
    }

//    if (!ableToObtain(s1, s2)) return 0; // check if [s1. ∞] obtains s2
//    int cnt=0, k=-1;
//    String s=s1;
//    StringBuilder remainBuilder; // record `remain string`
//    ArrayList<String> stringList=new ArrayList<>(); // record all the `remain string`
//    ArrayList<Integer> countList=new ArrayList<>(); // record matching count from start to the current remain string 
//    stringList.add(""); // record empty string
//    countList.add(0);
//    for (int i=0;i<=n1;i++) {
//        remainBuilder=new StringBuilder();
//        cnt+=getRemain(s, s2, remainBuilder); // get the next remain string, returns the count of matching
//        String remain=remainBuilder.toString();
//        if ((k=stringList.indexOf(remain))!=-1) break; // if there is a loop, break
//        stringList.add(remain); // record the remain string into arraylist 
//        countList.add(cnt);
//        s=remain+s1; // append s1 to make a new string
//    }
//    // here, k is the beginning of the loop
//    if (k==-1) return cnt/n2; // if there is no loop
//    int countOfLoop=cnt-countList.get(k), loopLength=stringList.size()-k; // get matching count in the loop, and loop length
//    cnt=countList.get(k);
//    n1-=k;
//    cnt+=countOfLoop*(n1/loopLength);
//    n1%=loopLength; 
//    cnt+=countList.get(k+n1)-countList.get(k);
//    return cnt/n2;
    // check if [s1. ∞] obtains s2
    private boolean ableToObtain(String s1, String s2) {
        boolean[] cnt=new boolean[26];
        for (char c: s1.toCharArray()) cnt[c-'a']=true;
        for (char c: s2.toCharArray()) {
            if (!cnt[c-'a']) return false;
        }
        return true;
    }

    // get remain string after s1 obtains s2, return the matching count
    private int getRemain(String s1, String s2, StringBuilder remain) {
        int cnt=0, lastMatch=-1, p2=0;
        for (int p1=0;p1<s1.length();p1++) {
            if (s1.charAt(p1)==s2.charAt(p2)) {
                if (++p2==s2.length()) {
                    p2=0;
                    cnt++;
                    lastMatch=p1;
                }
            }
        }
        remain.append(s1.substring(lastMatch+1));
        return cnt;
    }
	public static void main(String[] args) {
		num466 sol=new num466();
		System.out.println(sol.getMaxRepetitions("ababc", 4, "ab", 1));
	}

}





//public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
//	char[] arr1=s1.toCharArray();
//	char[] arr2=s2.toCharArray();
//	HashMap<Character,ArrayList<Integer>> map=new HashMap<Character,ArrayList<Integer>>();
//	for(int i=0;i<arr1.length;i++){
//		if(map.containsKey(arr1[i])){
//			map.get(arr1[i]).add(i);
//		}
//		else{
//			ArrayList<Integer> tem=new ArrayList<Integer>();
//			tem.add(i);
//			map.put(arr1[i], tem);
//		}
//	}
//	int last=-1;
//	int count=0;
//	for(int i=0;i<arr2.length;i++){
//		ArrayList<Integer> list=map.get(arr2[i]);
//		if(list==null)
//			return 0;
//		boolean add=false;;
//		for(int each:list){
//			if(each>last){
//				last=each;
//				add=true;
//				break;
//			}
//		}
//		if(!add){
//			last=list.get(0);
//			count++;
//		}
//	}
//	if(count==0)
//		return n1/n2;
//	return (n1-1)/(count*n2);
//}
//public int getMaxRepetitions1(String s1, int n1, String s2, int n2) {
//    char[] array1 = s1.toCharArray(), array2 = s2.toCharArray();
//    int count1 = 0, count2 = 0, i = 0, j = 0;
//    
//    while (count1 < n1) {
//        if (array1[i] == array2[j]) {
//            j++;
//            if (j == array2.length) {
//                j = 0;
//                count2++;
//            }
//        }
//        i++;
//        if (i == array1.length) {
//            i = 0;
//            count1++;
//        }
//    }
//    
//    return count2 / n2;
//}