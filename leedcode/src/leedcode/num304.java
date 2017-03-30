package leedcode;

public class num304 {

	public static void main(String[] args) {
		int matrix[][]={{1},{-7}};
		NumMatrix numMatrix = new NumMatrix(matrix);
		numMatrix.sumRegion(0, 0, 0, 0);
		numMatrix.sumRegion(1, 0, 1, 0);
		numMatrix.sumRegion(0, 0, 0, 0);
	}

}
