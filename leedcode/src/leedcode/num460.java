package leedcode;

public class num460 {

	public static void main(String[] args) {
		LFUCache cache = new LFUCache( 2 /* capacity */ );

		cache.put(3, 1);
		cache.put(2, 1);
		cache.put(2, 2);
		cache.put(4, 4);
		cache.get(2); 
		cache.put(3, 2);
		cache.get(2); 
		cache.get(3); 
//		cache.get(1);       // returns 1
//		cache.put(3, 3);    // evicts key 2
//		cache.get(2);       // returns -1 (not found)
//		cache.get(3);       // returns 3.
//		cache.put(4, 4);    // evicts key 1.
//		cache.get(1);       // returns -1 (not found)
//		cache.get(3);       // returns 3
//		cache.get(4);       // returns 4
	}

}
