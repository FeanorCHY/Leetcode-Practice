
public class num460 {

	public static void main(String[] args) {
		LFUCache sol=new LFUCache(10);
		sol.put(7,28);
		sol.put(7,1);
		sol.put(8,15);
		System.out.println(sol.get(6));
		sol.put(10,27);
		sol.put(8,10);
		System.out.println(sol.get(8));
		sol.put(6,29);
		sol.put(1,9);
		System.out.println(sol.get(6));
		sol.put(10,7);
		System.out.println(sol.get(1));
		System.out.println(sol.get(2));
		System.out.println(sol.get(13));
		sol.put(8,30);
		sol.put(1,5);
		System.out.println(sol.get(1));
		sol.put(13,2);
		System.out.println(sol.get(12));
		
		
		
		
		
//		sol.put(10, 13);
//		sol.put(3, 17);//
//		sol.put(6,11);
//		sol.put(10,5);
//		sol.put(9,10);
//		System.out.println(sol.get(13));
//		sol.put(2,19);
//		System.out.println(sol.get(2));
//		System.out.println(sol.get(3));
//		sol.put(5,25);
//		System.out.println(sol.get(8));
//		sol.put(9,22);
//		sol.put(5,5);
//		sol.put(1,30);
//		System.out.println(sol.get(11));
//		sol.put(9,12);
//		System.out.println(sol.get(7));
//		System.out.println(sol.get(5));
//		System.out.println(sol.get(8));
//		System.out.println(sol.get(9));
//		sol.put(4,30);
		
		
		
		
		
//		sol.put(9,3);sol.put(9);sol.put(10);sol.put(10);sol.put(6,14);sol.put(3,1);sol.put(3);sol.put(10,11);sol.put(8);sol.put(2,14);sol.put(1);sol.put(5);sol.put(4);sol.put(11,4);sol.put(12,24);sol.put(5,18);sol.put(13);sol.put(7,23);sol.put(8);sol.put(12);sol.put(3,27);sol.put(2,12);sol.put(5);sol.put(2,9);sol.put(13,4);sol.put(8,18);sol.put(1,7);sol.put(6);sol.put(9,29);sol.put(8,21);sol.put(5);sol.put(6,30);sol.put(1,12);sol.put(10);sol.put(4,15);sol.put(7,22);sol.put(11,26);sol.put(8,17);sol.put(9,29);sol.put(5);sol.put(3,4);sol.put(11,30);sol.put(12);sol.put(4,29);sol.put(3);sol.put(9);sol.put(6);sol.put(3,4);sol.put(1);sol.put(10);sol.put(3,29);sol.put(10,28);sol.put(1,20);sol.put(11,13);sol.put(3);sol.put(3,12);sol.put(3,8);sol.put(10,9);sol.put(3,26);sol.put(8);sol.put(7);sol.put(5);sol.put(13,17);sol.put(2,27);sol.put(11,15);sol.put(12);sol.put(9,19);sol.put(2,15);sol.put(3,16);sol.put(1);sol.put(12,17);sol.put(9,1);sol.put(6,19);sol.put(4);sol.put(5);sol.put(5);sol.put(8,1);sol.put(11,7);sol.put(5,2);sol.put(9,28);sol.put(1);sol.put(2,2);sol.put(7,4);sol.put(4,22);sol.put(7,24);sol.put(9,26);sol.put(13,28);sol.put(11,26)
//		System.out.println(sol.get(1));
//		sol.put(3, 3);
//		System.out.println(sol.get(2));
//		System.out.println(sol.get(3));
	}

}
