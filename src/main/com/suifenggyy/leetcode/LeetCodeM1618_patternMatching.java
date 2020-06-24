package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/25 1:46
 */
public class LeetCodeM1618_patternMatching {
	static class Solution {
		public boolean patternMatching(String pattern, String value) {
			String[] ab = new String[2];
			return match(pattern, value, ab);
		}

		public boolean match(String pattern, String value, String[] ab) {
			if (pattern == null || pattern.isEmpty()) {
				return value == null || value.isEmpty();
			}
			int index = pattern.charAt(0) - 'a';
			String abpattern = ab[index];
			if (abpattern != null) {
				if (!value.startsWith(abpattern)) {
					return false;
				}
				return match(pattern.substring(1), value.substring(abpattern.length()), ab);
			}

			for (int i = 0; i <= value.length(); i ++) {
				abpattern = value.substring(0, i);
				if (abpattern.equals(ab[0]) || abpattern.equals(ab[1])) {
					continue;
				}
				ab[index] = abpattern;
				if (match(pattern.substring(1), i == value.length() ? "" : value.substring(i), ab)) {
					return true;
				}
				ab[index] = null;
			}

			return false;
		}
	}

	public static void main(String[] args) {
		String[] test = new String[2];
		test[0] = null;
		test[1] = " ";
		String t = "a".substring(1);
		System.out.println("a".substring(1));

		Solution solution = new Solution();
		System.out.println(solution.patternMatching("a", ""));
	}
}
