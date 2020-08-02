package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/8/2 23:38
 */
public class LeetCode114_flatten {
	public static void flatten(TreeNode root) {
		root = dfs(root);
	}

	public static TreeNode dfs(TreeNode node) {
		if (node == null) {
			return node;
		}
		TreeNode cur = node;
		TreeNode right = node.right;
		if (node.left != null) {
			node.right = dfs(node.left);
			node.left = null;
			while (node.right != null) {
				node = node.right;
			}
		}
		if (right != null) {
			node.right = dfs(right);
		}
		return cur;
	}

	public static void main(String[] args) {

		Integer[] nums = {1,2,5,3,4,null,6};
		TreeNode treeNode = TreeNode.build(nums);
		flatten(treeNode);
	}
}
