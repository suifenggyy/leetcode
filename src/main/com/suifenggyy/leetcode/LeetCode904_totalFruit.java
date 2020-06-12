package com.suifenggyy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/12 22:55
 */
public class LeetCode904_totalFruit {
	public int totalFruit(int[] tree) {
		if (tree.length <= 2) {
			return tree.length;
		}
		int size = tree.length;
		int max = 0;
		Map<Integer, Integer> backet = new HashMap<>(2);
		int start = 0, end = 0;
		int cnt;
		while (end < size) {
			while (end < size && (backet.size() < 2 || backet.containsKey(tree[end]))) {
				backet.put(tree[end], backet.getOrDefault(tree[end], 0) + 1);
				end ++;
			}
			max = Math.max(max, end - start);

			while (start < end && end < size && backet.containsKey(tree[start]) && backet.size() == 2) {
				cnt = backet.get(tree[start]);
				if (cnt == 1) {
					backet.remove(tree[start]);
				} else {
					backet.put(tree[start], cnt - 1);
				}
				start ++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LeetCode904_totalFruit soution = new LeetCode904_totalFruit();
		int[] tree = {1,1,1,1,1,1,2,2,2,2,2,2};
		System.out.println(soution.totalFruit(tree));
	}
}
