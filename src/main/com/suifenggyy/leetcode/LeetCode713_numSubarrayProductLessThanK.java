package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/7/1 22:52
 */
public class LeetCode713_numSubarrayProductLessThanK {
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		long res = 1;
		int start = 0, cnt = 0;
		for (int end = 0; end < nums.length; end ++) {
			res *= nums[end];
			while (res >= k) {
				res /= nums[start];
				start ++;
			}
			cnt += end - start + 1;
		}
		return cnt;
	}

	public static void main(String[] args) {
		int[] nums = {10,5,1,1,1,12,6};
		System.out.println(numSubarrayProductLessThanK(nums, 10));

	}
}
