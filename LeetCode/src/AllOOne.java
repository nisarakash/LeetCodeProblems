/*
 * 432. All O`one Data Structure
 */

import java.util.HashMap;
import java.util.LinkedList;

public class AllOOne {

	HashMap<String, Node> map = new HashMap<String, Node>();
	LinkedList<Node> list = new LinkedList<Node>();

	Node head = null, tail = null;

	/** Initialize your data structure here. */
	public AllOOne() {

	}

	/**
	 * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
	 */
	public void inc(String key) {
		Node temp = null;
		if (map.containsKey(key)) {
			temp = map.get(key);
			temp.val++;
			if (head.val <= temp.val) {
				removeFromList(temp);
				addToHead(temp);
			}
		} else {
			temp = new Node(key, 1);
			if (head == null) {
				head = temp;
				tail = temp;
			} else {
				addToTail(temp);
			}
			map.put(key, temp);
		}
	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the
	 * data structure.
	 */
	public void dec(String key) {
		Node temp = null;
		if (map.containsKey(key)) {
			temp = map.get(key);
			temp.val--;
			if (temp.val == 0) {
				removeFromList(temp);
				map.remove(temp);
			} else if (temp.val == 1) {
				removeFromList(temp);
				addToTail(temp);
			}
		}
	}

	void removeFromList(Node node) {
		if (node.prev == null) {
			head = node.next;
		} else {
			node.prev.next = node.next;
		}
		if (node.next == null) {
			tail = node.prev;
		} else {
			node.next.prev = node.prev;
		}
	}

	void addToHead(Node node) {
		node.next = head;
		head = node;
	}

	void addToTail(Node node) {
		node.prev = tail;
		tail = node;
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		if (head == null) {
			return "";
		}
		return head.key;
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		if (tail == null) {
			return "";
		}
		return tail.key;
	}

	class Node {
		int val;
		Node prev, next;
		String key;

		Node(String key, int x) {
			val = x;
			this.key = key;
			prev = null;
			next = null;
		}
	}

}
