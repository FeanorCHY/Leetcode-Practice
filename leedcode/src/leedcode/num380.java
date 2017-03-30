package leedcode;

public class num380 {

	public static void main(String[] args) {
		RandomizedSet rs=new RandomizedSet();
		rs.insert(3);
		rs.insert(2);
		rs.insert(5);
//		rs.remove(3);
		System.out.println(rs.getRandom());
	}

}
