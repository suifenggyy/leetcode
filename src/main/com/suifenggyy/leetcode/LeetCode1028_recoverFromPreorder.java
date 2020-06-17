package com.suifenggyy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/18 1:51
 */
public class LeetCode1028_recoverFromPreorder {

	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	static class Solution {
		public TreeNode recoverFromPreorder(String S) {
			if (S == null) {
				return null;
			}

			Map<Integer, TreeNode> depthMap = new HashMap<>();
			TreeNode root = null;
			int level = 0;
			int num;
			int len = S.length();
			for (int i = 0; i < len; i++) {
				char ch = S.charAt(i);
				if (ch == '-') {
					level = 1;
					while (i + 1 < len && S.charAt(i + 1) == '-') {
						level ++;
						i ++;
					}
				} else {
					num = ch - '0';
					while (i + 1 < len && S.charAt(i + 1) != '-') {
						num = num * 10 + (S.charAt(i + 1) - '0');
						i ++;
					}
					if (root == null) {
						root = new TreeNode(num);
						depthMap.put(1, root);
					} else {
						TreeNode node = new TreeNode(num);
						TreeNode parent = depthMap.get(level);
						if (parent == null) {
							continue;
						}
						if (parent.left == null) {
							parent.left = node;
						} else {
							parent.right = node;
						}
						depthMap.put(level + 1, node);
					}
				}
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = solution.recoverFromPreorder("1-401--349---90--88");
		System.out.println("OK");
	}

}
