package leedcode;

import java.util.TreeSet;

public class num330 {
    public int minPatches(int[] nums, int n) {
    	int count=0;
    	long find=1;//take care of overflow input
    	int index=0;
    	while(find<=(long)n){
    		if(index<nums.length&&nums[index]==find){
    			index++;
    			find=((find-1)<<1)+2;
    		}
    		else{
    			count++;
    			find=((find-1)<<1)+2;
    		}
    		while(index<nums.length&&nums[index]<find){
    			find+=nums[index++];
    		}
    	}
    	
    	return count;
    }
	public static void main(String[] args) {
		int test[]={1,2,31,33};//
		num330 sol=new num330();
		System.out.println(sol.minPatches(test, 2147483647));
	}

}





//TreeSet<Integer> set=new TreeSet<Integer>();
//int count=0;
//int largest=-1;
//if(nums.length==0){
//	set.add(1);
//	count++;
//}
//else{
//	largest=nums[0];
//	set.add(nums[0]);
//}
//for(int i=1;i<nums.length;i++){
//	if(nums[i]>largest)
//		largest=nums[i];
//	TreeSet<Integer> tem=new TreeSet<Integer>();
//	for(int each:set){
//		tem.add(each+nums[i]);
//	}
//	set.addAll(tem);
//	set.add(nums[i]);
//}
//boolean fail=true;
//while(fail){
//	int index=1;
//	long found=-1;
//	for(int each:set){
//		if(index!=each){
//			found=index;
//			break;
//		}
//		index++;
//	}
////	if(found>n)
////		return count;
//	if(found==-1&&index>n)
//		return count;
//	if(index==n)
//		return count+1;
//	else if(index<n&&found==-1){
//		found=index;
//	}
//	if(found>largest){
////		count++;
//		while(found<=(long)n){
//			count++;
//			found=((found-1)<<1)+2;
//		}
//		return count;
//	}
//	
//	
//	TreeSet<Integer> tem=new TreeSet<Integer>();
//	for(int each:set){
//		if((long)each+(long)found>(long)n)
//			break;
//		tem.add(each+(int)found);
//	}
//	set.addAll(tem);
//	set.add((int)found);
//	count++;
//}
//
//return count;