package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/4 0:17
 */
public class LeetCode238_productExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return nums;
		}
		int len = nums.length;
		int[] mul = new int[len];
		mul[0] = nums[0];
		for (int i = 1; i < len - 2; i++) {
			mul[i] = nums[i] * mul[i - 1];
		}

		int rightMul = nums[len - 1];
		mul[len - 1] = nums[len - 1];
		for (int i = len - 2; i > 0; i --) {
			mul[i] = rightMul * mul[i - 1];
			rightMul *= nums[i];
		}
		mul[0] = rightMul;
		return mul;
	}

	public static void main(String[] args) {
		int[] p = {1,2,3,4};
		int[] res = productExceptSelf(p);
		System.out.println();
	}


}
