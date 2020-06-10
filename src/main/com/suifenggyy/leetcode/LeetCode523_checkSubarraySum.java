package com.suifenggyy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/11 0:52
 */
public class LeetCode523_checkSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> modIndex = new HashMap<>();
		modIndex.put(0, -1);
		int summod = 0;
		int index;
		for (int i = 0; i < nums.length; i++) {
			summod += nums[i];
			if (k != 0) {
				summod %= k;
			}
			index = modIndex.getOrDefault(summod, Integer.MAX_VALUE);
			if (i - index >= 2) {
				return true;
			}
			if (i < index) {
				modIndex.put(summod, i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LeetCode523_checkSubarraySum soution = new LeetCode523_checkSubarraySum();
		int[] nums = {1, 2, 4, 45, 66};
		System.out.println(soution.checkSubarraySum(nums, -6));

		System.out.println(-23 % 6);
	}
}
