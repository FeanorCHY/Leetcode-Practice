package leedcode;

import java.util.HashMap;

public class num432 {

	
	public static void main(String[] args) {
		AllOne ao=new AllOne();
		ao.inc("1");
		ao.inc("2");
		ao.inc("3");
		ao.inc("4");
		ao.inc("5");
		ao.inc("3");
		System.out.println(ao.getMaxKey());
		ao.inc("5");
		ao.dec("3");
		System.out.println(ao.getMaxKey());
		ao.dec("5");
		System.out.println(ao.getMinKey());
		HashMap f;
	}

}
