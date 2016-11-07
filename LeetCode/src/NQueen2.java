
/*
 * 52. N-Queens II
 */

import java.util.Arrays;

public class NQueen2 {
	public int totalNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(board[i], '.');
		return solveNQueens(board, 0, n);
	}

	public int solveNQueens(char[][] board, int start, int end) {

		if (start == end) {
			return 1;

		}
		int count = 0;
		if (start < end) {

			for (int i = 0; i < end; i++) {
				if (!check(board, i, start, end)) {
					continue;
				}
				board[i][start] = 'Q';
				count += solveNQueens(board, start + 1, end);
				board[i][start] = '.';
			}
		}

		return count;

	}

	public boolean check(char[][] board, int i, int j, int end) {
		for (int k = j - 1; k >= 0; k--) {
			if (board[i][k] == 'Q') {
				return false;
			}
		}
		for (int k = j - 1, l = i - 1; k >= 0 && l >= 0; k--, l--) {
			if (board[l][k] == 'Q') {
				return false;
			}
		}

		for (int k = j - 1, l = i + 1; k >= 0 && l < end; k--, l++) {
			if (board[l][k] == 'Q') {
				return false;
			}
		}
		return true;
	}
}
