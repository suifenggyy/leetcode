package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/20 20:13
 */
public class LeetCode10_isMatch {
	static class Solution {
		public boolean isMatch(String s, String p) {
			int dp[][] = new int[s.length() + 1][p.length() + 1];
			dp[0][0] = 1;
			char sc , pc;

			for (int i = 0; i <= s.length(); i++) {
				if (i == 0) {
					for (int j = 1; j <= p.length(); j ++) {
						if (p.charAt(j - 1) == '*' && j >= 2) {
							dp[i][j] = dp[i][j - 2];
						}
					}
					continue;
				}
				sc = s.charAt(i - 1);
				for (int j = 1; j <= p.length(); j ++) {
					pc = p.charAt(j - 1);
					if (sc == pc || pc == '.') {
						dp[i][j] = dp[i -1][j -1];
					} else if (pc == '*' && j >= 2 && i >= 1) {
						if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
							dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + dp[i][j - 2];
						} else {
							dp[i][j] = dp[i][j - 2];
						}
					}

				}
			}
			return dp[s.length()][p.length()] >= 1;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isMatch("aab", "aab"));

		StringBuilder stringBuilder = new StringBuilder();

	}
}
