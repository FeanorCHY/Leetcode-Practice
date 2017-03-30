package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num248 {
    private char[][] strobos = {{'0','0'}, {'1','1'}, {'6','9'}, {'8','8'}, {'9','6'}};
    public int strobogrammaticInRange(String low, String high) {
        if (low.length() > high.length()) return 0;
        if (low.length() == high.length() && low.compareTo(high) > 0) return 0;
        return count(high, true) - count(low, false);
    }
    private int count(String high, boolean inclusive) {
        int len = high.length();
        int count = 0;
        for(int i=1; i<len; i++) {
            count += countLen(i, true);
        }
        count += find(new char[len], 0, len-1, high.toCharArray(), inclusive, true);
        return count;
    }
    private int countLen(int len, boolean outside) {
        if (len == 0) return 1;
        if (len == 1) return 3;
        if (outside) return countLen(len-2, false)*4;
        return countLen(len-2, false)*5;
    }
    
    private int find(char[] num, int left, int right, char[] high, boolean inclusive, boolean ceiling) {
        if (left > right) {
            if (!ceiling) return 1;
            int compare = compare(num, high, left, num.length-1);
            if (inclusive && compare <= 0) return 1;
            if (!inclusive && compare < 0) return 1;
            return 0;
        }
        int count = 0;
        for(int i=0; i<strobos.length; i++) {
            if (left == 0 && right != 0 && strobos[i][0] == '0') continue;
            if (left == right && strobos[i][0] != strobos[i][1]) continue;
            if (ceiling && strobos[i][0] > high[left]) continue;
            num[left] = strobos[i][0];
            num[right] = strobos[i][1];
            count += find(num, left + 1, right - 1, high, inclusive, ceiling && num[left] == high[left]);
        }
        return count;
    }
    private int compare(char[] a, char[] b, int from, int to) {
        for(int i=from; i<=to; i++) {
            if (a[i] < b[i]) return -1;
            if (a[i] > b[i]) return 1;
        }
        return 0;
    }
	

	public static void main(String[] args) {
		num248 sol=new num248();
		System.out.println(sol.strobogrammaticInRange("50", "1200"));
	}

}



//
//int one[]={0,1,8};
//int two[]={0,11,69,88,96};
//int twop1[]={0,1,6,8,9};
//int twop2[]={0,1,9,8,6};
//public int strobogrammaticInRange(String low, String high) {
//    int count=0;
//    int countCur=4;
//    if(high.length()-low.length()>=2){
//    	int lowC=low.length()+1;
//    	int highC=high.length()-1;
//    	if(lowC>=2)
//    		count=4;
//    	for(int i=3;i<=highC;i++){
//    		if(i%2==0)
//    			countCur=countCur*5;
//    		if(i>=lowC){
//    			if(i%2==1){
//    				count=count+countCur*3;
//    			}
//    			else
//    				count=countCur+count;
//    		}
//    	}
//    	count=count+calCount(low,false);
//    	if(high.length()%2==0){
//    		count=count+countCur*5-calCount(high,true);
//    	}
//    	else
//    		count=count+countCur*3-calCount(high,true);
//    	return count;
//    }
//    else if(high.length()-low.length()==1){
//    	count=count+calCount(low,false);
//    	if(high.length()==2)
//    		count=count+4;
//    	else if(high.length()%2==0){
//    		count=count+4*(int)Math.pow(5, high.length()/2-1);
//    	}
//    	else if(high.length()%2==1){
//    		count=count+12*(int)Math.pow(5, high.length()/2-1);
//    	}
//    	count=count-calCount(high,true);
//    	return count;
//    }
//    else if(high.length()-low.length()<0)
//    	return 0;
//    else{
//    	count=calCount(low,false)-calCount(high,true);
//    	
//    }
//	
//	return count;
//}
//public int calCount(String str,boolean calhigh){
//	char[] arr=str.toCharArray();
//	if(str.length()==1){
//		int i=0;
//		for(;i<one.length;i++){
//			if(arr[0]>=one[i]+'0')
//				continue;
//			else 
//				break;
//		}
//		int count=one.length-i;
//		if(arr[0]-'0'==one[i-1]&&calhigh==false)
//			return ++count;
//		else
//			return count;
//	}
//	else if(str.length()==2){
//		int i=0;
//		for(;i<two.length;i++){
//			if(Integer.parseInt(str)>=two[i])
//				continue;
//			else 
//				break;
//		}
//		int count=two.length-i;
//		if(arr[0]-'0'==one[i-1]&&calhigh==false)
//			return ++count;
//		else
//			return count;
//		
//	}
//	else if(str.length()%2==0){
//		int count=0;
//		boolean over=false;
//		List<Integer> list=new ArrayList<Integer>();
//		for(int i=0;i<arr.length/2;i++){
//			int j=0;
//			for(;j<two.length;j++){
//				if(arr[i]>=twop1[j]+'0'){
//					continue;
//				}
//				else
//					break;
//			}
//			j--;
//			list.add(twop2[j]);
//			count=count+(two.length-1-j)*(int)Math.pow(5, arr.length/2-i-1);
//			if(arr[i]>twop1[j]+'0'){
//				return count;
////				over=true;
//			}
//		}
//		boolean equal=true;
//		if(over!=true){
//			int index=0;
//			for(;index<list.size();index++){
//				int each=list.get(list.size()-1-index);
//				if(arr[arr.length/2+index]-'0'>each){
//					equal=false;
//					break;
//				}
//				else if(arr[arr.length/2+index]-'0'<each){
//					equal=false;
//					count++;
//					break;
//				}
//					
//			}
//			if(equal==true&&calhigh==false)
//				count++;
//		}
//		return count;
//	}
//	else{
//		int count=0;
//		boolean over=false;
//		List<Integer> list=new ArrayList<Integer>();
//		for(int i=0;i<arr.length/2;i++){
//			int j=0;
//			for(;j<two.length;j++){
//				if(arr[i]>=twop1[j]+'0'){
//					continue;
//				}
//				else
//					break;
//			}
//			j--;
//			list.add(twop2[j]);
//			count=count+(two.length-1-j)*(int)Math.pow(5, arr.length/2-i-1)*3;
//			if(arr[i]>twop1[j]+'0'){
//				return count;
////				over=true;
//			}
//		}
//		boolean equal=true;
//		if(over!=true){
//			int mid=arr[arr.length/2]-'0';
//			int i=0;
//			for(;i<one.length;i++){
//				if(mid>=one[i]){
//					continue;
//				}
//				else
//					break;
//			}
//			i--;
//			count=count+one.length-1-i;
//			if(mid>one[i])
//				return count;
//			int index=0;
//			for(;index<list.size();index++){
//				int each=list.get(list.size()-1-index);
//				if(arr[arr.length/2+index+1]-'0'>each){
//					equal=false;
//					break;
//				}
//				else if(arr[arr.length/2+index]-'0'<each){
//					equal=false;
//					count++;
//					break;
//				}
//					
//			}
//			if(equal==true&&calhigh==false)
//				count++;
//		}
//    	return count;
//	}
//}