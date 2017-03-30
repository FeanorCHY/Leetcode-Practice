package leedcode;

import java.util.List;

public class NestedIntegerIm {//implements NestedInteger {
	int num;
	List<NestedInteger> list=null;
	boolean isNum;
	public boolean isInteger() {
		return isNum;
	}
	NestedIntegerIm(int element){
		num=element;
		isNum=true;
	}
	NestedIntegerIm(List<NestedInteger> list){
		this.list=list;
		isNum=false;
	}
	public Integer getInteger() {
		// TODO Auto-generated method stub
		return list==null?num:null;
	}

	public List<NestedInteger> getList() {
		// TODO Auto-generated method stub
		return list==null?null:list;
	}

}
