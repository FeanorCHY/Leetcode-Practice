package leedcode;

public class num308 {

	public static void main(String[] args) {
		int[][] matrix = {{1}};//{{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
		NumMatrix2D sol=new NumMatrix2D(matrix);
		System.out.println(sol.sumRegion(0,0,0,0));
		sol.update(0, 0, -1);
		System.out.println(sol.sumRegion(0,0,0,0));
//		System.out.println(sol.sumRegion(2, 1, 4, 3));
		
	}

}
