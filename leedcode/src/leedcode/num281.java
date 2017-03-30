package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num281 {

	public static void main(String[] args) {
		List<Integer> l1=new ArrayList<Integer>();
		List<Integer> l2=new ArrayList<Integer>();
//		l2.add(1);
//		l2.add(2);
//		l2.add(5);
//		l2.add(6);
		l1.add(3);
		l1.add(4);
		ZigzagIterator i = new ZigzagIterator(l1, l2);
		while (i.hasNext())
			System.out.println(i.next());
	}

}
