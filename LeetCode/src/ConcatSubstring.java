/*
 * 30. Substring with Concatenation of All Words   
 * You are given a string, s, and a list of words, words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in 
 * words exactly once and without any intervening characters.
 *
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConcatSubstring {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words.length == 0) {
			return result;
		}
		int wordLength = words[0].length();
		if (s.length() < wordLength * words.length) {
			return result;
		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
		}

		for (int i = 0; i < s.length() - wordLength * words.length + 1; i++) {

			HashMap<String, Integer> tempMap = new HashMap<String, Integer>(map);
			for (int j = 0; j < wordLength * words.length; j = j + wordLength) {
				String str = s.substring(i + j, i + j + wordLength);
				if (!tempMap.containsKey(str)) {
					break;
				}
				int d = tempMap.get(str);
				if (d == 1) {
					tempMap.remove(str);
				} else {
					tempMap.put(str, d - 1);
				}
			}
			if (tempMap.size() == 0) {
				result.add(i);
			}

		}
		return result;

	}
}
