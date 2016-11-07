/*
 * 72. Edit Distance
 */

public class EditDistance {
	public int minDistance(String s1, String s2) {

		if (s1.length() == 0) {
			return s2.length();
		}
		if (s2.length() == 0) {
			return s1.length();
		}

		int[][] result = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < s1.length() + 1; i++) {
			result[i][0] = i;
		}

		for (int i = 0; i < s2.length() + 1; i++) {
			result[0][i] = i;
		}

		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					result[i + 1][j + 1] = result[i][j];
				} else {
					result[i + 1][j + 1] = 1 + Math.min(result[i][j + 1], Math.min(result[i][j], result[i + 1][j]));
				}
			}
		}

		return result[s1.length()][s2.length()];

	}
}
