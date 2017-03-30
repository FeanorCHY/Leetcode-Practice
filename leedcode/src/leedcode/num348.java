package leedcode;

public class num348 {

	public static void main(String[] args) {
		TicTacToe ttt=new TicTacToe(3);
		System.out.println(ttt.move(0, 0, 1));
		System.out.println(ttt.move(0, 2, 2));
		System.out.println(ttt.move(2, 2, 1));
		System.out.println(ttt.move(1, 1, 2));
		System.out.println(ttt.move(2, 0, 1));
		System.out.println(ttt.move(1, 0, 2));
		System.out.println(ttt.move(2, 1, 1));
//		System.out.println(ttt.move(0, 0, 1));
//		System.out.println(ttt.move(0, 0, 1));
	}

}
