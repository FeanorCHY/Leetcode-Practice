package leedcode;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger{
	int num;
	List<NestedInteger> list=null;
	boolean isNum;
	public boolean isInteger() {
		return isNum;
	}
	NestedInteger(int element){
		num=element;
		isNum=true;
	}
	NestedInteger(){
		list=new ArrayList<NestedInteger>();
		isNum=false;
	}
	public void add(NestedInteger ni){
		list.add(ni);
	}
//	NestedInteger(List<NestedInteger> list){
//		this.list=list;
//		isNum=false;
//	}
	public Integer getInteger() {
		// TODO Auto-generated method stub
		return list==null?num:null;
	}

	public List<NestedInteger> getList() {
		// TODO Auto-generated method stub
		return list==null?null:list;
	}

}


//     // Constructor initializes an empty nested list.
//     public NestedInteger();
//
//     // Constructor initializes a single integer.
//     public NestedInteger(int value);
//
//     // @return true if this NestedInteger holds a single integer, rather than a nested list.
//     public boolean isInteger();
//
//     // @return the single integer that this NestedInteger holds, if it holds a single integer
//     // Return null if this NestedInteger holds a nested list
//     public Integer getInteger();
//
//     // Set this NestedInteger to hold a single integer.
//     public void setInteger(int value);
//
//     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//     public void add(NestedInteger ni);
//
//     // @return the nested list that this NestedInteger holds, if it holds a nested list
//     // Return null if this NestedInteger holds a single integer
//     public List<NestedInteger> getList();