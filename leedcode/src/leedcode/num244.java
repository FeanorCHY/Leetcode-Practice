package leedcode;

public class num244 {

	public static void main(String[] args) {
		String[] test={"practice", "makes", "perfect", "coding", "makes"};
		WordDistance wordDistance = new WordDistance(test);
		System.out.println(wordDistance.shortest("practice", "makes"));
	}

}
