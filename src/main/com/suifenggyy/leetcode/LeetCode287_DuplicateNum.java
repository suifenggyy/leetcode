package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/5/26 22:13
 */
public class LeetCode287_DuplicateNum {
	public int findDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int slow = nums[0], fast = nums[slow];
		while(nums[slow] != nums[fast]) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = 0;
		while (nums[slow] != nums[fast]) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return nums[slow];
	}

	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		LeetCode287_DuplicateNum solution = new LeetCode287_DuplicateNum();
		System.out.println(solution.findDuplicate(nums));
	}

}
