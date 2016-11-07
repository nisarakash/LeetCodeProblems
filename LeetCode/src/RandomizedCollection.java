/*
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedCollection {

	HashMap<Integer, Integer> map = null;
	ArrayList<Integer> list = null;
	Random r = null;

	/** Initialize your data structure here. */
	public RandomizedCollection() {
		map = new HashMap<Integer, Integer>();
		list = new ArrayList<Integer>();
		r = new Random();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		if (!map.containsKey(val)) {
			map.put(val, 1);
			list.add(val);
			return true;
		} else {
			map.put(val, map.get(val) + 1);
			list.add(val);
			return false;
		}
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		if (map.containsKey(val)) {
			int count = map.get(val);
			if (count > 1) {
				map.put(val, count - 1);
			} else {
				map.remove(val);
			}
			int index = list.indexOf(val);
			list.remove(index);
			return true;
		} else {
			return false;
		}
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		int rand = r.nextInt(list.size());
		return list.get(rand);
	}
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection(); boolean param_1 =
 * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
 * obj.getRandom();
 */