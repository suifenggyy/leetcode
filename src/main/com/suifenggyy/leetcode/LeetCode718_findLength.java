package com.suifenggyy.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/7/1 1:23
 */
public class LeetCode718_findLength {
	public int findLength(int[] A, int[] B) {
		Map<Integer, Set<Integer>> numIndexMap = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			Set<Integer> indexSet = numIndexMap.getOrDefault(A[i], new HashSet<>());
			indexSet.add(i);
			numIndexMap.put(A[i], indexSet);
		}

		int maxLen = 0;
		int j, now;
		for (int i = 0; i < B.length; i++) {
			Set<Integer> indexSet = numIndexMap.get(B[i]);
			if (indexSet == null) {
				continue;
			}
			for (int cur : indexSet) {
				j = i + 1;
				now = cur + 1;
				while (j < B.length && contain(numIndexMap, B[j], now)) {
					j ++;
					now ++;
				}
				maxLen = Math.max(maxLen, now - cur);
			}
		}
		return maxLen;
	}

	public boolean contain(Map<Integer, Set<Integer>> numIndexMap, int num, int index) {
		Set<Integer> indexSet = numIndexMap.get(num);
		return indexSet != null && indexSet.contains(index);
	}

	public int findLength_dp(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];
		dp[0][0] = 0;
		int maxLen = 0;
		for (int i = 0; i < A.length; i ++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					maxLen = Math.max(maxLen, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}

		return maxLen;
	}

	public static int findLength_huadong(int[] A, int[] B) {
		int maxLen = 0;
		int allLen = A.length + B.length - 1;
		int as, bs, len, al = A.length, bl = B.length;
		for (int i = 0; i < allLen; i++) {
			if (i < bl) {
				as = 0;
				bs = bl - i - 1;
				len = Math.min(i + 1, al);
			} else {
				bs = 0;
				as = i - bl + 1;
				len = Math.min(al - as, bl);
			}
			maxLen = Math.max(maxLen, findMax(A, B, as, bs, len));
		}
		return maxLen;
	}

	public static int findMax(int[] A, int[] B, int as, int bs, int len) {
		int cnt = 0; int max = 0;
		for (int i = 0; i < len; i++) {
			if (A[as + i] == B[bs + i]) {
				cnt ++;
				max = Math.max(max, cnt);
			} else {
				cnt = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] A = {1,2,3,2,1};
		int[] B = {3,2,1,4,7,8};
		System.out.println(findLength_huadong(A, B));
	}
}
