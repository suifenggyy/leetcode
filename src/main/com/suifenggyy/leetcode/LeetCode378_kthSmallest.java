package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/7/3 0:24
 */
public class LeetCode378_kthSmallest {
	public static int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[] index = new int[n];
		int min = Integer.MAX_VALUE, minIndex = 0;

		while (k > 0) {
			min = Integer.MAX_VALUE;
			for (int i = 0; i < m; i ++) {
				if (index[i] < n && min > matrix[i][index[i]]) {
					min = matrix[i][index[i]];
					minIndex = i;
				}
			}
			index[minIndex] ++;
			k --;
		}
		return min;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
		System.out.println(kthSmallest(matrix, 8));
	}
}
