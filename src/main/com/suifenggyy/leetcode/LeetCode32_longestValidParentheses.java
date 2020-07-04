package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/7/4 22:50
 */
public class LeetCode32_longestValidParentheses {
	public static int longestValidParentheses(String s) {
		if (s == null) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		int max = 0;
		Character preCh = null;
		for (int i = 1; i <= s.length(); i++) {
			char ch = s.charAt(i - 1);
			if (ch == '(') {
				dp[i] = 0;
			} else if (preCh != null) {
				if ('(' == preCh) {
					dp[i] = dp[i - 2] + 2;
				} else {
					if (i - dp[i - 1] - 1 - 1 >= 0 && s.charAt(i - dp[i - 1] - 1 - 1) == '(') {
						dp[i] = dp[i - 1] + 2;
						if (i  - dp[i - 1] - 2 > 0) {
							dp[i] += dp[i  - dp[i - 1] - 2];
						}
					}
				}
			}
			preCh = ch;
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()()(()))"));
	}
}
