/*
 * 174. Dungeon Game
 */

public class DungeonPath {
	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0)
			return 0;
		int x = dungeon.length - 1;
		int y = dungeon[0].length - 1;
		dungeon[x][y] = Math.max(1 - dungeon[x][y], 1);

		for (int i = y - 1; i >= 0; i--)
			dungeon[x][i] = Math.max(dungeon[x][i + 1] - dungeon[x][i], 1);

		for (int i = x - 1; i >= 0; i--)
			dungeon[i][y] = Math.max(dungeon[i + 1][y] - dungeon[i][y], 1);

		for (int i = x - 1; i >= 0; i--) {
			for (int j = y - 1; j >= 0; j--) {
				int right = Math.max(dungeon[i][j + 1] - dungeon[i][j], 1);
				int left = Math.max(dungeon[i + 1][j] - dungeon[i][j], 1);
				dungeon[i][j] = Math.min(left, right);
			}
		}
		return dungeon[0][0];

	}
}
