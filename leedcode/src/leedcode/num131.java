package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num131 {
	List<List<String>> listlist=new ArrayList<List<String>>();
	char[] arr;
    public List<List<String>> partition(String s) {
    	arr=s.toCharArray();
    	
    	addPar(0,new ArrayList<String>());
    	return listlist;
    }
    public void addPar(int index,List<String> list){
    	list.add(arr[index]+"");
    	if(index==arr.length-1){
    		List<String> temList=new ArrayList<String>(list);
    		listlist.add(temList);
    		list.remove(list.size()-1);
    		return;
    	}
    	addPar(index+1,list);
    	list.remove(list.size()-1);
    	for(int i=index+1;i<arr.length;i++){
    		int k=i;
    		boolean good=true;
    		for(int j=index;j<k;j++){
    			if(arr[j]!=arr[k]){
    				good=false;
    				break;
    			}
    			k--;
    		}
    		if(good){
    			String str="";
    			for(int j=index;j<=i;j++){
    				str=str+arr[j];
    			}
    			list.add(str);
    			if(i==arr.length-1){
    				List<String> temList2=new ArrayList<String>(list);
    				listlist.add(temList2);
    			}
    			else
    				addPar(i+1,list);
    			list.remove(list.size()-1);
    		}
    	}
    	
    }
	public static void main(String[] args) {
		num131 sol=new num131();
		System.out.println(sol.partition("aaab"));
	}

}
