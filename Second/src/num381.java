
public class num381 {

	public static void main(String[] args) {
		RandomizedCollection sol=new RandomizedCollection();
		sol.insert(1);
		sol.insert(1);
		sol.insert(2);
		sol.insert(2);
		sol.insert(2);

		sol.remove(1);
		sol.remove(1);
		sol.remove(2);

		sol.insert(1);
		sol.remove(2);
		
	}

}
