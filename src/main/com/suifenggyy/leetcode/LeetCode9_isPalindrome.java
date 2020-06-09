package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/10 0:56
 */
public class LeetCode9_isPalindrome {
	public boolean isPalindrome(int x) {
		if (x < 0 || x % 10 == 0) {
			return false;
		}
		if (x < 10) {
			return true;
		}

		long y = 0;
		while (x > y) {
			y *= 10;
			y += x % 10;
			x /= 10;
		}
		return y == x || x == y / 10;
	}

	public static void main(String[] args) {
		LeetCode9_isPalindrome soution = new LeetCode9_isPalindrome();
		System.out.println(soution.isPalindrome(1212112121));
	}
}
