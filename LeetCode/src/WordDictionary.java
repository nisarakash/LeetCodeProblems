/*
 * 211. Add and Search Word - Data structure design
 */

public class WordDictionary {

	Trie root = new Trie();

	// Adds a word into the data structure.
	public void addWord(String s) {
		if (root == null) {
			return;
		}
		Trie temp = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (temp.childrens[c - 'a'] == null) {
				temp.childrens[c - 'a'] = new Trie();
			}
			if (i == s.length() - 1) {
				temp.childrens[c - 'a'].isLeaf = true;
			}
			temp = temp.childrens[c - 'a'];
		}
		return;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String s) {
		return search(root, s);
	}

	public boolean search(Trie root, String s) {
		if (root == null) {
			return false;
		}
		if ("".equals(s)) {
			if (root.isLeaf == true) {
				return true;
			}
		}
		Trie temp = root;
		boolean exist = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '.') {
				for (int j = 0; j < temp.childrens.length; j++) {
					exist = exist | search(temp.childrens[j], s.substring(i + 1));
					if (exist) {
						return true;
					}
				}
				if (exist == false) {
					return false;
				}
			}

			if (temp.childrens[c - 'a'] == null) {
				return false;
			}

			if (i == s.length() - 1) {
				if (temp.childrens[c - 'a'].isLeaf == true) {
					return true;
				}
			}

			temp = temp.childrens[c - 'a'];

		}

		return exist;
	}
}

class Trie {
	boolean isLeaf;
	Trie[] childrens;

	Trie() {
		isLeaf = false;
		childrens = new Trie[26];
	}
}
