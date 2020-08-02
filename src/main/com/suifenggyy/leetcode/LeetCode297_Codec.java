package com.suifenggyy.leetcode;

import java.util.LinkedList;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/16 0:10
 */
public class LeetCode297_Codec {
	static class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder stringBuilder = new StringBuilder("[");
			LinkedList<TreeNode> linkedList = new LinkedList();
			linkedList.add(root);
			int endNullSize = 0;
			while (linkedList.size() > endNullSize) {
				TreeNode node = linkedList.removeFirst();
				if (node != null) {
					stringBuilder.append(node.val).append(",");
					linkedList.add(node.left);
					if (node.left == null) {
						endNullSize ++;
					} else {
						endNullSize = 0;
					}
					linkedList.add(node.right);
					if (node.right == null) {
						endNullSize ++;
					} else {
						endNullSize = 0;
					}
				} else {
					stringBuilder.append("null,");
				}
			}
			stringBuilder.setCharAt(stringBuilder.length() - 1, ']');
			return stringBuilder.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data == null || !data.startsWith("[") || !data.endsWith("]")) {
				return null;
			}
			String[] datas = data.substring(1, data.length() - 1).split(",");
			TreeNode root = null;
			if (datas.length >= 1 && !"null".equals(datas[0])) {
				root = new TreeNode(Integer.parseInt(datas[0]));
			}

			if (root != null) {
				LinkedList<TreeNode> linkedList = new LinkedList();
				linkedList.add(root);
				for (int i = 1; i < datas.length; i += 2) {
					TreeNode parent = linkedList.removeFirst();
					if (parent != null) {
						if (!"null".equals(datas[i])) {
							parent.left = new TreeNode(Integer.parseInt(datas[i]));
							linkedList.add(parent.left);
						}
						if (i + 1 < datas.length && !"null".equals(datas[i + 1])) {
							parent.right = new TreeNode(Integer.parseInt(datas[i + 1]));
							linkedList.add(parent.right);
						}
					}
				}
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Codec soution = new Codec();
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode3.left = treeNode4;
		treeNode3.right = treeNode5;
		System.out.println(soution.serialize(treeNode1));

		TreeNode root = soution.deserialize("[5,2,3,null,null,2,4,3,1]");
		System.out.println("OK");

		System.out.println(soution.serialize(root));





	}
}
