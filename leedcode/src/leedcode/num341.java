package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num341 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NestedInteger node=new NestedInteger(1);
		NestedInteger list=new NestedInteger();
		list.add(node);
		node=new NestedInteger(1);
		list.add(node);
		NestedInteger listNode1=list;
		list=new NestedInteger();
		node=new NestedInteger(1);
		list.add(node);
		node=new NestedInteger(1);
		list.add(node);
		
		NestedInteger biglist=new NestedInteger();
		biglist.add(listNode1);
		biglist.add(new NestedInteger(2));
		listNode1=list;
		biglist.add(listNode1);
		NestedInteger bigNode=biglist;
//		Iterator<NestedInteger> it=biglist.iterator();
		NestedIterator ni=new NestedIterator(biglist.getList());
		while(ni.hasNext()){
			System.out.println(ni.next());
		}
		
	}

}
