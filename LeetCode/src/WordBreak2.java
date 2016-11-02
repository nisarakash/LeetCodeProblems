/*
 * Given a string s and a dictionary of words dict, add spaces in s to 
 * construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is ["cats and dog", "cat sand dog"].
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict.size() == 0) {
			return new ArrayList<String>();
		}
		HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		return wordBreak(s, wordDict, 0, map);
	}

	public static List<String> wordBreak(String suffix, Set<String> wordDict,
			int start, HashMap<Integer, List<String>> map) {

		if (map.containsKey(start)) {
			return map.get(start);
		}

		List<String> result = new ArrayList<String>();
		if (wordDict.contains(suffix)) {
			result.add(suffix);
		}

		for (int i = 0; i < suffix.length() + 1; i++) {
			String pre = suffix.substring(0, i);
			if (!wordDict.contains(pre)) {
				continue;
			}

			for (String suf : wordBreak(suffix.substring(i, suffix.length()),
					wordDict, start + i, map)) {
				result.add(pre + " " + suf);
			}

		}
		map.put(start, result);
		return result;
	}
}
