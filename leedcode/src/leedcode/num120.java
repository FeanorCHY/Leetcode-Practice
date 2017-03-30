package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num120 {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle.size()==1)
    		return triangle.get(0).get(0);
    	if(triangle.size()==0)
    		return 0;
    	int[] result=new int[triangle.size()];
    	for(int i=0;i<triangle.size();i++){
    		result[i]=triangle.get(triangle.size()-1).get(i);
    	}
    	for(int row=triangle.size()-2;row>=0;row--){
    		for(int index=0;index<triangle.get(row).size();index++){
    			result[index]=triangle.get(row).get(index)+Math.min(result[index], result[index+1]);
    		}
    	}
    	
    	
        return result[0];
    }

	public static void main(String[] args) {
		int[][] test2={{2},{-1,-7},{6,7,9},{-3,8,5,7},{5,-3,2,5,-7},{-8,6,8,-5,-8,-7},{1,5,2,-5,5,8,-3},{-1,-2,2,-9,6,2,7,0},{1,-9,-5,-7,7,9,-4,-3,2}};
		List<List<Integer>> test=new ArrayList<List<Integer>>();
		List<Integer> list=new ArrayList<Integer>();
		for(int[] i:test2){
			List<Integer> temlist=new ArrayList<Integer>();
			for(Integer each:i){
				temlist.add(each);
			}
			test.add(temlist);
		}
		for(List<Integer> tem:test){
			System.out.println(tem.toString());
		}
//		list.add(2);
//		test.add(list);
//		list=new ArrayList<Integer>();
//		list.add(3);
//		list.add(4);
//		test.add(list);
//		list=new ArrayList<Integer>();
//		list.add(6);
//		list.add(5);
//		list.add(7);
//		test.add(list);
//		list=new ArrayList<Integer>();
//		list.add(4);
//		list.add(1);
//		list.add(8);
//		list.add(3);
//		test.add(list);
		num120 sol=new num120();
		System.out.println(sol.minimumTotal(test));
		
	}

}



//List<List<Integer>> listlist;
//int[] minSum;
//int result=Integer.MAX_VALUE;
//listlist=triangle;
//if(triangle.size()==1)
//	return triangle.get(0).get(0);
//if(triangle.size()==0)
//	return 0;
//minSum=new int[triangle.size()];
//for(int i=triangle.size()-1;i>=0;i--){
//	List<Integer> each=triangle.get(i);
//	int minV=Integer.MAX_VALUE;
//	for(Integer inner:each){
//		if(inner<minV)
//			minV=inner;
//	}
//	if(i<triangle.size()-1)
//		minSum[i]=minSum[i+1]+minV;
//	else
//		minSum[i]=minV;
//}
//public void find(int row,int index,int sum){
//	if(result==minSum[0])
//		return;
//	List<Integer> list=listlist.get(row);
//	if(row==listlist.size()-1){
//		if(sum+Math.min(list.get(index), list.get(index+1))<result)
//			result=sum+Math.min(list.get(index), list.get(index+1));
//		return;
//	}
//	if(list.get(index)+sum+minSum[row+1]<result){
//		find(row+1,index,list.get(index)+sum);
//	}
//	if(result==minSum[0])
//		return;
//	if(list.get(index+1)+sum+minSum[row+1]<result){
//		find(row+1,index+1,list.get(index+1)+sum);
//	}
//	
//	
//}
