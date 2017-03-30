package leedcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class num284 {

	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		PeekingIterator pi=new PeekingIterator(list.iterator());
		System.out.println(pi.next());
		System.out.println(pi.peek());
		System.out.println(pi.next());

	}

}
