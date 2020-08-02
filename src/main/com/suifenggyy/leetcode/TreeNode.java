package com.suifenggyy.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/7/3 0:45
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }


	public static TreeNode build(Integer[] nums) {
		TreeNode root = new TreeNode(nums[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		for (int i = 1; i < nums.length; i += 2) {
			TreeNode node = queue.poll();
			Integer left = nums[i];
			if (left != null) {
				node.left = new TreeNode(left);
				queue.add(node.left);
			}
			Integer right = nums[i + 1];
			if (right != null) {
				node.right = new TreeNode(right);
				queue.add(node.right);
			}
		}
		return root;
	}

	public static String print(TreeNode root) {
		if (root == null) {
			return "null";
		}
		StringBuilder stringBuilder = new StringBuilder("[");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int preSize;
		while (!queue.isEmpty()) {
			preSize = queue.size();
			while (preSize-- > 0) {
				TreeNode node = queue.poll();
				stringBuilder.append(node == null ? "null" : node.val).append(", ");
				if (node == null || node.left == null && node.right == null) {
					continue;
				}
				queue.add(node.left);
				queue.add(node.right);
			}
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		Integer[] nums = {1,2,5,3,4,null,6};
		TreeNode treeNode = build(nums);
		System.out.println(print(treeNode));
	}
}
