
/*
 * 117. Populating Next Right Pointers in Each Node II
 */

import java.util.HashMap;

public class PopulatingNextRightPointer {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		HashMap<Integer, TreeLinkNode> map = new HashMap<Integer, TreeLinkNode>();
		connect(root, map, 0);
		return;
	}

	public static void connect(TreeLinkNode root, HashMap<Integer, TreeLinkNode> map, int level) {
		if (root == null) {
			return;
		}
		if (map.containsKey(level)) {
			TreeLinkNode temp = map.get(level);
			temp.next = root;
		}
		map.put(level, root);
		connect(root.left, map, level + 1);
		connect(root.right, map, level + 1);
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}