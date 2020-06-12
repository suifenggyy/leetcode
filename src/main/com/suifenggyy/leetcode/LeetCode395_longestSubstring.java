package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/12 23:29
 */
public class LeetCode395_longestSubstring {
	int max = 0;
	boolean flag;

	public int longestSubstring(String s, int k) {
		int[] charCnt = new int[26];
		for (int i = 0; i < s.length(); i++) {
			charCnt[s.charAt(i) - 'a'] ++;
		}
		flag = true;
		for (int i = 0; i < 26; i++) {
			if (!flag) break;
			flag &= (charCnt[i] == 0 || charCnt[i] >= k);
		}
		if (flag) {
			return Math.max(max, s.length());
		}


		int start = 0;
		for (int i = 0; i <= s.length(); i++) {
			if (i == s.length()) {
				if (i - start > max) {
					max = Math.max(max, longestSubstring(s.substring(start, i), k));
				}
				break;
			}
			int index = s.charAt(i) - 'a';
			if (charCnt[index] < k && charCnt[index] > 0) {
				if (i > start) {
					if (i - start > max) {
						max = Math.max(max, longestSubstring(s.substring(start, i), k));
					}
				}
				start = i + 1;
			}
		}
		return max;
	}





	public static void main(String[] args) {
		LeetCode395_longestSubstring soution = new LeetCode395_longestSubstring();
		System.out.println(soution.longestSubstring("ababbb", 3));
	}
}
