package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/27 23:21
 */
public class LeetCode41_firstMissingPositive {
	static class Solution {
		public int firstMissingPositive(int[] nums) {
			int tmp, i;
			for (i = 0; i < nums.length; i++) {
				if (nums[i] == i + 1) {
					continue;
				}
				while (nums[i] > 0 && nums[i] - 1 < i && nums[nums[i] - 1] != nums[i]) {
					tmp = nums[nums[i] - 1];
					nums[nums[i] - 1] = nums[i];
					nums[i] = tmp;
				}
			}

			for (i = 0; i < nums.length; i++) {
				if (nums[i] != i + 1) {
					return i + 1;
				}
			}
			return i + 1;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1};
		System.out.println(solution.firstMissingPositive(nums));
	}
}
