/*
 * 289. Game of Life
 */
public class GameOfLife {
	public void gameOfLife(int[][] board) {
		int n, m;
		if ((n = board.length) == 0 || (m = board[0].length) == 0) {
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int current = board[i][j];
				int nextState = getNextState(board, i, j);
				board[i][j] = (nextState << 1) + current;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				board[i][j] = board[i][j] >> 1;
			}
		}
	}

	public int getNextState(int[][] board, int i, int j) {
		int current = board[i][j];
		int live = 0;
		for (int k = i - 1; k <= i + 1; k++) {
			for (int l = j - 1; l <= j + 1; l++) {
				if (k < 0 || k > board.length - 1 || l < 0
						|| l > board[0].length - 1 || (k == i && l == j)) {
					continue;
				}
				if ((board[k][l] & 1) == 1) {
					live++;
				}
			}
		}
		if (current == 1 && (live < 2 || live > 3)) {
			return 0;
		} else if ((current == 1 && live >= 2 && live <= 3)
				|| (current == 0 && live == 3)) {
			return 1;
		}
		return 0;
	}
}
