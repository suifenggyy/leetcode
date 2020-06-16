package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/17 1:00
 */
public class LeetCode1014_maxScoreSightseeingPair {
	static class Solution {
		public int maxScoreSightseeingPair(int[] A) {
			int m_max = Integer.MIN_VALUE;
			int n_max = Integer.MIN_VALUE;
			int max = 0;
			for (int i = 0; i < A.length; i++) {
				if (A[i] - i > n_max) {
					n_max = A[i] - i;
					max = Math.max(m_max + n_max, max);
				} else {
					max = Math.max(m_max + A[i] - i, max);
				}
				if (A[i] + i > m_max) {
					m_max = A[i] + i;
				}
			}
			return max;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {8,1,5,2,6};
		System.out.println(solution.maxScoreSightseeingPair(A));
	}


}
