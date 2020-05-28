package com.suifenggyy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/5/28 23:55
 */
public class LeetCode1253_ReconstructMatrix {
	public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		List<List<Integer>> res = new ArrayList();
		int sum = 0;
		for (int i = 0; i < colsum.length; i++) {
			sum += colsum[i];
		}
		if (sum != upper + lower) {
			return res;
		}
		int first = upper;
		List<Integer> list1 = new ArrayList(colsum.length);
		List<Integer> list2 = new ArrayList(colsum.length);
		for (int i = 0; i < colsum.length; i++) {
			if (colsum[i] == 2) {
				colsum[i] = 0;
				first -= 1;
				list1.add(1);
				list2.add(1);
			} else {
				list1.add(0);
				list2.add(0);
			}
		}

		for (int i = 0; i < colsum.length; i++) {
			if (colsum[i] > 0 && first > 0) {
				colsum[i] -= 1;
				first -= 1;
				list1.set(i, 1);
			}
		}
		if (first != 0) {
			return res;
		}
		res.add(list1);
		for (int i = 0; i < colsum.length; i++) {
			if (colsum[i] > 0) {
				colsum[i] -= 1;
				list2.set(i, 1);
			}
		}
		res.add(list2);
		return res;
	}
}
