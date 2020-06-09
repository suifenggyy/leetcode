package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/10 0:39
 */
public class LeetCodeM46_translateNum {
	public int translateNum(int num) {
		int cur, next = -1;
		int dp1 = 1, dp2 = 0;
		int dp = 1;
		while (num > 0) {
			cur = num % 10;
			num = num / 10;
			dp = dp1;
			if (cur == 1 || cur == 2 && next <= 5 && next >= 0) {
				dp += dp2;
			}
			dp2 = dp1;
			dp1 = dp;
			next = cur;
		}
		return dp;
	}

	public static void main(String[] args) {
		LeetCodeM46_translateNum soution = new LeetCodeM46_translateNum();
		System.out.println(soution.translateNum(18580));
	}


}
