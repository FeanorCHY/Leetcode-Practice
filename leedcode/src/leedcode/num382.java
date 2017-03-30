package leedcode;

import java.util.Random;

public class num382 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		Solution382 solution = new Solution382(head);
		Random mRandom=new Random();
		for(int i=1;i<100;i++){
			System.out.println(solution.getRandom());
		}
	}

}
