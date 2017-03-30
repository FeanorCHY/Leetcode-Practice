
public class num304 {

	public static void main(String[] args) {
		int[][] matrix = {
		          {3, 0, 1, 4, 2},
		          {5, 6, 3, 2, 1},
		          {1, 2, 0, 1, 5},
		          {4, 1, 0, 1, 7},
		          {1, 0, 3, 0, 5}
		        };
		NumMatrix sol=new NumMatrix(matrix);
		System.out.println(sol.sumRegion(2, 1, 4, 3));
		System.out.println(sol.sumRegion(1, 1, 2, 2));
	}

}
