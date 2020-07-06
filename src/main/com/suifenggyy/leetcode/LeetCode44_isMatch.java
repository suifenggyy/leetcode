package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/7/5 23:59
 */
public class LeetCode44_isMatch {
	public static boolean isMatch(String s, String p) {
		int dp[][] = new int[s.length() + 1][p.length() + 1];
		dp[0][0] = 1;
		char sc , pc;
		for (int i = 1; i <= p.length(); ++i) {
			if (p.charAt(i - 1) == '*') {
				dp[0][i] = 1;
			} else {
				break;
			}
		}
		for (int i = 1; i <= s.length(); i++) {
			sc = s.charAt(i - 1);
			for (int j = 1; j <= p.length(); j ++) {
				pc = p.charAt(j - 1);
				if (sc == pc || pc == '?') {
					dp[i][j] = dp[i -1][j -1];
				} else if (pc == '*') {
					if (dp[i][j - 1] == 1 || dp[i - 1][j] == 1) {
						dp[i][j] = 1;
					}
				}

			}
		}
		return dp[s.length()][p.length()] >= 1;
	}

	public static void main(String[] args) {
		System.out.println(isMatch("a","**a"));
	}
}
