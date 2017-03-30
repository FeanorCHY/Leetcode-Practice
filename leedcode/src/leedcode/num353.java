package leedcode;

public class num353 {

	public static void main(String[] args) {
		int food[][]={{0,1},{0,2},{1,2},{2,2},{2,1},{2,0},{1,0}};
		SnakeGame snake = new SnakeGame(3, 3, food);
		System.out.println(snake.move("R"));
		System.out.println(snake.move("R"));
		System.out.println(snake.move("D"));
		System.out.println(snake.move("D"));
		System.out.println(snake.move("L"));
		System.out.println(snake.move("L"));
		System.out.println(snake.move("U"));
		System.out.println(snake.move("U"));
		System.out.println(snake.move("R"));
		System.out.println(snake.move("R"));
		//[[2,2,[[0,1]]],["R"],["D"]]
//		int[] arr1=new int[2];
//		int[] arr2=new int[2];
//		arr1[1]=1;
//		arr2[1]=1;
//		arr1[0]=2;
//		arr1[0]=2;
//		System.out.println(arr1.equals(arr2));
	}

}
