import java.util.HashMap;

public class num381 {
	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	
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
