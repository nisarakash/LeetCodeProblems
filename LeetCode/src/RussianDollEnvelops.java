/*
 * 354. Russian Doll Envelopes
 */

import java.util.Arrays;

public class RussianDollEnvelops {

	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}
		Letter[] letters = new Letter[envelopes.length];
		int i = 0;
		for (int[] envelope : envelopes) {
			letters[i++] = new Letter(envelope[0], envelope[1]);
		}

		Arrays.sort(letters);

		int[] result = new int[letters.length];
		Arrays.fill(result, 1);

		for (i = 1; i < letters.length; i++) {
			for (int j = 0; j < i; j++) {
				if (letters[i].w < letters[j].w && letters[i].h < letters[j].h && result[i] < result[j] + 1) {
					result[i] = result[j] + 1;
				}
			}
		}

		int max = -1;
		for (i = 0; i < letters.length; i++)
			if (max < result[i])
				max = result[i];

		return max;

	}

}

class Letter implements Comparable<Letter> {

	Letter(int w, int h) {
		this.w = w;
		this.h = h;
		area = w * h;
	}

	int w;
	int h;
	int area;

	public int compareTo(Letter l2) {
		int compareArea = ((Letter) l2).area;
		return compareArea - this.area;
	}
}