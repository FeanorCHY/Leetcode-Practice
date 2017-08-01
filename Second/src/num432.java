
public class num432 {

	public static void main(String[] args) {
		AllOne sol=new AllOne();
		sol.inc("a");
		sol.inc("b");
		sol.inc("b");
		sol.inc("c");
		sol.inc("c");
		sol.inc("c");
		sol.dec("b");
		sol.dec("b");
		System.out.println(sol.getMinKey());
		sol.dec("a");
		System.out.println(sol.getMaxKey());
		System.out.println(sol.getMinKey());
		
	}

}
