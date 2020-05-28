package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/5/29 0:07
 */
public class LeetCode198_Rob {
	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int size = nums.length;
		if (size == 1) {
			return nums[0];
		}
		if (size == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int n1 = nums[1];
		int n2 = nums[0];
		int n3 = 0;
		int max = Math.max(n1, n2);
		for (int i = 2; i < size; i++) {
			int sum = Math.max(n2, n3) + nums[i];
			n3 = n2;
			n2 = n1;
			n1 = sum;
			if (max < sum) {
				max = sum;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int [] nums = {1,3,1};
		System.out.println(rob(nums));
	}

}
