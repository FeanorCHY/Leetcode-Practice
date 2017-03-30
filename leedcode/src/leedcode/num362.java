package leedcode;

public class num362 {

	public static void main(String[] args) {
		HitCounter counter = new HitCounter();

		// hit at timestamp 1.
		counter.hit(2);

		// hit at timestamp 2.
		counter.hit(3);

		// hit at timestamp 3.
		counter.hit(4);

		// get hits at timestamp 4, should return 3.
		System.out.println(counter.getHits(304));
	}

}
