package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/11 0:22
 */
public class LeetCodeL14_splitArray {
	public static int gcd(int a, int b) {
		a = a % b;
		if (a == 0) {
			return b;
		}
		return gcd(b, a);
	}

	public int splitArray(int[] nums) {
		int size = nums.length;
		int[] dp = new int[size];
		dp[0] = 1;
		int j, g;
		for (int i = 1; i < size; i++) {
			dp[i] = Integer.MAX_VALUE;
			if (nums[i] == 1) {
				dp[i] = dp[i -1] + 1;
			}
			for (j = i; j >= 0; j--) {
				g = nums[i] > nums[j] ? gcd(nums[i], nums[j]) : gcd(nums[j], nums[i]);
				if (g > 1) {
					dp[i] = j == 0 ? 1 : Math.min(dp[i], dp[j - 1] + 1);
				}
			}
		}
		return dp[size - 1];
	}


	public static void main(String[] args) {
		System.out.println(gcd(100, 30));
		int[] nums = {1, 1, 1, 1, 1, 1};
		LeetCodeL14_splitArray soution = new LeetCodeL14_splitArray();
		System.out.println(soution.splitArray(nums));
	}
}
