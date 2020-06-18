package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/19 0:20
 */
public class LeetCode125_isPalindrome {
	class Solution {
		public boolean isPalindrome(String s) {
			int size = s.length();
			int left = 0, right = size - 1;
			int leftCode, rightCode;
			while (left < right) {
				leftCode = trans(s.charAt(left));
				while (leftCode == -1 && left < right) {
					left ++;
					leftCode = trans(s.charAt(left));
				}

				rightCode = trans(s.charAt(right));
				while (rightCode == -1 && right > left) {
					right --;
					rightCode = trans(s.charAt(right));
				}
				if (leftCode != rightCode) {
					return false;
				}
				left ++;
				right --;
			}
			return true;
		}

		public int trans(char ch) {
			if (ch >= 'a' && ch <= 'z') {
				return ch - 'a' + 10;
			}

			if (ch >= 'A' && ch <= 'Z') {
				return ch - 'A' + 10;
			}

			if (ch >= '0' && ch <= '9') {
				return ch - '0';
			}
			return -1;
		}
	}
}
