package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/7/3 0:44
 */
public class LeetCode108_sortedArrayToBST {
	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		return toNode(nums, 0, nums.length - 1);
	}

	public static TreeNode toNode(int[] nums, int start, int end) {
		if (start == end) {
			return new TreeNode(nums[start]);
		}
		int mid = (start + end + 1) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		if (start < mid) {
			root.left = toNode(nums, start, mid - 1);
		}
		if (mid < end) {
			root.right = toNode(nums, mid + 1, end);
		}
		return root;
	}

	public static void main(String[] args) {
		int[] nums = {-10,-3,0,5,9};
		System.out.println(sortedArrayToBST(nums));
	}


}
