package com.suifenggyy.leetcode;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/11 23:22
 */
public class LeetCode381_RandomizedCollection {
	static class RandomizedCollection {
		private Map<Integer, Set<Integer>> keyIndex;
		private List<Integer> keys;
		private int size = 0;

		/**
		 * Initialize your data structure here.
		 */
		public RandomizedCollection() {
			keyIndex = new HashMap<>();
			keys = new ArrayList<>();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
		 */
		public boolean insert(int val) {
			boolean flag = !keyIndex.containsKey(val);
			keys.add(val);
			Set<Integer> indexSet = keyIndex.getOrDefault(val, new HashSet<>());
			indexSet.add(size);
			keyIndex.put(val, indexSet);
			size += 1;
			return flag;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection contained the specified element.
		 */
		public boolean remove(int val) {
			if (!keyIndex.containsKey(val) || keyIndex.get(val).size() == 0) {
				return false;
			}
			Set<Integer> indexSet = keyIndex.get(val);
			int index = indexSet.iterator().next();
			indexSet.remove(index);
			if (index != size - 1) {
				int lastkey = keys.get(size - 1);
				keys.set(index, lastkey);
				Set<Integer> lastkeyIndexSet = keyIndex.get(lastkey);
				lastkeyIndexSet.remove(size - 1);
				lastkeyIndexSet.add(index);
			}
			keys.remove(size - 1);
			size -= 1;
			return true;
		}

		/**
		 * Get a random element from the collection.
		 */
		public int getRandom() {
			if (size == 0) {
				return 0;
			}
			return keys.get(ThreadLocalRandom.current().nextInt(size));
		}
	}


	public static void main(String[] args) {
		RandomizedCollection obj = new RandomizedCollection();
		System.out.println(obj.insert(1));
		System.out.println(obj.insert(1));
		System.out.println(obj.insert(1));
		System.out.println(obj.getRandom());
		System.out.println(obj.remove(1));
		System.out.println(obj.remove(1));
		System.out.println(obj.remove(1));
		System.out.println(obj.remove(1));

		System.out.println(ThreadLocalRandom.current().nextInt(0,1));
	}

}
