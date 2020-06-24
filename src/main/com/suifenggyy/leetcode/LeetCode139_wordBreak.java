package com.suifenggyy.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/25 0:07
 */
public class LeetCode139_wordBreak {
	static class Solution {
		public boolean wordBreak(String s, List<String> wordDict) {
			Set<String> dict = new HashSet<>(wordDict);
			int[] dp = new int[s.length() + 1];
			int t = 0;
			dp[0] = 1;
			for (int i = 1; i <= s.length(); i++) {
				t = i - 1;
				while (t >= 0) {
					if (dp[t] == 1 && dict.contains(s.substring(t, i))) {
						dp[i] = 1;
						break;
					}
					t --;
				}
			}
			return dp[s.length()] == 1;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<String> dict = new ArrayList<>();
		dict.add("leet");
		dict.add("code");
		System.out.println(solution.wordBreak("leetcode", dict));
	}
}
