package com.suifenggyy.leetcode;

import java.util.Arrays;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/12 1:25
 */
public class LeetCode16_threeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int a, b, c;
		int res = nums[0] + nums[1] + nums[2];
		int minDif = Integer.MAX_VALUE;
		int sum;
		int size = nums.length;
		for (a = 0; a < size - 2; a ++) {
			if (a > 0 && nums[a] == nums[a - 1]) {
				continue;
			}
			b = a + 1;
			c = size - 1;
			while (b < c) {
				sum = nums[a] + nums[b] + nums[c];
				if (Math.abs(target - sum) < minDif) {
					minDif = Math.abs(target - sum);
					res = sum;
				}
				if (sum < target) {
					b ++;
				} else if (sum > target) {
					c --;
				} else {
					return sum;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		LeetCode16_threeSumClosest soution = new LeetCode16_threeSumClosest();
		int[] nums = {1,2,4,8,16,32,64,128};
		System.out.println(soution.threeSumClosest(nums, 82));

	}
}
