package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/30 0:17
 */
public class LeetCode209_minSubArrayLen {
	public int minSubArrayLen(int s, int[] nums) {
		int sum = 0;
		int minLen = Integer.MAX_VALUE;
		int start = 0; int end = 0;
		while (end < nums.length) {
			sum += nums[end];
			while (sum - nums[start] >= s) {
				sum -= nums[start];
				start ++;
			}
			if (sum >= s) {
				minLen = Math.min(minLen, end - start + 1);
			}
			end ++;
		}
		if (sum < s) {
			return 0;
		}
		return minLen;
	}
}
