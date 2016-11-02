/**
 * 
 * @author Akash
 * 
 *         Given an integer matrix, find the length of the longest increasing
 *         path.
 * 
 *         From each cell, you can either move to four directions: left, right,
 *         up or down. You may NOT move diagonally or move outside of the
 *         boundary (i.e. wrap-around is not allowed).
 * 
 *         Example :
 * 
 *         nums = [ [9,9,4], [6,6,8], [2,1,1] ]
 * 
 *         Return 4 The longest increasing path is [1, 2, 6, 9].
 * 
 */

public class LongestIncreasingPath {
	public static int[][] matrix;
	public static int[][] a;

	public int longestIncreasingPath(int[][] a) {
		if (a == null) {
			return 0;
		}

		LongestIncreasingPath.a = a;

		int row = a.length;
		if (row <= 0) {
			return 0;
		}
		int col = a[0].length;

		matrix = new int[row][col];

		int max = 1;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = maxPath(i, j, row, col);
				if (max < matrix[i][j]) {
					max = matrix[i][j];
				}
			}
		}

		return max;
	}

	public static int maxPath(int i, int j, int row, int col) {
		if (matrix[i][j] > 0) {
			return matrix[i][j];
		}

		int count = 1;

		if (i >= 0 && i < row - 1 && a[i][j] < a[i + 1][j]) {
			matrix[i + 1][j] = maxPath(i + 1, j, row, col);
			count = Math.max(count, 1 + matrix[i + 1][j]);
		}
		if (i <= row && i > 0 && a[i][j] < a[i - 1][j]) {
			matrix[i - 1][j] = maxPath(i - 1, j, row, col);
			count = Math.max(count, 1 + matrix[i - 1][j]);
		}
		if (j >= 0 && j < col - 1 && a[i][j] < a[i][j + 1]) {
			matrix[i][j + 1] = maxPath(i, j + 1, row, col);
			count = Math.max(count, 1 + matrix[i][j + 1]);
		}
		if (j <= col && j > 0 && a[i][j] < a[i][j - 1]) {
			matrix[i][j - 1] = maxPath(i, j - 1, row, col);
			count = Math.max(count, 1 + matrix[i][j - 1]);
		}

		return count;
	}
}
