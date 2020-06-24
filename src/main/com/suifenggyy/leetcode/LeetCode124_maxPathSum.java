package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/25 1:18
 */
public class LeetCode124_maxPathSum {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	static class Solution {
		int max = Integer.MIN_VALUE;
		public int maxPathSum(TreeNode root) {
			singlePath(root);
			return max;
		}

		public int singlePath(TreeNode node) {
			if (node == null) {
				return Integer.MIN_VALUE;
			}
			int left = singlePath(node.left);
			int right = singlePath(node.right);

			int curMax = Math.max(left, right);
			max = Math.max(max, curMax);

			if (curMax > 0) {
				curMax += node.val;
			} else {
				curMax = node.val;
			}
			max = Math.max(max, curMax);

			if (left > 0 && right > 0) {
				max = Math.max(max, left + right + node.val);
			}
			return curMax;
		}
	}
}
