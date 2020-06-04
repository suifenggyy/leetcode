package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/5 0:41
 */
public class LeetCode29_spiralOrder {
	public static int[] spiralOrder(int[][] matrix) {

		int m = matrix.length;
		if (m == 0) {
			return new int[0];
		}
		int n = matrix[0].length;
		if (m == 0) {
			return new int[0];
		}

		int[] xD = {0, 1, 0, -1};
		int[] yD = {1, 0, -1, 0};
		int D = 0;
		int xStart = 1, xEnd = m - 1, yStart = 0, yEnd = n - 1;
		int i = 0, j = -1;
		int size = m * n;
		int[] res = new int[size];
		for (int k = 0; k < size; k++) {
			i += xD[D];
			j += yD[D];
			res[k] = matrix[i][j];
			if (D == 1 && i >= xEnd && (xEnd-- > Integer.MIN_VALUE)
					|| D == 3 && i <= xStart && (xStart++ > Integer.MIN_VALUE)
					|| D == 0 && j >= yEnd && (yEnd-- > Integer.MIN_VALUE)
					|| D == 2 && j <= yStart && (yStart++ > Integer.MIN_VALUE)) {
				D = (D + 1) % 4;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int m = 1, n = 5;
		int[][] matrix = new int[m][];
		int k = 1;
		for (int i = 0; i < m; i ++) {
			int [] tmp = new int[n];
			for (int j = 0; j < n; j++) {
				tmp[j] = k ++;
			}
			matrix[i] = tmp;
		}

		int[] res = spiralOrder(matrix);
		System.out.println();
	}

}
