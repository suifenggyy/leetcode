package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/7/1 23:37
 */
public class LeetCode982_countTriplets {
	public int countTriplets(int[] A) {
		int[] status = new int[1 << 16];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				status[A[i] & A[j]] += 1;
			}
		}

		int res = 0;
		for (int i = 0; i < A.length; i++) {
			if (status[i] == 0) {
				continue;
			}
			for (int j = 0; j < 1 << 16; j++) {
				if ((A[j] & i) == 0) {
					res += status[i];
				}
			}
		}
		return res;
	}
}
